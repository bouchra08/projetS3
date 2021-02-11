package com.crud;

import java.sql.Date;
import java.util.List;

import com.bean.Projet;

public interface DAOprojet {
	public void ajouter_Projet(Projet p);
	public void modifier_Projet(int id_projet, String nom,Date date_lancement,String duree_realisation,Date date_echeance,Float budget,String lieu,String description);
	public void supprimer_Projet(Projet p);
	public List<Projet> AfficherProjets();

}
