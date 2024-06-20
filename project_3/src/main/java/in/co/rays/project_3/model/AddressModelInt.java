package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.AddressDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface AddressModelInt {

	
	public long add(AddressDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(AddressDTO dto)throws ApplicationException;
	public void update(AddressDTO dto)throws ApplicationException,DuplicateRecordException;
	public AddressDTO findByPK(long pk)throws ApplicationException;
	public AddressDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(AddressDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(AddressDTO dto)throws ApplicationException;
	public List getRoles(AddressDTO dto)throws ApplicationException;
}
