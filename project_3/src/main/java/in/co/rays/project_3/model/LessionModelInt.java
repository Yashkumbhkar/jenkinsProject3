package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.LessionDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public  interface LessionModelInt {
	public long add(LessionDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(LessionDTO dto)throws ApplicationException;
	public void update(LessionDTO dto)throws ApplicationException,DuplicateRecordException;
	public LessionDTO findByPK(long pk)throws ApplicationException;
	public LessionDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(LessionDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(LessionDTO dto)throws ApplicationException;
	public List getRoles(LessionDTO dto)throws ApplicationException;


}
