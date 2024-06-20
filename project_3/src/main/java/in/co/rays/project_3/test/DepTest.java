package in.co.rays.project_3.test;

import in.co.rays.project_3.dto.DepartmentDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.DepartmentModelHibImp;
import in.co.rays.project_3.model.DepartmentModelInt;
import in.co.rays.project_3.model.PriorityModelHibImp;
import in.co.rays.project_3.model.PriorityModelInt;

public class DepTest {
	
	public static DepartmentModelInt model = new DepartmentModelHibImp();
	
	
	 public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		
		 add();
	}


	private static void add() throws ApplicationException, DuplicateRecordException {

		 DepartmentDTO dto = new DepartmentDTO();
		 dto.setDepartment("HR");
		 model.add(dto);
		 System.out.println("done");
	}


}
