package com.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Donappel implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_appel;
	int id_donateur;
	Float montant;
	String devise;
	Date date_don;
	int id_asso;
	
	public int getId_asso() {
		return id_asso;
	}
	public void setId_asso(int id_asso) {
		this.id_asso = id_asso;
	}
	public Date getDate_don() {
		return date_don;
	}
	public void setDate_don(Date date_don) {
		this.date_don = date_don;
	}
	public int getId_appel() {
		return id_appel;
	}
	public void setId_appel(int id_appel) {
		this.id_appel = id_appel;
	}
	public int getId_donateur() {
		return id_donateur;
	}
	public void setId_donateur(int id_donateur) {
		this.id_donateur = id_donateur;
	}
	public Float getMontant() {
		return montant;
	}
	public void setMontant(Float montant) {
		this.montant = montant;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	
}
