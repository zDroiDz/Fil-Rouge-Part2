package control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import model.BDImage;
import model.DescripteurImage;

public class ControlIndexationImage {
	
	BDImage bdImage=BDImage.getInstance();
	
	private static final String PATH_REPERTOIRE_CIBLE= System.getProperty("user.dir")+"/src/model/TEST_RGB";
	
	public ControlIndexationImage()
	{
		
	}

	public void indexImg()
	{
		/* parcours de toutes les images du répertoire */
		File folder = new File(PATH_REPERTOIRE_CIBLE);
		File[] listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        if(!listOfFiles[i].getName().contains(".txt"))
		        {
		        	File fileToTreat=new File(PATH_REPERTOIRE_CIBLE+"/"+listOfFiles[i].getName());
			        
			        BufferedImage in = null;
					try {
						/* initialisation des variables à utiliser */
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
						
						/*
						JFrame f = new JFrame();
				        f.getContentPane().setBackground(new Color(tab[0], tab[1], tab[2]));
				        f.setTitle(listOfFiles[i].getName());
				        f.setSize(new Dimension(300, 200));
				        f.setVisible(true);
				        affichage d'une frame de la couleur moyenne
				        */
				        
				        DescripteurImage descripteurImage=new DescripteurImage(0, listOfFiles[i].getName(), listOfFiles[i].getName(), 0, tab, couleur);
						bdImage.ajouterDescripteurImage(descripteurImage);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        
		        
		      } 
		    }
	}
}
