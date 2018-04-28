package vueGraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import control.ControlHistorique;
import control.ControlRequeteRecherche;
import model.Admin;
import model.Profil;


// TODO: Auto-generated Javadoc
/**
 * The Class PanHistorique.
 */
public class PanHistorique extends JPanel{

	
	
	/** The control historique. */
	private ControlHistorique controlHistorique;
	
	/** The profil. */
	private Profil profil;
	

	/** The pan contents. */
	private JPanel panContents = new JPanel();
	
	/** The cartes. */
	CardLayout cartes ;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 427882115525050859L;
	
	/** The box mise en page. */
	Box boxMiseEnPage = Box.createHorizontalBox();
	
	/** The box recherches. */
	Box boxRecherches = Box.createHorizontalBox();
	
	/** The box validation. */
	Box boxValidation = Box.createHorizontalBox();
	
	/** The liste inter. */
	DefaultListModel<String >listeInter = new DefaultListModel<String>();

	
	/**
	 * Instantiates a new pan historique.
	 *
	 * @param controlHistorique the control historique
	 * @param profil the profil
	 */
	public PanHistorique(ControlHistorique controlHistorique, Profil profil) {
		this.controlHistorique = controlHistorique;
		this.profil = profil;
	}
	
	/**
	 * Initialisation.
	 */
	public void initialisation() {
		
		
		controlHistorique.FillBDHistorique(profil);
		JLabel ecranTitre = new JLabel("Affichage de l'historique correspondant a : " + profil.getIdentifiant());
		ecranTitre.setFont(new Font("Calibri", Font.BOLD, 24));
		boxMiseEnPage.add(ecranTitre);
		
		
		ArrayList<String> listeRecherches = (ArrayList<String>) controlHistorique.consulterListeRecherche();
		
	

		
		JList<String >liste = new JList<String>(listeInter);
		
		for(String recherche : listeRecherches) {
			listeInter.addElement(recherche);
		}
		
		liste.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		liste.setLayoutOrientation(JList.VERTICAL);
		liste.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		
		JScrollPane listScroller = new JScrollPane(liste); 
		listScroller.setPreferredSize(new Dimension(600,400));
		
		JButton validation = new JButton();
		validation.setText("Confirmer");
		validation.setFont(new Font("Calibri", Font.BOLD, 25));
		boxValidation.add(validation);
				
	
		boxMiseEnPage.add(boxRecherches);
		this.add(boxMiseEnPage);
		this.add(listScroller);
		this.add(boxValidation);
		
		validation.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(liste.getSelectedIndex());
				System.out.println((String) (controlHistorique.consulterHistoriqueRecherche(liste.getSelectedIndex())).get(0));
				afficherResultat((String) (controlHistorique.consulterHistoriqueRecherche(liste.getSelectedIndex())).get(0));
				
			}

		
			
		});
		
			
		
	}
	
	/**
	 * Update liste historique.
	 */
	public void updateListeHistorique() {
		controlHistorique.clearBDHistorique();
		controlHistorique.FillBDHistorique(profil);
		ArrayList<String> listeRecherches = (ArrayList<String>) controlHistorique.consulterListeRecherche();
		listeInter.clear();
		for(String recherche : listeRecherches) {
			listeInter.addElement(recherche);
		}
	}
	
	/**
	 * Afficher resultat.
	 *
	 * @param resultat the resultat
	 */
	private void afficherResultat(String resultat) {
		/*//cartes.show(panContents, "RESULTAT RECHERCHE");
		
		JFrame resultat = new JFrame();
		System.out.println("test");
		
		Box boxMiseEnPage = Box.createHorizontalBox();
		Box boxResultat = Box.createHorizontalBox();
		Box boxRetour = Box.createHorizontalBox();
		Box boxTexte = Box.createHorizontalBox();

	

		JLabel ecranTitre = new JLabel("Affichage de l'historique correspondant � : " + profil.getIdentifiant());
		ecranTitre.setFont(new Font("Calibri", Font.BOLD, 10));
		//boxMiseEnPage.add(ecranTitre);
		
		Box boxAffichageTypeRecherche = Box.createHorizontalBox();
		Box boxAffichageDateRecherche = Box.createHorizontalBox();
		
		JLabel typeRecherche  = new JLabel("default type");
		boxMiseEnPage.add(typeRecherche);
		JLabel dateRecherche = new JLabel("default date");
		boxMiseEnPage.add(dateRecherche);
		
		
		JTextArea textArea = new JTextArea();
		for(String a : liste){
			   textArea.append(a + "\n\n");
			}
        textArea.setBounds(10, 10, 200, 200);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        boxTexte.add(textArea);
        boxTexte.setBounds(0, 0, 200, 200);

		resultat.add(boxMiseEnPage);
		//resultat.add(boxTexte);
		
		resultat.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsListener(){
 
          
			@Override
			public void ancestorMoved(HierarchyEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println(arg0);
			}
			@Override
			public void ancestorResized(HierarchyEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println(arg0);
				int x = resultat.getWidth() - 100;
				int y = resultat.getHeight() - 100;
				//System.out.println("x : " + x + ",y : " + y);
				//textArea.setBounds(10,10,x,y);
				
				}           
        });
		
		//resultat.setSize(400, 400);		
		
		Point location = this.getLocation();
		if((location.getX() + 700) < 1500)
			location.translate(700, 0);
		else
			location.translate(0, 600);
		resultat.setLocation(location);
		resultat.setTitle("Resultat recherche");
		resultat.setVisible(true);
		*/
		
		ControlRequeteRecherche requete = new ControlRequeteRecherche(resultat);
		PopupHistorique affichage = new PopupHistorique(requete);
		affichage.setVisible(true);
		
		
	}

	
	
}
