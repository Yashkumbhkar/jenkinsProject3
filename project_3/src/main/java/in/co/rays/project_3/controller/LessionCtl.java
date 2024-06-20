package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.LessionDTO;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.LessionDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.BankModelInt;
import in.co.rays.project_3.model.LessionModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.RoleModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(name = " LessionCtl", urlPatterns = { "/ctl/LessionCtl" })
public class LessionCtl extends BaseCtl {

	@Override
	protected void preload(HttpServletRequest request) {
		RoleModelInt model = ModelFactory.getInstance().getRoleModel();
		try {
			List list = model.list();
			request.setAttribute("roleList", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", " name"));

			pass = false;
		} else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", " name must contains alphabets only");
			System.out.println(pass);
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("autharName"))) {
			request.setAttribute("autharName", PropertyReader.getValue("error.require", "autharName"));
			System.out.println(pass);
			pass = false;
		} /*
			 * else if (!DataValidator.isName(request.getParameter("authorName"))) {
			 * request.setAttribute("autharName",
			 * "autharName must contains alphabets only"); System.out.println(pass); pass =
			 * false;
			 */

		if (!OP_UPDATE.equalsIgnoreCase(request.getParameter("operation"))) {
			/*
			 * if (DataValidator.isNull(request.getParameter("password"))) {
			 * request.setAttribute("password", PropertyReader.getValue("error.require",
			 * "Password")); System.out.println(pass); pass = false; }
			 */
			/*
			 * else if (!DataValidator.isPassword(request.getParameter("password"))) {
			 * request.setAttribute("password",
			 * PropertyReader.getValue("Enter the valid Password"));
			 * System.out.println(pass); pass = false; }
			 * 
			 * if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
			 * request.setAttribute("confirmPassword",
			 * PropertyReader.getValue("error.require", "Confirm Password"));
			 * System.out.println(pass); pass = false; } else if
			 * (!DataValidator.isPassword(request.getParameter("confirmPassword"))){
			 * request.setAttribute("confirmPassword",PropertyReader.
			 * getValue("Enter the valid confirmPassword")); pass = false; }
			 * 
			 * 
			 * else if (!request.getParameter("password").equals(request.getParameter(
			 * "confirmPassword"))) { request.setAttribute("confirmPassword",
			 * "Confirm Password should  be matched."); pass = false; } }if
			 * (DataValidator.isNull(request.getParameter("role"))) {
			 * request.setAttribute("role", PropertyReader.getValue("error.require",
			 * "role")); pass = false; } if
			 * (DataValidator.isNull(request.getParameter("gender"))) {
			 * request.setAttribute("gender", PropertyReader.getValue("error.require",
			 * "gender")); pass = false; }
			 *
			 */

		}
		return pass;

	}

	@Override
	protected BaseDTO populateDTO(HttpServletRequest request) {

		LessionDTO dto = new LessionDTO();

		System.out.println(request.getParameter("dob"));

		dto.setId(DataUtility.getLong(request.getParameter("id")));

		// dto.setRoleId(DataUtility.getLong(request.getParameter("role")));
		dto.setName(DataUtility.getString(request.getParameter("name")));

		dto.setAuthorName(DataUtility.getString(request.getParameter("autharName")));
		System.out.println(request.getParameter("autharName"));

		// dto.setPassword(DataUtility.getString(request.getParameter("password")));

		// dto.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));

		// dto.setGender(DataUtility.getString(request.getParameter("gender")));
		// dto.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));

		populateBean(dto, request);

		return dto;

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));
		LessionModelInt model = ModelFactory.getInstance().getLessionModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {
			LessionDTO dto;
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
		LessionModelInt model = ModelFactory.getInstance().getLessionModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			LessionDTO dto = (LessionDTO) populateDTO(request);
			try {
				if (id > 0) {
					model.update(dto);

					ServletUtility.setSuccessMessage("Data is successfully Update", request);
				} else {

					try {
						model.add(dto);

						System.out.println("in ");
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

			LessionDTO dto = (LessionDTO) populateDTO(request);
			try {
				model.delete(dto);
				ServletUtility.redirect(ORSView.LESSION_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			}

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.LESSION_LIST_CTL, request, response);
			return;
		} else if (OP_RESET.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.LESSION_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.LESSION_VIEW;
	}

}
