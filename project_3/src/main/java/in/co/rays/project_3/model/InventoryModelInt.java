package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.InventoryDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface InventoryModelInt {

	 
	public long add(InventoryDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(InventoryDTO dto)throws ApplicationException;
	public void update(InventoryDTO dto)throws ApplicationException,DuplicateRecordException;
	public InventoryDTO findByPK(long pk)throws ApplicationException;
	public InventoryDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(InventoryDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(InventoryDTO dto)throws ApplicationException;
	public List getRoles(InventoryDTO dto)throws ApplicationException;

}
