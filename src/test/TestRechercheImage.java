package test;

import control.ControlDescripteurs;
import control.ControlRechercher;
import model.BDImage;
import vuetextuelle.BoundaryRechercher;

public class TestRechercheImage {

	public static void main(String[] args) {
		ControlDescripteurs controlDescripteurs = new ControlDescripteurs();
		controlDescripteurs.fillBDDescripteurImage();
		ControlRechercher controlRechercher = new ControlRechercher();
		BoundaryRechercher boundaryRechercher = new BoundaryRechercher(controlRechercher ) ;
		boundaryRechercher.effectuerRecherchePlageCouleur();
	}
}
