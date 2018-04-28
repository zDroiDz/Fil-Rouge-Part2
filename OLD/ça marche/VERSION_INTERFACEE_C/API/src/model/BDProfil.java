package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import control.ControlProfil;

public class BDProfil {
	
	private Map<Integer,Profil> lesProfils;
	
	private BDProfil() {
		this.lesProfils=new HashMap<>();
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
	        this.lesProfils.put(this.lesProfils.size(),user);
	    }

	    public List<Profil> getProfils(){
	    	List<Profil> list = new ArrayList<>();
	    	list.addAll(lesProfils.values());
	    	return list;
	    }
	    
	    public String toString()
	    {
	        return this.lesProfils.toString();
	    }
	    
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