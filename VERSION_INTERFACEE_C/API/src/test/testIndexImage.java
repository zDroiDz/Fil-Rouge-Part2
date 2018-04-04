package test;

import control.ControlIndexationImage;
import model.BDImage;

public class testIndexImage {
	
	public static void main(String[] args) {
		ControlIndexationImage controlIndexationImage=new ControlIndexationImage();
		controlIndexationImage.indexAllImgs();
		
		BDImage bdImage=BDImage.getInstance();
		System.out.println(bdImage.toString());
	}

}
