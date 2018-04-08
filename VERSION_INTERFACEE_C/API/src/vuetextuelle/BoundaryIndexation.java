package vuetextuelle;




import control.ControlIndexationC;
import control.ControlSIdentifier;


public class BoundaryIndexation {
	
	ControlIndexationC controlIndexation;
	ControlSIdentifier controlSidentifier;
	
	public BoundaryIndexation(ControlIndexationC controlIndexation, ControlSIdentifier controlSidentifier) {
		this.controlIndexation = controlIndexation;
	}
	
	public boolean connexion() {
		boolean valide=true;
		String identifiant;
		String motDePasse;
		
		Clavier clavier = new Clavier();
		
		do {
			System.out.println("Veuillez entrer utilisateur puis mot de passe");
			identifiant = clavier.entrerClavierString();
			motDePasse = clavier.entrerClavierString();
			//valide = controlSidentifier.Sidentifier(identifiant, motDePasse);
			if(!valide)
				System.out.println("L'indentification n'a pas �t� faite ! Avez-vous entrer le bon couple indentifiant/mot de passse ?");
		}while(!valide);
		
		if(valide) {
			return this.lancerIndexation();
		}
		return false;
	}

	public boolean lancerIndexation() {
		boolean succes = controlIndexation.lancerIndexation();
		if(succes)
			System.out.println("Indexation effectuee avec succ�s !");
		else
			System.out.println("Indexation �chou�e");
		return succes;
	}
	
}
