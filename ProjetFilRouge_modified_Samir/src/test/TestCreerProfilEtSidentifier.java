package test;

import control.ControlCreerProfil;
import control.ControlSIdentifier;
import model.BDProfil;
import vuetextuelle.BoundaryCreerProfilAdmin;
import vuetextuelle.BoundaryCreerProfilUtilisateur;
import vuetextuelle.BoundarySIdentifier;

public class TestCreerProfilEtSidentifier {
	
	public static void main(String[] args) {
		ControlCreerProfil controlCreerProfil=new ControlCreerProfil();
		BoundaryCreerProfilUtilisateur utilisateur=new BoundaryCreerProfilUtilisateur(controlCreerProfil);
		BoundaryCreerProfilAdmin admin=new BoundaryCreerProfilAdmin(controlCreerProfil);
		utilisateur.creerProfil();
		admin.creerProfil();
		System.out.println(controlCreerProfil.visualiserBDUtilisateur());
		
		
	
		BDProfil salut=BDProfil.getInstance();
		ControlSIdentifier controlSIdentifier=new ControlSIdentifier();
		
		
		
		//System.out.println(controlCreerProfil.visualiserBDUtilisateur());
		
		BoundarySIdentifier boundarySIdentifier=new BoundarySIdentifier(controlSIdentifier);
		boundarySIdentifier.connexion();
		
		
	}

}
