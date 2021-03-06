package vueGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import control.ControlHistorique;
import control.ControlRequeteRecherche;
import model.Admin;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTree;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.JList;

// TODO: Auto-generated Javadoc
/**
 * The Class PopupHistorique.
 */
public class PopupHistorique extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The lbl date recherche. */
	private JLabel lblDateRecherche;
	
	/** The lbl utilisateur. */
	private JLabel lblUtilisateur;
	
	/** The lbl requte. */
	private JLabel lblRequte;
	
	/** The txt N 1. */
	private JTextField txtN_1;
	
	/** The text field. */
	private JTextField textField;
	
	/** The text field 1. */
	private JTextField textField_1;
	
	/** The text field 2. */
	private JTextField textField_2;
	
	/** The list. */
	private JList list;
	
	/** The type recherche. */
	private String typeRecherche;
	
	/** The requete recherche. */
	private String requeteRecherche;
	
	/** The date recherche. */
	private String dateRecherche;
	
	/** The utilisateur recherche. */
	private String utilisateurRecherche;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ControlHistorique controlHistorique = new ControlHistorique();
					controlHistorique.FillBDHistorique(new Admin("admin","admin","admin"));
					
					
					
					ArrayList<String> listeRecherches = (ArrayList<String>) controlHistorique.consulterListeRecherche();

					DefaultListModel<String >listeInter = new DefaultListModel<String>();
					
					for(int i = 0; i < 20; i ++) {
					for(String recherche : listeRecherches) {
						listeInter.addElement(recherche);
					}}
							
					//jjiij frame = new jjiij("Comparaison image par seuil", "20% RVB", "29/03/2018 22:22", "admin", listeInter);
					ControlRequeteRecherche recherche = new ControlRequeteRecherche("<date> 2018/04/18 13:48:59 </date> <requete> testRequete </requete> <utilisateur> testUtilisateur </utilisateur> <type> testType </type> <mapResultat> {Samir=menaa, test1=test2} </mapResultat>");
					PopupHistorique frame = new PopupHistorique(recherche);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 * @param recherche the recherche
	 */
	public PopupHistorique(ControlRequeteRecherche recherche) {
		
		this.typeRecherche = recherche.getTypeRecherche();
		this.requeteRecherche = recherche.getRequeteRecherche();
		this.dateRecherche = recherche.getDateRecherche();
		this.utilisateurRecherche = recherche.getUtilisateurRecherche();
		
		this.setTitle("Affiche de l'historique de " + this.requeteRecherche);
		
		
		
		setBounds(100, 100, 500, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{15, 100, 100, 0, 0, 70, 30, 0};
		gbl_contentPane.rowHeights = new int[]{16, 16, 0, 0, 16, 16, 16, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTypeRecherche = new JLabel("Type recherche : ");
		GridBagConstraints gbc_lblTypeRecherche = new GridBagConstraints();
		gbc_lblTypeRecherche.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTypeRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_lblTypeRecherche.gridx = 1;
		gbc_lblTypeRecherche.gridy = 0;
		contentPane.add(lblTypeRecherche, gbc_lblTypeRecherche);
		
		textField = new JTextField();
		textField.setText(typeRecherche);
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblDateRecherche = new JLabel("Date :");
		GridBagConstraints gbc_lblDateRecherche = new GridBagConstraints();
		gbc_lblDateRecherche.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDateRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateRecherche.gridx = 4;
		gbc_lblDateRecherche.gridy = 0;
		contentPane.add(lblDateRecherche, gbc_lblDateRecherche);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setEditable(false);
		textField_2.setText(dateRecherche);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 0;
		contentPane.add(textField_2, gbc_textField_2);
		
		lblUtilisateur = new JLabel("Utilisateur : ");
		GridBagConstraints gbc_lblUtilisateur = new GridBagConstraints();
		gbc_lblUtilisateur.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblUtilisateur.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtilisateur.gridx = 1;
		gbc_lblUtilisateur.gridy = 1;
		contentPane.add(lblUtilisateur, gbc_lblUtilisateur);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setEditable(false);
		textField_1.setText(utilisateurRecherche);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		contentPane.add(textField_1, gbc_textField_1);
		
		lblRequte = new JLabel("Requ\u00EAte : ");
		GridBagConstraints gbc_lblRequte = new GridBagConstraints();
		gbc_lblRequte.insets = new Insets(0, 0, 5, 5);
		gbc_lblRequte.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblRequte.gridx = 1;
		gbc_lblRequte.gridy = 3;
		contentPane.add(lblRequte, gbc_lblRequte);
		
		txtN_1 = new JTextField();
		txtN_1.setText(requeteRecherche);
		txtN_1.setBackground(Color.WHITE);
		txtN_1.setEditable(false);
		GridBagConstraints gbc_txtN_1 = new GridBagConstraints();
		gbc_txtN_1.gridwidth = 4;
		gbc_txtN_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtN_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtN_1.gridx = 2;
		gbc_txtN_1.gridy = 3;
		contentPane.add(txtN_1, gbc_txtN_1);
		txtN_1.setColumns(10);
		
		list = new JList<String>(recherche.getListeResultat());
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				Process p;
		        try {
		        	
		        	if(recherche.getTypeRechercheNom().equals("texte")) {
		        		 System.out.println("gedit "+ recherche.getPath(list.getSelectedValue().toString()));
			        	   Process proc = Runtime.getRuntime().exec("gedit "+ recherche.getPath(list.getSelectedValue().toString()) );                        
			        	   proc.waitFor();
		        	}else if(recherche.getTypeRechercheNom().equals("image")) {
		        		System.out.println("eog "+ recherche.getPath(list.getSelectedValue().toString()));
			        	   Process proc = Runtime.getRuntime().exec("eog "+ recherche.getPath(list.getSelectedValue().toString()) );                        
			        	   proc.waitFor();
		        	}else {
		        		System.out.println("eog "+ recherche.getPath(list.getSelectedValue().toString()));
			        	   Process proc = Runtime.getRuntime().exec("totem ../EXTERN_FILES/base_files/DATA_FIL_ROUGE_DEV/TEST_SON/corpus_fi.wav");                        
			        	   proc.waitFor();
		        	}
		        	  
		        } catch (Exception excpt) {
		        	excpt.printStackTrace();
		        }
			}
		});
		
		JScrollPane listScroller = new JScrollPane(list); 
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 3;
		gbc_list.gridwidth = 5;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 5;
		contentPane.add(listScroller, gbc_list);
		
		
	}

}
