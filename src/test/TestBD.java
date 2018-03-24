package test;

import control.ControlDescripteurs;
import model.BDTexte;
import vuetextuelle.BoundaryVisualiserDescripteurs;

public class TestBD {
	
	
	public static void main(String[] args) {
		ControlDescripteurs controlDescripteurs=new ControlDescripteurs();
		controlDescripteurs.fillBDDescripteurTexte();
		BDTexte bdTexte=BDTexte.getInstance();
		
		System.out.println(bdTexte.toString());
		
		BoundaryVisualiserDescripteurs boundaryVisualiserDescripteurs=new BoundaryVisualiserDescripteurs(controlDescripteurs);
		boundaryVisualiserDescripteurs.visualiserDescripteurs();	
	}

}
