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
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import control.ControlFiles;
import control.ControlHistorique;
import control.ControlIndexationImage;
import control.ControlProfil;
import control.ControlRechercher;
import control.ControlRequeteRecherche;
import model.DescripteurImage;

// TODO: Auto-generated Javadoc
/**
 * The Class PanRechercheComparaisonImage.
 */
public class PanRechercheComparaisonImage extends JPanel{

	/** The control profil. */
	private ControlProfil controlProfil ;
	
	/** The control historique. */
	private ControlHistorique controlHistorique;
	
	/** The control rechercher. */
	private ControlRechercher controlRechercher;
	
	/** The control files. */
	private ControlFiles controlFiles;
	
	/** The control indexation image. */
	private ControlIndexationImage controlIndexationImage;
	
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
	private JLabel titleMidle = new JLabel("Résultats");
	
	/** The title right. */
	private JLabel titleRight = new JLabel("Visualisations");
	
	/** The title img donne. */
	private JLabel titleImgDonne=new JLabel("Votre Image");
	// fin

	// composants du panLeft

	/** The label choix fichier. */
	private JLabel labelChoixFichier = new JLabel("veuillez choisir un fichier :");
	
	/** The textfield path fichier. */
	private JTextField textfieldPathFichier= new JTextField();
	
	/** The boutton choix fichier. */
	private JButton bouttonChoixFichier=new JButton("sélectionner");
	
	

	/** The boite verticale gauche. */
	private Box boiteVerticaleGauche = Box.createVerticalBox();
	
	/** The box texte composante. */
	private Box boxTexteComposante = Box.createHorizontalBox();
	
	/** The box choix fichier. */
	private Box boxChoixFichier = Box.createHorizontalBox();
	
	/** The boxtitleleft. */
	private Box boxtitleleft = Box.createHorizontalBox();

	/** The label choix seuil. */
	private JLabel labelChoixSeuil = new JLabel("Ecart de ressemblance maximal (%)");
	
	/** The choix seuil. */
	private JSlider choixSeuil = new JSlider(0, 100, 0);
	
	/** The box texte seuil. */
	private Box boxTexteSeuil = Box.createHorizontalBox();
	
	/** The box choix seuil. */
	private Box boxChoixSeuil = Box.createHorizontalBox();
	
	/** The boutton lancer recherche. */
	private JButton bouttonLancerRecherche = new JButton("lancer recherche");
	
	/** The message erreur. */
	private JLabel messageErreur = new JLabel("veuillez sélectionner un fichier");

	// fin

	// composants du panCenter

	/** The pan center left. */
	private JPanel panCenterLeft = new JPanel();
	
	/** The pan center center. */
	private JPanel panCenterCenter=new JPanel();
	
	/** The pan center right. */
	private JPanel panCenterRight = new JPanel();
	
	/** The pan center bottom. */
	private JPanel panCenterBottom = new JPanel();
	
	
	/** The label texte image donnee. */
	private JLabel labelTexteImageDonnee=new JLabel("votre image :");
	
	/** The label texte average image donnee. */
	private JLabel labelTexteAverageImageDonnee=new JLabel("Aper�u de la couleur moyenne :");
	
	/** The average label color image donnee. */
	private JLabel averageLabelColorImageDonnee = new JLabel(
			"         \n         \n          \n         \n          \n         \n         \n         \n");

	/** The visualisation image donnee. */
	private JLabel visualisationImageDonnee = new JLabel();
	
	/** The box image donnee. */
	private Box boxImageDonnee=Box.createVerticalBox();

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
	// mise en page (oblig� de faire ici sinon les new d�calent l'initialisation
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
	// tableau des r�sultats
	private DescripteurImage[] tableauResultats;
	//

