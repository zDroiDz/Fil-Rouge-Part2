package vueGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import control.ControlHistorique;
import control.ControlProfil;
import control.ControlRechercher;
import control.ControlRequeteRecherche;
import model.DescripteurImage;

// TODO: Auto-generated Javadoc
/**
 * The Class PanRechercheCouleurDominante.
 */
public class PanRechercheCouleurDominante extends JPanel {

	/** The control profil. */
	private ControlProfil controlProfil;
	
	/** The control historique. */
	private ControlHistorique controlHistorique ;
	
	/** The control rechercher. */
	private ControlRechercher controlRechercher;
	
	/** The police titre. */
	private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	
	/** The police paragraphe. */
	private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);

	/** The pan top. */
	// jpanels de mise en page GLOBALE
	private JPanel panTop = new JPanel();
	
	/** The pan left. */
	private JPanel panLeft = new JPanel();
	
	/** The pan center. */
	private JPanel panCenter = new JPanel();
	// fin

	/** The title. */
	// composants du panTop
	private JLabel title = new JLabel("Recherche par couleur dominante");
	
	/** The title left. */
	private JLabel titleLeft = new JLabel("Paramétrisation");
	
	/** The title midle. */
	private JLabel titleMidle = new JLabel("Resultats");
	
	/** The title right. */
	private JLabel titleRight = new JLabel("Visualisations");
	// fin

	// composants du panLeft

	/** The label choix couleur. */
	private JLabel labelChoixCouleur = new JLabel("choix de la composante :");
	
	/** The jradio R. */
	private JRadioButton jradioR = new JRadioButton("Red");
	
	/** The jradio G. */
	private JRadioButton jradioG = new JRadioButton("Green");
	
	/** The jradio B. */
	private JRadioButton jradioB = new JRadioButton("Blue");

	/** The group. */
	private ButtonGroup group = new ButtonGroup();

	/** The boite verticale gauche. */
	private Box boiteVerticaleGauche = Box.createVerticalBox();
	
	/** The box texte composante. */
	private Box boxTexteComposante = Box.createHorizontalBox();
	
	/** The box choix composante. */
	private Box boxChoixComposante = Box.createHorizontalBox();
	
	/** The boxtitleleft. */
	private Box boxtitleleft = Box.createHorizontalBox();

	/** The label choix seuil. */
	private JLabel labelChoixSeuil = new JLabel("choix du seuil");
	
	/** The choix seuil. */
	private JSlider choixSeuil = new JSlider(0, 100, 0);
	
	/** The box texte seuil. */
	private Box boxTexteSeuil = Box.createHorizontalBox();
	
	/** The box choix seuil. */
	private Box boxChoixSeuil = Box.createHorizontalBox();
	
	/** The boutton lancer recherche. */
	private JButton bouttonLancerRecherche = new JButton("lancer recherche");
	
	/** The message erreur. */
	private JLabel messageErreur = new JLabel("veuillez sélectionner une composante");

	// fin

	// composants du panCenter

	/** The pan center left. */
	private JPanel panCenterLeft = new JPanel();
	
	/** The pan center right. */
	private JPanel panCenterRight = new JPanel();
	
	/** The pan center bottom. */
	private JPanel panCenterBottom = new JPanel();

	/** The label texte resultat. */
	private JLabel labelTexteResultat = new JLabel("Résultats de la recherche :");

	/** The combo box. */
	private JComboBox<String> comboBox = new JComboBox<>();

	/** The bouttonvisualiser image. */
	private JButton bouttonvisualiserImage = new JButton("Visualiser");
	
	/** The effacer recherche. */
	private JButton effacerRecherche = new JButton("Effacer Recherche");

	/** The box resultats. */
	private Box boxResultats = Box.createVerticalBox();
	
	/** The box visualisation. */
	private Box boxVisualisation = Box.createVerticalBox();

	/** The label texte average. */
	private JLabel labelTexteAverage = new JLabel("Aperçu de la couleur moyenne :");
	
	/** The label texte image. */
	private JLabel labelTexteImage = new JLabel("Aperçu de l'image :");

	/** The average label color. */
	private JLabel averageLabelColor = new JLabel(
			"         \n         \n          \n         \n          \n         \n         \n         \n");

	/** The visualisation image. */
	private JLabel visualisationImage = new JLabel();

	// fin

	/** The espacement 1. */
	// mise en page (obligé de faire ici sinon les new décalent l'initialisation
	private Component espacement1 = Box.createRigidArea(new Dimension(0, 30));
	
	/** The espacement 2. */
	private Component espacement2 = Box.createRigidArea(new Dimension(0, 30));
	
	/** The espacement 3. */
	private Component espacement3 = Box.createRigidArea(new Dimension(0, 30));

	/** The espacement 4. */
	private Component espacement4 = Box.createRigidArea(new Dimension(0, 50));
	
	/** The espacement 5. */
	private Component espacement5 = Box.createRigidArea(new Dimension(0, 50));
	
	/** The espacement 6. */
	private Component espacement6 = Box.createRigidArea(new Dimension(0, 50));
	//

	/** The tableau resultats. */
	// tableau des résultats
	private DescripteurImage[] tableauResultats;
	//

	/**
	 * Instantiates a new pan recherche couleur dominante.
	 *
	 * @param controlHistorique the control historique
	 * @param controlProfil the control profil
	 * @param controlRechercher the control rechercher
	 */
	public PanRechercheCouleurDominante(ControlHistorique controlHistorique, ControlProfil controlProfil, ControlRechercher controlRechercher) {

		this.controlHistorique = controlHistorique;
		this.controlProfil= controlProfil ;
		this.controlRechercher = controlRechercher ;
		
		this.setLayout(new BorderLayout());
		panCenter.setLayout(new BorderLayout());
		this.setVisible(true);
	}

	/**
	 * Initialisation.
	 */
	public void initialisation() {
		// TODO Auto-generated method stub


		// partie gauche

		group.add(jradioR);
		group.add(jradioG);
		group.add(jradioB);

		boxChoixComposante.add(jradioR);
		boxChoixComposante.add(jradioG);
		boxChoixComposante.add(jradioB);

		labelChoixCouleur.setFont(policeParagraphe);
		boxTexteComposante.add(labelChoixCouleur);

		labelChoixSeuil.setFont(policeParagraphe);
		boxTexteSeuil.add(labelChoixSeuil);
		boxChoixSeuil.add(choixSeuil);

		choixSeuil.setMinorTickSpacing(2);
		choixSeuil.setMajorTickSpacing(10);
		choixSeuil.setPaintTicks(true);
		choixSeuil.setPaintLabels(true);

		messageErreur.setFont(policeTitre);
		messageErreur.setForeground(new Color(255, 0, 0));
		messageErreur.setVisible(false);

		bouttonLancerRecherche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jradioB.isSelected() || jradioG.isSelected() || jradioR.isSelected()) {
					comboBox.removeAllItems();
					panCenter.setVisible(true);
					panCenterRight.setVisible(false);
					panCenterLeft.setVisible(true);
					messageErreur.setVisible(false);
					
					String couleurRecherche = "" ;
					
					DescripteurImage[] desc = null;
					if (jradioB.isSelected()) {
						desc = controlRechercher.rechercheCouleur("B", choixSeuil.getValue());
						couleurRecherche = "Bleu";
					} else if (jradioR.isSelected()) {
						desc = controlRechercher.rechercheCouleur("R", choixSeuil.getValue());
						couleurRecherche = "Rouge";
					} else if (jradioG.isSelected()) {
						desc = controlRechercher.rechercheCouleur("G", choixSeuil.getValue());
						couleurRecherche = "Vert";
					}
					tableauResultats = desc;
					
					Map<String, String> resultatHistoriqueCouleur = new HashMap<>();
					
					for (int i = 0; i < desc.length; i++) {
						comboBox.addItem(desc[i].getNomFichier());
						resultatHistoriqueCouleur.put(desc[i].getNomFichier(),desc[i].getPath());
					}
					
					if(FrameClient.profil.isHistorique()) {
						ControlRequeteRecherche requeteCouleur = new ControlRequeteRecherche(couleurRecherche + " "+ choixSeuil.getValue() +" %", FrameClient.profil.getIdentifiant(), "Recherche couleur", resultatHistoriqueCouleur);
						controlProfil.addHistoricContent(FrameClient.profil,requeteCouleur.getStockageBD());
						controlHistorique.FillBDHistorique(FrameClient.profil);
					}

					if (desc.length == 0) {
						bouttonvisualiserImage.setVisible(false);
					} else {
						bouttonvisualiserImage.setVisible(true);
					}
				} else {
					messageErreur.setVisible(true);
				}

			}
		});

		titleLeft.setFont(policeTitre);
		boxtitleleft.add(titleLeft);
		boiteVerticaleGauche.add(titleLeft);
		boiteVerticaleGauche.add(titleLeft);
		boiteVerticaleGauche.add(espacement1);
		boiteVerticaleGauche.add(boxTexteComposante);
		boiteVerticaleGauche.add(boxChoixComposante);
		boiteVerticaleGauche.add(espacement2);
		boiteVerticaleGauche.add(boxTexteSeuil);
		boiteVerticaleGauche.add(boxChoixSeuil);
		boiteVerticaleGauche.add(espacement3);
		boiteVerticaleGauche.add(bouttonLancerRecherche);
		boiteVerticaleGauche.add(messageErreur);

		title.setFont(policeTitre);

		bouttonvisualiserImage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panCenterRight.setVisible(true);
				System.out.println(comboBox.getSelectedItem());
				System.out.println(comboBox.getSelectedIndex());

				BufferedImage myPicture;
				try {
					myPicture = ImageIO.read(new File(tableauResultats[comboBox.getSelectedIndex()].getPath()));
					visualisationImage.setIcon(new ImageIcon(myPicture));
					averageLabelColor.setOpaque(true);
					averageLabelColor
							.setBackground(new Color(tableauResultats[comboBox.getSelectedIndex()].getComposante(0),
									tableauResultats[comboBox.getSelectedIndex()].getComposante(1),
									tableauResultats[comboBox.getSelectedIndex()].getComposante(2)));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		titleMidle.setFont(policeTitre);
		boxResultats.add(titleMidle);
		labelTexteResultat.setFont(policeParagraphe);
		boxResultats.add(labelTexteResultat);
		boxResultats.add(comboBox);
		boxResultats.add(espacement4);
		boxResultats.add(bouttonvisualiserImage);

		labelTexteAverage.setFont(policeParagraphe);

		titleRight.setFont(policeTitre);
		boxVisualisation.add(titleRight);

		averageLabelColor.setMinimumSize(new Dimension(100, 100));

		boxVisualisation.add(labelTexteAverage);
		boxVisualisation.add(averageLabelColor);
		boxVisualisation.add(espacement5);
		labelTexteImage.setFont(policeParagraphe);
		boxVisualisation.add(labelTexteImage);
		boxVisualisation.add(visualisationImage);

		effacerRecherche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panCenter.setVisible(false);
			}
		});
		panCenterBottom.add(effacerRecherche);

		panTop.add(title);
		panLeft.add(boiteVerticaleGauche);
		panCenterRight.add(boxVisualisation);
		panCenterLeft.add(boxResultats);
		panCenter.add(panCenterLeft, BorderLayout.WEST);
		panCenter.add(panCenterRight, BorderLayout.CENTER);
		panCenter.add(panCenterBottom, BorderLayout.SOUTH);

		this.add(panTop, BorderLayout.NORTH);
		this.add(panCenter, BorderLayout.CENTER);
		this.add(panLeft, BorderLayout.WEST);

		panCenter.setVisible(false);
		this.repaint();
	}

}