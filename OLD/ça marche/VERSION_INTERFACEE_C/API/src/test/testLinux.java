package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import control.ControlDescripteurs;
import control.ControlIndexationC;
import model.BDTexte;

public class testLinux {
	
	public static void main(String[] args) {
		
		BDTexte bdTexte = BDTexte.getInstance();
		ControlDescripteurs controlDescripteurs = new ControlDescripteurs();
		controlDescripteurs.fillBDDescripteurTexte();
		
		ControlIndexationC controlIndexation=new ControlIndexationC();
		//controlIndexation.lancerIndexation();
		
		String pathTexte="03-Des_chercheurs_parviennent_à_régénérer.xml";
		String pathSon="jingle_fi.bin";
		
		System.out.println(controlIndexation.compareTextes(pathTexte, 0));
		
		controlIndexation.compareSons(pathSon);
		
		
	
		
	}
	

}
