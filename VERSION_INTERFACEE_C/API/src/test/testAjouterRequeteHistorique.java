package test;


import java.util.HashMap;

import control.ControlHistorique;
import control.ControlProfil;
import control.ControlRequeteRecherche;
import model.BDProfil;
import model.Utilisateur;

public class testAjouterRequeteHistorique {
	
	
	public static void main(String[] args) {
		
		ControlProfil controlProfil=new ControlProfil();
		ControlHistorique controlHistorique = new ControlHistorique();
		
		controlProfil.FillBDProfils();
		BDProfil bdprofil = BDProfil.getInstance();
		
		Utilisateur user=new Utilisateur("admin", "admin", "admin");

		
		HashMap<String,String> test = new HashMap<String, String>();
		test.put("test1", "test2");
		test.put("Samir", "menaa");
		
		ControlRequeteRecherche requete = new ControlRequeteRecherche("testRequete", "testUtilisateur", "testType", test);
		
		
		controlProfil.addHistoricContent(user,requete.getStockageBD());

		controlHistorique.FillBDHistorique(user);
		System.out.println(bdprofil.toString());
		System.out.println(controlHistorique);
		
	}

}