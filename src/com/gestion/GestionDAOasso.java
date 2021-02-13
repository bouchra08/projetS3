package com.gestion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Association;
import com.bean.Donateur;
import com.crud.DAOassociation;

public class GestionDAOasso  implements DAOassociation{
	@Override
	public void ajouter_Association(Association a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(a);
		transaction.commit();
		session.close();		
	}
	public boolean validate(String email, String password) {

        Transaction transaction = null;
        Association a = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            a = (Association) session.createQuery("FROM Association a WHERE a.email= :email").setParameter("email", email)
                .uniqueResult();

            if (a != null && a.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
	public List<Association> AfficherAssociations(){		
		List<Association> associationList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String qr = "FROM Association"; //Entity name
		Query query = session.createQuery(qr);
		associationList = query.list();
		return associationList ;
	}

}
