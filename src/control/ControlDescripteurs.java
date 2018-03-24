package control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.BDImage;
import model.BDSon;
import model.BDTexte;
import model.DescripteurImage;
import model.DescripteurSon;
import model.DescripteurTexte;

public class ControlDescripteurs {
	
	private static final String PATH_BASE_DESCRIPTEUR_TEXTE= System.getProperty("user.dir")+"/src/model/base_texte/base_descripteur_texte.txt";
	private static final String PATH_BASE_DESCRIPTEUR_SON="";
	private static final String PATH_BASE_DESCRIPTEUR_IMAGE="";
	
	private static final String PATH_LISTE_BASE_TEXTE= System.getProperty("user.dir")+"/src/model/base_texte/liste_base_texte.txt";
	
	private BDTexte bdTexte=BDTexte.getInstance();
	private BDSon bdSon=BDSon.getInstance();
	private BDImage bdImage=BDImage.getInstance();
	
	public void fillBDDescripteurTexte()
	{
		try{
			/*création des ressources necessaires*/
    		InputStream flux=new FileInputStream(PATH_BASE_DESCRIPTEUR_TEXTE); 
    		InputStreamReader lecture=new InputStreamReader(flux);
    		BufferedReader buff=new BufferedReader(lecture);
    		String ligne;
    		while ((ligne=buff.readLine())!=null){
    			String[] recupID=ligne.split(" ");
    			String id=recupID[2];
    			
    			String[] recupContentInter=ligne.split("<mots>");
    			String[] recupContent=recupContentInter[1].split("</mots>");
    			
    			String content=recupContent[0];
    			
    			content=content.replace(";","");
    			
    			String[] descripteurs=content.split(" ");
    			
    			int internalcpt=0;
    			String mot="";
    			String Occurences = null;
    			
    			/* on crée ici le descripteur*/
    			DescripteurTexte desc=new DescripteurTexte(Integer.parseInt(id),"");
    			for(int i=0;i<descripteurs.length;i++)
    			{
    				if(descripteurs[i].length()!=0)
    				{
    					if(internalcpt==0)
        				{
    						mot=descripteurs[i];
        					internalcpt++;
        					continue;
        				}
    					if(internalcpt==1)
        				{
    						Occurences=descripteurs[i];
        					internalcpt=0;
        					/*ajout du couple motcle:nombre d'occurences au descripteur*/
        					desc.addContent(mot, Integer.parseInt(Occurences));
        					continue;
        				}
    				}
    				
    			}

    				bdTexte.ajouterDescripteurTexte(desc);
    				
    		}
    		buff.close(); 
    		}		
    		catch (Exception e){
    		System.out.println(e.toString());
    		}
		
		setPathTexte();
	}
	
	
	
	public void setPathTexte()
	{
		
		try{
			/*création des ressources necessaires*/
    		InputStream flux=new FileInputStream(PATH_LISTE_BASE_TEXTE); 
    		InputStreamReader lecture=new InputStreamReader(flux);
    		BufferedReader buff=new BufferedReader(lecture);
    		String ligne;
    		while ((ligne=buff.readLine())!=null){
    			
    			String[] recupTab=ligne.split(" ");
    			
    			
    			if(recupTab[4].length()!=0 && recupTab.length!=0)
    			{
        			
    				DescripteurTexte desc=bdTexte.getDescripteurTexte(Integer.parseInt(recupTab[1]));
        			if(desc!=null)
        			{
        				desc.setPath(recupTab[4]);
        			}
    			}
    		}
    		buff.close(); 
    		}		
    		catch (Exception e){
    		System.out.println(e.toString());
    		}
	}
	
	
	public String visualiserDescripteursTexte()
	{
		String monArray=this.bdTexte.toString();
		return monArray;
	}
	public String visualiserDescripteursSon()
	{
		String monArray=this.bdSon.toString();
		return monArray;
	}
	
	public String visualiserDescripteursImage()
	{
		String monArray=this.bdImage.toString();
		return monArray;
	}

}
