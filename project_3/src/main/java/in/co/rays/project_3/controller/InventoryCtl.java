package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.InventoryDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.DesceaseModeInt;
import in.co.rays.project_3.model.InventoryModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.PatientModeInt;
import in.co.rays.project_3.model.ProductModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;


@WebServlet(name = "InventoryCtl", urlPatterns = { "/ctl/InventoryCtl" })

public class InventoryCtl  extends BaseCtl {

	
	 
	@Override
	protected void preload(HttpServletRequest request) {

		ProductModelInt model = ModelFactory.getInstance().getProductModel();
		DesceaseModeInt model1 = ModelFactory.getInstance().getDesceaseModel();
		try {
			List list = model1.list();
			request.setAttribute("mt", list);
			
			
			HashMap map = new HashMap();
			map.put("Box", "Box");
			map.put("Mobile", "Mobile");
			map.put("Laptop" ,"Laptop");
 request.setAttribute("sm", map);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("supplierName"))) {
			request.setAttribute("supplierName", PropertyReader.getValue("error.require", " supplierName"));

			pass = false;
		} else if (!DataValidator.isName(request.getParameter("supplierName"))) {
			request.setAttribute("supplierName", " supplierName must contains alphabets only");
			System.out.println(pass);
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("lastUpdatedDate"))) {
			request.setAttribute("lastUpdatedDate", PropertyReader.getValue("error.require", " lastUpdatedDate"));

			pass = false;
		} /*else if (!DataValidator.isDate(request.getParameter("lastUpdatedDate"))) {
			request.setAttribute("lastUpdatedDate", "lastUpdateDate must contains Digit only");
			System.out.println(pass);
			pass = false;*/

		

		if (DataValidator.isNull(request.getParameter("quantity"))) {
			request.setAttribute("quantity", PropertyReader.getValue("error.require", " quantity"));

			pass = false;
		}
		
		/*
		 * else if (!DataValidator.isPhoneNo(request.getParameter("quantity"))) {
		 * request.setAttribute("quantity", "quantity must contains Digit only"); pass =
		 * false; }
		 */		if (DataValidator.isNull(request.getParameter("product"))) {
			request.setAttribute("product", PropertyReader.getValue("error.require", " product"));

			pass = false;
		}

		return pass;

	}
	
	@Override
	protected BaseDTO populateDTO(HttpServletRequest request) {

		InventoryDTO dto = new InventoryDTO();

		dto.setId(DataUtility.getLong(request.getParameter("id")));

		dto.setSupplierName(DataUtility.getString(request.getParameter("supplierName")));
		dto.setLastUpatedDate(DataUtility.getDate(request.getParameter("lastUpdatedDate")));

		dto.setQuantity(DataUtility.getInt(request.getParameter("quantity")));

		dto.setProduct(DataUtility.getString(request.getParameter("product")));

		populateBean(dto, request);

		return dto;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));
		InventoryModelInt model = ModelFactory.getInstance().getInventoryModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {
			InventoryDTO dto;
			try {
				dto = model.findByPK(id);
				ServletUtility.setDto(dto, request);
			} catch (Exception e) {
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));
		InventoryModelInt model = ModelFactory.getInstance().getInventoryModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			InventoryDTO dto = (InventoryDTO) populateDTO(request);
			try {
				if (id > 0) {
					model.update(dto);

					ServletUtility.setSuccessMessage("Data is successfully Update", request);
				} else {

					try {
						model.add(dto);
						ServletUtility.setDto(dto, request);
						ServletUtility.setSuccessMessage("Data is successfully saved", request);
					} catch (ApplicationException e) {
						ServletUtility.handleException(e, request, response);
						return;
					} catch (DuplicateRecordException e) {
						ServletUtility.setDto(dto, request);
						ServletUtility.setErrorMessage("Login id already exists", request);
					}

				}
				ServletUtility.setDto(dto, request);

			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Login id already exists", request);
			}
		} else if (OP_DELETE.equalsIgnoreCase(op)) {

			InventoryDTO dto = (InventoryDTO) populateDTO(request);
			try {
				model.delete(dto);
				ServletUtility.redirect(ORSView.INVENTORY_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			}

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.INVENTORY_LIST_CTL, request, response);
			return;
		} else if (OP_RESET.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.INVENTORY_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.INVENTORY_VIEW;
	}

}
