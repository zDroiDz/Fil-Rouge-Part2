package vuetextuelle;


import model.Profil;
import model.ProfilUtilisateur;
import control.ControlCreerProfil;

public class BoundaryCreerProfilUtilisateur {

	private static ControlCreerProfil controlCreerProfil;
	
	public BoundaryCreerProfilUtilisateur(ControlCreerProfil controlCreerProfil)
	{
		this.controlCreerProfil=controlCreerProfil;
	}
	
	public Profil creerProfil()
	{
		Clavier clavier =new Clavier();
		System.out.println("Veuillez entrez votre prenom");
		String prenom=clavier.entrerClavierString();
		System.out.println("Veuillez entrez votre nom");
		String nom=clavier.entrerClavierString();
		System.out.println("Veuillez entrez votre mot de passe");
		String mdp = clavier.entrerClavierString();
		
	   return this.controlCreerProfil.creerProfil(ProfilUtilisateur.UTILISATEUR, nom, prenom, mdp);
				
		
	}
	
	
	
}
