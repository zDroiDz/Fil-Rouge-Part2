package vueTextuelle;

import control.ControlConfigurer;

public class BoundaryConfigurer {
	ControlConfigurer controlConfigurer;
	
	public BoundaryConfigurer(ControlConfigurer controlConfigurer){
		this.controlConfigurer=controlConfigurer;
	}
	
	public boolean connexion(){
		boolean connecte =false ;
		
		return connecte;
	}
	public void creerMoteur(){
		 int nbOccTxt;
		 int nbEch;
		 int nbIntervallle;
		 int nbBitsCouleur;
		 controlConfiguer.creerMoteur(nbOccTxt,nbEch,nbIntervallle,nbBitsCouleur);
		
		/*Faire Appel à configurer Indexation */
		
	}
}
