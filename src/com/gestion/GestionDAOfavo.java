package com.gestion;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bean.Assofavorites;

import com.crud.Daoassofavorites;

public class GestionDAOfavo implements Daoassofavorites{
	@Override
	public void ajouter_Assofavorites(Assofavorites af) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(af);
		transaction.commit();
		session.close();		
	}
	public List<Assofavorites> AfficherAssofavorites(int id_donateur){		
		List<Assofavorites> assofavoList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String qr = "FROM Assofavorites WHERE id_donateur="+id_donateur; //Entity name
		Query query = session.createQuery(qr);
		assofavoList = query.list();
		return assofavoList ;
	}

}
