package com.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commentaire implements Serializable {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_c;
	int id_asso;
	int id_donateur;
	Date date_creation;
	String description;
	public int getId_asso() {
		return id_asso;
	}
	public void setId_asso(int id_asso) {
		this.id_asso = id_asso;
	}
	public int getId_donateur() {
		return id_donateur;
	}
	public int getId_c() {
		return id_c;
	}
	public void setId_donateur(int id_donateur) {
		this.id_donateur = id_donateur;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creationt(Date date_creation) {
		this.date_creation= date_creation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
