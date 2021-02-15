package com.crud;

import java.util.List;

import com.bean.Assofavorites;

public interface Daoassofavorites {
	public void ajouter_Assofavorites(Assofavorites af);
	
	public List<Assofavorites> AfficherAssofavorites(int id_donateur);

}
