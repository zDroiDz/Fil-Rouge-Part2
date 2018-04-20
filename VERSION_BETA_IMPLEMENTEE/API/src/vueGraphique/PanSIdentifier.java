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

import control.ControlSIdentifier;
import model.Profil;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanSIdentifier extends JPanel {
	
	ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
	
	private JTextField login = new JTextField();
	private JPasswordField password = new JPasswordField() ;

	/**
	 * Create the panel.
	 */
	private Profil profil = null ;
	private Font policeTitre=new Font( "Calibri", Font.BOLD,36);
	 
	private JTextField prenom = new JTextField() ;
	private JTextField nom = new JTextField();
	private JPasswordField mdp = new JPasswordField();
	private JPasswordField confMdp = new JPasswordField();
	private JLabel lblNewLabel_1;
	private JButton buttonOk = new JButton("Ok"); ;
	private JButton creerCompte = new JButton("Creer un compte");
	private JLabel lblIdentifiantOuMot = new JLabel("Identifiant ou mot de passe incorrect !");
	
	
	/**
	 * 
	 */
	public PanSIdentifier() {
		setLayout(null);
		
		
		lblIdentifiantOuMot.setBounds(252, 136, 272, 15);
		lblIdentifiantOuMot.setForeground(Color.RED);
		lblIdentifiantOuMot.setVisible(false);
		add(lblIdentifiantOuMot);
		
		
		lblNewLabel_1 = new JLabel("Welcome to Brick'nSoft");
		lblNewLabel_1.setBounds(299, 31, 163, 15);
		add(lblNewLabel_1);
		
				
		JLabel lblLogin = new JLabel("Identifiant");
		lblLogin.setBounds(189, 78, 126, 15);
		add(lblLogin);
		login.setBounds(189, 105, 151, 19);
		
		login.setText("prenom.nom");
		login.setColumns(10);
		add(login);
		
		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setBounds(420, 78, 130, 15);
		add(lblPassword);
		password.setBounds(420, 105, 151, 19);
		
		password.setColumns(10);
		password.setText("mdp");
		add(password);
		buttonOk.setBounds(624, 102, 53, 25);
		add(buttonOk);
		
		
				this.buttonOk.addActionListener(new ActionListener() {
		
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(FrameClient.profil == null) {
							lblIdentifiantOuMot.setVisible(true);
						}
					}
					
				});
		
	
		
		JLabel lblNewLabel = new JLabel("Creer un compte ?");
		lblNewLabel.setBounds(204, 187, 783, 43);
		lblNewLabel.setFont(policeTitre);
		lblNewLabel.setFont(policeTitre);
		add(lblNewLabel);
		prenom.setBounds(387, 290, 151, 19);
		
		
		prenom.setColumns(10);
		add(prenom);
		nom.setBounds(214, 290, 151, 19);
		
		
		nom.setColumns(10);
		add(nom);
		
		JLabel labelVerifMdp = new JLabel("Les champs doivent etre identique ! ");
		labelVerifMdp.setBounds(576, 338, 395, 131);
		labelVerifMdp.setForeground(Color.RED);
		labelVerifMdp.setVisible(false);
		add(labelVerifMdp);
		mdp.setBounds(214, 353, 324, 19);
		
		
		mdp.setColumns(10);
		add(mdp);
		confMdp.setBounds(214, 413, 324, 19);
		

		confMdp.setColumns(10);
		add(confMdp);
		creerCompte.setBounds(296, 444, 151, 25);
		add(creerCompte);
		
		JLabel labelPrenomCreation = new JLabel("Prenom");
		labelPrenomCreation.setBounds(214, 262, 70, 15);
		add(labelPrenomCreation);
		
		JLabel labelNomCreation = new JLabel("Nom");
		labelNomCreation.setBounds(387, 262, 70, 15);
		add(labelNomCreation);
		
		JLabel lblMotDePasseCreation = new JLabel("Mot de passe");
		lblMotDePasseCreation.setBounds(214, 326, 114, 15);
		add(lblMotDePasseCreation);
		
		JLabel lblConfirmationMotDe = new JLabel("Confirmation mot de passe");
		lblConfirmationMotDe.setBounds(214, 386, 233, 15);
		add(lblConfirmationMotDe);
		
		
		this.creerCompte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!mdp.getText().equals(confMdp.getText())) {
					labelVerifMdp.setVisible(true);
				}else {
					labelVerifMdp.setVisible(false);
				}
			}
			
		});
		
		
	}
	
	
	
	public JButton getBoutonOk() {
		return this.buttonOk ;
	}
	
	public JButton getBoutonCreerCompte() {
		return this.creerCompte ;
	}
	
	public String getLogin() {
		return this.login.getText() ;
	}
	
	public String getPasswordConnection() {
		return this.password.getText();
	}
	
	public Profil getProfil() {
		return this.profil;
	}
	public String getPrenom() {
		return prenom.getText();
	}

	public String getNom() {
		return nom.getText();
	}
	
	public String getPasswordCreation() {
	  return this.mdp.getText();
	}
	
	public String getConfPasswordCreation() {
		return this.confMdp.getText();
	}
}
