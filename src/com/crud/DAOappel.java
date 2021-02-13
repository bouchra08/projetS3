package com.crud;

import java.sql.Date;

import java.util.List;

import com.bean.Appelaudon;

public interface DAOappel {
	public List<Appelaudon> ajouter_Appelaudon(Appelaudon ap);
	public List<Appelaudon> modifier_Appelaudon(int id_appel, String nom,Float budget,String lieu,String description);
	public List<Appelaudon> supprimer_Appelaudon(Appelaudon ap);
	public List<Appelaudon> AfficherAppelaudons();
	public List<Appelaudon> AfficherAppelaudon(int id);

}
