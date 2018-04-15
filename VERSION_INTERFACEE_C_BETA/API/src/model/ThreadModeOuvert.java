package model;

import control.ControlIndexationC;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import control.ControlDescripteurs;

public class ThreadModeOuvert extends Thread {
	
	private ControlIndexationC controlIndexationC ;
	private ControlDescripteurs controlDescripteurs ;
	
	//permet de remonter au dossier source du projet
	static String nomDossierReference = new File(System.getProperty("user.dir")).getParentFile().getName();
	
	private static final String PATH_DOSSIER_SON = "../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/TEST_SON" ;
	private static final String PATH_DOSSIER_IMAGE = "../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/TEST_RGB" ;
	private static final String PATH_DOSSIER_TEXTE = "../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/Textes" ;
	
	private List<String> filesSonReference = Arrays.asList(new File(PATH_DOSSIER_SON).list());
	private List<String> filesImageReference = Arrays.asList(new File(PATH_DOSSIER_IMAGE).list());
	private List<String> filesTexteReference = Arrays.asList(new File(PATH_DOSSIER_TEXTE).list());
	
	private boolean condition = true ;
	private boolean reIndex = false ;
	
	
	public ThreadModeOuvert(ControlIndexationC controlIndexationC, ControlDescripteurs controlDescripteurs) {
		this.controlDescripteurs = controlDescripteurs;
		this.controlIndexationC = controlIndexationC ;
	}
	
	public void arret() {
		this.condition = false ;
	}
	
	public void run() {
		
		
		
	 do {
			try {
				Thread.sleep(5000);
				System.out.println("Je run !");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			List<String> filesSonActuel = Arrays.asList(new File(PATH_DOSSIER_SON).list());
		    List<String> filesImageActuel = Arrays.asList(new File(PATH_DOSSIER_IMAGE).list());
			List<String> filesTexteActuel = Arrays.asList(new File(PATH_DOSSIER_TEXTE).list());
			
			for(String s : filesSonActuel) {
				if(!filesSonReference.contains(s) || filesSonReference.size() != filesSonActuel.size()) {
					this.filesSonReference = filesSonActuel;
					reIndex = true ;
				}
			}
			for(String s : filesImageActuel) {
				if(!filesImageReference.contains(s) || filesImageReference.size() != filesImageActuel.size()) {
					this.filesImageReference = filesImageActuel;
					reIndex = true ;
				}
			}
			for(String s : filesTexteActuel) {
				if(!filesTexteReference.contains(s) || filesTexteReference.size() != filesTexteActuel.size()) {
					this.filesTexteReference = filesTexteActuel ;
					reIndex = true ;
				}
			}
			
			if(reIndex) {
				System.out.println("Indexation");
				this.controlIndexationC.lancerIndexation();
				this.controlDescripteurs.fillBDDescripteurSon();
				this.controlDescripteurs.fillBDDescripteurTexte();
				//manque image
				this.reIndex = false ;
				System.out.println("reset");
			}
			
		 
	 }while(condition);
	
		
		
		
		
	}
}
