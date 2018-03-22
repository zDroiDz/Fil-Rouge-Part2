package test;

import vueTextuelle.BoundaryCreerProfilUtilisateur;
import control.ControlCreerProfil;


public class TestCasCreerProfilClient {

	public static void main(String[] args) {

		// Initialisation controleur du cas
		ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
		// Initialisation vue du cas
	BoundaryCreerProfilUtilisateur boundaryCreerProfilClient = new BoundaryCreerProfilUtilisateur(controlCreerProfil);

		// Lancement du cas
		boundaryCreerProfilClient.creerProfil();

		// Verification de la bonne realisation du cas
		System.out.println("VERIFICATION");
		System.out.println(controlCreerProfil.visualiserBDUtilisateur());
		
		// Resultat du test
		// Veuillez entrer votre nom
		// Dupond
		// Veuillez entrer votre prenom
		// Hector
		// Veuillez entrer votre mot de passe
		// cdh
		// VERIFICATION
		// BDPersonnel [listePersonnel={}]
		// BDClient [listeClient={0=Client [nom=Dupond, prenom=Hector,
		// login=Hector.Dupond, mdp=cdh, connecte=false, historiqueCommandes=[],
		// carteBancaire=null]}]
	}
}
