package vuetextuelle;



import control.ControlChangerModeRecherche;
import control.ControlSIdentifier;

public class BoundaryChangerModeRecherche {

	private ControlChangerModeRecherche controlChangerModeRecherche;
	private ControlSIdentifier controlSIdentifier;

	
	public BoundaryChangerModeRecherche(ControlChangerModeRecherche controlChangerModeRecherche){
		this.controlChangerModeRecherche= controlChangerModeRecherche;
	}
	
	public void  changerModeRecherche (){ 
		int choix;
		Clavier clavier = new Clavier();
		System.out.println("Choississez le mode de recherche");
		System.out.println("1 : mode ouvert");
		System.out.println("2 : mode ferme");
		choix=clavier.entrerClavierInt();
		
		controlChangerModeRecherche.setMode(choix);

	}

}
