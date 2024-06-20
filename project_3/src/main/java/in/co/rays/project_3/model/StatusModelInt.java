package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.StatusDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface StatusModelInt {
	
	
	public long add(StatusDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(StatusDTO dto)throws ApplicationException;
	public void update(StatusDTO dto)throws ApplicationException,DuplicateRecordException;
	public StatusDTO findByPK(long pk)throws ApplicationException;
	public StatusDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(StatusDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(StatusDTO dto)throws ApplicationException;
	public List getRoles(StatusDTO dto)throws ApplicationException;
}
