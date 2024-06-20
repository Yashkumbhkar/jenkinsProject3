package in.co.rays.project_3.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.EmployeeDTO;
import in.co.rays.project_3.dto.OrderDTO;
import in.co.rays.project_3.dto.OrderDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;


	
	public class OrderModelHipImp implements OrderModelInt {
	
		public long add(OrderDTO dto) throws ApplicationException, DuplicateRecordException {

			OrderDTO existDto = null;
				
				Session session = HibDataSource.getSession();
				Transaction tx = null;
				try {

					tx = session.beginTransaction();

					session.save(dto);

					dto.getId();
					tx.commit();
				} catch (HibernateException e) {
					e.printStackTrace();
					if (tx != null) {
						tx.rollback();

					}
					throw new ApplicationException("Exception in Order Add " + e.getMessage());
				} finally {
					session.close();
				}
				return dto.getId();

			}
		
		public void delete(OrderDTO dto) throws ApplicationException {
			Session session = null;
			Transaction tx = null;
			try {
				session = HibDataSource.getSession();
				tx = session.beginTransaction();
				session.delete(dto);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null) {
					tx.rollback();
				}
				throw new ApplicationException("Exception in Order Delete" + e.getMessage());
			} finally {
				session.close();
			}
		}
		public void update(OrderDTO dto) throws ApplicationException, DuplicateRecordException {
			Session session = null;
			
			Transaction tx = null;

			try {
				session = HibDataSource.getSession();
				tx = session.beginTransaction();
				session.saveOrUpdate(dto);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null) {
					tx.rollback();
				}
				throw new ApplicationException("Exception in Order update" + e.getMessage());
			} finally {
				session.close();
			}
		}

				public OrderDTO findByPK(long pk) throws ApplicationException {
					Session session = null;
					OrderDTO dto = null;
					try {
						session = HibDataSource.getSession();
						dto = (OrderDTO) session.get(OrderDTO.class, pk);

					} catch (HibernateException e) {
						throw new ApplicationException("Exception : Exception in getting Order by pk");
					} finally {
						session.close();
					}

					return dto;
				}

				

		public OrderDTO findByLogin(String login) throws ApplicationException {
			Session session = null;
			OrderDTO dto = null;
			try {
				session = HibDataSource.getSession();
				Criteria criteria = session.createCriteria(OrderDTO.class);
				criteria.add(Restrictions.eq("login", login));
				List list = criteria.list();
				if (list.size() == 1) {
					dto = (OrderDTO) list.get(0);
				}
			} catch (HibernateException e) {
				e.printStackTrace();
				throw new ApplicationException("Exception in getting Order by Login " + e.getMessage());

			} finally {
				session.close();
			}

			return dto;
		}

	
		public List list(int pageNo, int pageSize) throws ApplicationException {
			Session session = null;
			List list = null;
			try {
				session = HibDataSource.getSession();
				Criteria criteria = session.createCriteria(OrderDTO.class);
				if (pageSize > 0) {
					pageNo = (pageNo - 1) * pageSize;
					criteria.setFirstResult(pageNo);
					criteria.setMaxResults(pageSize);

				}
				list = criteria.list();

			} catch (HibernateException e) {
				throw new ApplicationException("Exception : Exception in  Employees list");
			} finally {
				session.close();
			}

			return list;
		}
		
		public List search(OrderDTO dto) throws ApplicationException {
			// TODO Auto-generated method stub
			return null;
		}


		
		@Override
		public List search(OrderDTO dto, int pageNo, int pageSize) throws ApplicationException {

			Session session = null;
			ArrayList<OrderDTO> list = null;
			try {
				session = HibDataSource.getSession();
				Criteria criteria = session.createCriteria(OrderDTO.class);
				if (dto != null) {
					if (dto.getId() != null && dto.getId() > 0) {
						criteria.add(Restrictions.eq("id", dto.getId()));
					}
					if (dto.getName() != null && dto.getName().length() > 0) {
						criteria.add(Restrictions.like("name", dto.getName() + "%"));
					}
					
					  if (dto.getOrderProduct() != null && dto.getOrderProduct().length() > 0) {
					  criteria.add(Restrictions.like("orderProduct", dto.getOrderProduct() + "%"));
					  }

					  if (dto.getAddress()!= null && dto.getAddress().length() > 0) {
					  criteria.add(Restrictions.like("address", dto.getAddress() + "%"));
					  }
					 
					
					if (dto.getDob() !=  null  && dto.getDob().getTime() > 0) {
						criteria.add(Restrictions.eq("dob", dto.getDob()));
					}
					
					
				}
				
				
				if (pageSize > 0) {
					pageNo = (pageNo - 1) * pageSize;
					criteria.setFirstResult(pageNo);
					criteria.setMaxResults(pageSize);
				}
				list = (ArrayList<OrderDTO>) criteria.list();
			} catch (HibernateException e) {
				throw new ApplicationException("Exception in Employee search");
			} finally {
				session.close();
			}

			return list;
		}

		

		
		
	
	}

