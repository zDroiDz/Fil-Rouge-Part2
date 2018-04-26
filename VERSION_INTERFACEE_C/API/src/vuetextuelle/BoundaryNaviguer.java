package vuetextuelle;


import java.util.Scanner;

import control.ControlChangerModeRecherche;
import control.ControlConfigurer;
import control.ControlCreerProfil;
import control.ControlDescripteurs;
import control.ControlHistorique;
import control.ControlProfil;
import control.ControlRechercher;
import control.ControlSIdentifier;
import model.BDProfil;
import model.Profil;


public class BoundaryNaviguer {
	
	
	
	Scanner scanner = new Scanner(System.in);
	Profil profil ;
	int choix = -1 ;
	
	private ControlHistorique controlHistorique = new ControlHistorique();
	ControlProfil controlProfil = new ControlProfil();

	private ControlRechercher controlRechercher = new ControlRechercher(controlHistorique, controlProfil );
	private BoundaryRechercher boundaryRechercher = new BoundaryRechercher(controlRechercher);

	private ControlDescripteurs controlDescripteurs = new ControlDescripteurs();
	private BoundaryVisualiserDescripteurs boundaryVisualiserDescripteurs = new BoundaryVisualiserDescripteurs(controlDescripteurs);
	
	private ControlChangerModeRecherche controlChangerModeRecherche = new ControlChangerModeRecherche();
	private BoundaryChangerModeRecherche boundaryChangerModeRecherche = new BoundaryChangerModeRecherche(controlChangerModeRecherche);

	private ControlConfigurer controlConfigurer = new ControlConfigurer();
	private BoundaryConfigurer boundaryConfigurer =new BoundaryConfigurer(controlConfigurer);
	
	public BoundaryNaviguer()
	{
		ControlProfil controlProfil=new ControlProfil();
		ControlDescripteurs controlDescripteurs= new ControlDescripteurs();
		ControlHistorique controlHistorique=new ControlHistorique();
		
		controlDescripteurs.fillBDDescripteurTexte();
		controlDescripteurs.fillBDDescripteurSon();
	
		controlProfil.FillBDProfils();
	
		controlConfigurer.setup();
	}
	
	
	//vérifie que les fichiers pour la recherche sont la (descripteurs)
	int check_recherche(){

	return 1;

	}

	private void menu_choix_connexion() {
		// TODO Auto-generated method stub
		do{
			
			
			do{
				System.out.println("\nMenu de choix connexion :  \n1- Se connecter\n2- Créer un compte");
				choix = scanner.nextInt();
				if ( (choix!= 1) && (choix!= 2)) {
				       System.out.println("Probleme de saisie, veuillez recommencer.\n" );
				     }
			}while(choix != 1 && choix!= 2);
			
			switch(choix){
				case 1 :
					ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
					BoundarySIdentifier boundarySIdentifier = new BoundarySIdentifier(controlSIdentifier);
					profil = boundarySIdentifier.connexion();
					if(profil != null ){
						controlHistorique.FillBDHistorique(profil);	
					}
					
					break;
				case 2:
					ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
					BoundaryCreerProfilUtilisateur boundaryCreerProfilUtilisateur=new BoundaryCreerProfilUtilisateur(controlCreerProfil );
					profil = boundaryCreerProfilUtilisateur.creerProfil();	
					break ;
			}
		}while(profil == null);
		if(profil.isAdmin()){
			menu_base_admin();
		}else{
			menu_utilisateur();
		}
	}
	

	/* menu de base quand l'admin arrive dans l'api */
	void menu_base_admin() {

	   System.out.println("\nMenu principal : \n1 - Administrateur\n2 - Utilisateur\n3 - Quitter\n" );
	   
	   do {
	     this.choix = this.scanner.nextInt();

	     if ( (choix!= 1) && (choix!= 2) && (choix!= 3) ) {
	       System.out.println("Probleme de saisie, veuillez recommencer.\n" );
	     }

	   } while( (choix!= 1) && (choix!= 2) && (choix!= 3) );


	   if (choix == 1) {
	     menu_administrateur(0);
	   }else if (choix == 2 ) {
	      int verif = check_recherche();

	      if (verif == 1) {
	        menu_utilisateur();
	      }else{
	        System.out.println("\nRecherche impossible, veuillez indexer les documents.\n" );
	        menu_base_admin();
	      }

	   }else if(choix == 3){
		  System.out.println("\n Au revoir !");
	      System.exit(0) ;
	   }
	   
	   menu_base_admin();
	}

	/*
	 * 
	 */
	void menu_administrateur(int verif) {


	System.out.println("\nMenu administrateur :\n1 - Lancer indexation\n2 - Configuration\n3 - Visualiser descripteurs\n4 - Changer mode recherche\n5 - Créer administrateur\n6 - Retour au menu principal\n" );

	do {

	  choix = this.scanner.nextInt();

	  if ( (choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) && (choix != 5) && (choix != 6) ) {
	    System.out.println("Probleme de saisie, veuillez recommencer.\n" );
	  }

	} while( (choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) && (choix != 5) && (choix != 6) );

	//indexation
	   if (choix == 1) {
	      System.out.println("Lancement de l'indexation !\n" );
	     
	      System.out.println("Indexation terminée !");
	      //rmThenStartIndexation();
	      //indexImage();
	      //resetAndIndex();

	      menu_administrateur(1);
	//menu Configuration
	   }else if (choix == 2 ) {
	      menu_configuration();

	//menu visualiser descripteurs
	   }else if (choix == 3 ) {
	     menu_visualiserdesc();
	     
	   }else if(choix == 4){
		   this.boundaryChangerModeRecherche.changerModeRecherche();
	   }else if(choix == 5){
		   ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
		   BoundaryCreerProfilAdmin boundaryCreerProfilAdmin=new BoundaryCreerProfilAdmin(controlCreerProfil );
		   boundaryCreerProfilAdmin.creerProfil();
	     //retour au menu principal
	   } else if(choix == 6){
	     menu_base_admin();
	   }

	   menu_administrateur(1);
	}


