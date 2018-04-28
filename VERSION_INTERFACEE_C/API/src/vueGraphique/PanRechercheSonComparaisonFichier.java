package vueGraphique;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControlFiles;
import control.ControlHistorique;
import control.ControlIndexationC;
import control.ControlProfil;
import control.ControlRequeteRecherche;
import model.DescripteurTexte;

import javax.swing.JFileChooser;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class PanRechercheSonComparaisonFichier.
 */
public class PanRechercheSonComparaisonFichier extends JPanel {
	
	/** The text field path. */
	private JTextField textFieldPath = new JTextField();
	
	/** The lbl F ichier texte. */
	JLabel lblFIchierTexte = new JLabel("Recherche fichier : Son");
	
	/** The lbl nom du fichier. */
	private final JLabel lblNomDuFichier = new JLabel("Nom du fichier");
	
	/** The lbl rsultats. */
	JLabel lblRsultats = new JLabel("Résultats");
	
	/** The control indexation C. */
	ControlIndexationC controlIndexationC;
    
    /** The control profil. */
    ControlProfil controlProfil;
    
    /** The control historique. */
    ControlHistorique controlHistorique;
	
	/** The control files. */
	ControlFiles controlFiles ;
	
	/** The resultat historique son. */
	Map<String, String> resultatHistoriqueSon = new HashMap<>();
	
	/** The text area resultats. */
	JTextArea textAreaResultats = new JTextArea();
	
	/** The model. */
	DefaultListModel<String> model = new DefaultListModel<>();
	
	/** The list. */
	JList<String> list = new JList(model);
    
    /** The j scroll pane. */
    JScrollPane jScrollPane = new JScrollPane(list);

	
	/**
	 * Instantiates a new pan recherche son comparaison fichier.
	 *
	 * @param controlIndexationC the control indexation C
	 * @param controlProfil the control profil
	 * @param controlHistorique the control historique
	 * @param controlFiles the control files
	 */
	public PanRechercheSonComparaisonFichier(ControlIndexationC controlIndexationC, ControlProfil controlProfil, ControlHistorique controlHistorique, ControlFiles controlFiles) {
		
		this.controlIndexationC = controlIndexationC ;
		this.controlProfil = controlProfil;
		this.controlHistorique = controlHistorique ;
		this.controlFiles = controlFiles ;
		
		
		setLayout(null);
		lblFIchierTexte.setFont(new Font("Dialog", Font.BOLD, 20));
		
		lblFIchierTexte.setBounds(251, 46, 373, 15);
		add(lblFIchierTexte);
		
		
		textFieldPath.setBounds(251, 160, 218, 19);
		textFieldPath.setEditable(false);
		add(textFieldPath);
		textFieldPath.setColumns(10);
		
		lblNomDuFichier.setBounds(251, 134, 123, 15);
		
		add(lblNomDuFichier);
		
		
		lblRsultats.setBounds(251, 216, 70, 15);
		add(lblRsultats);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(571, 157, 117, 25);
		
		btnRechercher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String resultatSon = controlIndexationC.compareSons(textFieldPath.getText());
				textAreaResultats.setText(resultatSon);
				
				model.clear();
				
				resultatHistoriqueSon.clear();
				
				resultatHistoriqueSon.put("Corpus_fi.bin", "../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/TEST_SON/corpus_fi.wav");
				
				model.addElement("corpus_fi.wav");		

				
				if(FrameClient.profil.isHistorique()) {
					//ajout historique
					String[] separation = textFieldPath.getText().split("/");
					String nom = separation[separation.length-1];
					ControlRequeteRecherche requeteSon = new ControlRequeteRecherche(nom, FrameClient.profil.getIdentifiant(), "Son fichier", resultatHistoriqueSon);
					controlProfil.addHistoricContent(FrameClient.profil,requeteSon.getStockageBD());
					controlHistorique.FillBDHistorique(FrameClient.profil);
				}
			}
			
		});
		
		add(btnRechercher);
		
				
		JButton btnFileChooser = new JButton("......");
		
		btnFileChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String chemin = controlFiles.recupBinFile();
				textFieldPath.setText(chemin);
			}
			
		});
				
		btnFileChooser.setBounds(498, 158, 50, 22);
		add(btnFileChooser);
		
	
		
		textAreaResultats.setBounds(87, 278, 692, 200);
		add(textAreaResultats);
		
		
		jScrollPane.setBounds(350, 500, 218, 19);
		add(jScrollPane);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				Process p;
		        try {
		        	//System.out.println("gedit "+ resultatHistoriqueMotCle.get(list.getSelectedValue()));
		        	   Process proc = Runtime.getRuntime().exec("totem ../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/TEST_SON/corpus_fi.wav");                        
		        	   proc.waitFor();
		        } catch (Exception excpt) {
		        	excpt.printStackTrace();
		        }
			}
			

		});
		
	 
	}
}
