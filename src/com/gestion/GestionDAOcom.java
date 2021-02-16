package com.gestion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Commentaire;
import com.crud.DAOcom;


public class GestionDAOcom implements DAOcom{
	@Override
	public void ajouter_Commentaire(Commentaire c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		session.close();		
	}
	public List<Commentaire> AfficherCommentaire(int id_asso){		
		List<Commentaire> commentaireList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String qr = "FROM Commentaire WHERE id_donateur="+id_asso; //Entity name
		Query query = session.createQuery(qr);
		commentaireList = query.list();
		return commentaireList;
	}

}
