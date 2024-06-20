package in.co.rays.project_3.test;

import in.co.rays.project_3.dto.TypeDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.TypeModelHibImp;
import in.co.rays.project_3.model.TypeModelInt;
import in.co.rays.project_3.model.UserModelHibImp;
import in.co.rays.project_3.model.UserModelInt;

public class TestType {

	
	public static TypeModelInt model = new TypeModelHibImp();

	 public static void main(String[] args) throws Exception {
		add();
	}

	private static void add() throws Exception, Exception {
		 
		 TypeDTO dto = new TypeDTO();
		 
		 dto.setType("Case");
		 model.add(dto);
		 System.out.println("Data inserted");
	}
}
