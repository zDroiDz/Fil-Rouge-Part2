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

public class ControlConfigurer {

	private static final String PATH_FICHIER_CONFIG= "../EXTERN_FILES/configuration.config";

	
	int nbOccTxt ;
	int nbEch ;
	int nbIntervalles; 
	int nbBitsNb ;
	int nbBitsCouleur ;
	
	private BDMoteur bdMoteur=BDMoteur.getInstance();
	

	public void creerMoteur(int nbOccTxt,int  nbEch,int nbIntervallle,int nbBitsCouleur){
		Moteur moteurCreer=new Moteur(nbOccTxt,nbEch,nbIntervallle,nbBitsCouleur);
		bdMoteur.ajouterMoteur(moteurCreer);
		
	}
	
	public int getNbOccTxt() {
		return nbOccTxt;
	}
	public void setNbOccTxt(int nbOccTxt) {
		this.nbOccTxt = nbOccTxt;
		//this.updateFile();
	}
	public int getNbEch() {
		return nbEch;
	}
	public void setNbEch(int nbEch) {
		this.nbEch = nbEch;
		this.updateFile();
	}
	public int getNbIntervalles() {
		return nbIntervalles;
	}
	public void setNbIntervalles(int nbIntervalles) {
		this.nbIntervalles = nbIntervalles;
		//this.updateFile();
	}
	public int getNbBitsNb() {
		return nbBitsNb;
	}
	public void setNbBitsNb(int nbBitsNb) {
		this.nbBitsNb = nbBitsNb;
		//this.updateFile();
	}
	public int getNbBitsCouleur() {
		return nbBitsCouleur;
	}
	public void setNbBitsCouleur(int nbBitsCouleur) {
		this.nbBitsCouleur = nbBitsCouleur;
		//this.updateFile();
	}
	
	public void configureAll(int nbOccTxt, int nbEch, int nbIntervalles, int nbBitsNB, int nbBitsCouleur){
		this.setNbOccTxt(nbOccTxt);
		this.setNbEch(nbEch);
		this.setNbIntervalles(nbIntervalles);
		this.setNbBitsNb(nbBitsNB);
		this.setNbBitsCouleur(nbBitsCouleur);
		this.updateFile();
	}
	
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
