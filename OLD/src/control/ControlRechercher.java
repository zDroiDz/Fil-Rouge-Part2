package control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.BDImage;
import model.BDTexte;
import model.Descripteur;
import model.DescripteurImage;
import model.DescripteurSon;
import model.DescripteurTexte;
import model.Profil;

public class ControlRechercher {
	
	private BDTexte bdTexte=BDTexte.getInstance();
	private BDImage bdimage = BDImage.getInstance();
	private ControlHistorique controlHistorique ; 
	private ControlProfil controlProfil;
	
	
	public ControlRechercher(ControlHistorique controlHistorique,ControlProfil controlProfil){
			this.controlHistorique = controlHistorique ;
			this.controlProfil=controlProfil;
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
		
		resultatTexte.add("03-Des_chercheurs_parviennent_�_r�g�n�rer.xml \n 03-Mimer_un_signal_nerveux_pour.xml \n 05-La_circoncision_pourrait_r�duire_le.xml"); 
		
		return resultatTexte;
	}
	
	
	public List<DescripteurImage> lancerRecherchePlageCouleurs(int couleur, int seuil){
		return this.bdimage.getDescripteurs(couleur, seuil);
		
	}
	
	public List<String> effectuerRechercheSon(DescripteurSon descripteurSon ,int seuil){
		List<String> resultatSon =new ArrayList<>();
		
		resultatSon.add("Une ressemblance � �t� trouv�e dans corpus_fi.bin � l'instant : 29.568001s  Une ressemblance � �t� trouv�e dans corpus_fi.bin � l'instant : 29.632001s  Trouv� dans corpus_fi.bin postiton :  29.568001s  32.128002s Une ressemblance � �t� trouv�e dans jingle_fi.bin � l'instant : 0.000000s  Trouv� dans jingle_fi.bin postiton :  0.000000s  2.560000s");

		
		return resultatSon;
		
	}	
	
	public List<DescripteurTexte> lancerRechercheMotCle(String motCle,int seuil, Profil profil){
		
		
		List<DescripteurTexte> listeDescripteursRecherche= bdTexte.getDescripteurs(motCle, seuil);
		
		//si la session est en mode historique
				if(profil.isHistorique()){
					
					List<String> histo = new ArrayList<>();	
					for(DescripteurTexte d : listeDescripteursRecherche){
						histo.add(d.toString());
					}
					this.controlHistorique.ajouterHistorique(motCle, histo);
					String chaine=motCle+": ";
					for(int i=0;i<histo.size();i++)
					{
						chaine+=histo.get(i).toString()+";";
					}
					
					chaine+="|";
					
					this.controlProfil.addHistoricContent(profil, chaine);
					
				}
	    
		return listeDescripteursRecherche;
		
	}


	public List<String> effectuerRechercheImage(DescripteurImage descripteur, int seuil) {
		// TODO Auto-generated method stub
		List<String> resultatImage = new ArrayList<>();
		
		resultatImage.add("01.jpg \n 03.jpg \n 45.jpg ");
		
		return resultatImage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
