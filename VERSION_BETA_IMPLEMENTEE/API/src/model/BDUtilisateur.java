package model;

import java.util.HashMap;
import java.util.Map;


public class BDUtilisateur {
	Map<Integer, Utilisateur> listeUtilisateur = new HashMap<>();
	private BDUtilisateur() {};
	private static class SingletonHolder 
	{
		private final static BDUtilisateur instance =new BDUtilisateur();
	}
	
	public static BDUtilisateur getInstance()
	{
		return SingletonHolder.instance;
	}
	
	public void ajouterUtilisateur(Utilisateur client){
		this.listeUtilisateur.put(this.listeUtilisateur.size(), client);	
	}
	
	public Utilisateur getUtilisateur(int numeroClient){
		return this.listeUtilisateur.get(numeroClient);
	}
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
