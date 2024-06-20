package in.co.rays.project_3.test;

import org.apache.log4j.Priority;

import in.co.rays.project_3.dto.AddressDTO;
import in.co.rays.project_3.dto.PriorityDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.AddressModelHibImp;
import in.co.rays.project_3.model.AddressModelInt;
import in.co.rays.project_3.model.PriorityModelHibImp;
import in.co.rays.project_3.model.PriorityModelInt;

public class Testp {

	public static PriorityModelInt model = new PriorityModelHibImp();
	
	
	 public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		
		 add();
	}


	private static void add() throws ApplicationException, DuplicateRecordException {
 PriorityDTO dto = new PriorityDTO();
		 
		 dto.setPriority("Medium");
		 model.add(dto);
		 System.out.println("Data inserted");
	}

		
	}


