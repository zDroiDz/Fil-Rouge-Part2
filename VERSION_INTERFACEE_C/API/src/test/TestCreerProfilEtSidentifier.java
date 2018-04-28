package test;

import control.ControlCreerProfil;
import control.ControlSIdentifier;
import model.BDProfil;

public class TestCreerProfilEtSidentifier {
	
	public static void main(String[] args) {
		ControlCreerProfil controlCreerProfil=new ControlCreerProfil();
	//	BoundaryCreerProfilAdmin admin=new BoundaryCreerProfilAdmin(controlCreerProfil);
		
	//	admin.creerProfil();
		System.out.println(controlCreerProfil.visualiserBDUtilisateur());
		
		
		/*
		BDProfil salut=BDProfil.getInstance();
		ControlSIdentifier controlSIdentifier=new ControlSIdentifier();
		
		
		admin.creerProfil();
		System.out.println(controlCreerProfil.visualiserBDUtilisateur());
		
		BoundarySIdentifier boundarySIdentifier=new BoundarySIdentifier(controlSIdentifier);
		boundarySIdentifier.connexion();*/
		
		
	}

}
