package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import control.ControlIndexationImage;


public class BDImage {
	
	Map<Integer,DescripteurImage> listeDescripteurImage=new HashMap<>();
	
    private static class BDImageHolder
    {
        private final static BDImage instance=new BDImage();
    }

    public static BDImage getInstance()
    {
        return BDImageHolder.instance;
    }
    
    public  void ajouterDescripteurImage(DescripteurImage descripteur)
    {
        this.listeDescripteurImage.put(listeDescripteurImage.size(),descripteur);
    }
    
    public DescripteurImage getDescripteurImage(int id)
    {
    	return this.listeDescripteurImage.get(id);
    }

	@Override
	public String toString() {
		return "BDImage [listeDescripteurImage=" + listeDescripteurImage + "]";
	}
	
	public DescripteurImage[] compareDescripteur(DescripteurImage descripteur)
	{
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
			
			PositionScore[cpt]=scoreFinal;
			descripteurPosition[cpt]=d;
			cpt++;
		}
		return triBulles(PositionScore, descripteurPosition);
	}
	
	public List<DescripteurImage> rechercheCouleur(String composante,int pourcentage,int ecartMax)
	{
		
		return null;
	}
	
	public static void main(String[] args) {
		
		ControlIndexationImage controlIndexationImage= new ControlIndexationImage();
		controlIndexationImage.indexAllImgs();
		int tab[]= {200,156,127};
		DescripteurImage descripteurImage=new DescripteurImage(0, "salut", "salut", 0, tab, "RED");
		BDImage bdImage=BDImage.getInstance();
		bdImage.compareDescripteur(descripteurImage);
	}
	
	
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
