package in.co.rays.project_3.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.LessionDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class LessionModelHib implements LessionModelInt {

	public long add(LessionDTO dto) throws ApplicationException, DuplicateRecordException {

		LessionDTO existDto = null;

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

	public void delete(LessionDTO dto) throws ApplicationException {
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

	public void update(LessionDTO dto) throws ApplicationException, DuplicateRecordException {
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

	public LessionDTO findByPK(long pk) throws ApplicationException {
		Session session = null;
		LessionDTO dto = null;
		try {
			session = HibDataSource.getSession();
			dto = (LessionDTO) session.get(LessionDTO.class, pk);

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in getting Employee by pk");
		} finally {
			session.close();
		}

		return dto;
	}

	public LessionDTO findByLogin(String login) throws ApplicationException {
		Session session = null;
		LessionDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(LessionDTO.class);
			criteria.add(Restrictions.eq("login", login));
			List list = criteria.list();
			if (list.size() == 1) {
				dto = (LessionDTO) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in getting Lession by Login " + e.getMessage());

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
			Criteria criteria = session.createCriteria(LessionDTO.class);
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

	public List search(LessionDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public List search(LessionDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub

		Session session = null;
		ArrayList<LessionDTO> list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(LessionDTO.class);
			if (dto != null) {
				if (dto.getId() != null && dto.getId() > 0) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				if (dto.getName() != null && dto.getName().length() > 0) {
					System.out.println("in model search method >> " + dto.getName());
					criteria.add(Restrictions.like("name", dto.getName() + "%"));
				}

				if (dto.getAuthorName() != null && dto.getAuthorName().length() > 0) {
					criteria.add(Restrictions.like("authorName", dto.getAuthorName() + "%"));
				}

				if (pageSize > 0) {
					pageNo = (pageNo - 1) * pageSize;
					criteria.setFirstResult(pageNo);
					criteria.setMaxResults(pageSize);
				}
			}
			list = (ArrayList<LessionDTO>) criteria.list();
		} catch (HibernateException e) {
			throw new ApplicationException("Exception in Lession search");
		} finally {
			session.close();
		}
		return list;

	}

	@Override
	public List getRoles(LessionDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
}