package com.crud;

import java.util.List;

import com.bean.Association;
import com.bean.Donateur;

public interface DAOassociation {
	public void ajouter_Association(Association a);
	public boolean validate(String email, String password);
	public List<Association> AfficherAssociations();

}
