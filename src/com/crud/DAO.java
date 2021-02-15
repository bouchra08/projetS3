package com.crud;

import java.util.List;

import com.bean.Donateur;


public interface DAO {
	public void ajouter_Donateur(Donateur d);
	public int validate(String email, String password);
	public void modifier_Donateur(int id_donateur, String nom, String prenom,String email,String tel,String ville,String password);
	public void supprimer_Donateur(Donateur d);
	public List<Donateur> AfficherDonateurs();
	

}
