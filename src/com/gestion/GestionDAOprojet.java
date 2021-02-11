package com.gestion;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Projet;
import com.crud.DAOprojet;

public class GestionDAOprojet implements DAOprojet{
	@Override
	public void ajouter_Projet(Projet p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();		
	}
	
	public void modifier_Projet(int id_projet, String nom,Date date_lancement,String duree_realisation,Date date_echeance,Float budget,String lieu,String description) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Projet p = (Projet) session.load(Projet.class,id_projet);
		p.setNom(nom);
		p.setDate_lancement(date_lancement);
		p.setDuree_realisation(duree_realisation);
		p.setDate_echeance(date_echeance);
		p.setBudget(budget);
		p.setLieu(lieu);
		p.setDescription(description);
		
		
		session.update(p);
		transaction.commit();
		session.close();			
	}
	
	public void supprimer_Projet(Projet p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();		
		session.delete(p);
        transaction.commit();
		session.close();	

	}
	
	public List<Projet> AfficherProjets(){		
		List<Projet> projetList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String qr = "FROM Projet"; //Entity name
		Query query = session.createQuery(qr);
		projetList  = query.list();
		return projetList ;
	}

}
