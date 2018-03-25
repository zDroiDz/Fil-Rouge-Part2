package control;

import java.util.List;

import model.BDHistorique;
import model.Descripteur;



public class ControlHistorique {

	private BDHistorique BDhistorique = BDHistorique.getInstance();
	
	public ControlHistorique() {
		
	}
	
	public List<String> consulterHistoriqueRecherche(int idHistorique){
		return BDhistorique.getResultatsRecherche(idHistorique);
	}
	
	public List<String> consulterListeRecherche(){
		return BDhistorique.getListeRecherche();
	}

	public void ajouterHistorique(String requeteRecherche, List<String> resultatRecherche) {
		BDhistorique.ajouterRecherche(requeteRecherche, resultatRecherche);
	}
	
	public String toString() {
		return ("Affichage BD : " + BDhistorique.toString() + "\n");
	}

	
}
