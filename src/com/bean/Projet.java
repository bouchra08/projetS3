package com.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projet implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int id_projet;
	String nom;
	Date date_lancement;
	String duree_realisation;
	Date date_echeance;
	Float budget;
	String lieu;
	String description;
	int id_asso;
	public int getId_projet() {
		return id_projet;
	}
	public void setId_projet(int id_projet) {
		this.id_projet = id_projet;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDate_lancement() {
		return date_lancement;
	}
	public void setDate_lancement(Date date_lancement) {
		this.date_lancement = date_lancement;
	}
	public String getDuree_realisation() {
		return duree_realisation;
	}
	public void setDuree_realisation(String duree_realisation) {
		this.duree_realisation = duree_realisation;
	}
	public Date getDate_echeance() {
		return date_echeance;
	}
	public void setDate_echeance(Date date_echeance) {
		this.date_echeance = date_echeance;
	}
	public Float getBudget() {
		return budget;
	}
	public void setBudget(Float budget) {
		this.budget = budget;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId_asso() {
		return id_asso;
	}
	public void setId_asso(int id_asso) {
		this.id_asso = id_asso;
	}
	
	
	

}
