package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DescripteurImage extends Descripteur {
	
	/*private int tabR[][];
	private int tabG[][];
	private int tabB[][];*/
	
	private int seuilCouleur ;
	
	public DescripteurImage(int id ,String nomFichier, String path, int seuil ){
		super();
		super.id = id ;
		super.nomFichier = nomFichier ;
		super.path = path ;
		this.seuilCouleur= seuil;
	}
	
	   
	  public boolean checkPlage(int seuil) {
		
		  return this.seuilCouleur >= seuil ;
		  
	}
	
	
	/**
	 * @return the seuilCouleur
	 */
	public int getSeuilCouleur() {
		return seuilCouleur;
	}


	/**
	 * @param seuilCouleur the seuilCouleur to set
	 */
	public void setSeuilCouleur(int seuilCouleur) {
		this.seuilCouleur = seuilCouleur;
	}


	public String toString(){
		return super.nomFichier ;
	}
	

}
