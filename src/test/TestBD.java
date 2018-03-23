package test;

import control.ControlDescripteurs;
import model.BDTexte;

public class TestBD {
	
	
	public static void main(String[] args) {
		ControlDescripteurs controlDescripteurs=new ControlDescripteurs();
		
		controlDescripteurs.fillBDDescripteurTexte();
		
		BDTexte bdTexte=BDTexte.getInstance();
		
		System.out.println(bdTexte.toString());
		
		controlDescripteurs.setPath();
		
		System.out.println(bdTexte.toString());
	}

}
