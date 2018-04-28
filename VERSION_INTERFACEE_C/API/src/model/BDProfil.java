package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import control.ControlProfil;

// TODO: Auto-generated Javadoc
/**
 * The Class BDProfil.
 */
public class BDProfil {
	
	/** The les profils. */
	private Map<Integer,Profil> lesProfils;
	
	/**
	 * Instantiates a new BD profil.
	 */
	private BDProfil() {
		this.lesProfils=new HashMap<>();
	}
	
	 /**
 	 * The Class BDProfilHolder.
 	 */
 	private static class BDProfilHolder
	    {
	        
        	/** The Constant instance. */
        	private final static BDProfil instance=new BDProfil();
	    }

	    /**
    	 * Gets the single instance of BDProfil.
    	 *
    	 * @return single instance of BDProfil
    	 */
    	public static BDProfil getInstance()
	    {
	        return BDProfilHolder.instance;
	    }

	    /**
    	 * Ajouter utilisateur.
    	 *
    	 * @param user the user
    	 */
    	public  void ajouterUtilisateur(Profil user)
	    {
	        this.lesProfils.put(this.lesProfils.size(),user);
	    }

	    /**
    	 * Gets the profils.
    	 *
    	 * @return the profils
    	 */
    	public List<Profil> getProfils(){
	    	List<Profil> list = new ArrayList<>();
	    	list.addAll(lesProfils.values());
	    	return list;
	    }
	    
	    /* (non-Javadoc)
    	 * @see java.lang.Object#toString()
    	 */
    	public String toString()
	    {
	        return this.lesProfils.toString();
	    }
	    
	    /**
    	 * Connexion.
    	 *
    	 * @param id the id
    	 * @param mdp the mdp
    	 * @return the profil
    	 */
    	public Profil connexion(String id,String mdp)
	    {
	    	for(Profil pro:lesProfils.values())
	    	{
	    		if(pro.getIdentifiant().equals(id) && pro.getMDP().equals(mdp))
	    		{
	    			return pro;
	    		}
	    	}
	    	return null;
	    }
	    
}