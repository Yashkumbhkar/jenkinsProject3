package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.ProductDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.BankModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.ProductModelInt;
import in.co.rays.project_3.model.RoleModelInt;
import in.co.rays.project_3.model.TypeModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;
@WebServlet(name = "ProductCtl", urlPatterns = { "/ctl/ProductCtl" })
public class ProductCtl  extends BaseCtl{
	
	
	@Override
	protected void preload(HttpServletRequest request) {
	
		ProductModelInt model = ModelFactory.getInstance().getProductModel();
		TypeModelInt model1 =  ModelFactory.getInstance().getTypeModel();
		try {
			List list = model1.list();
			request.setAttribute("mt", list);

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
			
			if (DataValidator.isNull(request.getParameter("price"))) {
				request.setAttribute("price", PropertyReader.getValue("error.require", " price"));
				
				pass = false;
			}

			
			
			
			if (DataValidator.isNull(request.getParameter("type"))) {
				request.setAttribute("type", PropertyReader.getValue("error.require", " type"));
				
				pass = false;
			}
			
			
			if (DataValidator.isNull(request.getParameter("expireDate"))) {
				request.setAttribute("expireDate", PropertyReader.getValue("error.require", " expireDate"));
				
				pass = false;
			} 

			
			return pass;

	}
	  
	   @Override
	protected BaseDTO populateDTO(HttpServletRequest request) {
		
		   ProductDTO dto = new ProductDTO();
			
	         
	   
			dto.setId(DataUtility.getLong(request.getParameter("id")));

			dto.setName(DataUtility.getString(request.getParameter("name")));

			dto.setPrice(DataUtility.getString(request.getParameter("price")));

			dto.setType(DataUtility.getString(request.getParameter("type")));
			dto.setExpireDate(DataUtility.getDate(request.getParameter("expireDate")));


		
	        
			populateBean(dto,request);
			

			return dto;
	   }
	
           @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        		String op = DataUtility.getString(request.getParameter("operation"));
        		ProductModelInt model = ModelFactory.getInstance().getProductModel();
        		long id = DataUtility.getLong(request.getParameter("id"));
        		if (id > 0 || op != null) {
        			ProductDTO dto;
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
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            	
            	 
            	 String op = DataUtility.getString(request.getParameter("operation"));
         		ProductModelInt model = ModelFactory.getInstance().getProductModel();
         		long id = DataUtility.getLong(request.getParameter("id"));
         		if (OP_SAVE.equalsIgnoreCase(op)||OP_UPDATE.equalsIgnoreCase(op)) {
         			ProductDTO dto = (ProductDTO) populateDTO(request);
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

         			ProductDTO dto = (ProductDTO) populateDTO(request);
         			try {
         				model.delete(dto);
         				ServletUtility.redirect(ORSView.PRODUCT_LIST_CTL, request, response);
         				return;
         			} catch (ApplicationException e) {
         				ServletUtility.handleException(e, request, response);
         				return;
         			}

         		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

         			ServletUtility.redirect(ORSView.PRODUCT_LIST_CTL, request, response);
         			return;
         		} else if (OP_RESET.equalsIgnoreCase(op)) {

         			ServletUtility.redirect(ORSView.PRODUCT_CTL, request, response);
         			return;
         		}
         		ServletUtility.forward(getView(), request, response);

         	}


            
	     
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.PRODUCT_VIEW;
	}

}
