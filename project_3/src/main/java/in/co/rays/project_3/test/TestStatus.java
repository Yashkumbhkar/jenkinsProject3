package in.co.rays.project_3.test;

import in.co.rays.project_3.dto.AddressDTO;
import in.co.rays.project_3.dto.StatusDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.StatusModelHibImp;
import in.co.rays.project_3.model.StatusModelInt;
import in.co.rays.project_3.model.TypeModelHibImp;
import in.co.rays.project_3.model.TypeModelInt;

public class TestStatus {

	  
	public static StatusModelInt model = new StatusModelHibImp();
	
	 public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		
		  add();
	}

	private static void add() throws ApplicationException, DuplicateRecordException {
 StatusDTO dto = new StatusDTO();
		 
		 dto.setStatus("Manager");
		 model.add(dto);
		 System.out.println("Data inserted");
		
	}

}
