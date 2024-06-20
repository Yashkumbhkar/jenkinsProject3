package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.SalaryDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface SalaryModelInt {

	public long add(SalaryDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(SalaryDTO dto)throws ApplicationException;
	public void update(SalaryDTO dto)throws ApplicationException,DuplicateRecordException;
	public SalaryDTO findByPK(long pk)throws ApplicationException;
	public SalaryDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(SalaryDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(SalaryDTO dto)throws ApplicationException;
	public List getRoles(SalaryDTO dto)throws ApplicationException;

}
