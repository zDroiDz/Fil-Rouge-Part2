package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDProfil {
	
	private Map<Integer,Profil> lesProfils1;
	
	private BDProfil() {
		this.lesProfils1=new HashMap<>();
	}
	
	 private static class BDProfilHolder
	    {
	        private final static BDProfil instance=new BDProfil();
	    }

	    public static BDProfil getInstance()
	    {
	        return BDProfilHolder.instance;
	    }

	    public  void ajouterUtilisateur(Profil user)
	    {
	        this.lesProfils1.put(this.lesProfils1.size(),user);
	    }

	    public String toString()
	    {
	        return this.lesProfils1.toString();
	    }
	    
	    public Profil connexion(String id,String mdp)
	    {
	    	for(Profil pro:lesProfils1.values())
	    	{
	    		if(pro.getIdentifiant().equals(id) && pro.getMDP().equals(mdp))
	    		{
	    			return pro;
	    		}
	    	}
	    	return null;
	    }
	    
}