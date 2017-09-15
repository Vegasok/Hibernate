package Vegas.org;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;

import models.ProductCategory;
import models.Product;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		List<Product> products = null;
		try {
			session.beginTransaction();
			/*----------SQL queries-------------*/
			/*SQLQuery queryUpdate = session.createSQLQuery("UPDATE product SET title = :title WHERE id = :id");
			queryUpdate.setParameter("title", "test");
			queryUpdate.setParameter("id", "1");
			queryUpdate.executeUpdate();
			
			SQLQuery querySelect = session.createSQLQuery("SELECT {p.*}, {pc.*} FROM product p INNER JOIN product_category pc ON p.product_category_id = pc.id ");
			querySelect.addEntity("p", models.Product.class);
			querySelect.addJoin("pc", "p.productCategory");
			products = querySelect.list();*/
			
			/*----------HQL queries-------------*/
			/*Query query = session.createQuery("FROM Product as p INNER JOIN p.productCategory as pc WITH pc.id = :id");
			query.setParameter("id", 1L);
			products = query.list();*/
			
			/*----------Criteria queries-------------*/
			Criteria criteria = session.createCriteria(Product.class);	
			criteria.add(Restrictions.eq("title", "title2"));
			//criteria.add(Restrictions.between("price", 10, 20));
			//criteria.add(Restrictions.like("price", "test"));
			//criteria.add(Restrictions.or(Restrictions.not(Restrictions.in("id", someArray)));
			//criteria.add(Restrictions.sqlRestriction("data > 10.20.2004"));
			criteria.addOrder(Order.desc("id"));

			products = criteria.list();
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			log.error("message ....", e);
		}finally{
			session.close();
			sessionFactory.close();
		}		
		
		for(Product product: products) {
			System.out.println(product.toString());
		}
	}
}

