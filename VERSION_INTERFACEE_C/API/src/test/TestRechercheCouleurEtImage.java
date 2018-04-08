package test;

import control.ControlFiles;
import control.ControlIndexationImage;
import model.BDImage;
import model.DescripteurImage;

public class TestRechercheCouleurEtImage {
	
public static void main(String[] args) {
		
		ControlIndexationImage controlIndexationImage= new ControlIndexationImage();
		controlIndexationImage.indexAllImgs();
		int tab[]= {200,156,127};
		DescripteurImage descripteurImage=new DescripteurImage(0, "salut", "salut", 0, tab, "RED");
		BDImage bdImage=BDImage.getInstance();
		//bdImage.compareDescripteur(descripteurImage);
		
		System.out.println("test de recherche couleur Rouge � plus de 50%");
		bdImage.rechercheCouleur("R",50);
		
		System.out.println("test de recherche par comparaison de descripteurs");
		String path="D:\\bordel a cul\\Fil-Rouge-Part2-julien\\VERSION_INTERFACEE_C\\API\\src\\model\\TEST_RGB\\09.jpg";
		DescripteurImage[] tablo=bdImage.compareDescripteur(controlIndexationImage.indexImage(path));
		
		ControlFiles controlFiles=new ControlFiles();
		System.out.println("affichage dans l'ordre des 4 images les plus ressemblantes");
		/*for(int i=0;i<tablo.length;i++)
		{
			controlFiles.drawAverageColor(tablo[i]);
			controlFiles.drawImage(tablo[i].getPath());
		}*/
		
		for(int i=0;i<4;i++)
		{
			controlFiles.drawAverageColor(tablo[i]);
			controlFiles.drawImage(tablo[i].getPath());
		}
	}

}
