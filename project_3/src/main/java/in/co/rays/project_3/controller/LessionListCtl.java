package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.LessionDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.model.LessionModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.RoleModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(name = " LessionListCtl", urlPatterns = { "/ctl/LessionListCtl" })
public class LessionListCtl extends BaseCtl {

	@Override
	protected void preload(HttpServletRequest request) {

		RoleModelInt model = ModelFactory.getInstance().getRoleModel();
		LessionModelInt bmodel = ModelFactory.getInstance().getLessionModel();

		try {
			List list = bmodel.list(0, 0);
			request.setAttribute("nameList", list);
		} catch (Exception e) {

		}
	}

	@Override
	protected BaseDTO populateDTO(HttpServletRequest request) {

		LessionDTO dto = new LessionDTO();
		System.out.println("name>>> " + request.getParameter("name"));
		dto.setName(DataUtility.getString(request.getParameter("name")));
		// dto.setName(DataUtility.getString(request.getParameter("nname")));

		// dto.setLastName(DataUtility.getString(request.getParameter("lastName")));
		// dto.setDob(DataUtility.getDate(request.getParameter("dob")));
		dto.setAuthorName(DataUtility.getString("authorName"));
		populateBean(dto, request);
		return dto;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list;
		List next;
		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));
		LessionDTO dto = (LessionDTO) LessionDTO(request);

		LessionModelInt model = ModelFactory.getInstance().getLessionModel();
		try {
			list = model.search(dto, pageNo, pageSize);

			ArrayList<LessionDTO> a = (ArrayList<LessionDTO>) list;

			next = model.search(dto, pageNo + 1, pageSize);
			ServletUtility.setList(list, request);
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", request);
			}
			if (next == null || next.size() == 0) {
				request.setAttribute("nextListSize", 0);

			} else {
				request.setAttribute("nextListSize", next.size());
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private LessionDTO LessionDTO(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List list = null;
		List next = null;
		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;
		LessionDTO dto = (LessionDTO) populateDTO(request);
		System.out.println("lessionname= " + dto.getName());
		String op = DataUtility.getString(request.getParameter("operation"));

		String[] ids = request.getParameterValues("ids");
		LessionModelInt model = ModelFactory.getInstance().getLessionModel();
		try {

			if (OP_SEARCH.equalsIgnoreCase(op)) {

				System.out.println("in search method>>>>");

				pageNo = 1;

			} else if (OP_NEXT.equalsIgnoreCase(op)) {

				pageNo++;

			} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {

				pageNo--;

			}

			else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.LESSION_CTL, request, response);
				return;
			} else if (OP_RESET.equalsIgnoreCase(op)) {

				ServletUtility.redirect(ORSView.LESSION_LIST_CTL, request, response);
				return;
			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					LessionDTO deletedto = new LessionDTO();
					for (String id : ids) {
						deletedto.setId(DataUtility.getLong(id));
						model.delete(deletedto);
						ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
					}
				} else {
					ServletUtility.setErrorMessage("Select at least one record", request);
				}
			}
			if (OP_BACK.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.LESSION_LIST_CTL, request, response);
				return;
			}
			dto = (LessionDTO) populateDTO(request);
			list = model.search(dto, pageNo, pageSize);

			ServletUtility.setDto(dto, request);
			next = model.search(dto, pageNo + 1, pageSize);

			ServletUtility.setList(list, request);
			ServletUtility.setList(list, request);
			if (list == null || list.size() == 0) {
				if (!OP_DELETE.equalsIgnoreCase(op)) {
					ServletUtility.setErrorMessage("No record found ", request);
				}
			}
			if (next == null || next.size() == 0) {
				request.setAttribute("nextListSize", 0);

			} else {
				request.setAttribute("nextListSize", next.size());
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected String getView() {

		return ORSView.LESSION_LIST_VIEW;
	}

}
