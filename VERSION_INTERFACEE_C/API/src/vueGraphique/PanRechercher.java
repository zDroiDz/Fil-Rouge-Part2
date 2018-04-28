package vueGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;*/

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControlHistorique;
import control.ControlIndexationC;
import control.ControlIndexationImage;
import control.ControlProfil;
import control.ControlRechercher;
import control.ControlRequeteRecherche;
import model.DescripteurImage;
import model.DescripteurTexte;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JList;

// TODO: Auto-generated Javadoc
/**
 * The Class PanRechercher.
 */
public class PanRechercher extends JPanel {

	/** The panel. */
	//private JPanel this;
	private JPanel panel;
	
	/** The button radion. */
	private JPanel buttonRadion ;
	
	/** The search images. */
	private JPanel searchImages;
	
	/** The panel fichier searcher. */
	private JPanel panelFichierSearcher;

/** The text field. */
//JtextFields
	private JTextField textField;
	
	/** The stocker chemin. */
	private JTextField stockerChemin;
	 
 	/** The button rechercher. */
 	/*Boutton Uttilis� */
	private JButton buttonRechercher;
	
	/** The open button. */
	private JButton openButton;
   
   /** The search button. */
   /*Image Import� pour rechercher */
	private ImageIcon searchButton ;
	
	/** The box mise enpage button radion. */
	//les box utilis�es pour l'organisation
	Box boxMiseEnpageButtonRadion =Box.createVerticalBox();
	
	/** The box mise enpage text seuil. */
	Box boxMiseEnpageTextSeuil =Box.createHorizontalBox();
	
	/** The box mise enpage file search. */
	Box boxMiseEnpageFileSearch =Box.createHorizontalBox();
	
	/** The sliders image. */
	Box slidersImage = Box.createVerticalBox();
    
    /** The choix type recherche. */
    private JComboBox choixTypeRecherche ;
    
    /** The group. */
    private ButtonGroup group;
    
    /** The spinner. */
    private  JSpinner spinner;
    
    /** The panel texte seuil. */
    private JPanel panelTexteSeuil;
    
    /** The fc. */
    /*importer un fichier pour lancer la recherche */
    JFileChooser fc;
    
    /** The list. */
    private JList<String> list;
    
    /** The son. */
    JRadioButton son = new JRadioButton("Son");
	
	/** The image. */
	JRadioButton image= new JRadioButton("image");
	
	/** The text. */
	JRadioButton text = new JRadioButton("text");
	
	/** The choix couleur vert. */
	JSlider choixCouleurVert =new JSlider(0,100,0);
    
    /** The choix couleur bleu. */
    JSlider choixCouleurBleu =new JSlider(0,100,0);
    
    /** The choix couleur rouge. */
    JSlider choixCouleurRouge =new JSlider(0,100,0);

	
    /** The control indexation C. */
    ControlIndexationC controlIndexationC = new ControlIndexationC();
	
	/** The control historique. */
	private ControlHistorique controlHistorique = new ControlHistorique();
	
	/** The control profil. */
	private ControlProfil controlProfil = new ControlProfil();
    
    /** The control rechercher. */
    ControlRechercher controlRechercher = new ControlRechercher(controlHistorique, controlProfil);
    
    /** The list model. */
    DefaultListModel<String> listModel = new DefaultListModel<>();
    
    /** The control indexation image. */
    ControlIndexationImage controlIndexationImage = new ControlIndexationImage();
    
    /**
     * Instantiates a new pan rechercher.
     */
    public PanRechercher(){
  
   }
   
   /**
    * Initialisation.
    */
   public void initialisation(){
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		fc = new JFileChooser();
		searchButton = new ImageIcon("1.png");
	    choixTypeRecherche = new JComboBox();
	    buttonRechercher = new JButton();
	    openButton=new JButton();
	    buttonRadion = new JPanel();
	    panelTexteSeuil = new JPanel();
	    panelFichierSearcher=new JPanel();
	   searchImages=new JPanel();
		group = new ButtonGroup();
		textField = new JTextField();
		spinner = new JSpinner();
		buttonRadion.setVisible(false);
		 panelFichierSearcher.setVisible(false);
		 panelTexteSeuil.setVisible(true);
		 searchImages.setVisible(false);
	    	
    
  }
  	
