package com.gestion;

import com.crud.DAO;

import com.bean.Association;
import com.bean.Donateur;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.Query;

public class GestionDAO  implements DAO{
	@Override
	public void ajouter_Donateur(Donateur d) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(d);
		transaction.commit();
		session.close();		
	}
	public int validate(String email, String password) {

        Transaction transaction = null;
        Donateur d = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            d = (Donateur) session.createQuery("FROM Donateur d WHERE d.email= :email").setParameter("email", email)
                .uniqueResult();

            if (d != null && d.getPassword().equals(password)) {
                return  d.getId_donateur();
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }
	
	public void modifier_Donateur(int id_donateur, String nom, String prenom,String email,String tel,String ville,String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Donateur dn = (Donateur) session.load(Donateur.class,id_donateur);
		dn.setNom(nom);
		dn.setPrenom(prenom);
		dn.setEmail(email);
		dn.setTel(tel);
		dn.setVille(ville);
		dn.setPassword(password);
		
		session.update(dn);
		transaction.commit();
		session.close();			
	}
	
	public void supprimer_Donateur(Donateur d) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();		
		session.delete(d);
        transaction.commit();
		session.close();	

	}
	
	public List<Donateur> AfficherDonateurs(){		
		List<Donateur> donateurList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String qr = "FROM Donateur"; //Entity name
		Query query = session.createQuery(qr);
		donateurList = query.list();
		return donateurList;
	}
}
