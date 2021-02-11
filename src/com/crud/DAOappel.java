package com.crud;

import java.sql.Date;

import java.util.List;

import com.bean.Appelaudon;

public interface DAOappel {
	public void ajouter_Appelaudon(Appelaudon ap);
	public void modifier_Appelaudon(int id_appel, String nom,Date date_lancement,Date date_echeance,Float budget,String lieu,String description);
	public void supprimer_Appelaudon(Appelaudon ap);
	public List<Appelaudon> AfficherAppelaudons();

}
