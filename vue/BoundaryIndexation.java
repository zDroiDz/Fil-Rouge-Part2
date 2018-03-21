package vue;

import control.Clavier;
import control.ControlIndexation;
import control.ControlSidentifier;

public class BoundaryIndexation {

	ControlIndexation controlIndexation;
	ControlSidentifier controlSidentifier;
	
	public BoundaryIndexation(ControlIndexation controlIndexation, ControlSidentifier controlSidentifier) {
		this.controlIndexation = controlIndexation;
	}
	
	public boolean connexion() {
		boolean valide;
		String identifiant;
		String motDePasse;
		
		Clavier clavier = new Clavier();
		
		do {
			System.out.println("Veuillez entrer utilisateur puis mot de passe");
			identifiant = clavier.entrerClavierString();
			motDePasse = clavier.entrerClavierString();
			valide = controlSidentifier.Sidentifier(identifiant, motDePasse);
			if(!valide)
				System.out.println("L'indentification n'a pas été faite ! Avez-vous entrer le bon couple indentifiant/mot de passse ?");
		}while(!valide);
		
		if(valide) {
			return this.lancerIndexation();
		}
		return false;
	}

	public boolean lancerIndexation() {
		boolean succes = controlIndexation.lancerIndexation();
		if(succes)
			System.out.println("Indexation effectuee avec succès !");
		else
			System.out.println("Indexation échouée");
		return succes;
	}
	
}
