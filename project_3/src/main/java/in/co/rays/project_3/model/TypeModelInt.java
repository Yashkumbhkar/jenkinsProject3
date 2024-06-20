package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.TypeDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface TypeModelInt {

	public long add(TypeDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(TypeDTO dto)throws ApplicationException;
	public void update(TypeDTO dto)throws ApplicationException,DuplicateRecordException;
	public TypeDTO findByPK(long pk)throws ApplicationException;
	public TypeDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(TypeDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(TypeDTO dto)throws ApplicationException;
	public List getRoles(TypeDTO dto)throws ApplicationException;
	 
}
