package test;

import control.ControlDescripteurs;
import control.ControlIndexationC;
import model.ThreadModeOuvert;

public class TestThread {

	public static void main(String[] args) {
		
		ControlIndexationC controlIndexationC = new ControlIndexationC();
		ControlDescripteurs controlDescripteurs = new ControlDescripteurs();
		ThreadModeOuvert threadModeOuvert = new ThreadModeOuvert(controlIndexationC, controlDescripteurs);
		threadModeOuvert.start();
		
	}
	
}
