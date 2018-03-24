package test;

import control.ControlDescripteurs;
import control.ControlRechercher;
import model.BDTexte;
import vuetextuelle.BoundaryRechercher;

public class TestRechercheTexte {

	public static void main(String[] args) {
	
		ControlDescripteurs controlDescripteurs = new ControlDescripteurs();
		controlDescripteurs.fillBDDescripteurTexte();
		controlDescripteurs.setPathTexte();
		ControlRechercher controlRechercher = new ControlRechercher();
		BoundaryRechercher boundaryRechercher = new BoundaryRechercher(controlRechercher );
		boundaryRechercher.effectuerRechercheMotCle();
	}
		
}
