package vueTextuelle;

import control.ControlChangerModeRecherche;
import control.ControlConfigurer;
import control.ControlSIdentifier;

public class BoundaryChangerModeRecherche {

	private ControlChangerModeRecherche controlChangerModeRecherche;
	private ControlSIdentifier controlSIdentifier;

	
	public BoundaryChangerModeRecherche(ControlChangerModeRecherche controlChangerModeRecherche){
		this.controlChangerModeRecherche= controlChangerModeRecherche;
	}
	
	public void  changerModeRecherche (){ // methode connexion() ds le diag de classe
		int choix;
	//	if (controlConfigurer.connexion()){
		Clavier clavier = new Clavier();
		System.out.println("Choississez le mode de recherche");
		System.out.println("1 : mode ouvert");
		System.out.println("2 : mode ferme");
		choix=clavier.entrerClavierInt();
		
			if(controlChangerModeRecherche.setMode(choix)){
				System.out.println("Changement de mode reussi");
			}
			else {
				System.out.println("Probleme lors du changement de mode : mode inchange");
			}
		
	//}

	}

}
