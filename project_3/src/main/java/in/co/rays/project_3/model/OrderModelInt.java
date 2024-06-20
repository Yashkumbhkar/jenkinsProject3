package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.OrderDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface OrderModelInt {

	public long add(OrderDTO dto) throws ApplicationException, DuplicateRecordException;

	public void delete(OrderDTO dto) throws ApplicationException;

	public void update(OrderDTO dto) throws ApplicationException, DuplicateRecordException;

	public OrderDTO findByPK(long pk) throws ApplicationException;

	public OrderDTO findByLogin(String login) throws ApplicationException;

	public List list(int pageNo, int pageSize) throws ApplicationException;

	public List search(OrderDTO dto, int pageNo, int pageSize) throws ApplicationException;

}
