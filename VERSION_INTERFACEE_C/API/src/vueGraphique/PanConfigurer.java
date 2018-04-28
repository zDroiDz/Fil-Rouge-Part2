package vueGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import control.ControlConfigurer;
import control.ControlIndexationC;

// TODO: Auto-generated Javadoc
/**
 * The Class PanConfigurer.
 */
public class PanConfigurer extends JPanel {
	

	/** The control indexation C. */
	private ControlIndexationC controlIndexationC ;
	
	/** The control configurer. */
	ControlConfigurer controlConfigurer ;
	
	/** The box mise en page config. */
	Box boxMiseEnPageConfig = Box.createVerticalBox();
	
	/** The box nb occ txt. */
	Box boxNbOccTxt = Box.createHorizontalBox();
	
	/** The box nb ech son. */
	Box boxNbEchSon = Box.createHorizontalBox();
	
	/** The box nb inter son. */
	Box boxNbInterSon = Box.createHorizontalBox();
	
	/** The box nb bits NB. */
	Box boxNbBitsNB = Box.createHorizontalBox();
	
	/** The box nb bits couleur. */
	Box boxNbBitsCouleur = Box.createHorizontalBox();
	
	/** The box buttons. */
	Box boxButtons = Box.createHorizontalBox();
	
	/** The box validation indexation. */
	Box boxValidationIndexation = Box.createHorizontalBox();
	
	/** The box validation configuration. */
	Box boxValidationConfiguration = Box.createHorizontalBox();
	
	/** The box verification validite. */
	Box boxVerificationValidite = Box.createHorizontalBox();
	
	/** The text area nb occ txt. */
	JTextArea textAreaNbOccTxt = new JTextArea();
	
	/** The text area nb ech son. */
	JTextArea textAreaNbEchSon = new JTextArea();
	
	/** The text area nb inter son. */
	JTextArea textAreaNbInterSon = new JTextArea();

	/** The text area nb bits NB. */
	JTextArea textAreaNbBitsNB = new JTextArea();
	
	/** The text area nb bits couleur. */
	JTextArea textAreaNbBitsCouleur = new JTextArea();
	
	/** The label valid indexation. */
	JLabel labelValidIndexation = new JLabel("Indexation terminée !");
	
	/** The label valid configuration. */
	JLabel labelValidConfiguration = new JLabel("Configuration effectuée !");
	
	/** The label verification validite. */
	JLabel labelVerificationValidite = new JLabel("Un des champs n'est pas valide !");
	
	/** The button configurer. */
	JButton buttonConfigurer = new JButton("Configurer");
	
	/** The button indexer. */
	JButton buttonIndexer = new JButton("Indexer");
	
	/** The police titre. */
	Font policeTitre =  new Font("Calibri", Font.BOLD, 24);;
	
