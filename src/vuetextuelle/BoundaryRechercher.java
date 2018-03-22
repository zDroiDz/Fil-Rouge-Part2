package vuetextuelle;


import java.util.ArrayList;
import java.util.List;

import model.Descripteur;
import model.DescripteurImage;
import model.DescripteurSon;
import model.DescripteurTexte;
import control.ControlRechercher;

public class BoundaryRechercher {
	
	private  ControlRechercher controlRechercher;
	
	
	public BoundaryRechercher(ControlRechercher controlRechercher){
		this.controlRechercher = controlRechercher;
	}
	
	public void effectuerRechercheFichier(){
		int typeFichier, seuil;
		Descripteur descripteur ;
		List<String> resultat=new ArrayList<>();
		Clavier clavier = new Clavier();
		System.out.println("Saississez le type de fichier a comparer");
		System.out.println("1 : texte");
		System.out.println("2 : image");
		System.out.println("3 : audio");
		typeFichier=clavier.entrerClavierInt();
		System.out.println("Selectionnez le fichier");
		String fichier=clavier.entrerClavierString();
		// comment importer un fichier
		System.out.println("Saississez le seuil");
		seuil=clavier.entrerClavierInt();

		switch(typeFichier){
		case 1:
			 descripteur =(DescripteurTexte) controlRechercher.genererDescripteurTexte(fichier);
			resultat=controlRechercher.effectuerRechercheTexte((DescripteurTexte) descripteur,seuil);
			break;
		case 2:
			 descripteur =(DescripteurImage) controlRechercher.genererDescripteurImage(fichier);
			resultat=controlRechercher.effectuerRechercheImage((DescripteurImage) descripteur,seuil);
			break;
		case 3:
			 descripteur =(DescripteurSon) controlRechercher.genererDescripteurSon(fichier);
			resultat=controlRechercher.effectuerRechercheSon((DescripteurSon) descripteur,seuil);
			break;
		default:
			System.out.println("Erreur");
		}
		
		System.out.println("Resutat de la recherche"+resultat);
	}
	
	
	
	public void effectuerRechercheMotCle(){
		Clavier clavier = new Clavier();
		System.out.println("Saisissez un mot clé");
		String motCle=clavier.entrerClavierString();
		
		System.out.println("Saisissez le seuil");
		int seuil=clavier.entrerClavierInt();
		
	/* N'oubliez pas d'ajouter le moteur souahité */
		
	}
	
	
	
	
	
	public static void main(String[] args)
	{
		ControlRechercher controlRechercher=new ControlRechercher();
		BoundaryRechercher boundaryRechercher=new BoundaryRechercher(controlRechercher);
		boundaryRechercher.effectuerRechercheFichier();
		
	}
	
}

