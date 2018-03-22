package model;

import java.util.ArrayList;
import java.util.List;


public class BDMoteur {
private List<Moteur> lesMoteurs;
	
	private BDMoteur() {
		this.lesMoteurs=new ArrayList<>();
	}
	
	 private static class BDMoteurHolder
	    {
	        private final static BDMoteur instance=new BDMoteur();
	    }

	    public static BDMoteur getInstance()
	    {
	        return BDMoteurHolder.instance;
	    }

	    public  void ajouterMoteur(Moteur moteur)
	    {
	        this.lesMoteurs.add(moteur);

	    }

	    public String toString()
	    {
	        return lesMoteurs.toString();
	    }
}
