package model;

import control.ControlIndexationC;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import control.ControlDescripteurs;

// TODO: Auto-generated Javadoc
/**
 * The Class ThreadModeOuvert.
 */
public class ThreadModeOuvert extends Thread {
	
	/** The control indexation C. */
	private ControlIndexationC controlIndexationC ;
	
	/** The control descripteurs. */
	private ControlDescripteurs controlDescripteurs ;
	
	/** The nom dossier reference. */
	//permet de remonter au dossier source du projet
	static String nomDossierReference = new File(System.getProperty("user.dir")).getParentFile().getName();
	
	/** The Constant PATH_DOSSIER_SON. */
	private static final String PATH_DOSSIER_SON = "../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/TEST_SON" ;
	
	/** The Constant PATH_DOSSIER_IMAGE. */
	private static final String PATH_DOSSIER_IMAGE = "../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/TEST_RGB" ;
	
	/** The Constant PATH_DOSSIER_TEXTE. */
	private static final String PATH_DOSSIER_TEXTE = "../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/Textes" ;
	
	/** The files son reference. */
	private List<String> filesSonReference = Arrays.asList(new File(PATH_DOSSIER_SON).list());
	
	/** The files image reference. */
	private List<String> filesImageReference = Arrays.asList(new File(PATH_DOSSIER_IMAGE).list());
	
	/** The files texte reference. */
	private List<String> filesTexteReference = Arrays.asList(new File(PATH_DOSSIER_TEXTE).list());
	
	/** The condition. */
	private boolean condition = true ;
	
	/** The re index. */
	private boolean reIndex = false ;
	
	
	/**
	 * Instantiates a new thread mode ouvert.
	 *
	 * @param controlIndexationC the control indexation C
	 * @param controlDescripteurs the control descripteurs
	 */
	public ThreadModeOuvert(ControlIndexationC controlIndexationC, ControlDescripteurs controlDescripteurs) {
		this.controlDescripteurs = controlDescripteurs;
		this.controlIndexationC = controlIndexationC ;
	}
	
	/**
	 * Arret.
	 */
	public void arret() {
		this.condition = false ;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
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
