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

// TODO: Auto-generated Javadoc
/**
 * The Class PanRechercheTexteComparaisonFichier.
 */
public class PanRechercheTexteComparaisonFichier extends JPanel {
	
	/** The spinner model. */
	SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 1000, 1);
	
	/** The spinner. */
	JSpinner spinner = new JSpinner(spinnerModel);
	
	/** The text field path. */
	private JTextField textFieldPath = new JTextField();
	
	/** The model. */
	DefaultListModel<String> model = new DefaultListModel<>();
	
	/** The list. */
	JList<String> list = new JList(model);
	
	/** The lbl F ichier texte. */
	JLabel lblFIchierTexte = new JLabel("Recherche fichier : Textes");
	
	/** The lbl nom du fichier. */
	private final JLabel lblNomDuFichier = new JLabel("Nom du fichier");
	
	/** The j scroll pane. */
	JScrollPane jScrollPane = new JScrollPane(list);
	
	/** The control indexation C. */
	ControlIndexationC controlIndexationC;
    
    /** The control profil. */
    ControlProfil controlProfil;
    
    /** The control historique. */
    ControlHistorique controlHistorique;
	
	/** The control files. */
	ControlFiles controlFiles ;
	
	/** The resultat historique texte. */
	Map<String, String> resultatHistoriqueTexte = new HashMap<>();
	
	/** The lbl seuil. */
	private final JLabel lblSeuil = new JLabel("Seuil");

	
	/**
	 * Instantiates a new pan recherche texte comparaison fichier.
	 *
	 * @param controlIndexationC the control indexation C
	 * @param controlProfil the control profil
	 * @param controlHistorique the control historique
	 * @param controlFiles the control files
	 */
	public PanRechercheTexteComparaisonFichier(ControlIndexationC controlIndexationC, ControlProfil controlProfil, ControlHistorique controlHistorique, ControlFiles controlFiles) {
		
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
		
		jScrollPane.setBounds(251, 259, 292, 260);
		add(jScrollPane);
		
		lblNomDuFichier.setBounds(251, 134, 123, 15);
		
		add(lblNomDuFichier);
		
		JLabel lblRsultats = new JLabel("Résultats");
		lblRsultats.setBounds(251, 216, 70, 15);
		add(lblRsultats);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(647, 157, 117, 25);
		
		btnRechercher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				java.util.List <DescripteurTexte> resultatTexte = controlIndexationC.compareTextes(textFieldPath.getText(), (int) spinner.getValue());
				model.clear();
				resultatHistoriqueTexte.clear();
				
				for(DescripteurTexte d : resultatTexte) {
					model.addElement(d.getNomFichier());
					resultatHistoriqueTexte.put(d.getNomFichier(), d.getPath());
				}
				
				if(FrameClient.profil.isHistorique()) {
					//ajout historique
					String[] separation = textFieldPath.getText().split("/");
					String nom = separation[separation.length-1];
					ControlRequeteRecherche requeteTexte = new ControlRequeteRecherche(nom + " " + (int) spinner.getValue(), FrameClient.profil.getIdentifiant(), "Texte fichier", resultatHistoriqueTexte);
					controlProfil.addHistoricContent(FrameClient.profil,requeteTexte.getStockageBD());
					controlHistorique.FillBDHistorique(FrameClient.profil);
				}
			}
			
		});
		
		add(btnRechercher);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				Process p;
		        try {
		        	System.out.println("gedit "+ resultatHistoriqueTexte.get(list.getSelectedValue()));
		        	   Process proc = Runtime.getRuntime().exec("gedit "+ resultatHistoriqueTexte.get(list.getSelectedValue()) );                        
		        	   proc.waitFor();
		        } catch (Exception excpt) {
		        	excpt.printStackTrace();
		        }
			}
			

		});
		
				
		JButton btnFileChooser = new JButton("......");
		
		btnFileChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String chemin = controlFiles.recupTxtOrXMLFile();
				textFieldPath.setText(chemin);
			}
			
		});
				
		btnFileChooser.setBounds(554, 158, 50, 22);
		add(btnFileChooser);
		
		
	    spinner.setEditor(new JSpinner.DefaultEditor(spinner));
		spinner.setBounds(481, 152, 50, 36);
		add(spinner);
		lblSeuil.setBounds(481, 134, 70, 15);
		
		add(lblSeuil);
	}
}
