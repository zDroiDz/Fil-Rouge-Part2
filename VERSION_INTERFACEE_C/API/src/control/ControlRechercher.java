package control;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import model.BDImage;
import model.BDTexte;
import model.Descripteur;
import model.DescripteurImage;
import model.DescripteurSon;
import model.DescripteurTexte;
import model.Profil;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlRechercher.
 */
public class ControlRechercher {
	
	/** The bd texte. */
	private BDTexte bdTexte=BDTexte.getInstance();
	
	/** The bd image. */
	private BDImage bdImage = BDImage.getInstance();
	
	/** The control historique. */
	private ControlHistorique controlHistorique ; 
	
	/** The control profil. */
	private ControlProfil controlProfil;
	
	
	
	/**
	 * Instantiates a new control rechercher.
	 *
	 * @param controlHistorique the control historique
	 * @param controlProfil the control profil
	 */
	public ControlRechercher(ControlHistorique controlHistorique,ControlProfil controlProfil){
			this.controlHistorique = controlHistorique ;
			this.controlProfil=controlProfil;
	}
	
	
	/**
	 * Instantiates a new control rechercher.
	 */
	public ControlRechercher() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Generer descripteur texte.
	 *
	 * @param fichier the fichier
	 * @return the descripteur texte
	 */
	public DescripteurTexte genererDescripteurTexte(String fichier){
		DescripteurTexte descripteurTexte=null ;
		
		return descripteurTexte;
	}
	
	/**
	 * Generer descripteur image.
	 *
	 * @param fichier the fichier
	 * @return the descripteur image
	 */
	public DescripteurImage genererDescripteurImage(String fichier){
	       DescripteurImage descripteurImage=null ;
			
			return descripteurImage;
		} 
	
	/**
	 * Generer descripteur son.
	 *
	 * @param fichier the fichier
	 * @return the descripteur son
	 */
	public DescripteurSon genererDescripteurSon(String fichier){
		DescripteurSon descripteurSon=null ;
		
		return descripteurSon;
	}
	
	
	/**
	 * Lancer recherche mot cle.
	 *
	 * @param motCle the mot cle
	 * @param seuil the seuil
	 * @param profil the profil
	 * @return the list
	 */
	public List<DescripteurTexte> lancerRechercheMotCle(String motCle,int seuil, Profil profil){
		
		
		List<DescripteurTexte> listeDescripteursRecherche= bdTexte.getDescripteurs(motCle, seuil);
		
		//si la session est en mode historique
		/*		if(profil.isHistorique()){
					
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
					
				}*/
	    
		return listeDescripteursRecherche;
		
	}

	/**
	 * Compare descripteur image.
	 *
	 * @param descripteur the descripteur
	 * @param margeRessemblance the marge ressemblance
	 * @return the descripteur image[]
	 */
	public DescripteurImage[] compareDescripteurImage(DescripteurImage descripteur,int margeRessemblance)
	{
		Map<Integer,DescripteurImage> listeDescripteurImage = bdImage.getListeDescripteurImage();
		
		float[] PositionScore= new float[listeDescripteurImage.size()];
		DescripteurImage[] descripteurPosition=new DescripteurImage[listeDescripteurImage.size()];
		int redO=descripteur.getComposante(0);
		int greenO=descripteur.getComposante(1);
		int blueO=descripteur.getComposante(2);
		
		int cpt=0;
		
		float percentRedO=(redO*100)/(redO+greenO+blueO);
		float percentGreenO=(greenO*100)/(redO+greenO+blueO);
		float percentBlueO=(blueO*100)/(redO+greenO+blueO);
		
		for(DescripteurImage d:listeDescripteurImage.values())
		{
			int red=d.getComposante(0);
			int green=d.getComposante(1);
			int blue=d.getComposante(2);
			
			float scoreRed;
			float scoreGreen;
			float scoreBlue;
			float scoreFinal;
			
			float percentRed=(red*100)/(red+green+blue);
			float percentGreen=(green*100)/(red+green+blue);
			float percentBlue=(blue*100)/(red+green+blue);
				
			scoreRed=Math.abs(percentRedO-percentRed);
			scoreGreen=Math.abs(percentGreenO-percentGreen);
			scoreBlue=Math.abs(percentBlueO-percentBlue);

			scoreFinal=scoreRed+scoreGreen+scoreBlue;
			
			System.out.println(margeRessemblance+ " " +scoreFinal);
			if(scoreFinal<margeRessemblance)
			{
				PositionScore[cpt]=scoreFinal;
				descripteurPosition[cpt]=d;
				cpt++;
			}
		}
		return triBulles(PositionScore, descripteurPosition);
	}
	
