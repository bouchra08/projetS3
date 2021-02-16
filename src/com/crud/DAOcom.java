package com.crud;

import java.util.List;

import com.bean.Commentaire;


public interface DAOcom {
	public void ajouter_Commentaire(Commentaire c);
	public List<Commentaire> AfficherCommentaire(int id_asso);

}
