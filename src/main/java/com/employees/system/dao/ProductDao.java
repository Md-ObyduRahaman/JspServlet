package com.employees.system.dao;


import com.employees.system.model.Product;
import com.employees.system.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDao {



	public Boolean saveProduct(Product product) {
		Boolean flag = false;
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
				return flag;
			}
			e.printStackTrace();
			flag = false;
		}finally {
			return flag;
		}
	}



	public Boolean updateUser(Product product) {
		Transaction transaction = null;
		Boolean flag = false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(product);
			// commit transaction
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				return flag;
			}
			e.printStackTrace();
		}finally {
			return flag;
		}
	}


	public void deleteUser(Long id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Product product = session.get(Product.class, id);
			if (product != null) {
				session.delete(product);
				System.out.println("user is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}


	public Product getUser(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = null;
			Product product = null;
			try {
				transaction = session.beginTransaction();

				// Fetch the product by its ID
				product = session.get(Product.class, id);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	public List<Product> getAllUser(Long userId) {
		Transaction transaction = null;
		List<Product> listOfUser = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Updated query to include parameter binding
			listOfUser = session.createQuery("FROM Product WHERE user_id = :userId", Product.class)
					.setParameter("userId", userId)
					.getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfUser;
	}

}