	/** The police paragraphe. */
	Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16) ;
	
	/** The police valide. */
	Font policeValide = new Font("Calibri", Font.BOLD, 24);
	
	/** The key listener. */
	KeyListener keyListener ;
	
	/**
	 * Instantiates a new pan configurer.
	 *
	 * @param controlConfigurer the control configurer
	 * @param controlIndexationC the control indexation C
	 */
	public PanConfigurer(ControlConfigurer controlConfigurer, ControlIndexationC controlIndexationC){
		this.controlConfigurer = controlConfigurer ;
		this.controlIndexationC = controlIndexationC ;
		
		 keyListener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("typed");
				boxValidationConfiguration.setVisible(false);
				boxValidationIndexation.setVisible(false);
				boxVerificationValidite.setVisible(false);
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("pressed");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				boolean valide = true ;
				System.out.println("released");
				
				String contenuNbOccTxt= textAreaNbOccTxt.getText();
				String contenuNbEchSon= textAreaNbEchSon.getText();
				String contenuInterSon= textAreaNbInterSon.getText();
				String contenuNbBitsNB= textAreaNbBitsNB.getText();
				String contenuNbBitsCouleur= textAreaNbBitsCouleur.getText();
				
				
				for(int i = 0 ; i < contenuNbOccTxt.length() ; i++) {
					if(!verifyValide(contenuNbOccTxt.charAt(i)) ) {
						valide  = false ;
					}
				}
				
				for(int i = 0 ; i < contenuNbEchSon.length() ; i++) {
					if(!verifyValide(contenuNbEchSon.charAt(i))) {
						valide  = false ;
					}
				}
				
				for(int i = 0 ; i < contenuInterSon.length() ; i++) {
					if(!verifyValide(contenuInterSon.charAt(i))) {
						valide  = false ;
					}
				}
				
				for(int i = 0 ; i < contenuNbBitsNB.length() ; i++) {
					if(!verifyValide(contenuNbBitsNB.charAt(i)) ) {
						valide  = false ;
					}
				}
				
				for(int i = 0 ; i < contenuNbBitsCouleur.length() ; i++) {
					if(!verifyValide(contenuNbBitsCouleur.charAt(i)) ) {
						valide  = false ;
					}
				}
				
				if(!valide || contenuNbOccTxt.length()==0 || contenuNbEchSon.length()==0 || contenuInterSon.length()==0 ||contenuNbBitsNB.length()==0 ||contenuNbBitsCouleur.length()==0 ) {
					boxVerificationValidite.setVisible(true);
					buttonConfigurer.setEnabled(false);
				}
				else
				{
					buttonConfigurer.setEnabled(true);
				}
					

			}
		};
		
	}
	
	
	/**
	 * Initialisation.
	 */
	public void initialisation(){
		
		
		this.textAreaNbOccTxt.addKeyListener(keyListener);
		this.textAreaNbEchSon.addKeyListener(keyListener);
		this.textAreaNbInterSon.addKeyListener(keyListener);
		this.textAreaNbBitsNB.addKeyListener(keyListener);
		this.textAreaNbBitsCouleur.addKeyListener(keyListener);
		
		JLabel texteConfigurer = new JLabel("Menu Configuration");
		texteConfigurer.setFont(policeTitre);
		
		JLabel texteNbOccTxt = new JLabel("Nombre d'occurences fichier texte");
		texteNbOccTxt.setFont(policeParagraphe);
		
		JLabel texteNbEchSon = new JLabel("Nombre d'échantillons fichiers son");
		texteNbEchSon.setFont(policeParagraphe);
		
		JLabel texteNbInterSon = new JLabel("Nombre d'intervalles fichiers son");
		texteNbInterSon.setFont(policeParagraphe);
		
		JLabel texteNbBitsNB = new JLabel("Nombre de bits significatifs fichiers image noir et blanc");
		texteNbBitsNB.setFont(policeParagraphe);
		
		JLabel texteNbBitsCouleur = new JLabel("Nombre de bits significatifs fichiers image couleur");
		texteNbBitsCouleur.setFont(policeParagraphe);
		
		
		this.boxMiseEnPageConfig.add(texteConfigurer);
		this.boxMiseEnPageConfig.add(Box.createRigidArea(new Dimension(0,30)));
		
		this.boxNbOccTxt.add(texteNbOccTxt);
		this.boxNbOccTxt.add(Box.createRigidArea(new Dimension(10,0)));
		this.textAreaNbOccTxt.setMaximumSize(new Dimension(120,20));
		this.textAreaNbOccTxt.setText(String.valueOf(this.controlConfigurer.getNbOccTxt()));
		this.boxNbOccTxt.add(textAreaNbOccTxt);
		
		this.boxNbEchSon.add(texteNbEchSon);
		this.boxNbEchSon.add(Box.createRigidArea(new Dimension(10,0)));
		this.textAreaNbEchSon.setMaximumSize(new Dimension(120,20));
		this.textAreaNbEchSon.setText(String.valueOf(this.controlConfigurer.getNbEch()));
		this.boxNbEchSon.add(textAreaNbEchSon);
		
		this.boxNbInterSon.add(texteNbInterSon);
		this.boxNbInterSon.add(Box.createRigidArea(new Dimension(10,0)));
		this.textAreaNbInterSon.setMaximumSize(new Dimension(120,20));
		this.textAreaNbInterSon.setText(String.valueOf(this.controlConfigurer.getNbIntervalles()));
		this.boxNbInterSon.add(textAreaNbInterSon);
		
		this.boxNbBitsNB.add(texteNbBitsNB);
		this.boxNbBitsNB.add(Box.createRigidArea(new Dimension(10,0)));
		this.textAreaNbBitsNB.setMaximumSize(new Dimension(120,20));
		this.textAreaNbBitsNB.setText(String.valueOf(this.controlConfigurer.getNbBitsNb()));
		this.boxNbBitsNB.add(textAreaNbBitsNB);
		
		this.boxNbBitsCouleur.add(texteNbBitsCouleur);
		this.boxNbBitsCouleur.add(Box.createRigidArea(new Dimension(10,0)));
		this.textAreaNbBitsCouleur.setMaximumSize(new Dimension(120,20));
		this.textAreaNbBitsCouleur.setText(String.valueOf(this.controlConfigurer.getNbBitsCouleur()));
		this.boxNbBitsCouleur.add(textAreaNbBitsCouleur);
		
		
		this.buttonConfigurer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controlConfigurer.configureAll(Integer.valueOf(textAreaNbOccTxt.getText()), Integer.valueOf(textAreaNbEchSon.getText()), Integer.valueOf(textAreaNbInterSon.getText()),Integer.valueOf(textAreaNbBitsNB.getText()),Integer.valueOf(textAreaNbBitsCouleur.getText()) );
				boxValidationConfiguration.setVisible(true);
			}
			
		});
		
		this.buttonIndexer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controlIndexationC.lancerIndexation();
				boxValidationIndexation.setVisible(true);
			}
			
		});
		
		
		labelVerificationValidite.setFont(policeValide);
		labelVerificationValidite.setForeground(Color.RED);
		
		
		this.boxButtons.add(buttonConfigurer);
		this.boxButtons.add(Box.createRigidArea(new Dimension(20,0)));
		this.boxButtons.add(buttonIndexer);
		this.boxValidationConfiguration.add(labelValidConfiguration);
		this.boxValidationIndexation.add(labelValidIndexation);
		this.boxVerificationValidite.add(labelVerificationValidite);
		
		Dimension separation = new Dimension(0,20);
		this.boxMiseEnPageConfig.add(boxNbOccTxt);
		this.boxMiseEnPageConfig.add(Box.createRigidArea(separation));
		this.boxMiseEnPageConfig.add(boxNbEchSon);
		this.boxMiseEnPageConfig.add(Box.createRigidArea(separation));
		this.boxMiseEnPageConfig.add(boxNbInterSon);
		this.boxMiseEnPageConfig.add(Box.createRigidArea(separation));
		this.boxMiseEnPageConfig.add(boxNbBitsNB);		
		this.boxMiseEnPageConfig.add(Box.createRigidArea(separation));
		this.boxMiseEnPageConfig.add(boxNbBitsCouleur);
		this.boxMiseEnPageConfig.add(Box.createRigidArea(separation));
		this.boxMiseEnPageConfig.add(boxButtons);
		this.boxMiseEnPageConfig.add(boxValidationConfiguration);
		this.boxMiseEnPageConfig.add(boxValidationIndexation);
		this.boxMiseEnPageConfig.add(boxVerificationValidite);
		this.boxValidationConfiguration.setVisible(false);
		this.boxValidationIndexation.setVisible(false);
		this.boxVerificationValidite.setVisible(false);
				
		this.add(boxMiseEnPageConfig);
		
		this.setVisible(true);
		
	}
	
	/**
	 * Verify valide.
	 *
	 * @param car the car
	 * @return true, if successful
	 */
	public boolean verifyValide(char car)
	{
		String specialChars = "[`~!@#$%^&*()_+[\\]\\\\;\',./{}|:\"<>?] abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
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
