package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.DesceaseDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface DesceaseModeInt {
 
	 
	public long add(DesceaseDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(DesceaseDTO dto)throws ApplicationException;
	public void update(DesceaseDTO dto)throws ApplicationException,DuplicateRecordException;
	public DesceaseDTO findByPK(long pk)throws ApplicationException;
	public DesceaseDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(DesceaseDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(DesceaseDTO dto)throws ApplicationException;
	public List getRoles(DesceaseDTO dto)throws ApplicationException;
}
