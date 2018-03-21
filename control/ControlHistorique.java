package control;

import java.util.List;

import Modeles.BDHistorique;

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
}
