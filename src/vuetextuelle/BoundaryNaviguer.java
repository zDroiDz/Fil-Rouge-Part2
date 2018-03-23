package vuetextuelle;


import java.util.Scanner;

public class BoundaryNaviguer {
	
	Scanner scanner = new Scanner(System.in);
	int choix = -1 ;
	//vérifie que les fichiers pour la recherche sont la (descripteurs)
	int check_recherche(){

	return 1;

	}


	/* menu de base quand on arrive dans l'api */
	void menu_base() {

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
	        menu_base();
	      }

	   }else if(choix == 3){
	      System.exit(0) ;
	   }
	}

	void menu_administrateur(int verif) {


	String mdp ; 

	//s'identifier



	System.out.println("\nMenu administrateur :\n1 - Lancer indexation\n2 - Configuration\n3 - Visualiser descripteurs\n4 - Retour au menu principal\n" );

	do {

	  choix = this.scanner.nextInt();

	  if ( (choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) ) {
	    System.out.println("Probleme de saisie, veuillez recommencer.\n" );
	  }

	} while( (choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) );

	//indexation
	   if (choix == 1) {
	      System.out.println("Lancement de l'indexation !\n" );
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

	     //retour au menu principal
	   } else if(choix == 4){
	     menu_base();
	   }



	}

	void menu_comparaison(){
	  System.out.println("\nMenu recherche par comparaison : \n1 - Texte\n2 - Son\n3 - Image\n4 - Retour\n" );
	
	  do {

		  choix = this.scanner.nextInt();

	    if ( (choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) ) {
	      System.out.println("Probleme de saisie, veuillez recommencer.\n" );
	    }

	  } while( (choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) );


	   String requete ;
	  //Comparaison texte
	     if (choix == 1 ) {
	        System.out.println("Saisissez le chemin du fichier à comparer (.xml)\n" );
	    		requete = this.scanner.nextLine();
	    		//indexFileToCompare(requete);

	  //Comparaison son
	     }else if (choix == 2) {
	        System.out.println("Saisissez le chemin du fichier à comparer (.bin)\n" );
	        requete = this.scanner.nextLine();
	  			//compare(requete);

	  //menu comparaison image
	     }else if (choix == 3 ) {
	      System.out.println("Saisissez le chemin du fichier à comparer (.txt)\n" );
	      requete = this.scanner.nextLine();
	      //searchImage(requete);

	       //retour au menu utilisateur
	     } else if(choix == 4){
	       menu_utilisateur();
	     }

	     menu_utilisateur();

	}

	void menu_recherche_motcle(){
	    System.out.println("\nRecherche par mot-clé.\nVeuillez entrer un mot clé : \n" );
	    String mot ;
	    mot = this.scanner.nextLine();
	  	//byword(mot);

	    menu_utilisateur();
	}

	void menu_visualiserdesc() {
	    System.out.println("\nMenu visualiser descripteurs : \n1 - Texte\n2 - Son\n3 - Image\n4 - Retour\n" );
	    
	    do {

	      choix = scanner.nextInt();

	      if ((choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) ) {
	        System.out.println("Probleme de saisie, veuillez recommencer.\n" );
	      }

	    } while( (choix != 1 ) && (choix != 2) && (choix != 3) && (choix != 4) );

	    //Visualisation texte
	       if (choix == 1) {
	          System.out.println("Visualisation descripteurs texte\n" );
	        //  system("cat ../EXTERN_FILES/database/base_texte/base_descripteur_texte.txt");
	    //visualisation son
	       }else if (choix == 2 ) {
	          System.out.println("Visualisation descripteurs son\n" );
	        //  system("cat ../EXTERN_FILES/database/base_son/base_descripteur_son.txt");
	    //visualisation image
	       }else if (choix == 3 ) {
	        System.out.println("Visualisation descripteurs image\n" );
	       // system("cat ../EXTERN_FILES/database/base_image/base_descripteur_image.txt");
	         //retour au menu admin
	       } else if(choix == 4 ){
	         menu_administrateur(1);
	       }

	       menu_administrateur(1);
	}

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
	        System.out.println("Saisissez le nombre d'occurences : \n" );
	        int nbocc = this.scanner.nextInt() ;
	        
	        //modifConfig(nbocc, "txt_nboccurrences:");

	  //configuration son
	     }else if (choix == 2 ) {
	        System.out.println("Configuration son\n" );
	        menu_configuration_son();

	  //configuration image
	     }else if (choix == 3 ) {
	      System.out.println("Configuration image\n" );
	        menu_configuration_image();

	       //retour au menu admin
	     } else if(choix == 4 ){
	       menu_administrateur(1);
	     }
	    
	     menu_administrateur(1);
	}

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

	void menu_utilisateur() {

	   System.out.println("\nMenu utilisateur : \n1 - Recherche par mot-clé\n2 - Recherche par comparaison\n3 - Retour au menu principal\n" );
	
	   //entrée du menu
	   do {

	     choix = scanner.nextInt();

	     if ( (choix != 1 ) && (choix != 2) && (choix != 3) ) {
	       System.out.println("Probleme de saisie, veuillez recommencer.\n" );
	     }

	   } while( (choix != 1 ) && (choix != 2) && (choix != 3) );

	//après premier choix

	//recherche par mot clé
	   if (choix == 1) {
	      menu_recherche_motcle();

	//menu comparaison
	   }else if (choix == 2 ) {
	      menu_comparaison();

	//Retour
	   }else if (choix == 3 ) {

	     menu_base();
	   }


	}


	
	public static void  main(String[] args) {
		
	BoundaryNaviguer boundaryNaviguer = new BoundaryNaviguer() ;	
	boundaryNaviguer.menu_base();

	}

}
