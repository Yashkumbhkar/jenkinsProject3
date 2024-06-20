package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.ClientDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.AddressModelInt;
import in.co.rays.project_3.model.ClientModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.OrderModelInt;
import in.co.rays.project_3.model.PriorityModelInt;
import in.co.rays.project_3.model.RoleModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(name = "ClientCtl", urlPatterns = { "/ctl/ClientCtl" })

public class ClientCtl extends BaseCtl {

	protected void preload(HttpServletRequest request) {
		RoleModelInt model1 = ModelFactory.getInstance().getRoleModel();
		PriorityModelInt model = ModelFactory.getInstance().getPriorityModel();
		try {
		
			 List list =  model.list(0, 0);
			request.setAttribute("pList", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "name"));

			pass = false;
		} else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", " name must contains alphabets only");
			System.out.println(pass);
			pass = false;

		}

		
		if (DataValidator.isNull(request.getParameter("phone"))) {
			request.setAttribute("phone", PropertyReader.getValue("error.require", "phone"));
			pass = false;
		}

		else if (!DataValidator.isPhoneNo(request.getParameter("phone"))) {
			request.setAttribute("phone", "phone must contains Number only");
			System.out.println(pass);
			pass = false;
			
	

		
		
		if (DataValidator.isNull(request.getParameter("priority"))) {
			request.setAttribute("priority", PropertyReader.getValue("error.require", "priority"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("priority"))) {
			request.setAttribute("priority", "priority must contains alphabets only");
			System.out.println(pass);
			pass = false;

		}
	
		if (!OP_UPDATE.equalsIgnoreCase(request.getParameter("operation"))) {

		

		
		


	}
		
		
		}
	    return pass ; 

	}
	
		

	protected BaseDTO populateDTO(HttpServletRequest request) {
		ClientDTO dto = new ClientDTO();

		dto.setId(DataUtility.getLong(request.getParameter("id")));

//dto.setRoleId(DataUtility.getLong(request.getParameter("role")));
		dto.setName(DataUtility.getString(request.getParameter("name")));

		dto.setPhone(DataUtility.getInt(request.getParameter("phone")));
		dto.setPriority(DataUtility.getString(request.getParameter("priority")));


		populateBean(dto, request);

		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = DataUtility.getString(request.getParameter("operation"));
		ClientModelInt model = ModelFactory.getInstance().getClientModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {
			ClientDTO dto;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = DataUtility.getString(request.getParameter("operation"));
		ClientModelInt model = ModelFactory.getInstance().getClientModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			ClientDTO dto = (ClientDTO) populateDTO(request);
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

			ClientDTO dto = (ClientDTO) populateDTO(request);
			try {
				model.delete(dto);
				ServletUtility.redirect(ORSView.CLIENT_LIST_VIEW, request, response);
				return;
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			}

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.CLIENT_LIST_VIEW, request, response);
			return;
		} else if (OP_RESET.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.CLIENT_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.CLIENT_VIEW;
	}

}