	/**
	 * Recherche couleur.
	 *
	 * @param composante the composante
	 * @param pourcentage the pourcentage
	 * @return the descripteur image[]
	 */
	public DescripteurImage[] rechercheCouleur(String composante,int pourcentage)
	{
		Map<Integer,DescripteurImage> listeDescripteurImage = bdImage.getListeDescripteurImage();
		
		ArrayList<Float> arrayScore=new ArrayList<>();
		ArrayList<DescripteurImage> arrayDesc=new ArrayList<>();
		int cpt=0;
		for(DescripteurImage d:listeDescripteurImage.values())
		{
			int red=d.getComposante(0);
			int green=d.getComposante(1);
			int blue=d.getComposante(2);
			
			switch (composante) {
			case "R":
				float percentRed=(red*100)/(red+green+blue);
				if(percentRed>pourcentage)
				{
					arrayScore.add(percentRed);
					arrayDesc.add(d);
					cpt++;
				}
				break;
			case "G":
				float percentGreen=(green*100)/(red+green+blue);
				if(percentGreen>pourcentage)
				{
					arrayScore.add(percentGreen);
					arrayDesc.add(d);
					cpt++;
				}
				break;
			case "B":
				float percentBlue=(blue*100)/(red+green+blue);
				if(percentBlue>pourcentage)
				{
					arrayScore.add(percentBlue);
					arrayDesc.add(d);
					cpt++;
				}
				break;

			default:
				break;
			}
		}
		float[] tabScores=new float[cpt];
		DescripteurImage[] tabDesc= new DescripteurImage[cpt];
		for(int i=0;i<arrayScore.size();i++)
		{
			tabScores[i]=arrayScore.get(i);
			tabDesc[i]=arrayDesc.get(i);
		}
		ArrayList<DescripteurImage> reversor= new ArrayList<>();
		
		DescripteurImage[] tabDescInv=triBulles(tabScores, tabDesc);
		
		for(int i=0;i<tabDescInv.length;i++)
		{
			reversor.add(tabDescInv[i]);
		}
		
		Collections.reverse(reversor);
		
		
		DescripteurImage[] tabDescOrdered=new DescripteurImage[cpt];
		
		for(int i=0;i<tabDescOrdered.length;i++)
		{
			tabDescOrdered[i]=reversor.get(i);
			System.out.println(reversor.get(i));
		}
		
		return tabDescOrdered;
	}
	
	
	/**
	 * Tri bulles.
	 *
	 * @param tab1 the tab 1
	 * @param tab2 the tab 2
	 * @return the descripteur image[]
	 */
	public DescripteurImage[] triBulles(float[] tab1, DescripteurImage[] tab2)
	{
		float echange;
		DescripteurImage echangeDesc;
		boolean tab_en_ordre = false;
	    int taille = tab1.length;
	    while(!tab_en_ordre)
	    {
	        tab_en_ordre = true;
	        for(int i=0 ; i < taille-1 ; i++)
	        {
	            if(tab1[i] > tab1[i+1])
	            { 
	                echange=tab1[i];
					echangeDesc=tab2[i];
					tab1[i]=tab1[i+1];
					tab2[i]=tab2[i+1];
					tab1[i+1]=echange;
					tab2[i+1]=echangeDesc;
					
	                tab_en_ordre = false;
	            }
	        }
	        taille--;
	    }
	    return tab2;
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
