package vuetextuelle;


import java.util.ArrayList;
import java.util.List;

import model.Descripteur;
import model.DescripteurImage;
import model.DescripteurSon;
import model.DescripteurTexte;
import model.Profil;
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
		
		System.out.println("Resutat de la recherche : \n"+resultat);
	}
	
	
	
	public void effectuerRechercheMotCle(Profil pro){
		Clavier clavier = new Clavier();
		System.out.println("Saisissez un ou plusieurs mot-cl�(s) (s�par�s par des espaces, si un mot n'est pas voulu mettre - devant (exemple : -chez))");
		String motCle=clavier.entrerClavierString();
		
		System.out.println("Saisissez le seuil");
		int seuil=clavier.entrerClavierInt();
		
		
		List<DescripteurTexte> resultat  = this.controlRechercher.lancerRechercheMotCle(motCle, seuil);
		
		for(DescripteurTexte d : resultat){
			System.out.println(d.toString());
		}
		
	}
	
	

	public void effectuerRecherchePlageCouleur(){
		Clavier clavier = new Clavier();
		System.out.println("Saisissez (un entier) la plage de couleur souahit�e ( 1 : rouge, 2 : vert , 3 : bleu) ");
		int couleur = clavier.entrerClavierInt();
		System.out.println("Saisissez le seuil pour la recherche");
		int seuil = clavier.entrerClavierInt();
		
		List<DescripteurImage> resultat =  this.controlRechercher.lancerRecherchePlageCouleurs(couleur, seuil);
		System.out.println("R�sultats de la recherche : ");
		for(DescripteurImage d : resultat){
			System.out.println(d.getId() + " : " + d.toString());
		}
	}
	
}

