package model;

import java.util.HashMap;
import java.util.Map;


public class BDAdministrateur {

	int numeroPersonnel ;
    Map <Integer,Admin> listeAdmin = new HashMap<>();
    
    private BDAdministrateur() {};
	private static class SingletonHolder 
	{
		private final static  BDAdministrateur instance =new  BDAdministrateur();
	}
	
	public static  BDAdministrateur getInstance()
	{
		return SingletonHolder.instance;
	}
	public void ajouterPersonnel(Admin admin){
		this.listeAdmin.put(this.listeAdmin.size(), admin);	
		
	}
	public Admin getPersonnel(int numeroAdmin){
		return this.listeAdmin.get(numeroAdmin);
	}
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
