package test;

import control.ControlFiles;
import control.ControlIndexationImage;
import model.BDImage;

public class testOpenFile {
	
	
	
	public static void main(String[] args) {
		
		ControlIndexationImage controlIndexationImage=new ControlIndexationImage();
		//controlIndexationImage.indexAllImgs();
		
		BDImage bdImage= BDImage.getInstance();
		ControlFiles choice=new ControlFiles();
		//System.out.println(choice.recupTxtOrXMLFile());
		String path=choice.recupImgFile();
		System.out.println(path);
		choice.drawImage(path);
		//choice.drawAverageColor(bdImage.getDescripteurImage(0));
		
		
	}
	


}
