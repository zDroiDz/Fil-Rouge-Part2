package control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.BDTexte;
import model.Descripteur;
import model.DescripteurImage;
import model.DescripteurSon;
import model.DescripteurTexte;

public class ControlRechercher {
	
	private BDTexte bdTexte=BDTexte.getInstance();
	
	public ControlRechercher(){	
	}
	
	
	public DescripteurTexte genererDescripteurTexte(String fichier){
		DescripteurTexte descripteurTexte=null ;
		
		return descripteurTexte;
	}
	
	public DescripteurImage genererDescripteurImage(String fichier){
	       DescripteurImage descripteurImage=null ;
			
			return descripteurImage;
		} 
	
	public DescripteurSon genererDescripteurSon(String fichier){
		DescripteurSon descripteurSon=null ;
		
		return descripteurSon;
	}
	

	public List<String> effectuerRechercheTexte(DescripteurTexte descripteurTexte ,int seuil){
		
		List<String> resultatTexte =new ArrayList<>();
		
		return resultatTexte;
	}
	
	
	public  List<String> effectuerRechercheImage(DescripteurImage descripteurImage ,int seuil){
		List<String> resultatImage =new ArrayList<>();
		
		return resultatImage;
		
	}	
	
	public List<String> effectuerRechercheSon(DescripteurSon descripteurSon ,int seuil){
		List<String> resultatSon =new ArrayList<>();
		
		return resultatSon;
		
	}	
	
	public List<String> lancerRechercheMotCle(String motCle,int seuil){
		List<String> listeDescripteursRecherche=new ArrayList<>();
	    listeDescripteursRecherche = bdTexte.getDescripteurs(motCle, seuil);
	    
		
		
		
		
		return listeDescripteursRecherche;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
