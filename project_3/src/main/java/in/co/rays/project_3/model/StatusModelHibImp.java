package in.co.rays.project_3.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.StatusDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class StatusModelHibImp implements  StatusModelInt {


	public long add(StatusDTO dto) throws ApplicationException, DuplicateRecordException {


		StatusDTO existDto = null;
		
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
			throw new ApplicationException("Exception in Status Add " + e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();

	}

	
	public void delete(StatusDTO dto) throws ApplicationException {
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
			throw new ApplicationException("Exception in Bank Delete" + e.getMessage());
		} finally {
			session.close();
		}
	}


	public void update(StatusDTO dto) throws ApplicationException, DuplicateRecordException {
		Session session = null;
		/*
		 * Transaction tx = null; StatusDTO exesistDto = findByLogin(dto.getLogin());
		 * 
		 * if (exesistDto != null && exesistDto.getId() != dto.getId()) { throw new
		 * DuplicateRecordException("Login id already exist"); }
		 */
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
			throw new ApplicationException("Exception in Bank update" + e.getMessage());
		} finally {
			session.close();
		}
	}

	

	public StatusDTO findByPK(long pk) throws ApplicationException {
		Session session = null;
		StatusDTO dto = null;
		try {
			session = HibDataSource.getSession();
			dto = (StatusDTO) session.get(StatusDTO.class, pk);

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in getting Bank by pk");
		} finally {
			session.close();
		}

		return dto;
	}

	

	public StatusDTO findByLogin(String login) throws ApplicationException {
		Session session = null;
		StatusDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(StatusDTO.class);
			criteria.add(Restrictions.eq("login", login));
			List list = criteria.list();
			if (list.size() == 1) {
				dto = (StatusDTO) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in getting Bank by Login " + e.getMessage());

		} finally {
			session.close();
		}

		return dto;
	}

	
	public List list() throws ApplicationException {
		return list(0, 0);
	}

	

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(StatusDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);

			}
			list = criteria.list();

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in  Banks list");
		} finally {
			session.close();
		}

		return list;
	}

	
	public List search(StatusDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	
	public List search(StatusDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub

		Session session = null;
		ArrayList<StatusDTO> list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(StatusDTO.class);
			if (dto != null) {
		
				
				
				  if (dto.getStatus() != null && dto.getStatus().length() > 0) {
				  criteria.add(Restrictions.like("status", dto.getStatus() + "%"));
				  }
							
			System.out.println("searchcalll");
			// if pageSize is greater than 0
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = (ArrayList<StatusDTO>) criteria.list();
			}	} catch (HibernateException e) {
			throw new ApplicationException("Exception in Bank search");
		} finally {
			session.close();
		}

		return list;
	}

	

	public List getRoles(StatusDTO dto) throws ApplicationException {
		return null;
	}




	
}
