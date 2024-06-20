package in.co.rays.project_3.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.PatientDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class PatientModelHibImp implements PatientModeInt{
	
	
	public long add(PatientDTO dto) throws ApplicationException, DuplicateRecordException {


		PatientDTO existDto = null;
		
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
			throw new ApplicationException("Exception in Employee Add " + e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();

	}

	
	public void delete(PatientDTO dto) throws ApplicationException {
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
			throw new ApplicationException("Exception in Employee Delete" + e.getMessage());
		} finally {
			session.close();
		}
	}


	public void update(PatientDTO dto) throws ApplicationException, DuplicateRecordException {
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
			throw new ApplicationException("Exception in Employee update" + e.getMessage());
		} finally {
			session.close();
		}
	}

	

	public PatientDTO findByPK(long pk) throws ApplicationException {
		Session session = null;
		PatientDTO dto = null;
		try {
			session = HibDataSource.getSession();
			dto = (PatientDTO) session.get(PatientDTO.class, pk);

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in getting Employee by pk");
		} finally {
			session.close();
		}

		return dto;
	}

	

	public PatientDTO findByLogin(String login) throws ApplicationException {
		Session session = null;
		PatientDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(PatientDTO.class);
			criteria.add(Restrictions.eq("login", login));
			List list = criteria.list();
			if (list.size() == 1) {
				dto = (PatientDTO) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in getting Employee by Login " + e.getMessage());

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
			Criteria criteria = session.createCriteria(PatientDTO.class);
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

	
	public List search(PatientDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	
	public List search(PatientDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub

		Session session = null;
		ArrayList<PatientDTO> list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(PatientDTO.class);
			if (dto != null) {
				if (dto.getId() != null && dto.getId() > 0) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				if (dto.getName() != null && dto.getName().length() > 0) {
					criteria.add(Restrictions.like("name", dto.getName() + "%"));
				}
				
				/*
				 * if (dto.getDateOfVisit != null && dto.getDateOfVisit().getTime() > 0) {
				 * criteria.add(Restrictions.like("salary", getDateOfVisit) + "%")); }
				 */

				  if (dto.getMobile() != null ) {
				  criteria.add(Restrictions.eq("mobile", dto.getMobile() ));
				  }
				  
				
				
				  if (dto.getDecease() != null && dto.getDecease().length() > 0) {
				  criteria.add(Restrictions.eq("decease", dto.getDecease())); }
				 
				
				if (dto.getDateOfVisit() != null && dto.getDateOfVisit().getTime() > 0) {
					criteria.add(Restrictions.eq("dateOfVisit", dto.getDateOfVisit()));
				}
				
				
			}
			
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = (ArrayList<PatientDTO>) criteria.list();
		} catch (HibernateException e) {
			throw new ApplicationException("Exception in Employee search");
		} finally {
			session.close();
		}

		return list;
	}

	

	public List getRoles(PatientDTO dto) throws ApplicationException {
		return null;
	}



	
	

}
