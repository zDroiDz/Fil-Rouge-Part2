package vuetextuelle;

import model.ProfilUtilisateur;
import control.ControlCreerProfil;

public class BoundaryCreerProfilAdmin {

	private static ControlCreerProfil controlCreerProfil;
	
	public BoundaryCreerProfilAdmin(ControlCreerProfil controlCreerProfil)
	{
		this.controlCreerProfil=controlCreerProfil;
	}
	
	public void creerProfil()
	{
		Clavier clavier =new Clavier();

		System.out.println("Veuillez entrez prenom : ");
		String prenom=clavier.entrerClavierString();
		System.out.println("Veuillez entrez le nom : ");
		String nom=clavier.entrerClavierString();
		System.out.println("Veuillez entrez le mot de passe : ");
		String mdp = clavier.entrerClavierString();
		
	    this.controlCreerProfil.creerProfil(ProfilUtilisateur.ADMIN, prenom, nom, mdp);
	 }
	
	
}
