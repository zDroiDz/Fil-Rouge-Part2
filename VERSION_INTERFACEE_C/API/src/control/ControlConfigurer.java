/*
 * 
 */
package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import model.BDMoteur;
import model.Moteur;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlConfigurer.
 *
 * @author william
 */
public class ControlConfigurer {

	/** The Constant PATH_FICHIER_CONFIG. */
	private static final String PATH_FICHIER_CONFIG= "../EXTERN_FILES/configuration.config";

	
	/** The nb occ txt. */
	int nbOccTxt ;
	
	/** The nb ech. */
	int nbEch ;
	
	/** The nb intervalles. */
	int nbIntervalles; 
	
	/** The nb bits nb. */
	int nbBitsNb ;
	
	/** The nb bits couleur. */
	int nbBitsCouleur ;
	
	/** The bd moteur. */
	private BDMoteur bdMoteur=BDMoteur.getInstance();
	
/**
 * Constructeur.
 *
 * @param nbOccTxt the nb occ txt
 * @param nbEch the nb ech
 * @param nbIntervallle the nb intervallle
 * @param nbBitsCouleur the nb bits couleur
 */
	public void creerMoteur(int nbOccTxt,int  nbEch,int nbIntervallle,int nbBitsCouleur){
		Moteur moteurCreer=new Moteur(nbOccTxt,nbEch,nbIntervallle,nbBitsCouleur);
		bdMoteur.ajouterMoteur(moteurCreer);
		
	}
	

	
	/**
	 * Gets the nb occ txt.
	 *
	 * @return the nb occ txt
	 */
	public int getNbOccTxt() {
		return nbOccTxt;
	}
	
	/**
	 * Sets the nb occ txt.
	 *
	 * @param nbOccTxt the new nb occ txt
	 */
	public void setNbOccTxt(int nbOccTxt) {
		this.nbOccTxt = nbOccTxt;
		//this.updateFile();
	}
	
	/**
	 * Gets the nb ech.
	 *
	 * @return the nb ech
	 */
	public int getNbEch() {
		return nbEch;
	}
	
	/**
	 * Sets the nb ech.
	 *
	 * @param nbEch the new nb ech
	 */
	public void setNbEch(int nbEch) {
		this.nbEch = nbEch;
		this.updateFile();
	}
	
	/**
	 * Gets the nb intervalles.
	 *
	 * @return the nb intervalles
	 */
	public int getNbIntervalles() {
		return nbIntervalles;
	}
	
	/**
	 * Sets the nb intervalles.
	 *
	 * @param nbIntervalles the new nb intervalles
	 */
	public void setNbIntervalles(int nbIntervalles) {
		this.nbIntervalles = nbIntervalles;
		//this.updateFile();
	}
	
	/**
	 * Gets the nb bits nb.
	 *
	 * @return the nb bits nb
	 */
	public int getNbBitsNb() {
		return nbBitsNb;
	}
	
	/**
	 * Sets the nb bits nb.
	 *
	 * @param nbBitsNb the new nb bits nb
	 */
	public void setNbBitsNb(int nbBitsNb) {
		this.nbBitsNb = nbBitsNb;
		//this.updateFile();
	}
	
	/**
	 * Gets the nb bits couleur.
	 *
	 * @return the nb bits couleur
	 */
	public int getNbBitsCouleur() {
		return nbBitsCouleur;
	}
	
	/**
	 * Sets the nb bits couleur.
	 *
	 * @param nbBitsCouleur the new nb bits couleur
	 */
	public void setNbBitsCouleur(int nbBitsCouleur) {
		this.nbBitsCouleur = nbBitsCouleur;
		//this.updateFile();
	}
	
	/**
	 * Configure all.
	 *
	 * @param nbOccTxt the nb occ txt
	 * @param nbEch the nb ech
	 * @param nbIntervalles the nb intervalles
	 * @param nbBitsNB the nb bits NB
	 * @param nbBitsCouleur the nb bits couleur
	 */
	public void configureAll(int nbOccTxt, int nbEch, int nbIntervalles, int nbBitsNB, int nbBitsCouleur){
		this.setNbOccTxt(nbOccTxt);
		this.setNbEch(nbEch);
		this.setNbIntervalles(nbIntervalles);
		this.setNbBitsNb(nbBitsNB);
		this.setNbBitsCouleur(nbBitsCouleur);
		this.updateFile();
	}
	
	/**
	 * Setup.
	 */
	public void setup(){
		 
		try{
		InputStream flux=new FileInputStream(PATH_FICHIER_CONFIG); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		while ((ligne=buff.readLine())!=null){
			//System.out.println(ligne);
			String[] parts = ligne.split("\\s+");
			if(parts.length>1){
				switch(parts[0]){
				case "txt_nboccurrences:":
					this.nbOccTxt = Integer.parseInt(parts[1]);
					break;
				case "echantillons:":
					this.nbEch =Integer.parseInt(parts[1]);
					break;
				case "nbintervalles:":
					this.nbIntervalles = Integer.parseInt(parts[1]);
					break;
				case "NbBit_NB:":
					this.nbBitsNb=Integer.parseInt(parts[1]);
					break;
				case "NbBit_RGB:":
					this.nbBitsCouleur = Integer.parseInt(parts[1]);
					break;
					
				}
					
			}
			
		}
		buff.close(); 
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	}
	
	/**
	 * Update file.
	 */
	public void updateFile(){
		

		try {
			FileOutputStream writer;
			writer = new FileOutputStream(PATH_FICHIER_CONFIG);
			
				writer.write(("<txt>\ntxt_nboccurrences: "+this.nbOccTxt+"\n</txt>\n<sound>\nechantillons: "+this.nbEch+"\nnbintervalles: "+this.nbIntervalles+"\n</sound>\n<image>\nNbBit_NB: "+this.nbBitsNb+"\nNbBit_RGB: "+this.nbBitsCouleur+"\n</image>").getBytes());
			
			
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

    
	
	
	
}
