package control;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import model.BDImage;
import model.BDSon;
import model.BDTexte;
import model.DescripteurImage;
import model.DescripteurSon;
import model.DescripteurTexte;

public class ControlDescripteurs {
	
	private static final String PATH_BASE_DESCRIPTEUR_TEXTE= "../EXTERN_FILES/database/base_texte/base_descripteur_texte.txt";
	private static final String PATH_BASE_DESCRIPTEUR_SON="../EXTERN_FILES/database/base_son/base_descripteur_son.txt";
	private static final String PATH_BASE_DESCRIPTEUR_IMAGE= "../EXTERN_FILES/database/base_descripteur_image.txt";
	private static final String PATH_LISTE_BASE_TEXTE= "../EXTERN_FILES/database/base_texte/liste_base_texte.txt";
	private static final String PATH_REPERTOIRE_CIBLE= "../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/TEST_RGB";
	BDSon bdSon = BDSon.getInstance();
	BDImage bdImage = BDImage.getInstance();
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
	
	public void fillBDDescripteurImage()
	{
		/* parcours de toutes les images du r�pertoire */
		File folder = new File(PATH_REPERTOIRE_CIBLE);
		File[] listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        if(!listOfFiles[i].getName().contains(".txt"))
		        {
		        	File fileToTreat=new File(PATH_REPERTOIRE_CIBLE+"/"+listOfFiles[i].getName());
			        
			        BufferedImage in = null;
					try {
						/* initialisation des variables � utiliser */
						in = ImageIO.read(fileToTreat);
						int l=in.getWidth();
						int h=in.getHeight();
						int tab[]=new int[3];
						tab[0]=0;
						int cpt=0;
						String couleur="";
						
						for(int j=0;j<l;j++)
						{
							for(int k=0;k<h;k++)
							{
								Color mycolor = new Color(in.getRGB(j, k));
								tab[0]+=mycolor.getRed();
								tab[1]+=mycolor.getGreen();
								tab[2]+=mycolor.getBlue();
								cpt++;
							}
						}	
				
						tab[0]=(int)(tab[0]/cpt);
						tab[1]=(int)(tab[1]/cpt);
						tab[2]=(int)(tab[2]/cpt);

						if(tab[0]>tab[1] && tab[0]>tab[2])
						{
							couleur="RED";
						}
						if(tab[1]>tab[2] && tab[1]>tab[0])
						{
							couleur="GREEN";
						}
						if(tab[2]>tab[1] && tab[2]>tab[0])
						{
							couleur="BLUE";
						}
												
						String tabint[]=listOfFiles[i].getName().split("\\.");
						
						int id=Integer.parseInt(tabint[0]);
				        
				        DescripteurImage descripteurImage=new DescripteurImage(id, listOfFiles[i].getName(), listOfFiles[i].getPath(), 0, tab, couleur);
						bdImage.ajouterDescripteurImage(descripteurImage);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        
		      } 
		    }
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
        				desc.setPath(("../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/Textes/"+recupTab[4]));
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
		String monArray=this.bdImage.toString();
		return monArray;
	}
	


}
