package com.crud;

import java.sql.Date;
import java.util.List;

import com.bean.Projet;

public interface DAOprojet {
	public List<Projet> ajouter_Projet(Projet p);
	public List<Projet> modifier_Projet(int id_projet, String nom,String duree_realisation,Date date_echeance,Float budget,String lieu,String description);
	public List<Projet> supprimer_Projet(Projet p);
	public List<Projet> AfficherProjets();
	public List<Projet> AfficherProjet(int id);

}
