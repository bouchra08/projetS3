package com.crud;

import java.util.List;


import com.bean.Association;


public interface DAOassociation {
	public void ajouter_Association(Association a);
	public int validate(String email, String password);
	public List<Association> AfficherAssociations();
	public List<Association> AfficherUneAssociation(int id);
	

}
