package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DescripteurImage extends Descripteur {
	
	private String couleurDominante;
	
	private int seuilCouleur ;
	private int avgColor[];
	
	public DescripteurImage(int id ,String nomFichier, String path, int seuil,int tabAvg[],String coul){
		super();
		super.id = id ;
		super.nomFichier = nomFichier ;
		super.path = path ;
		this.seuilCouleur= seuil;
		this.avgColor=tabAvg;
		this.couleurDominante=coul;
	}

	@Override
	public String toString() {
		return super.toString()+"DescripteurImage [couleurDominante=" + couleurDominante + ", seuilCouleur=" + seuilCouleur
				+ ", avgColor=" + Arrays.toString(avgColor) + "]";
	}
	
	
	public int getComposante(int composante)
	{
		return this.avgColor[composante];
	}
	


}
