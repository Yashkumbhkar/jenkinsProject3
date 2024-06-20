package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.ProductDetailsDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface ProductDetailsModelInt {

	 
	public long add(ProductDetailsDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(ProductDetailsDTO dto)throws ApplicationException;
	public void update(ProductDetailsDTO dto)throws ApplicationException,DuplicateRecordException;
	public ProductDetailsDTO findByPK(long pk)throws ApplicationException;
	public ProductDetailsDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(ProductDetailsDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(ProductDetailsDTO dto)throws ApplicationException;
	public List getRoles(ProductDetailsDTO dto)throws ApplicationException;

}
