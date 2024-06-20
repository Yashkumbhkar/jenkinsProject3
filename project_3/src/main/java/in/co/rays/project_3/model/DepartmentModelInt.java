package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.DepartmentDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface DepartmentModelInt {
	

	public long add(DepartmentDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(DepartmentDTO dto)throws ApplicationException;
	public void update(DepartmentDTO dto)throws ApplicationException,DuplicateRecordException;
	public DepartmentDTO findByPK(long pk)throws ApplicationException;
	public DepartmentDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(DepartmentDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(DepartmentDTO dto)throws ApplicationException;
	public List getRoles(DepartmentDTO dto)throws ApplicationException;
}
