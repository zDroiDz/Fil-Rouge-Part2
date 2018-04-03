package control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import model.BDImage;
import model.BDSon;
import model.BDTexte;
import model.DescripteurImage;
import model.DescripteurSon;
import model.DescripteurTexte;

public class ControlDescripteurs {
	
	private static final String PATH_BASE_DESCRIPTEUR_TEXTE= System.getProperty("user.dir")+"/src/model/base_texte/base_descripteur_texte.txt";
	private static final String PATH_BASE_DESCRIPTEUR_SON=System.getProperty("user.dir")+"/src/model/base_son/base_descripteur_son.txt";
	private static final String PATH_BASE_DESCRIPTEUR_IMAGE= System.getProperty("user.dir")+"/src/mode/base_image/base_descripteur_image.txt";
	private static final String PATH_LISTE_BASE_TEXTE= System.getProperty("user.dir")+"/src/model/base_texte/liste_base_texte.txt";
	BDSon bdSon = BDSon.getInstance();
	BDImage bdimage = BDImage.getInstance();
	BDTexte bdTexte=BDTexte.getInstance();
	
	

	
	public void fillBDDescripteurSon()
	{
		int ligneM = 0 ;
		int colonneM = 0 ;
		try{
			DescripteurSon descripteurSon = null;
    		InputStream flux=new FileInputStream(PATH_BASE_DESCRIPTEUR_SON); 
    		InputStreamReader lecture=new InputStreamReader(flux);
    		BufferedReader buff=new BufferedReader(lecture);
    		String ligne;
    		//pour chaque ligne lue
    		while ((ligne=buff.readLine())!=null){
    			//System.out.println(ligne);
    			String[] partsID = ligne.split("<id>");
    			String[] partsFenetre = ligne.split("<fenetre>");
    			
    			//si la ligne lue contient la balise <id>
    			if(partsID.length > 1 ){
    				//si le descripteur son a été créé on l'ajoute dans la BD
    				if(descripteurSon != null){
    					descripteurSon.setSize(ligneM, colonneM);
    					
    					this.bdSon.ajouterDescripteurSon(descripteurSon);
    				}
    				//on en créé un nouveau
    				 descripteurSon = new DescripteurSon();
    				 //reset de ligne a chaque descripteur
    				 ligneM = 0 ;
    			}
    			
    			if(partsFenetre.length > 1){
    				String[] partsFenetreFermee = partsFenetre[1].split("</fenetre>");
    				//System.out.println(partsFenetreFermee[0]);
    				String valeurs[] = partsFenetreFermee[0].split("\\s+");
    				//i correspond a la colonne, ligne incrémenté a la mano
    				colonneM = valeurs.length ;
    				for(int i = 1 ; i < valeurs.length ; i ++ ){
    					descripteurSon.addContent(ligneM, i, Integer.parseInt(valeurs[i]));
    				}
    			}
    			ligneM++ ;
    			
    		}
    		buff.close(); 
    		if(descripteurSon != null){
    			descripteurSon.setSize(ligneM, colonneM);
				this.bdSon.ajouterDescripteurSon(descripteurSon);
			}
    		}		
    		catch (Exception e){
    		System.out.println(e.toString());
    		}
	}
	
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
        			//indice -1 car indice hashmap commence a 0 alors que id descripteur commence a 1
    				DescripteurTexte desc=bdTexte.getDescripteurTexte(Integer.parseInt(recupTab[1])-1);
        			if(desc!=null)
        			{
        				desc.setPath((recupTab[4]));
        				desc.setNomFichier((recupTab[4]));
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
		String monArray=this.bdimage.toString();
		return monArray;
	}
	


}
