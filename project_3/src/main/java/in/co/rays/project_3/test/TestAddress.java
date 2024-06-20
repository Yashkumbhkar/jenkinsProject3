package in.co.rays.project_3.test;

import in.co.rays.project_3.dto.AddressDTO;
import in.co.rays.project_3.dto.TypeDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.AddressModelHibImp;
import in.co.rays.project_3.model.AddressModelInt;
import in.co.rays.project_3.model.TypeModelHibImp;
import in.co.rays.project_3.model.TypeModelInt;

public class TestAddress {

	public static AddressModelInt model = new AddressModelHibImp();

	public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		
		 add();
	}

	private static void add() throws ApplicationException, DuplicateRecordException {

 AddressDTO dto = new AddressDTO();
		 
		 dto.setAddress("Ujjain");
		 model.add(dto);
		 System.out.println("Data inserted");
	}
}
