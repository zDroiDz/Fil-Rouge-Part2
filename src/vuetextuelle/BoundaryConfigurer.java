package vuetextuelle;


import java.util.Scanner;

import control.ControlConfigurer;

public class BoundaryConfigurer {

	ControlConfigurer controlConfigurer ;
	Scanner scanner = new Scanner(System.in);
	
	public BoundaryConfigurer(ControlConfigurer controlConfigurer){
		this.controlConfigurer = controlConfigurer ;
		
	}
	
	public void configureTxt(){
		System.out.println("Saisissez le nombre d'occurences pour les fichiers texte ");
		int nbOccTxt  = this.scanner.nextInt();	
		this.controlConfigurer.setNbOccTxt(nbOccTxt);
	}
	
	public void configureSon(){
		System.out.println("Saisissez le nombre d'échantillons");
		int nbEch  = this.scanner.nextInt();	
		this.controlConfigurer.setNbEch(nbEch);
		
		System.out.println("Saisissez le nombre d'intervalles");
		int nbInter  = this.scanner.nextInt();	
		this.controlConfigurer.setNbIntervalles(nbInter);
	}
	
	public void configureImage(){
		System.out.println("Saisissez le nombre de bits significatifs pour les images en noir et blanc ");
		int nbBitsNB  = this.scanner.nextInt();	
		this.controlConfigurer.setNbBitsNb(nbBitsNB);
		
		System.out.println("Saisissez le nombre de bits significatifs pour les images en couleur ");
		int nbBitsCouleur  = this.scanner.nextInt();	
		this.controlConfigurer.setNbBitsCouleur(nbBitsCouleur);
	}
	
	public static void main(String[] args){
		
		ControlConfigurer controlConfigurer = new ControlConfigurer() ;
		
		BoundaryConfigurer boundaryConfigurer = new BoundaryConfigurer(controlConfigurer);
		//boundaryConfigurer.configureImage();
		//boundaryConfigurer.configureSon();
		//boundaryConfigurer.configureTxt();
		controlConfigurer.setup();
		System.out.println(controlConfigurer.getNbOccTxt());
		System.out.println(controlConfigurer.getNbEch());
		System.out.println(controlConfigurer.getNbIntervalles());
		System.out.println(controlConfigurer.getNbBitsNb());
		System.out.println(controlConfigurer.getNbBitsCouleur());
		
	}

}
