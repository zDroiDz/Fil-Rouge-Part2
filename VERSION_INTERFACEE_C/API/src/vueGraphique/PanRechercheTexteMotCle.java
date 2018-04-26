package vueGraphique;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControlHistorique;
import control.ControlProfil;
import control.ControlRechercher;
import model.DescripteurTexte;

import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanRechercheTexteMotCle extends JPanel{
	
	DefaultListModel<String> model = new DefaultListModel<>();
	private JTextField textFieldMotCle = new JTextField();;
	JLabel lblRsultats = new JLabel("Résultats");
	JList<String> list = new JList(model);
    JScrollPane jScrollPane = new JScrollPane(list);
    SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 1000, 1);
    JSpinner SpinnerRessemblance = new JSpinner(spinnerModel);
    
    ControlRechercher controlRechercher = new ControlRechercher();
    ControlProfil controlProfil = new ControlProfil();
    ControlHistorique controlHistorique = new ControlHistorique();
	Map<String, String> resultatHistoriqueMotCle = new HashMap<>();

	
		public PanRechercheTexteMotCle() {
			
		setLayout(null);
		
		JLabel labelTitre = new JLabel("Recherche Mot-Clé");
		labelTitre.setFont(new Font("Dialog", Font.BOLD, 20));
		labelTitre.setBounds(270, 55, 222, 40);
		add(labelTitre);
		
		JLabel lblEntrezUnMotcl = new JLabel("Entrez un Mot-Clé");
		lblEntrezUnMotcl.setBounds(225, 145, 162, 15);
		add(lblEntrezUnMotcl);
		
		
		textFieldMotCle.setBounds(225, 172, 298, 19);
		add(textFieldMotCle);
		textFieldMotCle.setColumns(10);
		
		SpinnerRessemblance.setEditor(new JSpinner.DefaultEditor(SpinnerRessemblance));
		SpinnerRessemblance.setBounds(569, 165, 45, 33);
		add(SpinnerRessemblance);
		
		jScrollPane.setBounds(225, 272, 308, 290);
		add(jScrollPane);
		
		lblRsultats.setBounds(225, 242, 70, 15);
		add(lblRsultats);
		

		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				Process p;
		        try {
		        	System.out.println("gedit "+ resultatHistoriqueMotCle.get(list.getSelectedValue()));
		        	   Process proc = Runtime.getRuntime().exec("gedit "+ resultatHistoriqueMotCle.get(list.getSelectedValue()) );                        
		        	   proc.waitFor();
		        } catch (Exception excpt) {
		        	excpt.printStackTrace();
		        }
			}
			

		});
        
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(654, 169, 117, 25);
		
		btnRechercher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				java.util.List<DescripteurTexte> resultatMotCle = controlRechercher.lancerRechercheMotCle((String)textFieldMotCle.getText(), (int)SpinnerRessemblance.getValue(), FrameClient.profil);
				//vide les anciens résultats
				resultatHistoriqueMotCle.clear();
				
				model.clear();
				for(DescripteurTexte d : resultatMotCle){
					model.addElement(d.getNomFichier());
					System.out.println("chemin " + d.getPath());
					resultatHistoriqueMotCle.put(d.getNomFichier(), d.getPath());
				}
				
				if(FrameClient.profil.isHistorique()) {
					//ajout historique
					RequeteRecherche requeteMotCle = new RequeteRecherche(textFieldMotCle.getText(), FrameClient.profil.getIdentifiant(), "Mot cle", resultatHistoriqueMotCle);
					controlProfil.addHistoricContent(FrameClient.profil,requeteMotCle.getStockageBD());
					controlHistorique.FillBDHistorique(FrameClient.profil);	
				}
				
			}
		});
		
		add(btnRechercher);
		
		
	}
}
