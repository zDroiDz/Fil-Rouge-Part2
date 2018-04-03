package vuetextuelle;


import java.util.InputMismatchException;
import java.util.Scanner;

import control.ControlConfigurer;

public class BoundaryConfigurer {

	ControlConfigurer controlConfigurer ;
	Scanner scanner = new Scanner(System.in);
	
	public BoundaryConfigurer(ControlConfigurer controlConfigurer){
		this.controlConfigurer = controlConfigurer ;
		
	}
	
	public void configureTxt(){
		int nbOccTxt  ;
		 
		do{
			 try {
					System.out.println("Saisissez le nombre d'occurences pour les fichiers texte ");
					nbOccTxt= scanner.nextInt();
			    } catch (InputMismatchException e) {
			        System.out.println("Saisie incorrecte ");
			        nbOccTxt = -1 ;
			    } 
			 scanner.nextLine(); // clears the buffer
		 }while(nbOccTxt == -1);
		
		this.controlConfigurer.setNbOccTxt(nbOccTxt);
	}
	
	public void configureSon(){
		
		int nbEch;
		
		do{
			 try {
				 System.out.println("Saisissez le nombre d'échantillons");
					nbEch= scanner.nextInt();
			    } catch (InputMismatchException e) {
			        System.out.println("Saisie incorrecte ");
			        nbEch = -1 ;
			    } 
			 scanner.nextLine(); // clears the buffer
		 }while(nbEch == -1);
		
		
		this.controlConfigurer.setNbEch(nbEch);
		
		int nbInter;
		do{
			 try {

					System.out.println("Saisissez le nombre d'intervalles");
					nbInter= scanner.nextInt();
			    } catch (InputMismatchException e) {
			        System.out.println("Saisie incorrecte ");
			        nbInter = -1 ;
			    } 
			 scanner.nextLine(); // clears the buffer
		 }while(nbInter == -1);
		
		this.controlConfigurer.setNbIntervalles(nbInter);
	}
	
	public void configureImage(){
		int nbBitsNB  ;
		do{
			 try {
				 System.out.println("Saisissez le nombre de bits significatifs pour les images en noir et blanc ");
				 nbBitsNB= scanner.nextInt();
			    } catch (InputMismatchException e) {
			        System.out.println("Saisie incorrecte ");
			        nbBitsNB = -1 ;
			    } 
			 scanner.nextLine(); // clears the buffer
		 }while(nbBitsNB == -1);
		
		this.controlConfigurer.setNbBitsNb(nbBitsNB);
		
		int nbBitsCouleur;	
		
		do{
			 try {
				 	System.out.println("Saisissez le nombre de bits significatifs pour les images en couleur ");
				 	nbBitsCouleur= scanner.nextInt();
			    } catch (InputMismatchException e) {
			        System.out.println("Saisie incorrecte ");
			        nbBitsCouleur = -1 ;
			    } 
			 scanner.nextLine(); // clears the buffer
		 }while(nbBitsCouleur == -1);
		
		this.controlConfigurer.setNbBitsCouleur(nbBitsCouleur);
	}
	
	

}
