package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.CategoryDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface CategoryModelInt {
	
	
	public long add(CategoryDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(CategoryDTO dto)throws ApplicationException;
	public void update(CategoryDTO dto)throws ApplicationException,DuplicateRecordException;
	public CategoryDTO findByPK(long pk)throws ApplicationException;
	public CategoryDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(CategoryDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(CategoryDTO dto)throws ApplicationException;
	public List getRoles(CategoryDTO dto)throws ApplicationException;


}
