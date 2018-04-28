package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// TODO: Auto-generated Javadoc
/**
 * The Class DescripteurImage.
 */
public class DescripteurImage extends Descripteur {
	
	/** The couleur dominante. */
	private String couleurDominante;
	
	/** The seuil couleur. */
	private int seuilCouleur ;
	
	/** The avg color. */
	private int avgColor[];
	
	/**
	 * Instantiates a new descripteur image.
	 *
	 * @param id the id
	 * @param nomFichier the nom fichier
	 * @param path the path
	 * @param seuil the seuil
	 * @param tabAvg the tab avg
	 * @param coul the coul
	 */
	public DescripteurImage(int id ,String nomFichier, String path, int seuil,int tabAvg[],String coul){
		super();
		super.id = id ;
		super.nomFichier = nomFichier ;
		super.path = path ;
		this.seuilCouleur= seuil;
		this.avgColor=tabAvg;
		this.couleurDominante=coul;
	}

	/* (non-Javadoc)
	 * @see model.Descripteur#toString()
	 */
	@Override
	public String toString() {
		return super.toString()+"DescripteurImage [couleurDominante=" + couleurDominante + ", seuilCouleur=" + seuilCouleur
				+ ", avgColor=" + Arrays.toString(avgColor) + "]";
	}
	
	
	/**
	 * Gets the composante.
	 *
	 * @param composante the composante
	 * @return the composante
	 */
	public int getComposante(int composante)
	{
		return this.avgColor[composante];
	}
	


}