	/**
	 * Instantiates a new pan recherche comparaison image.
	 *
	 * @param controlProfil the control profil
	 * @param controlHistorique the control historique
	 * @param controlRechercher the control rechercher
	 * @param controlFiles the control files
	 * @param controlIndexationImage the control indexation image
	 */
	public PanRechercheComparaisonImage(ControlProfil controlProfil, ControlHistorique controlHistorique, ControlRechercher controlRechercher, ControlFiles controlFiles, ControlIndexationImage controlIndexationImage) {
		
		this.controlProfil = controlProfil ;
		this.controlHistorique = controlHistorique;
		
		this.controlRechercher = controlRechercher;
		this.controlFiles = controlFiles;
		this.controlIndexationImage = controlIndexationImage;

		this.setLayout(new BorderLayout());


		panCenter.setLayout(new BorderLayout());
		this.setVisible(true);
		
		bouttonChoixFichier.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String chemin=controlFiles.recupImgFile();
						textfieldPathFichier.setText(chemin);
					}
				});
	}

	/**
	 * Initialisation.
	 */
	public void initialisation() {
		// TODO Auto-generated method stub

		this.setMinimumSize(new Dimension(1000, 1000));
		// partie gauche

		labelChoixFichier.setFont(policeParagraphe);
		boxTexteComposante.add(labelChoixFichier);
		textfieldPathFichier.setText("");
		textfieldPathFichier.setEditable(false);
		boxChoixFichier.add(textfieldPathFichier);
		boxChoixFichier.add(bouttonChoixFichier);
		
		

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
				
				Map<String, String> resultatHistoriqueImage = new HashMap<>();

				
				if(textfieldPathFichier.getText().equals(""))
				{
					messageErreur.setVisible(true);
				}
				else
				{
					
					
					comboBox.removeAllItems();
					panCenter.setVisible(true);
					panCenterRight.setVisible(false);
					panCenterLeft.setVisible(true);
					messageErreur.setVisible(false);
					DescripteurImage ledescTemp=controlIndexationImage.indexImage(textfieldPathFichier.getText());
					
					BufferedImage myPicture;
					try {
						myPicture = ImageIO.read(new File(ledescTemp.getPath()));
						visualisationImageDonnee.setIcon(new ImageIcon(myPicture));
						averageLabelColorImageDonnee.setOpaque(true);
						averageLabelColorImageDonnee
								.setBackground(new Color(ledescTemp.getComposante(0),ledescTemp.getComposante(1),ledescTemp.getComposante(2)));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					DescripteurImage[] temp=controlRechercher.compareDescripteurImage(ledescTemp,choixSeuil.getValue());
					tableauResultats=new DescripteurImage[temp.length];
					int cpt=0;
					for(int i=0;i<temp.length;i++)
					{
						if(temp[i]!=null)
						{
							tableauResultats[cpt]=temp[i];
							cpt++;
						}
					}
					
					if(tableauResultats.length==0)
					{
						bouttonvisualiserImage.setVisible(false);
					}
					else
					{
						for (int i = 0; i < tableauResultats.length; i++) {
							if(tableauResultats[i]!=null)
							{
								comboBox.addItem(tableauResultats[i].getNomFichier());
								resultatHistoriqueImage.put(tableauResultats[i].getNomFichier(), tableauResultats[i].getPath());
							}							
						}
					}
					
						if(FrameClient.profil.isHistorique()) {
							//ajout historique
							String[] separation = textfieldPathFichier.getText().split("/");
							String nom = separation[separation.length-1];
							ControlRequeteRecherche requeteImage = new ControlRequeteRecherche(nom + " " + choixSeuil.getValue()+"%", FrameClient.profil.getIdentifiant(), "Image fichier", resultatHistoriqueImage);
							controlProfil.addHistoricContent(FrameClient.profil,requeteImage.getStockageBD());
							controlHistorique.FillBDHistorique(FrameClient.profil);
							//fin historique
						}
				}
				
				repaint();
				
			}
		});

		titleLeft.setFont(policeTitre);
		boxtitleleft.add(titleLeft);
		boiteVerticaleGauche.add(titleLeft);
		boiteVerticaleGauche.add(titleLeft);
		boiteVerticaleGauche.add(espacement1);
		boiteVerticaleGauche.add(boxTexteComposante);
		boiteVerticaleGauche.add(boxChoixFichier);
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
					System.out.println(tableauResultats[comboBox.getSelectedIndex()].getPath());
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
				
				repaint();
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
		
		titleImgDonne.setFont(policeTitre);
		
		boxImageDonnee.add(titleImgDonne);
		boxImageDonnee.add(labelTexteImageDonnee);
		boxImageDonnee.add(visualisationImageDonnee);
		boxImageDonnee.add(espacement6);
		boxImageDonnee.add(labelTexteAverageImageDonnee);
		boxImageDonnee.add(averageLabelColorImageDonnee);

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
		panCenterCenter.add(boxImageDonnee);
		panCenterRight.add(boxVisualisation);
		panCenterLeft.add(boxResultats);
		panCenter.add(panCenterLeft, BorderLayout.CENTER);
		panCenter.add(panCenterCenter, BorderLayout.WEST);
		panCenter.add(panCenterRight, BorderLayout.EAST);
		panCenter.add(panCenterBottom, BorderLayout.SOUTH);

		this.add(panTop, BorderLayout.NORTH);
		this.add(panCenter, BorderLayout.CENTER);
		this.add(panLeft, BorderLayout.WEST);

		panCenter.setVisible(false);
		this.repaint();
	}

}