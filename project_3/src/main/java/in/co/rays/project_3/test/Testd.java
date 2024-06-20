package in.co.rays.project_3.test;

import in.co.rays.project_3.dto.DesceaseDTO;
import in.co.rays.project_3.dto.PriorityDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.DescaseModelHibImp;
import in.co.rays.project_3.model.DesceaseModeInt;
import in.co.rays.project_3.model.PriorityModelHibImp;
import in.co.rays.project_3.model.PriorityModelInt;

public class Testd {
	
	public static DesceaseModeInt model = new DescaseModelHibImp();
	
	
	 public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		add();
	}


	private static void add() throws ApplicationException, DuplicateRecordException {
 DesceaseDTO dto = new DesceaseDTO();
		 
		 dto.setDesCeaseDTO("Nose");
		 model.add(dto);
		 System.out.println("Data inserted");
		
	}


}
