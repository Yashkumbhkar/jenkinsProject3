package in.co.rays.project_3.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.ClientDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class ClientModelHibImp implements ClientModelInt {

	  
	public long add(ClientDTO dto) throws ApplicationException, DuplicateRecordException {

		ClientDTO existDto = null;
			
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
	
	public void delete(ClientDTO dto) throws ApplicationException {
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
	public void update(ClientDTO dto) throws ApplicationException, DuplicateRecordException {
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

			public ClientDTO findByPK(long pk) throws ApplicationException {
				Session session = null;
				ClientDTO dto = null;
				try {
					session = HibDataSource.getSession();
					dto = (ClientDTO) session.get(ClientDTO.class, pk);

				} catch (HibernateException e) {
					throw new ApplicationException("Exception : Exception in getting Order by pk");
				} finally {
					session.close();
				}

				return dto;
			}

			

	public ClientDTO findByLogin(String login) throws ApplicationException {
		Session session = null;
		ClientDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(ClientDTO.class);
			criteria.add(Restrictions.eq("login", login));
			List list = criteria.list();
			if (list.size() == 1) {
				dto = (ClientDTO) list.get(0);
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
			Criteria criteria = session.createCriteria(ClientDTO.class);
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
	
	public List search(ClientDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}


	
	@Override
	public List search(ClientDTO dto, int pageNo, int pageSize) throws ApplicationException {

		Session session = null;
		ArrayList<ClientDTO> list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(ClientDTO.class);
			if (dto != null) {
				if (dto.getId() != null && dto.getId() > 0) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				if (dto.getName() != null && dto.getName().length() > 0) {
					criteria.add(Restrictions.like("name", dto.getName() + "%"));
				}
				
				  if (dto.getAddress() != null && dto.getAddress().length() > 0) {
				  criteria.add(Restrictions.like("address", dto.getAddress() + "%"));
				  }

				/*
				 * if (dto.getPhone() != null && dto.getPhone() > 0) {
				 * criteria.add(Restrictions.eq("phone", dto.getPhone())); }
				 * 
				 */				
				if (dto.getPriority() !=  null  && dto.getPriority().length() > 0) {
					criteria.add(Restrictions.like("priority", dto.getPriority() + "%"));
				}
				
				
			}
			
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = (ArrayList<ClientDTO>) criteria.list();
		} catch (HibernateException e) {
			throw new ApplicationException("Exception in Employee search");
		} finally {
			session.close();
		}

		return list;
	}

	

	
	
}
