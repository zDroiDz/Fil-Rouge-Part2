package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import control.ControlIndexationImage;
import sun.security.krb5.internal.crypto.Des;


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
	
	public DescripteurImage[] rechercheCouleur(String composante,int pourcentage)
	{
		
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
