package com.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assofavorites implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int asso;
	int id_donateur;
	Date date_ajout;
	int id_asso;
	String nom;
	String email;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId_asso() {
		return id_asso;
	}
	public void setId_asso(int id_asso) {
		this.id_asso = id_asso;
	}
	public int getId_donateur() {
		return id_donateur;
	}
	public void setId_donateur(int id_donateur) {
		this.id_donateur = id_donateur;
	}
	

}
