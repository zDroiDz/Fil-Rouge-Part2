package model;

import java.util.ArrayList;
import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class BDMoteur.
 */
public class BDMoteur {

/** The les moteurs. */
private List<Moteur> lesMoteurs;
	
	/**
	 * Instantiates a new BD moteur.
	 */
	private BDMoteur() {
		this.lesMoteurs=new ArrayList<>();
	}
	
	 /**
 	 * The Class BDMoteurHolder.
 	 */
 	private static class BDMoteurHolder
	    {
	        
        	/** The Constant instance. */
        	private final static BDMoteur instance=new BDMoteur();
	    }

	    /**
    	 * Gets the single instance of BDMoteur.
    	 *
    	 * @return single instance of BDMoteur
    	 */
    	public static BDMoteur getInstance()
	    {
	        return BDMoteurHolder.instance;
	    }

	    /**
    	 * Ajouter moteur.
    	 *
    	 * @param moteur the moteur
    	 */
    	public  void ajouterMoteur(Moteur moteur)
	    {
	        this.lesMoteurs.add(moteur);

	    }

	    /* (non-Javadoc)
    	 * @see java.lang.Object#toString()
    	 */
    	public String toString()
	    {
	        return lesMoteurs.toString();
	    }
}
