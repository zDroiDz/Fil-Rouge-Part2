package testTextuel;

import java.util.ArrayList;

import Modeles.BDHistorique;
import control.ControlHistorique;
import vue.BoundaryHistorique;

public class testHistorique {
	
	public static void main(String args[]) {

		ControlHistorique controlHistorique = new ControlHistorique();
		BoundaryHistorique boundaryHistorique = new BoundaryHistorique(controlHistorique);
		
		System.out.println("Begin test");
		
		String requeteRecherche1 = "test";
		ArrayList<String> resultatRecherche1 = new ArrayList<>();
		resultatRecherche1.add("res1");
		resultatRecherche1.add("res2");
		resultatRecherche1.add("res3");
		
		String requeteRecherche2 = "toto";
		ArrayList<String> resultatRecherche2 = new ArrayList<>();
		resultatRecherche2.addAll(resultatRecherche1);
		resultatRecherche2.add("tata");
		
		
		boundaryHistorique.ajouterHistorique(requeteRecherche1, resultatRecherche1);
		boundaryHistorique.ajouterHistorique(requeteRecherche2, resultatRecherche2);
		
		System.out.println(controlHistorique); 
		
		boundaryHistorique.consulterHistorique();
		
	}
}