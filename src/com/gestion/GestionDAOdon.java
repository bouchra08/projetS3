package com.gestion;

import com.crud.DAOdonappel;

import com.bean.Donappel;
import com.bean.Donateur;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.Query;

public class GestionDAOdon implements DAOdonappel {
	@Override
	public void ajouter_Donappel(Donappel dp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(dp);
		transaction.commit();
		session.close();		
	}
	public List<Donappel> AfficherDonappels(){		
		List<Donappel> donappelList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String qr = "FROM Donappel"; //Entity name
		Query query = session.createQuery(qr);
		donappelList  = query.list();
		return donappelList ;
	}
	
}
