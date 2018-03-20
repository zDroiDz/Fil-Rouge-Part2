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
	    
	    
	    

		public static void main(String[] args) {
			
			BDProfil salut=BDProfil.getInstance();
			
			for(int i=0;i<100;i++)
			{
				user use=new user("test","test","test");
				salut.ajouterUtilisateur(use);
			}
			
			System.out.println(salut.toString());
			
		}

}