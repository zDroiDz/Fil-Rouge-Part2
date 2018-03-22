package test;

import control.ControlCreerProfil;
import control.ControlSIdentifier;
import model.BDProfil;

import vuetextuelle.BoundaryCreerProfilAdmin;
import vuetextuelle.BoundarySIdentifier;

public class TestCreerProfilEtSidentifier {
	
	public static void main(String[] args) {
		ControlCreerProfil controlCreerProfil=new ControlCreerProfil();
		BoundaryCreerProfilAdmin admin=new BoundaryCreerProfilAdmin(controlCreerProfil);
		
		BDProfil salut=BDProfil.getInstance();
		ControlSIdentifier controlSIdentifier=new ControlSIdentifier();
		
		
		admin.creerProfil();
		System.out.println(controlCreerProfil.visualiserBDUtilisateur());
		
		BoundarySIdentifier boundarySIdentifier=new BoundarySIdentifier(controlSIdentifier);
		boundarySIdentifier.connexion();
		
		
	}

}
