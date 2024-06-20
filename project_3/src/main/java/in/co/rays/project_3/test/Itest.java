package in.co.rays.project_3.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import in.co.rays.project_3.dto.InventoryDTO;
import in.co.rays.project_3.dto.PriorityDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.InventoryModelHibImp;
import in.co.rays.project_3.model.InventoryModelInt;
import in.co.rays.project_3.model.PriorityModelHibImp;
import in.co.rays.project_3.model.PriorityModelInt;

public class Itest {
	
	
	public static InventoryModelInt model = new InventoryModelHibImp();

	
	 public static void main(String[] args) throws ApplicationException, DuplicateRecordException, ParseException {
		
		 
		  add();
	}

	private static void add() throws ApplicationException, DuplicateRecordException, ParseException {

		  SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		InventoryDTO dto = new InventoryDTO();
		
		 dto.setSupplierName("Yash");
		 dto.setQuantity(1);
		 dto.setProduct("laptop");
		 dto.setLastUpatedDate(sdf.parse("05-05-2003"));
		/*
		 * InventoryModelHibImp model = new InventoryModelHibImp();
		 */		 
		  model.add(dto);
		   
		 System.out.println("Data inserted");
	}

		
	

	}