	  /**
	   * Lancer recherche.
	   */
	  public void lancerRecherche(){
  		
  		
		
	    
		
		choixTypeRecherche.setBounds(35, 36, 92, 20);
		choixTypeRecherche.addItem("motsCles");
		choixTypeRecherche.addItem("RechercheParFichier");
		choixTypeRecherche.addItem("ImageParCurseur");
		this.add(choixTypeRecherche);
	
	
	  
		buttonRechercher.setIcon(searchButton);

		buttonRechercher.setBounds(357, 36, 29, 20);
		this.add(buttonRechercher);
	
		buttonRadion.setBounds(35, 67, 92, 155);
		this.add(buttonRadion);
		buttonRadion.setLayout(new BoxLayout(buttonRadion, BoxLayout.X_AXIS));
		
		group.add(text);
		group.add(son);
		group.add(image);
		
		boxMiseEnpageButtonRadion.add(text);
		boxMiseEnpageButtonRadion.add(son);
		boxMiseEnpageButtonRadion.add(image);
		buttonRadion.add(boxMiseEnpageButtonRadion);
		
		panelTexteSeuil.setBounds(143, 30, 204, 62);
	
		boxMiseEnpageTextSeuil.createRigidArea(new Dimension(50,0));
	
		panelFichierSearcher.setBounds(143, 30, 204, 30);
		boxMiseEnpageFileSearch.createRigidArea(new Dimension(50,0));  	
		textField.setColumns(10);
		boxMiseEnpageTextSeuil.add(textField);
		boxMiseEnpageTextSeuil.add(spinner);
		panelTexteSeuil.add(boxMiseEnpageTextSeuil);
		
		openButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 if (e.getSource() == openButton) {
			            int returnVal = fc.showOpenDialog(PanRechercher.this);

			            if (returnVal == JFileChooser.APPROVE_OPTION) {
			                File file = fc.getSelectedFile();
			                stockerChemin.setText(file.getAbsolutePath());
			          
			                 
			            } else {
			                
			            }
			            
			    }
				
			}
		});
	    
		this.add(panelTexteSeuil);
		
		
		
		buttonRadion.setVisible(false);
		
		
		
		panelFichierSearcher.setBounds(143, 30, 204, 30);
        
        stockerChemin=new JTextField();
        stockerChemin.setColumns(10);
        boxMiseEnpageFileSearch.add(stockerChemin);
        boxMiseEnpageFileSearch.add(openButton);
        panelFichierSearcher.add(boxMiseEnpageFileSearch);
    
        this.add(panelFichierSearcher);
        
        searchImages.setBounds(143, 30, 204, 150);
        choixCouleurRouge.setMinorTickSpacing(2);  
        choixCouleurRouge.setMajorTickSpacing(20);  
        choixCouleurRouge.setPaintTicks(true);  
        choixCouleurRouge.setPaintLabels(true);  
        slidersImage.add(choixCouleurRouge);
        
        slidersImage.createRigidArea(new Dimension (20,0));
        choixCouleurBleu.setMinorTickSpacing(2);  
        choixCouleurBleu.setMajorTickSpacing(20);  
        choixCouleurBleu.setPaintTicks(true);  
        choixCouleurBleu.setPaintLabels(true);
        slidersImage.add(choixCouleurBleu);
        slidersImage.createRigidArea(new Dimension (20,0));
       // choixCouleurPourcentage.setLabelTable(choixCouleurPourcentage.createStandardLabels(10));
        choixCouleurVert.setMinorTickSpacing(2);  
        choixCouleurVert.setMajorTickSpacing(20);  
        choixCouleurVert.setPaintTicks(true);  
        choixCouleurVert.setPaintLabels(true);
        slidersImage.add(choixCouleurVert);
        slidersImage.createRigidArea(new Dimension (20,0));
        
        
        searchImages.add(slidersImage);
        
        this.add(searchImages);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(156, 228, 212, 154);
        add(scrollPane);
        
        
       
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);
      
      
        list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				 /*if(!e.getValueIsAdjusting()) {
			            final ArrayList<String> selectedValuesList = (ArrayList<String>) list.getSelectedValuesList();
			            System.out.println(selectedValuesList);
			        }*/
				System.out.println(list.getSelectedValue());
				
			}
		});
        
       
        
        
        choixTypeRecherche.addActionListener(new ActionListener() {
			
        	
			public void actionPerformed(ActionEvent arg0) {
				int numeroChoix=choixTypeRecherche.getSelectedIndex();
				if(numeroChoix == 0){
					// System.out.println(numeroChoix);
					 buttonRadion.setVisible(false);
					 panelTexteSeuil.setVisible(true);
					 panelFichierSearcher.setVisible(false);
					 searchImages.setVisible(false);
					   
				    
				}
				
				else if(numeroChoix ==1){
			        slidersImage.createRigidArea(new Dimension (20,0));
			        // choixCouleurPourcentage.setLabelTable(choixCouleurPourcentage.createStandardLabels(10));
			         
			         choixCouleurVert.setMinorTickSpacing(2);  
			         choixCouleurVert.setMajorTickSpacing(20);  
			         choixCouleurVert.setPaintTicks(true);  
			         choixCouleurVert.setPaintLabels(true);
			         slidersImage.add(choixCouleurVert);
			         slidersImage.createRigidArea(new Dimension (20,0));
			         
			         
			         searchImages.add(slidersImage);
			         
					// System.out.println(numeroChoix);
					 buttonRadion.setVisible(true);
					 panelFichierSearcher.setVisible(true);
					 panelTexteSeuil.setVisible(false);
					 searchImages.setVisible(false);
					
				}
				
				else if(numeroChoix ==2){
					 buttonRadion.setVisible(false);
					 panelFichierSearcher.setVisible(false);
					 panelTexteSeuil.setVisible(false);
					 searchImages.setVisible(true);
				}
			}
		});
        
        
        setUpButtonRechercher();
	   
      this.setVisible(true);
        
	
	}
	
	/**
	 * Sets the up button rechercher.
	 */
	public void setUpButtonRechercher(){
		
		
		buttonRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(choixTypeRecherche.getSelectedIndex());
				switch(choixTypeRecherche.getSelectedIndex()){
					case 0 :
						java.util.List<DescripteurTexte> resultatMotCle = controlRechercher.lancerRechercheMotCle((String)textField.getText(), (int)spinner.getValue(), FrameClient.profil);
						System.out.println((int)spinner.getValue());
						Map<String, String> resultatHistoriqueMotCle = new HashMap<>();
						
						listModel.clear();
						for(DescripteurTexte d : resultatMotCle){
							listModel.addElement(d.getNomFichier());
							resultatHistoriqueMotCle.put(d.getNomFichier(), d.getPath());
						}
						//ajout historique
						ControlRequeteRecherche requeteMotCle = new ControlRequeteRecherche(textField.getText(), FrameClient.profil.getIdentifiant(), "Mot cle", resultatHistoriqueMotCle);
						controlProfil.addHistoricContent(FrameClient.profil,requeteMotCle.getStockageBD());
						controlHistorique.FillBDHistorique(FrameClient.profil);
						
						break;
					case 1 : 
						if(son.isSelected()) {
							String resultatSon = controlIndexationC.compareSons(stockerChemin.getText());
							System.out.println(resultatSon);
						}else if(image.isSelected()){

							DescripteurImage temp = controlIndexationImage.indexImage(stockerChemin.getText());
							DescripteurImage[] resultatImage = controlRechercher.compareDescripteurImage(temp,0);
							listModel.clear();
							
							Map<String, String> resultatHistoriqueImage = new HashMap<>();
							
							for(int i = 0 ; i < resultatImage.length ; i++) {
								listModel.addElement(resultatImage[i].getNomFichier());
								resultatHistoriqueImage.put(resultatImage[i].getNomFichier(), resultatImage[i].getPath());
							}
							//ajout historique
							String[] separation = stockerChemin.getText().split("/");
							String nom = separation[separation.length-1];
							ControlRequeteRecherche requeteImage = new ControlRequeteRecherche(nom, FrameClient.profil.getIdentifiant(), "Image fichier", resultatHistoriqueImage);
							controlProfil.addHistoricContent(FrameClient.profil,requeteImage.getStockageBD());
							controlHistorique.FillBDHistorique(FrameClient.profil);
							
						}else if(text.isSelected()){
							java.util.List <DescripteurTexte> resultatTexte = controlIndexationC.compareTextes(stockerChemin.getText(), 0);
							listModel.clear();
							
							Map<String, String> resultatHistoriqueTexte = new HashMap<>();
							
							for(DescripteurTexte d : resultatTexte) {
								listModel.addElement(d.getNomFichier());
								resultatHistoriqueTexte.put(d.getNomFichier(), d.getPath());
							}
							//ajout historique
							String[] separation = stockerChemin.getText().split("/");
							String nom = separation[separation.length-1];
							ControlRequeteRecherche requeteTexte = new ControlRequeteRecherche(nom, FrameClient.profil.getIdentifiant(), "Texte fichier", resultatHistoriqueTexte);
							controlProfil.addHistoricContent(FrameClient.profil,requeteTexte.getStockageBD());
							controlHistorique.FillBDHistorique(FrameClient.profil);
						}
						break;
					case 2 : 
						int pourcentBleu = choixCouleurBleu.getValue();
						int pourcentVert = choixCouleurVert.getValue();
						int pourcentRouge = choixCouleurRouge.getValue();
						
						String couleurRecherche ="" ;
						int valeurRecherche = Math.max(pourcentBleu,Math.max(pourcentVert,pourcentRouge));
						
						if(valeurRecherche == pourcentBleu) {
							couleurRecherche = "B" ;
						}else if(valeurRecherche == pourcentVert) {
							couleurRecherche = "G";
						}else {
							couleurRecherche = "R";
						}
						
						System.out.println(couleurRecherche +"  " + valeurRecherche);
						DescripteurImage[] resultatCouleur = controlRechercher.rechercheCouleur(couleurRecherche, valeurRecherche);
						
						listModel.clear();
						
						Map<String, String> resultatHistoriqueCouleur = new HashMap<>();

						for(int i = 0 ; i < resultatCouleur.length ; i++) {
							listModel.addElement(resultatCouleur[i].getNomFichier());
							resultatHistoriqueCouleur.put(resultatCouleur[i].getNomFichier(), resultatCouleur[i].getPath());

						}
						ControlRequeteRecherche requeteCouleur = new ControlRequeteRecherche(couleurRecherche + " "+ valeurRecherche +" %", FrameClient.profil.getIdentifiant(), "Recherche couleur", resultatHistoriqueCouleur);
						controlProfil.addHistoricContent(FrameClient.profil,requeteCouleur.getStockageBD());
						controlHistorique.FillBDHistorique(FrameClient.profil);
						
						break ;
				}
					
				
			}
		});
		
	}
	
	
	
}