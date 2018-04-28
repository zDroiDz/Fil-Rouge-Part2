package vueGraphique;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.sun.javafx.css.converters.PaintConverter;

import control.ControlConfigurer;
import control.ControlCreerProfil;
import control.ControlDescripteurs;
import control.ControlFiles;
import control.ControlHistorique;
import control.ControlIndexationC;
import control.ControlIndexationImage;
import control.ControlProfil;
import control.ControlRechercher;
import control.ControlSIdentifier;
import model.BDProfil;
import model.Profil;
import model.ProfilUtilisateur;
import model.ThreadModeOuvert;

// TODO: Auto-generated Javadoc
/**
 * The Class FrameClient.
 */
public class FrameClient extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The pan contents. */
	private JPanel panContents = new JPanel();
	
	/** The pan accueil. */
	private JPanel panAccueil = new JPanel();

	/** The profil. */
	public static Profil profil = null ;
	
	/** The barre menu admin. */
	private JMenuBar barreMenuAdmin ;
	
	/** The barre menu user. */
	private JMenuBar barreMenuUser ;
	
	/** The image logo. */
	private JLabel imageLogo;
	
	/** The cartes. */
	private CardLayout cartes ;
	
	/** The control indexation C. */
	private ControlIndexationC controlIndexationC = new ControlIndexationC();
	
	/** The control configurer. */
	private ControlConfigurer controlConfigurer = new ControlConfigurer();
	
	/** The control historique. */
	private ControlHistorique controlHistorique = new ControlHistorique();
	
	/** The control profil. */
	private ControlProfil controlProfil = new ControlProfil();
	
	/** The control rechercher. */
	private ControlRechercher controlRechercher = new ControlRechercher();
	
	/** The control files. */
	private ControlFiles controlFiles = new ControlFiles();
	
	/** The control indexation image. */
	private ControlIndexationImage controlIndexationImage = new ControlIndexationImage();
	
	/** The control S identifier. */
	private ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
	
	/** The control creer profil. */
	private ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
	
	/** The control descripteurs. */
	private ControlDescripteurs controlDescripteurs = new ControlDescripteurs();

	/** The pan configurer. */
	private PanConfigurer panConfigurer = new PanConfigurer(controlConfigurer, controlIndexationC )  ;
	
	/** The pan rechercher. */
	private PanRechercher panRechercher = new PanRechercher() ;
	
	/** The pan recherche couleur dominante. */
	private PanRechercheCouleurDominante panRechercheCouleurDominante = new PanRechercheCouleurDominante(controlHistorique, controlProfil, controlRechercher);

	/** The pan rechercher comparaison image. */
	private PanRechercheComparaisonImage panRechercherComparaisonImage = new PanRechercheComparaisonImage(controlProfil, controlHistorique, controlRechercher, controlFiles, controlIndexationImage);
	
	/** The pan recherche texte mot cle. */
	private PanRechercheTexteMotCle panRechercheTexteMotCle = new PanRechercheTexteMotCle(controlRechercher, controlProfil, controlHistorique);
	
	/** The pan recherche texte comparaison fichier. */
	private PanRechercheTexteComparaisonFichier panRechercheTexteComparaisonFichier = new PanRechercheTexteComparaisonFichier(controlIndexationC, controlProfil, controlHistorique, controlFiles);
	
	/** The pan recherche son comparaison fichier. */
	private PanRechercheSonComparaisonFichier panRechercheSonComparaisonFichier = new PanRechercheSonComparaisonFichier(controlIndexationC, controlProfil, controlHistorique, controlFiles);

	
	/** The pan S identifier. */
	private PanSIdentifier panSIdentifier = new PanSIdentifier(controlSIdentifier, controlCreerProfil);
	

	/** The pan historique. */
	private PanHistorique panHistorique = null ; 
	
	/** The pan creer admin. */
	private PanCreerAdmin panCreerAdmin = new PanCreerAdmin(controlCreerProfil);
	
	
	
	
	/** The thread mode ouvert. */
	private ThreadModeOuvert threadModeOuvert = new ThreadModeOuvert(controlIndexationC, controlDescripteurs); 
  
	/** The pop up. */
	private PopUp popUp = new PopUp(this);
	
	/**
	 * Instantiates a new frame client.
	 */
	public FrameClient(){
		BufferedImage myPicture;
        String path="src/rsz_30859220_1810475535640617_1730222156_n.png";
		try {
			myPicture = ImageIO.read(new File(path));
			imageLogo=new JLabel(new ImageIcon(myPicture));
			imageLogo.setVisible(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.setTitle("Moteur de recherche");
		this.setSize(850,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(850,600));
		
		controlProfil.FillBDProfils();
		controlDescripteurs.fillBDDescripteurSon();
		controlDescripteurs.fillBDDescripteurTexte();
		controlDescripteurs.fillBDDescripteurImage();
		
		this.cartes = new CardLayout();
		this.barreMenuAdmin = new JMenuBar();
		this.barreMenuUser = new JMenuBar();
		
		this.controlConfigurer.setup();
		this.panConfigurer.initialisation();
		//


		panRechercher.initialisation();
		panRechercher.lancerRecherche();
		
		this.panContents.setLayout(cartes);
		this.panContents.add(this.panConfigurer, "CONFIGURER" );
		//
		

		this.panContents.add(panSIdentifier,"SIdentifier");
		this.panContents.add(panRechercheCouleurDominante, "COULEUR DOMINANTE");
		this.panContents.add(panRechercherComparaisonImage, "COULEUR COMPARAISON");
		this.panContents.add(panRechercheTexteMotCle, "TEXTE MOTCLE");
		this.panContents.add(panRechercheTexteComparaisonFichier, "TEXTE COMPARAISON");
		this.panContents.add(panRechercheSonComparaisonFichier, "SON COMPARAISON");
		this.panContents.add(panCreerAdmin, "CreerAdmin");
		
		
		this.getContentPane().add(this.panContents);
		
		
		
		JLabel texteAccueil = new JLabel("Bienvenu dans le moteur de recherche");
		texteAccueil.setFont(new Font("Calibri", Font.BOLD, 24));
		this.panAccueil.add(texteAccueil);
		
		
		
		
		
		initialisationMenuAdmin();
		initialisationMenuUser();
		
		identification();
		
		
		
	}
	
	/**
	 * Identification.
	 */
	private void identification() {
		cartes.show(panContents, "SIdentifier");
		
		JButton boutonOK = this.panSIdentifier.getBoutonOk();
		
			boutonOK.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					FrameClient.profil = controlSIdentifier.SIdentifier(panSIdentifier.getLogin(), panSIdentifier.getPasswordConnection());
					if(profil != null ) {
						popUp.setVisible(true);
						setVisible(false);
						initialisationAcceuil();
					}
					
					
				}
			});
		
		
		JButton boutonCreerCompte  = this.panSIdentifier.getBoutonCreerCompte();
		
		boutonCreerCompte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean creation = panSIdentifier.getPasswordCreation().equals(panSIdentifier.getConfPasswordCreation());
				if(controlCreerProfil.verificationCreation(panSIdentifier.getPasswordCreation()) && creation && !panSIdentifier.getPrenom().equals("") && !panSIdentifier.getNom().equals("") && !panSIdentifier.getPasswordCreation().equals("") ) {
					System.out.println(panSIdentifier.getPrenom());
					profil = controlCreerProfil.creerProfil(ProfilUtilisateur.UTILISATEUR,panSIdentifier.getPrenom(), panSIdentifier.getNom(), panSIdentifier.getPasswordCreation());
					//initialisationAcceuil();
				}
				
				if(profil != null ) {
					popUp.setVisible(true);
					setVisible(false);
					initialisationAcceuil();
				}
				
			}
			
		});
	
		this.setVisible(true);
	}


	/**
	 * Initialisation acceuil.
	 */
	private void initialisationAcceuil() {
		
		
		if(profil.isAdmin()) {
			//intialisationMenuAdmin();
			this.setJMenuBar(this.barreMenuAdmin);
			this.barreMenuAdmin.setVisible(true);
		}else {
			//initialisationMenuUser();
			this.setJMenuBar(this.barreMenuUser);
			this.barreMenuUser.setVisible(true);
			
		}
		
		// TODO Auto-generated method stub
		
		
		imageLogo.setVisible(true);
		this.panAccueil.setVisible(true);
		this.panAccueil.add(imageLogo);
		
		this.panContents.add(panAccueil, "ECRAN_ACCUEIL");

	    cartes.show(panContents, "ECRAN_ACCUEIL");   

		
	}
	
	/**
	 * Initialisation menu user.
	 */
	private void initialisationMenuUser(){
		
	
		JMenuItem historique = new JMenuItem("Consulter historique");
		JMenuItem deconnexion = new JMenuItem("Se deconnecter");
		
		// pour la recherche niveau 1
		JMenu rechercheTexte = new JMenu("Recherche texte");
		JMenu rechercheImage = new JMenu("Recherche image");
		JMenu rechercheSon = new JMenu("Recherche son");

		// recherche image niveau 2

		JMenuItem rechercheCouleurDominante = new JMenuItem("par couleur dominante");
		JMenuItem rechercheCouleurComparaison = new JMenuItem("par comparaison de fichier");

		// recherche texte niveau 2

		JMenuItem rechercheTexteMotCle = new JMenuItem("par mots clés");
		JMenuItem rechercheTexteComparaison = new JMenuItem("par comparaison de fichier");

		// recherche son niveau 2

		JMenuItem rechercheSonComparaison = new JMenuItem("par comparaison de fichier");		

		rechercheSonComparaison.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cartes.show(panContents, "SON COMPARAISON");
			}
		});
		
		
		JMenu menuRecherche = new JMenu("Recherche");
		JMenu menuHistorique = new JMenu("Historique");
		JMenu menuDeconnexion = new JMenu("Deconnexion");
		
		// =================== AJOUT DES ACTIONS LISTENER SUR LES
				// MENUITEMS=================================

				rechercheCouleurDominante.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						panRechercheCouleurDominante.initialisation();

						cartes.show(panContents, "COULEUR DOMINANTE");
					}
				});

				rechercheCouleurComparaison.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						panRechercherComparaisonImage.initialisation();

						cartes.show(panContents, "COULEUR COMPARAISON");
					}
				});
		
		//appel pan historique
				historique.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(panHistorique == null) {
							panHistorique = new PanHistorique(controlHistorique, profil);
							panHistorique.initialisation();
							panContents.add(panHistorique, "HISTORIQUE");
						}
						panHistorique.updateListeHistorique();
						cartes.show(panContents, "HISTORIQUE");
					}
					
				});
				
				//appel d�connexion
				deconnexion.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(profil.isAdmin()) {
							barreMenuAdmin.setVisible(false);
						}else {
							barreMenuUser.setVisible(false);
						}
						FrameClient.profil = null ;
						cartes.show(panContents, "SIdentifier");
						controlProfil.FillBDProfils();
					}
					
				});		
		
				rechercheTexteMotCle.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						cartes.show(panContents, "TEXTE MOTCLE");
					}
				});
		
				rechercheTexteComparaison.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						cartes.show(panContents, "TEXTE COMPARAISON");
					}
				});
				
				
				// ajout des composants
		rechercheImage.add(rechercheCouleurDominante);
		rechercheImage.add(rechercheCouleurComparaison);
				

		rechercheTexte.add(rechercheTexteMotCle);
		rechercheTexte.add(rechercheTexteComparaison);

		rechercheSon.add(rechercheSonComparaison);

		menuRecherche.add(rechercheTexte);
		menuRecherche.add(rechercheImage);
		menuRecherche.add(rechercheSon);

		menuHistorique.add(historique);
		menuDeconnexion.add(deconnexion);
		
		this.barreMenuUser.add(menuRecherche);
		this.barreMenuUser.add(menuHistorique);
		this.barreMenuUser.add(menuDeconnexion);
		
	}


	/**
	 * Initialisation menu admin.
	 */
	private void initialisationMenuAdmin() {
		// TODO Auto-generated method stub

		JMenuItem configuration = new JMenuItem("Configuration / Indexation");
		JMenuItem creerAdmin = new JMenuItem("Créer Administrateur");
		JMenuItem historique = new JMenuItem("Consulter historique");
		JMenuItem deconnexion = new JMenuItem("Se déconnecter");
		//JMenuItem visualiserDescripteur = new JMenuItem("Visualiser descripteurs");
		
		JCheckBoxMenuItem modeOuvert = new JCheckBoxMenuItem("Mode Ouvert");
		JCheckBoxMenuItem modeFerme = new JCheckBoxMenuItem("Mode Ferme");
		modeFerme.setSelected(true);
		modeFerme.setEnabled(false);
		
		JMenu menuRecherche = new JMenu("Recherche");
		JMenu menuHistorique = new JMenu("Historique");
		JMenu menuConfigurer = new JMenu("Configurer");
		JMenu sousMenuChoix = new JMenu("Choix mode");
		JMenu menuDeconnexion = new JMenu("Déconnexion");
	
		

		// pour la recherche niveau 1
		JMenu rechercheTexte = new JMenu("Recherche texte");
		JMenu rechercheImage = new JMenu("Recherche image");
		JMenu rechercheSon = new JMenu("Recherche son");

		// recherche image niveau 2

		JMenuItem rechercheCouleurDominante = new JMenuItem("par couleur dominante");
		JMenuItem rechercheCouleurComparaison = new JMenuItem("par comparaison de fichier");
		JMenuItem rechercheCouleurMultiple = new JMenuItem("par couleur multiple");

		// recherche texte niveau 2

		JMenuItem rechercheTexteMotCle = new JMenuItem("par mots clés");
		JMenuItem rechercheTexteComparaison = new JMenuItem("par comparaison de fichier");

		// recherche son niveau 2

		JMenuItem rechercheSonComparaison = new JMenuItem("par comparaison de fichier");
		
rechercheSonComparaison.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cartes.show(panContents, "SON COMPARAISON");
			}
		});

		
		//---------MenuItems------
		
		// =================== AJOUT DES ACTIONS LISTENER SUR LES
				// MENUITEMS=================================
				
				rechercheCouleurDominante.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						panRechercheCouleurDominante.initialisation();

						cartes.show(panContents, "COULEUR DOMINANTE");
					}
				});

				rechercheCouleurComparaison.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						panRechercherComparaisonImage.initialisation();

						cartes.show(panContents, "COULEUR COMPARAISON");
					}
				});
				
				rechercheTexteMotCle.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						cartes.show(panContents, "TEXTE MOTCLE");
					}
				});
		
				rechercheTexteComparaison.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						cartes.show(panContents, "TEXTE COMPARAISON");
					}
				});
				
		//appel pan historique
		historique.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(panHistorique == null) {
					panHistorique = new PanHistorique(controlHistorique, profil);
					panHistorique.initialisation();
					panContents.add(panHistorique, "HISTORIQUE");
				}
				panHistorique.updateListeHistorique();
				cartes.show(panContents, "HISTORIQUE");
			}
			
		});
		
		//appel d�connexion
		deconnexion.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(profil.isAdmin()) {
					barreMenuAdmin.setVisible(false);
				}else {
					barreMenuUser.setVisible(false);
				}
				FrameClient.profil = null ;
				cartes.show(panContents, "SIdentifier");
				controlProfil.FillBDProfils();
			}
			
		});
		
		//appel pan configuration
		configuration.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cartes.show(panContents, "CONFIGURER");
			}
			
		});
		
		//appel pan creer admin
		creerAdmin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cartes.show(panContents, "CreerAdmin");
			}
			
		});
		
	/*	visualiserDescripteur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
		
		//JCheckBox
		modeOuvert.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(modeFerme.isSelected()){
					modeFerme.setSelected(false);
				}
				modeOuvert.setEnabled(false);
				modeFerme.setEnabled(true);
				System.out.println("Mode ouvert");
				if(threadModeOuvert.getState().equals(Thread.State.TERMINATED)) {
					threadModeOuvert = new ThreadModeOuvert(controlIndexationC, controlDescripteurs);
					threadModeOuvert.start();
				}else {
					threadModeOuvert.start();
				}
				
			    	
				
			}
			
		});
		
		modeFerme.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(modeOuvert.isSelected()){
					modeOuvert.setSelected(false);
				}
				modeFerme.setEnabled(false);
				modeOuvert.setEnabled(true);
				System.out.println("Mode ferme");
				threadModeOuvert.arret();
			}
			
			
		});
		
		rechercheImage.add(rechercheCouleurDominante);
		rechercheImage.add(rechercheCouleurComparaison);

		rechercheTexte.add(rechercheTexteMotCle);
		rechercheTexte.add(rechercheTexteComparaison);

		rechercheSon.add(rechercheSonComparaison);

		menuRecherche.add(rechercheTexte);
		menuRecherche.add(rechercheImage);
		menuRecherche.add(rechercheSon);
		
		sousMenuChoix.add(modeOuvert);
		sousMenuChoix.add(modeFerme);
		menuConfigurer.add(configuration);
		menuConfigurer.add(creerAdmin);
	//	menuConfigurer.add(visualiserDescripteur);
		menuConfigurer.add(sousMenuChoix);

		menuHistorique.add(historique);
		menuDeconnexion.add(deconnexion);
		
		
		this.barreMenuAdmin.add(menuRecherche);
		this.barreMenuAdmin.add(menuHistorique);
		this.barreMenuAdmin.add(menuConfigurer);
		this.barreMenuAdmin.add(menuDeconnexion);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		FrameClient laframe = new FrameClient();
	}

}