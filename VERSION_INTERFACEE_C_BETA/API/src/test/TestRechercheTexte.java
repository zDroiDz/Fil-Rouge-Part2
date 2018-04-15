package test;

import control.ControlDescripteurs;
import control.ControlHistorique;
import control.ControlProfil;
import control.ControlRechercher;
import model.BDTexte;
import model.Profil;
import model.Utilisateur;
import vuetextuelle.BoundaryRechercher;

public class TestRechercheTexte {

	public static void main(String[] args) {
		
		/*
		ControlDescripteurs controlDescripteurs = new ControlDescripteurs();
		controlDescripteurs.fillBDDescripteurTexte();
		controlDescripteurs.setPathTexte();

		ControlHistorique controlHistorique = new ControlHistorique();
		ControlProfil controlProfil = new ControlProfil();

		ControlRechercher controlRechercher = new ControlRechercher(controlHistorique, controlProfil );
		BoundaryRechercher boundaryRechercher = new BoundaryRechercher(controlRechercher );
		Profil profil = new Utilisateur("test","test","test");
		profil.setHistorique();
		boundaryRechercher.effectuerRechercheMotCle(profil);
		
		*/
		Profil profil = new Utilisateur("william","ressuge","test");
		ControlHistorique controlHistorique=new ControlHistorique();
		controlHistorique.FillBDHistorique(profil);
	}
		
}