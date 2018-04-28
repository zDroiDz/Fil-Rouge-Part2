package vueGraphique;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	KeyListener keyListener ;
	
	
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
		
		JLabel lblVousNePouvez = new JLabel("Vous ne pouvez pas utiliser ce mot de passe !");
		lblVousNePouvez.setForeground(Color.RED);
		lblVousNePouvez.setBounds(507, 191, 332, 15);
		lblVousNePouvez.setVisible(false);
		add(lblVousNePouvez);
		
		this.creerCompte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mdp.getText().equals(confMdp.getText()) && !prenom.getText().equals("") && !nom.getText().equals("") && !mdp.getText().equals("")){
					controlCreerProfil.creerProfil(ProfilUtilisateur.ADMIN, nom.getText(), prenom.getText(), mdp.getText());
					labelConfirmation.setVisible(false);
				}else {
					labelConfirmation.setVisible(true);
				}
				
				if(!controlCreerProfil.verificationCreation(mdp.getText())) {
					lblVousNePouvez.setVisible(true);
				}else {
					lblVousNePouvez.setVisible(false);
				}
			}
		});
		
keyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				creerCompte.setEnabled(true);
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				boolean valide = true ;
				String prenom1=prenom.getText();
				String nom1=nom.getText();
				String mdp1=mdp.getText();
				String confmdp1=confMdp.getText();
				
				for(int i = 0 ; i < prenom1.length() ; i++) {
					if(!verifyValide(prenom1.charAt(i)) ) {
						valide  = false ;
					}
				}
				
				for(int i = 0 ; i < nom1.length() ; i++) {
					if(!verifyValide(nom1.charAt(i)) ) {
						valide  = false ;
					}
				}
				for(int i = 0 ; i < mdp1.length() ; i++) {
					if(!verifyValide(mdp1.charAt(i)) ) {
						valide  = false ;
					}
				}
				for(int i = 0 ; i < confmdp1.length() ; i++) {
					if(!verifyValide(confmdp1.charAt(i)) ) {
						valide  = false ;
					}
				}
				
				if(!valide || prenom1.length()==0 || nom1.length()==0 || mdp1.length()==0 ||confmdp1.length()==0 )
				{
					creerCompte.setEnabled(false);
				}
				else
				{
					creerCompte.setEnabled(true);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		};
		
		
		prenom.addKeyListener(keyListener);
		nom.addKeyListener(keyListener);
		mdp.addKeyListener(keyListener);
		confMdp.addKeyListener(keyListener);
		

	}
	
	
	public boolean verifyValide(char car)
	{
		String specialChars = "[`~!@#$%^&*()_+[\\]\\\\;\',./{}|:\"<>?] ";
		
		for(int i=0;i<specialChars.length();i++)
		{
			if(car==specialChars.charAt(i))
			{
				return false;
			}
		}
		return true;
	}
}
