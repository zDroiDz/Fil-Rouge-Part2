package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import control.ControlIndexation;

public class testLinux {
	
	public static void main(String[] args) {
		ControlIndexation controlIndexation=new ControlIndexation();
		//controlIndexation.lancerIndexation();
		
		String pathTexte="03-Des_chercheurs_parviennent_à_régénérer.xml";
		String pathSon="jingle_fi.bin";
		
		controlIndexation.compareTextes(pathTexte);
		
		controlIndexation.compareSons(pathSon);
		
	}
	

}