	/**
	 * 
	 */
	void menu_visualiserdesc() {
	    System.out.println("\nMenu visualiser descripteurs : \n1 - Texte\n2 - Son\n3 - Image\n4 - Retour\n" );
	    
		this.boundaryVisualiserDescripteurs.visualiserDescripteurs();


	       menu_administrateur(1);
	}

	/**
	 * 
	 */
	void menu_configuration() {
	  System.out.println("\nMenu configuration : \n1 - Texte\n2 - Son\n3 - Image\n4 - Retour\n" );
	  
	  do {

	    choix = scanner.nextInt();

	    if ((choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) ) {
	      System.out.println("Probleme de saisie, veuillez recommencer.\n" );
	    }

	  } while( (choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) );

	  //configuration texte
	     if (choix == 1) {
	        System.out.println("Configuration texte\n" );
	        this.boundaryConfigurer.configureTxt();
	        

	  //configuration son
	     }else if (choix == 2 ) {
	        System.out.println("Configuration son\n" );
	        this.boundaryConfigurer.configureSon();

	  //configuration image
	     }else if (choix == 3 ) {
	      System.out.println("Configuration image\n" );
	      	this.boundaryConfigurer.configureImage();

	       //retour au menu admin
	     } else if(choix == 4 ){
	       menu_administrateur(1);
	     }
	    
	     menu_administrateur(1);
	}

	/**
	 * 
	 */
	void menu_configuration_son() {
	System.out.println("\nMenu configuration son\n1 - Nombre d'échantillons\n2 - Nombre de fenetres\n3 - Retour\n" );


	do {
	  choix = scanner.nextInt();

	  if ( (choix != 1 ) && (choix != 2) && (choix != 3) ) {
	    System.out.println("Probleme de saisie, veuillez recommencer.\n" );
	  }

	} while((choix != 1 ) && (choix != 2) && (choix != 3));

	int valeur ;

	if (choix == 1) {
	   System.out.println("Saisissez le nombre d'échantillons : \n" );
	   valeur = this.scanner.nextInt();
	   //modifConfig(valeur, "echantillions:");
	//menu comparaison
	}else if (choix == 2 ) {
	   System.out.println("Saisissez le nombre d'intervalles : \n" );
	   valeur = this.scanner.nextInt();
	  // modifConfig(valeur, "nbintervalles:");
	//Retour
	}else if(choix == 3 ){
	  menu_configuration();
	}

	
	menu_administrateur(1);

	}

	void menu_configuration_image() {
	System.out.println("\nMenu configuration image\n1 - Nombre de bits de quantification NB\n2 - Nombre de bits de quantification RVB\n3 - Retour\n" );

	

	do {
	  choix = scanner.nextInt();

	  if ( (choix != 1 ) && (choix != 2) && (choix != 3) ) {
	    System.out.println("Probleme de saisie, veuillez recommencer.\n" );
	  }

	} while((choix != 1 ) && (choix != 2) && (choix != 3));

	  int valeur ;

	if (choix == 1) {
	   System.out.println("Saisissez le nombre de bits de quantification NB : \n" );
	   valeur = this.scanner.nextInt();
	  // modifConfig(valeur, "NbBit_NB:");
	//menu comparaison
	}else if (choix == 2 ) {
	   System.out.println("Saisissez le nombre de quantification RVB : \n" );
	   valeur = this.scanner.nextInt();
	  // modifConfig(valeur, "NbBit_RGB:");
	//Retour
	}else if(choix == 3 ){
	  menu_configuration();
	}
	
	menu_administrateur(1);
	}

	/**
	 * 
	 */
	void menu_utilisateur() {

	   System.out.println("\nMenu utilisateur : \n1 - Recherche par mot-clé\n2 - Recherche par plage de couleur\n3 - Recherche par fichier\n4 - Consulter historique\n5 - Retour au menu principal\n6 - Quitter" );
	
	   //entrée du menu
	   do {

	     choix = scanner.nextInt();

	     if ( (choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) && (choix != 5) && (choix != 6)) {
	       System.out.println("Probleme de saisie, veuillez recommencer.\n" );
	     }

	   } while( (choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) && (choix != 5) && (choix != 6));

	//après premier choix

	//recherche par mot clé
	   if (choix == 1) {
		   
		   boundaryRechercher.effectuerRechercheMotCle(profil);

	   }else if(choix == 2){
		   
		   boundaryRechercher.effectuerRecherchePlageCouleur(profil);
		   
	   }else if (choix == 3 ) {
		   
	     boundaryRechercher.effectuerRechercheFichier(profil);
	     
	   }else if(choix == 4){
		
		ControlHistorique controlHistorique = new ControlHistorique();
		BoundaryHistorique  boundaryHistorique = new BoundaryHistorique(controlHistorique);
		boundaryHistorique.consulterHistorique();
	//Retour
	   }else if (choix == 5 ) {
			if(profil.isAdmin()){
				menu_base_admin();
			}else{
				System.out.println("Accès interdit ! Vous n'êtes pas administrateur !");
				menu_utilisateur();
			}
	     
	   }else if(choix == 6){
		   
		   System.out.println("\n Au revoir !");
		   System.exit(0);
	   }

	   menu_utilisateur();

	}


	
	public static void  main(String[] args) {
		
	BoundaryNaviguer boundaryNaviguer = new BoundaryNaviguer() ;	
	boundaryNaviguer.menu_choix_connexion();

	}


	

}
