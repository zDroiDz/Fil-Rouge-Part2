package model;

import java.util.HashMap;
import java.util.Map;


// TODO: Auto-generated Javadoc
/**
 * The Class BDAdministrateur.
 */
public class BDAdministrateur {

	/** The numero personnel. */
	int numeroPersonnel ;
    
    /** The liste admin. */
    Map <Integer,Admin> listeAdmin = new HashMap<>();
    
    /**
     * Instantiates a new BD administrateur.
     */
    private BDAdministrateur() {};
	
	/**
	 * The Class SingletonHolder.
	 */
	private static class SingletonHolder 
	{
		
		/** The Constant instance. */
		private final static  BDAdministrateur instance =new  BDAdministrateur();
	}
	
	/**
	 * Gets the single instance of BDAdministrateur.
	 *
	 * @return single instance of BDAdministrateur
	 */
	public static  BDAdministrateur getInstance()
	{
		return SingletonHolder.instance;
	}
	
	/**
	 * Ajouter personnel.
	 *
	 * @param admin the admin
	 */
	public void ajouterPersonnel(Admin admin){
		this.listeAdmin.put(this.listeAdmin.size(), admin);	
		
	}
	
	/**
	 * Gets the personnel.
	 *
	 * @param numeroAdmin the numero admin
	 * @return the personnel
	 */
	public Admin getPersonnel(int numeroAdmin){
		return this.listeAdmin.get(numeroAdmin);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String retour = "BDAdmin [listePersonnel={";
		int i =0;
		for(Admin p:listeAdmin.values()){
			retour += i +"="+p.toString();
			i++;
		}
		retour += "}]";
		return retour;
	}
	
}
