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
	
	
	public PanCreerAdmin(ControlCreerProfil controlCreerProfil) {
		
		this.controlCreerProfil = controlCreerProfil; 
		
		JLabel lblNewLabel = new JLabel("Creer un admin ?");
		lblNewLabel.setFont(policeTitre);
		
		
		
		prenom.setColumns(10);
		
		
		nom.setColumns(10);
		
		
		mdp.setColumns(10);
		
		
		confMdp.setColumns(10);
		
		JLabel labelConfirmation = new JLabel("Les mot de passe doivent être identique !");
		labelConfirmation.setForeground(Color.RED);
		labelConfirmation.setVisible(false);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(confMdp)
									.addComponent(mdp)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(26)
										.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(labelConfirmation))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(74)
							.addComponent(creerCompte)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(mdp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(confMdp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(creerCompte)
					.addGap(27)
					.addComponent(labelConfirmation)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
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
