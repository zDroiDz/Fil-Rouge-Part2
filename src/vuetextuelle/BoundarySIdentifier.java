package vuetextuelle;

import java.util.Scanner;

import control.ControlSIdentifier;
import model.Profil;

public class BoundarySIdentifier {
	
	ControlSIdentifier controlSIdentifier;
	
	
	public BoundarySIdentifier(ControlSIdentifier controlSIdentifier)
	{
		this.controlSIdentifier=controlSIdentifier;
	}
	
	public Profil connexion()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Veuillez saisir votre idendifiant (prenom.nom)");
		String identifiant=sc.nextLine();
		System.out.println("Veuillez saisir votre mot de passe");
		String MDP=sc.nextLine();
		
		Profil profilUser=this.controlSIdentifier.SIdentifier(identifiant, MDP);
		
		if(profilUser!=null)
		{
			System.out.println("Authentification réussie");
			int choix = 2;
			do
			{
				System.out.println("Veuillez saisir votre mode de session: 1) historique 0) sans historique");
				choix=sc.nextInt();
				switch (choix) {
				case 1:
					System.out.println("Vous avez choisi une session avec historique");
					break;
				case 0:
					System.out.println("Vous avez choisi une session sans historique");
					break;
				}
			}while(choix !=1 && choix !=0);
		}
		else
		{
			System.out.println("Ce compte n'existe pas identification echouée");
		}
		
		return profilUser;
	}
}
