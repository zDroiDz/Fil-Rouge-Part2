package model;

import java.util.HashMap;
import java.util.Map;


// TODO: Auto-generated Javadoc
/**
 * The Class BDUtilisateur.
 */
public class BDUtilisateur {
	
	/** The liste utilisateur. */
	Map<Integer, Utilisateur> listeUtilisateur = new HashMap<>();
	
	/**
	 * Instantiates a new BD utilisateur.
	 */
	private BDUtilisateur() {};
	
	/**
	 * The Class SingletonHolder.
	 */
	private static class SingletonHolder 
	{
		
		/** The Constant instance. */
		private final static BDUtilisateur instance =new BDUtilisateur();
	}
	
	/**
	 * Gets the single instance of BDUtilisateur.
	 *
	 * @return single instance of BDUtilisateur
	 */
	public static BDUtilisateur getInstance()
	{
		return SingletonHolder.instance;
	}
	
	/**
	 * Ajouter utilisateur.
	 *
	 * @param client the client
	 */
	public void ajouterUtilisateur(Utilisateur client){
		this.listeUtilisateur.put(this.listeUtilisateur.size(), client);	
	}
	
	/**
	 * Gets the utilisateur.
	 *
	 * @param numeroClient the numero client
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur(int numeroClient){
		return this.listeUtilisateur.get(numeroClient);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String retour = "BDUtilisateur [listeUtilisateur={";
		int i =0;
		for(Utilisateur p:listeUtilisateur.values()){
			retour += i +"="+p.toString();
			i++;
		}
		retour += "}]";
		return retour;
	}
	
	
}
