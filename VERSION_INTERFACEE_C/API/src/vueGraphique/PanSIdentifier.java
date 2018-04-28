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
import control.ControlSIdentifier;
import model.Profil;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

// TODO: Auto-generated Javadoc
/**
 * The Class PanSIdentifier.
 */
public class PanSIdentifier extends JPanel {
	
	/** The control S identifier. */
	ControlSIdentifier controlSIdentifier ;
	
	/** The control creer profil. */
	ControlCreerProfil controlCreerProfil ;
	
	/** The login. */
	private JTextField login = new JTextField();
	
	/** The password. */
	private JPasswordField password = new JPasswordField() ;

	/**
	 * Create the panel.
	 */
	private Profil profil = null ;
	
	/** The police titre. */
	private Font policeTitre=new Font( "Calibri", Font.BOLD,36);
	 
	/** The prenom. */
	private JTextField prenom = new JTextField() ;
	
	/** The nom. */
	private JTextField nom = new JTextField();
	
	/** The mdp. */
	private JPasswordField mdp = new JPasswordField();
	
	/** The conf mdp. */
	private JPasswordField confMdp = new JPasswordField();
	
	/** The lbl new label 1. */
	private JLabel lblNewLabel_1;
	
	/** The button ok. */
	private JButton buttonOk = new JButton("Ok"); ;
	
	/** The creer compte. */
	private JButton creerCompte = new JButton("Creer un compte");
	
	/** The lbl identifiant ou mot. */
	private JLabel lblIdentifiantOuMot = new JLabel("Identifiant ou mot de passe incorrect !");
	
	/** The key listener. */
	KeyListener keyListener ;
	
	
	/**
	 * Instantiates a new pan S identifier.
	 *
	 * @param controlSIdentifier the control S identifier
	 * @param controlCreerProfil the control creer profil
	 */
	public PanSIdentifier(ControlSIdentifier controlSIdentifier, ControlCreerProfil controlCreerProfil) {
		
		this.controlCreerProfil = controlCreerProfil ;
		this.controlSIdentifier = controlSIdentifier ;
		
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
		
		
		login.setColumns(10);
		add(login);
		
		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setBounds(420, 78, 130, 15);
		add(lblPassword);
		password.setBounds(420, 105, 151, 19);
		
	
		password.setColumns(10);
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
		labelVerifMdp.setBounds(552, 395, 287, 54);
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
		
		JLabel lblVousNePouvez = new JLabel("Vous ne pouvez pas utiliser ce mot de passe !");
		lblVousNePouvez.setForeground(Color.RED);
		lblVousNePouvez.setBounds(515, 326, 363, 15);
		lblVousNePouvez.setVisible(false);
		add(lblVousNePouvez);
		
		
		this.creerCompte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!mdp.getText().equals(confMdp.getText())) {
					labelVerifMdp.setVisible(true);
				}else {
					labelVerifMdp.setVisible(false);
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
	
	
	
	/**
	 * Gets the bouton ok.
	 *
	 * @return the bouton ok
	 */
	public JButton getBoutonOk() {
		return this.buttonOk ;
	}
	
	/**
	 * Gets the bouton creer compte.
	 *
	 * @return the bouton creer compte
	 */
	public JButton getBoutonCreerCompte() {
		return this.creerCompte ;
	}
	
	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return this.login.getText() ;
	}
	
	/**
	 * Gets the password connection.
	 *
	 * @return the password connection
	 */
	public String getPasswordConnection() {
		return this.password.getText();
	}
	
	/**
	 * Gets the profil.
	 *
	 * @return the profil
	 */
	public Profil getProfil() {
		return this.profil;
	}
	
	/**
	 * Gets the prenom.
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return nom.getText();
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return prenom.getText();
	}
	
	/**
	 * Gets the password creation.
	 *
	 * @return the password creation
	 */
	public String getPasswordCreation() {
	  return this.mdp.getText();
	}
	
	/**
	 * Gets the conf password creation.
	 *
	 * @return the conf password creation
	 */
	public String getConfPasswordCreation() {
		return this.confMdp.getText();
	}
	
	/**
	 * Verify valide.
	 *
	 * @param car the car
	 * @return true, if successful
	 */
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
