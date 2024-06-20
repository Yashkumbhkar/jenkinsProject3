package in.co.rays.project_3.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.ProductDetailsDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class ProductDetailsHibImp  implements ProductDetailsModelInt {
	
	
	@Override
	public long add(ProductDetailsDTO dto) throws ApplicationException, DuplicateRecordException {
		

		ProductDetailsDTO existDto = null;
		
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
			throw new ApplicationException("Exception in Product Add " + e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();

	}

	@Override
	public void delete(ProductDetailsDTO dto) throws ApplicationException {
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
			throw new ApplicationException("Exception in Product Delete" + e.getMessage());
		} finally {
			session.close();
		}
	}
		
	

	@Override
	public void update(ProductDetailsDTO dto) throws ApplicationException, DuplicateRecordException {
		Session session = null;
		/*
		 * Transaction tx = null; ProductDetailsDTO exesistDto = findByLogin(dto.getLogin());
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
			throw new ApplicationException("Exception in Product update" + e.getMessage());
		} finally {
			session.close();
		}
		
	}

	@Override
	public ProductDetailsDTO findByPK(long pk) throws ApplicationException {
		Session session = null;
		ProductDetailsDTO dto = null;
		try {
			session = HibDataSource.getSession();
			dto = (ProductDetailsDTO) session.get(ProductDetailsDTO.class, pk);

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in getting Product by pk");
		} finally {
			session.close();
		}

		return dto;

	}

	@Override
	public ProductDetailsDTO findByLogin(String login) throws ApplicationException {
		Session session = null;
		ProductDetailsDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(ProductDetailsDTO.class);
			criteria.add(Restrictions.eq("login", login));
			List list = criteria.list();
			if (list.size() == 1) {
				dto = (ProductDetailsDTO) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in getting Product by Login " + e.getMessage());

		} finally {
			session.close();
		}

		return dto;
	}
	@Override
	public List list() throws ApplicationException {
		return list(0, 0);

	}

	@Override
	public List list(int pageNo, int pageSize) throws ApplicationException {
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(ProductDetailsDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);

			}
			list = criteria.list();

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in  Products list");
		} finally {
			session.close();
		}

		return list;
	}

	
	
	@Override
	public List search(ProductDetailsDTO dto, int pageNo, int pageSize) throws ApplicationException {
		Session session = null;
		ArrayList<ProductDetailsDTO> list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(ProductDetailsDTO.class);
			if (dto != null) {
				if (dto.getId() != null && dto.getId() > 0) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				if (dto.getName() != null && dto.getName().length() > 0) {
					criteria.add(Restrictions.like("name", dto.getName() + "%"));
				}
				
				  if (dto.getPrice() != null && dto.getPrice().length() > 0) {
				  criteria.add(Restrictions.eq("price", dto.getPrice() ));
				  }
				/*
				 * if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				 * criteria.add(Restrictions.like("login", dto.getLogin() + "%")); }
				 */
							/*
				 * if (dto.getGender() != null && dto.getGender().length() > 0) {
				 * criteria.add(Restrictions.like("gender", dto.getGender() + "%")); }
				 */
				if (dto.getDateOfPurchase() != null && dto.getDateOfPurchase().getTime() > 0) {
					criteria.add(Restrictions.eq("dateOfPurchase", dto.getDateOfPurchase()));
				}
				if (dto.getCategory() != null && dto.getCategory().length() > 0) {
					criteria.add(Restrictions.eq("category", dto.getCategory()));
				}
				
			}
			
			System.out.println("searchcalll");
			// if pageSize is greater than 0
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = (ArrayList<ProductDetailsDTO>) criteria.list();
		} catch (HibernateException e) {
			throw new ApplicationException("Exception in Product search");
		} finally {
			session.close();
		}

		return list;
	}
	

	@Override
	public List search(ProductDetailsDTO dto) throws ApplicationException {
		return search(dto, 0, 0);
		
	}

	@Override
	public List getRoles(ProductDetailsDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}


}
