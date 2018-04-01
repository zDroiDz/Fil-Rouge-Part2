package vuetextuelle;



import java.util.ArrayList;
import java.util.List;

import control.ControlHistorique;
import model.Descripteur;

public class BoundaryHistorique {

	ControlHistorique controlHistorique;
	
	public BoundaryHistorique(ControlHistorique controlHistorique) {
		this.controlHistorique = controlHistorique;
	}
	
	public void consulterHistorique() {
		System.out.println("Veuillez s�l�ctionner la recherche � consulter");
		
		//Intercaler ici le "clique souris"
		//Parti "textuelle"
		ArrayList<String> listeRecherche = (ArrayList<String>) controlHistorique.consulterListeRecherche();
		System.out.println(listeRecherche);
		
		int entreeClavier;
		Clavier clavier = new Clavier();
		
		do {
			entreeClavier = clavier.entrerClavierInt();
			if(entreeClavier >= listeRecherche.size() || entreeClavier < 0)
				System.out.println("Taille incorrect: Veuillez entrer une valeur dans la liste");
		}while(entreeClavier >= listeRecherche.size() || entreeClavier < 0);
		
		ArrayList<String> historiqueRecherche = (ArrayList<String>) controlHistorique.consulterHistoriqueRecherche(entreeClavier);
		
		if(historiqueRecherche.isEmpty()) {
			System.out.println("Erreur : Aucune recherche correspondante n'a �t� effectu�e");
		}else {
			System.out.println("Recherche trouv�e !");
			System.out.println(historiqueRecherche);
		}
		
	}
	
	public void ajouterHistorique(String requeteRecherche, List<String> resultatRecherche) {
		controlHistorique.ajouterHistorique(requeteRecherche, resultatRecherche);
	}
}
