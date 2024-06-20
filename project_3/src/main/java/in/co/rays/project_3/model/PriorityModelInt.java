package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.PriorityDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface PriorityModelInt {

	public long add(PriorityDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(PriorityDTO dto)throws ApplicationException;
	public void update(PriorityDTO dto)throws ApplicationException,DuplicateRecordException;
	public PriorityDTO findByPK(long pk)throws ApplicationException;
	public PriorityDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(PriorityDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(PriorityDTO dto)throws ApplicationException;
	public List getRoles(PriorityDTO dto)throws ApplicationException;
	
}
