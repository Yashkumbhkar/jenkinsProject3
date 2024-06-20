package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.PatientDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface PatientModeInt {
 

	public long add(PatientDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(PatientDTO dto)throws ApplicationException;
	public void update(PatientDTO dto)throws ApplicationException,DuplicateRecordException;
	public PatientDTO findByPK(long pk)throws ApplicationException;
	public PatientDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(PatientDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(PatientDTO dto)throws ApplicationException;
	public List getRoles(PatientDTO dto)throws ApplicationException;
}
