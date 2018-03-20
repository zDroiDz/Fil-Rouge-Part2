package model;

import java.util.ArrayList;
import java.util.List;

public class BDProfil {
	
	private List<Profil> lesProfils;
	
	private BDProfil() {
		this.lesProfils=new ArrayList<>();
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
	        this.lesProfils.add(user);

	    }

	    public String toString()
	    {
	        return lesProfils.toString();
	    }
	    
	    public Profil connexion(String id,String mdp)
	    {
	    	for(Profil pro:lesProfils)
	    	{
	    		if(pro.getIdentifiant().equals(id) && pro.getMDP().equals(mdp))
	    		{
	    			return pro;
	    		}
	    	}
	    	
	    	return null;
	    }
	    

}