package vueGraphique;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

// TODO: Auto-generated Javadoc
/**
 * The Class PopUp.
 */
public class PopUp extends JDialog {

	/** The content panel. */
	private final JPanel contentPanel = new JPanel();

	

	/**
	 * Create the dialog.
	 */
	 private Font policeTitre=new Font( "Calibri", Font.BOLD,36);
	 
 	/** The group. */
 	private ButtonGroup group;
	 
 	/** The btn ok. */
 	JButton btnOk = new JButton("Ok");
	 
	/**
	 * Instantiates a new pop up.
	 *
	 * @param frameClient the frame client
	 */
	public PopUp(JFrame frameClient) {
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		setBounds(100, 100, 437, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Voulez vous que vos recherches soient enregistrees?");
		group = new ButtonGroup();
		JRadioButton rdBtnOui = new JRadioButton("Oui");
		JRadioButton rdBtnNon = new JRadioButton("Non");
		rdBtnNon.setSelected(true);
		group.add(rdBtnNon);
		group.add(rdBtnOui);
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(109)
							.addComponent(rdBtnOui)
							.addGap(28)
							.addComponent(rdBtnNon))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(144)
							.addComponent(btnOk)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(45)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdBtnNon)
						.addComponent(rdBtnOui))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOk)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rdBtnOui.isSelected()) {
					FrameClient.profil.setHistorique();
				}else {
					FrameClient.profil.setNoHistorique();
				}
				
				if(rdBtnNon.isSelected() || rdBtnOui.isSelected()) {
					dispose();
				}
				frameClient.setVisible(true);
			}
			
		});
	}
}
