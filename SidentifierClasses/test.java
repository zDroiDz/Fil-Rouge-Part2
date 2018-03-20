package model;

public class test {
	
	
	
	public static void main(String[] args) {
		
		BDProfil salut=BDProfil.getInstance();
		ControlSIdentifier controlSIdentifier=new ControlSIdentifier();
		
		for(int i=0;i<100;i++)
		{
			user use=new user("test","test","test");
			salut.ajouterUtilisateur(use);
		}
		
		System.out.println(salut.toString());
		
		System.out.println(" pour le test identifiant=test.test mdp=test");
		BoundarySIdentifier boundarySIdentifier=new BoundarySIdentifier(controlSIdentifier);
		boundarySIdentifier.connexion();
		
	}

}
