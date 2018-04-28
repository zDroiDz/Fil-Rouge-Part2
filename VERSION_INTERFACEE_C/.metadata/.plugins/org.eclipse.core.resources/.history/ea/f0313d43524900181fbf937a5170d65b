package vueGraphique;

import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.DefaultListModel;

public class RequeteRecherche {

	//Attributs de la recherche
	private String dateRecherche;
	private String requeteRecherche;
	private String utilisateurRecherche;
	private String typeRecherche;
	
	//Resultats produits de la recherche
	private Map<String,String> mapResultat;

	//Creation du String associ�e � la recherche dans la BD
	private String recherche;
	
	
	/*
	 * Fonctionnement de la classe : 
	 * 
	 * Deux constructeurs : 
	 * 
	 *  - Un qui permet de constituer la recherche � partir d'un String
	 *  - Un qui permet de cr�er le string a partir des diff�rens param�tres de Recherche
	 *  
	 *  Fonctionnement : 
	 *  
	 *  1. On effectue une recherche. On veut stocker cette recherche, donc on appelle le second constructeur 
	 *    (avec les diff�rents attribue), et puis on appelle la m�thode "getStockageBD()" pour avoir le string
	 *    � stocker dans la BD.
	 *    
	 *  2. Lorsque on veut voir une recherche depuis la BD, on utilise le premier constructeur, qui va reconstituer
	 *     les diff�rentes valeurs des attributs � partir d'un seul String.
	 *     On a plus qu'a fournir cet objet "RequeteRecherche" � l'afficheur pour qu'il affiche tous les diff�rents param�tres.
	 *  
	 */
	
	
	public RequeteRecherche(String recherche) {
		dateRecherche = "Inconnue";
		requeteRecherche = "Inconnue";
		utilisateurRecherche = "Inconnue";
		typeRecherche = "Inconnue";
		
		mapResultat = new HashMap<String,String>();
		this.recherche = recherche;
		this.lectureString();
	}
	
	public RequeteRecherche(String requeteRecherche, String utilisateurRecherche, String typeRecherche, Map<String,String> mapResultat) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH'h'mm");
		Date date = new Date();
		this.dateRecherche = dateFormat.format(date);
		
		this.requeteRecherche = requeteRecherche;
		this.utilisateurRecherche = utilisateurRecherche;
		this.typeRecherche = typeRecherche;
		
		this.mapResultat = mapResultat;
		this.creationString();
		
	}
	
	
	public String getPath(String nom) {
		return this.mapResultat.get(nom);
	}
	
	public String getTypeRechercheNom() {
		if(this.typeRecherche.equals("Recherche couleur") || this.typeRecherche.equals("Image fichier")) {
			return "image";
		}else if(this.typeRecherche.equals("Mot cle") || this.typeRecherche.equals("Texte fichier")) {
			return "texte";
		}else {
			return "son";
		}
		
		
	}
	
	//M�thodes Statique
	
	public void creationString() {
		this.recherche = requeteRecherche + ": ";
		this.recherche += "<date> " + dateRecherche + " </date>";
		this.recherche += " <requete> " + requeteRecherche + " </requete>";
		this.recherche += " <utilisateur> " + utilisateurRecherche + " </utilisateur>";
		this.recherche += " <type> " + typeRecherche + " </type>";
		
		this.recherche += " <mapResultat> " + mapResultat.toString() + " </mapResultat>";
		
		this.recherche += " | ";
	}
	
	public void lectureString() {
		
		//Test lecture
		/*
		System.out.println(recherche.substring(recherche.indexOf("<date> ")+7, recherche.indexOf(" </date>")));
		System.out.println(recherche.substring(recherche.indexOf("<requete> ")+10, recherche.indexOf(" </requete>")));
		System.out.println(recherche.substring(recherche.indexOf("<utilisateur> ")+14, recherche.indexOf(" </utilisateur>")));
		System.out.println(recherche.substring(recherche.indexOf("<type> ")+7, recherche.indexOf(" </type>")));
		
		System.out.println(recherche.substring(recherche.indexOf("<mapResultat> ")+14, recherche.indexOf(" </mapResultat>")));
		*/
		

		this.dateRecherche = (recherche.substring(recherche.indexOf("<date> ")+7, recherche.indexOf(" </date>")));
		this.requeteRecherche = (recherche.substring(recherche.indexOf("<requete> ")+10, recherche.indexOf(" </requete>")));
		this.utilisateurRecherche = (recherche.substring(recherche.indexOf("<utilisateur> ")+14, recherche.indexOf(" </utilisateur>")));
		this.typeRecherche = (recherche.substring(recherche.indexOf("<type> ")+7, recherche.indexOf(" </type>")));
		
		
		//HashMap
		String str = (recherche.substring(recherche.indexOf("<mapResultat> ")+14, recherche.indexOf(" </mapResultat>")));
		Properties props = new Properties();
		try {
			props.load(new StringReader(str.substring(1, str.length() - 1).replace(", ", "\n")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}       
		mapResultat.clear();
		for (Map.Entry<Object, Object> e : props.entrySet()) {
			mapResultat.put((String)e.getKey(), (String)e.getValue());
		}
		//System.out.println(map2);
	}
	
	
	//Getter/Setter 
	

	public String getDateRecherche() {
		return dateRecherche;
	}

	public void setDateRecherche(String dateRecherche) {
		this.dateRecherche = dateRecherche;
	}

	public String getRequeteRecherche() {
		return requeteRecherche;
	}

	public void setRequeteRecherche(String requeteRecherche) {
		this.requeteRecherche = requeteRecherche;
	}

	public String getUtilisateurRecherche() {
		return utilisateurRecherche;
	}

	public void setUtilisateurRecherche(String utilisateurRecherche) {
		this.utilisateurRecherche = utilisateurRecherche;
	}

	public String getTypeRecherche() {
		return typeRecherche;
	}

	public void setTypeRecherche(String typeRecherche) {
		this.typeRecherche = typeRecherche;
	}

	public DefaultListModel<String> getListeResultat() {
		DefaultListModel<String> retour = new DefaultListModel<String>();
		for ( String key : mapResultat.keySet() ) {
		    retour.addElement(key);
		}
		return retour;
	}
	
	public Map<String,String> getMap(){
		return mapResultat;
	}


	public String getStockageBD() {
		return recherche;
	}

	public void setStockageBD(String recherche) {
		this.recherche = recherche;
	}

	
	//ToString
	
	public String toString() {
		return ("date recherche : " + dateRecherche + ", requete recherche : " + requeteRecherche + "\nutilisateur Recherche :" + utilisateurRecherche + ", typeRecherche : " + typeRecherche + "\nmap : " + mapResultat.toString());
	}
	
	
	
	
	
}
