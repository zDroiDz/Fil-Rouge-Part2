package vueGraphique;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FrameClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panContents = new JPanel();
	private JPanel panAccueil = new JPanel();
	private JMenuBar barreMenu ;
	CardLayout cartes ;
	
	public FrameClient(){
		
		this.setTitle("Moteur de recherche");
		this.setSize(900,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.cartes = new CardLayout();
		this.barreMenu = new JMenuBar();
		
		this.panContents.setLayout(cartes);
		
		this.getContentPane().add(this.panContents);
		this.setJMenuBar(this.barreMenu);
		
		initialisationAcceuil();
		
		
		//intialisationMenuAdmin();
		initialisationMenuUser();
		
		this.setVisible(true);
		
	}


	private void initialisationAcceuil() {
		// TODO Auto-generated method stub
		JLabel texteAccueil = new JLabel("Bienvenu dans le moteur de recherche");
		texteAccueil.setFont(new Font("Calibri", Font.BOLD, 24));
		
	    this.panAccueil.add(texteAccueil);

		this.panAccueil.setVisible(true);
		
		this.panContents.add(panAccueil, "ECRAN_ACCUEIL");

	    cartes.show(panContents, "ECRAN_ACCUEIL");    

		
	}
	
	private void initialisationMenuUser(){
		JMenuItem recherche = new JMenuItem("Recherche");
		JMenuItem historique = new JMenuItem("Consulter historique");
		JMenuItem deconnexion = new JMenuItem("Se d�connecter");
		
		JMenu menuRecherche = new JMenu("Recherche");
		JMenu menuHistorique = new JMenu("Historique");
		JMenu menuDeconnexion = new JMenu("D�connexion");
		
		menuRecherche.add(recherche);
		menuHistorique.add(historique);
		menuDeconnexion.add(deconnexion);
		
		this.barreMenu.add(menuRecherche);
		this.barreMenu.add(menuHistorique);
		this.barreMenu.add(menuDeconnexion);
		
	}


	/**
	 * 
	 */
	private void intialisationMenuAdmin() {
		// TODO Auto-generated method stub

		JMenuItem configuration = new JMenuItem("Configuration / Indexation");
		JMenuItem creerAdmin = new JMenuItem("Cr�er Administrateur");
		JMenuItem recherche = new JMenuItem("Recherche");
		JMenuItem historique = new JMenuItem("Consulter historique");
		JMenuItem deconnexion = new JMenuItem("Se d�connecter");
		JCheckBoxMenuItem modeOuvert = new JCheckBoxMenuItem("Mode Ouvert");
		JCheckBoxMenuItem modeFerme = new JCheckBoxMenuItem("Mode Ferme");
		
		JMenu menuRecherche = new JMenu("Recherche");
		JMenu menuHistorique = new JMenu("Historique");
		JMenu menuConfigurer = new JMenu("Configurer");
		JMenu sousMenuChoix = new JMenu("Choix mode");
		JMenu menuDeconnexion = new JMenu("D�connexion");
	
		
		

		
		//---------MenuItems------
		
		//appel pan recherche

		recherche.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("test");
			}
			
		});
		
		//appel pan historique
		historique.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//appel d�connexion
		deconnexion.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//appel pan configuration
		configuration.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//appel pan creer admin
		creerAdmin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("test");
			}
			
		});
		
		
		//JCheckBox
		modeOuvert.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(modeFerme.isSelected()){
					modeFerme.setSelected(false);
				}
				System.out.println("Mode ouvert");
			}
			
		});
		
		modeFerme.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(modeOuvert.isSelected()){
					modeOuvert.setSelected(false);
				}
				System.out.println("Mode ferm�");
			}
			
			
		});
		
		sousMenuChoix.add(modeOuvert);
		sousMenuChoix.add(modeFerme);
		menuConfigurer.add(configuration);
		menuConfigurer.add(creerAdmin);
		menuConfigurer.add(sousMenuChoix);
		menuRecherche.add(recherche);
		menuHistorique.add(historique);
		menuDeconnexion.add(deconnexion);
		
		
		this.barreMenu.add(menuRecherche);
		this.barreMenu.add(menuHistorique);
		this.barreMenu.add(menuConfigurer);
		this.barreMenu.add(menuDeconnexion);
		
	}
	
	public static void main(String[] args) {
		FrameClient laframe = new FrameClient();
	}

}
