package test;

import control.ControlCreerProfil;
import control.ControlSIdentifier;
import model.BDProfil;
import model.Profil;
import model.Utilisateur;
import vuetextuelle.BoundaryCreerProfilAdmin;
import vuetextuelle.BoundarySIdentifier;

public class TestCreerProfilEtSidentifier {
	
	public static void main(String[] args) {
		/*
		ControlCreerProfil controlCreerProfil=new ControlCreerProfil();
		BoundaryCreerProfilAdmin admin=new BoundaryCreerProfilAdmin(controlCreerProfil);
		
		admin.creerProfil();
		System.out.println(controlCreerProfil.visualiserBDUtilisateur());
		
		*/
		BDProfil salut=BDProfil.getInstance();
		ControlSIdentifier controlSIdentifier=new ControlSIdentifier();
		
		for(int i=0;i<10;i++)
		{
			Profil p=new Utilisateur("test","test","test");
			salut.ajouterUtilisateur(p);
		}
		
		BoundarySIdentifier boundarySIdentifier=new BoundarySIdentifier(controlSIdentifier);
		boundarySIdentifier.connexion();
		
	}

}
