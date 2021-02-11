package com.gestion;

import com.crud.DAOdonappel;

import com.bean.Donappel;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.Query;

public class GestionDAOdon implements DAOdonappel {
	@Override
	public List<Donappel> AfficherDonappels(){		
		List<Donappel> donappelList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String qr = "FROM Donappel"; //Entity name
		Query query = session.createQuery(qr);
		donappelList  = query.list();
		return donappelList ;
	}
	
}
