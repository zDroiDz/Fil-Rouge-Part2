package vueGraphique;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import control.ControlCreerProfil;
import model.ProfilUtilisateur;

import javax.swing.JLabel;
import java.awt.Color;

public class PanCreerAdmin extends JPanel {

	/**
	 * Create the panel.
	 */
	 private Font policeTitre=new Font( "Calibri", Font.BOLD,36);
	private JTextField prenom =  new JTextField();;
	private JTextField nom = new JTextField();;
	private JPasswordField mdp = new JPasswordField();;
	private JPasswordField confMdp = new JPasswordField();;
	JButton creerCompte = new JButton("Creer un  compte admin");
	ControlCreerProfil controlCreerProfil ;
	private final JLabel lblPrenom = new JLabel("Prénom");
	private final JLabel lblNewLabel_2 = new JLabel("Nom");
	private final JLabel lblNewLabel_1 = new JLabel("Mot de passe");
	private final JLabel lblConfirmationMotDe = new JLabel("Confirmation mot de passe");
	
	
	public PanCreerAdmin(ControlCreerProfil controlCreerProfil) {
		
		this.controlCreerProfil = controlCreerProfil; 
		
		JLabel lblNewLabel = new JLabel("Création administrateur");
		lblNewLabel.setBounds(199, 45, 761, 30);
		lblNewLabel.setFont(policeTitre);
		prenom.setBounds(408, 148, 159, 19);
		
		
		
		prenom.setColumns(10);
		nom.setBounds(237, 148, 159, 19);
		
		
		nom.setColumns(10);
		mdp.setBounds(237, 218, 330, 19);
		
		
		mdp.setColumns(10);
		confMdp.setBounds(237, 281, 330, 19);
		
		
		confMdp.setColumns(10);
		
		JLabel labelConfirmation = new JLabel("Les mot de passe doivent être identique !");
		labelConfirmation.setBounds(260, 312, 297, 15);
		labelConfirmation.setForeground(Color.RED);
		labelConfirmation.setVisible(false);
		setLayout(null);
		add(lblNewLabel);
		add(confMdp);
		add(mdp);
		add(prenom);
		add(nom);
		add(labelConfirmation);
		creerCompte.setBounds(301, 350, 202, 25);
		add(creerCompte);
		lblPrenom.setBounds(237, 121, 70, 15);
		
		add(lblPrenom);
		lblNewLabel_2.setBounds(408, 121, 70, 15);
		
		add(lblNewLabel_2);
		lblNewLabel_1.setBounds(237, 191, 147, 15);
		
		add(lblNewLabel_1);
		lblConfirmationMotDe.setBounds(237, 254, 266, 15);
		
		add(lblConfirmationMotDe);
		
		this.creerCompte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mdp.getText().equals(confMdp.getText()) && !prenom.getText().equals("") && !nom.getText().equals("") && !mdp.getText().equals("")){
					controlCreerProfil.creerProfil(ProfilUtilisateur.ADMIN, prenom.getText(), nom.getText(), mdp.getText());
					labelConfirmation.setVisible(false);
				}else {
					labelConfirmation.setVisible(true);
				}
			}
		});
		

	}
}
