package in.co.rays.project_3.test;

import in.co.rays.project_3.dto.CategoryDTO;
import in.co.rays.project_3.dto.PriorityDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CategoryModelHibImp;
import in.co.rays.project_3.model.CategoryModelInt;
import in.co.rays.project_3.model.PriorityModelHibImp;
import in.co.rays.project_3.model.PriorityModelInt;

public class cTest {
	
	
	public static CategoryModelInt model = new CategoryModelHibImp();
	
	
	 public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		
		 add();
	}


	private static void add() throws ApplicationException, DuplicateRecordException {
CategoryDTO dto = new CategoryDTO();
		 
		 dto.setCategory("Case");
		 model.add(dto);
		 System.out.println("Data inserted");
	}



}
