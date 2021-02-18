package com.crud;

import java.util.List;
import com.bean.Donappel;
import com.bean.Donateur;

public interface DAOdonappel{

	public List<Donappel> AfficherDonappels();
	public void ajouter_Donappel(Donappel dp);
}
