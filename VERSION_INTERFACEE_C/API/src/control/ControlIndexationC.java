package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import model.BDTexte;
import model.DescripteurTexte;

// TODO: Auto-generated Javadoc
/*
 * liste des commandes :
 * ./apiJAVA indexation => lance l'indexation
 * 
 * ./apiJAVA comparaison texte $chemin => lance la comparaison
 * ./apiJAVA comparaison son $chemin => lance la comparaison
 * ./apiJAVA comparaison image $chemin => lance la comparaison
 * 
 */

/**
 * The Class ControlIndexationC.
 */
public class ControlIndexationC {
	
	/** The bd texte. */
	BDTexte bdTexte = BDTexte.getInstance();

	
	/**
	 * Lancer indexation.
	 *
	 * @return true, if successful
	 */
	public boolean lancerIndexation() {
		String s;
        Process p;
        try {
        	   Process proc = Runtime.getRuntime().exec("./apiJAVA indexation");                        
        	   proc.waitFor();
        	   return true;
        } catch (Exception e) {
        	
        }
        
        return false;
	}
	
	/**
	 * Gets the id.
	 *
	 * @param input the input
	 * @return the id
	 */
	public int getId(String input) {
		String separation[] = input.split(" ");
		return Integer.parseInt(separation[2]);
	}
	
	/**
	 * Gets the seuil.
	 *
	 * @param input the input
	 * @return the seuil
	 */
	public int getSeuil(String input) {
		String separation[] = input.split(" ");
		return Integer.parseInt(separation[4]);
	}
	
	/**
	 * Compare textes.
	 *
	 * @param path the path
	 * @param seuil the seuil
	 * @return the list
	 */
	public List<DescripteurTexte> compareTextes(String path, int seuil)
	{
		
		List<DescripteurTexte> resultat = new ArrayList<>();
		
		String cmd="./apiJAVA comparaison texte ";
		cmd+=path;
		
		 String s;
	     Process p;
	     try {
	            p = Runtime.getRuntime().exec(cmd);
	            BufferedReader br = new BufferedReader(
	                new InputStreamReader(p.getInputStream()));
	            while ((s = br.readLine()) != null) {
	            	System.out.println(s);
	            	
	            	//vérification que le seuil est bon
	            	if(this.getSeuil(s) >= seuil) {
	            		resultat.add(bdTexte.getDescripteurTexte(this.getId(s)-1));
	            	}
	            }
	                
	            p.waitFor();
	            System.out.println ("exit: " + p.exitValue());
	            p.destroy();
	        } catch (Exception e) {}     
	     
	     
	     return resultat ;
		
	}
	
	/**
	 * Compare sons.
	 *
	 * @param path the path
	 * @return the string
	 */
	public String compareSons(String path)
	{
		String cmd="./apiJAVA comparaison son ";
		cmd+=path;
		 String resultat = "" ;
		 String s;
	     Process p;
	     try {
	            p = Runtime.getRuntime().exec(cmd);
	            BufferedReader br = new BufferedReader(
	                new InputStreamReader(p.getInputStream()));
	            while ((s = br.readLine()) != null) {
	                //System.out.println(s);
	                resultat += s ;
	                resultat += "\n";
	            }

	            p.waitFor();
	            System.out.println ("exit: " + p.exitValue());
	            p.destroy();
	        } catch (Exception e) {}   
	     
	     return resultat ;
	}
	
}
