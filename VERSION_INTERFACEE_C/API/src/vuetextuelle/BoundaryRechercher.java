package vuetextuelle;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Descripteur;
import model.DescripteurImage;
import model.DescripteurSon;
import model.DescripteurTexte;
import model.Profil;
import control.ControlHistorique;
import control.ControlRechercher;

public class BoundaryRechercher {
	
	private  ControlRechercher controlRechercher;
	private ControlHistorique controlHistorique = new ControlHistorique();
	
	public BoundaryRechercher(ControlRechercher controlRechercher){
		this.controlRechercher = controlRechercher;
	}
	
	public void effectuerRechercheFichier(Profil profil){
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
		
		System.out.println("Resutat de la recherche : \n"+resultat);
	}
	
	
	
	public void effectuerRechercheMotCle(Profil profil){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un ou plusieurs mot-clé(s) (séparés par des espaces, si un mot n'est pas voulu mettre - devant (exemple : -chez))");
		String motCle= scanner.nextLine();
		 int seuil ;
		
		 do{
			 try {
					System.out.println("Saisissez le seuil");
			         seuil= scanner.nextInt();
			    } catch (InputMismatchException e) {
			        System.out.println("Saisie incorrecte ");
			        seuil = -1 ;
			    } 
			 scanner.nextLine(); // clears the buffer
		 }while(seuil == -1);
			
		 
		
		List<DescripteurTexte> resultat  = this.controlRechercher.lancerRechercheMotCle(motCle, seuil, profil);
		
		
		
		for(DescripteurTexte d : resultat){
			System.out.println(d.toString());
		}
		
	}
	
	

	public void effectuerRecherchePlageCouleur(Profil profil){
		Clavier clavier = new Clavier();
		System.out.println("Saisissez (un entier) la plage de couleur souahitée ( 1 : rouge, 2 : vert , 3 : bleu) ");
		int couleur = clavier.entrerClavierInt();
		System.out.println("Saisissez le seuil pour la recherche");
		int seuil = clavier.entrerClavierInt();
		

		
	}
	

	
}

