package Testing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import Testing.BattleshipMainGUI;
import base.*;
import ships.*;

;public class AbilitiesWindow extends JFrame {

	private JPanel contentPane;
	private Player user;
	private GameBoard board;
	
	private JButton okayExocet;
	private JButton cancelExocet;
	private JTextField exoShootCoor;
	private JFrame ExocetPreferenceFrame;
	private Coordinate coord;
	JRadioButton crossExocet;
	JRadioButton xExocet;
	/**
	 * Create the frame.
	 */
	public AbilitiesWindow(Player aUser, GameBoard aBoard) {
		user = aUser;
		board = aBoard;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblNewLabel = new JLabel("<HTML><center><b>Aircraft carier:</b> Each Exocet missile targets 5 squares in a firing pattern that resembles an X or a cross.</center></HTML>");
		
		JLabel lblTheTomahawkMissile = new JLabel("<HTML><center><b>Battleship:</b> The Tomahawk missile strikes a 3x3 grid of squares for a total of nine shots at once.</center></HTML>");
		
		JLabel lblApacheMissilesTarget = new JLabel("<HTML><center><b>Destroyer:</b> Apache missiles target a horizontal or vertical line of 3 squares.</center></HTML>");
		
		JLabel lblTheTorpedoHits = new JLabel("<HTML><center><b>Submarine:</b> The Torpedo hits every spot in a selected row or column until it hits an enemy ship.</center></HTML>");
		
		JLabel lblTheSonarScanner = new JLabel("<HTML><center><b>Submarine:</b> The Sonar Scanner let\u2019s you know if any enemy ship is located in a 3x3 space, but it doesn't tell you where.</center></HTML>");
		
		JLabel lblMoveARecon = new JLabel("<HTML><center><b>Aircraft Carrier:</b> Move a recon plane.</center></HTML>");
		
		JLabel lblReconPlanesLet = new JLabel("<HTML><center><b>Aircraft Carrier</b> Recon Planes Scanner let you know if any enemy ship is located in a space pattern that resembles an X or a cross, and tells you where.</center></HTML>");
		
		JLabel lblAntiaircraftMissilesChecks = new JLabel("<HTML><center>Anti-Aircraft Missiles checks a spot to see if an enemy recon plane is located at that spot and shoots it.</center></HTML>");
		
		JButton btnFireExocetMissile = new JButton("Fire Exocet Missile");
		btnFireExocetMissile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExocetPreferenceFrame = new JFrame("Please Select Your Preference");
				ExocetPreferenceFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				ExocetPreferenceFrame.setLayout(new GridLayout(3,4));
				ExocetPreferenceFrame.setSize(375, 150);
				ExocetPreferenceFrame.setResizable(false);
				
				
				JPanel panel1 = new JPanel();
				JPanel panel2 = new JPanel();
				JPanel panel3 = new JPanel();
				JPanel panel4 = new JPanel();
				JPanel panel5 = new JPanel();
				JPanel panel6 = new JPanel();
				
				JLabel shootLabel = new JLabel("Where would you like to shoot?");
				exoShootCoor = new JTextField(10);
				
				crossExocet = new JRadioButton("Cross Firing Pattern");
				xExocet = new JRadioButton("X Firing Pattern");
				ButtonGroup bg = new ButtonGroup();
				bg.add(crossExocet);
				bg.add(xExocet);

				okayExocet = new JButton("Okay");
				okayExocet.addActionListener(new AbilitiesButtonListener());
				cancelExocet = new JButton("Cancel");
				cancelExocet.addActionListener(new AbilitiesButtonListener());
				
				panel1.add(shootLabel);
				panel2.add(exoShootCoor);
				panel3.add(crossExocet);
				panel4.add(xExocet);
				panel5.add(okayExocet);
				panel6.add(cancelExocet);
				
				ExocetPreferenceFrame.add(panel1);
				ExocetPreferenceFrame.add(panel2);
				ExocetPreferenceFrame.add(panel3);
				ExocetPreferenceFrame.add(panel4);
				ExocetPreferenceFrame.add(panel5);
				ExocetPreferenceFrame.add(panel6);
				
				ExocetPreferenceFrame.setVisible(true);
			}
		});
		
		JButton btnFireTomahawkMissile = new JButton("Fire Tomahawk Missile");
		
		JButton btnFireApacheMissile = new JButton("Fire Apache Missile");
		
		JButton btnFireTorpedo = new JButton("Fire Torpedo");
		
		JButton btnUseSonarScanner = new JButton("Use Sonar Scanner");
		
		JButton btnUseReconPlanes = new JButton("Use Recon Planes Scanner");
		
		JButton btnMovePlane = new JButton("Move Plane");
		
		JButton btnFireAntiaircraftMissle = new JButton("Fire Anti-Aircraft Missle");
		
		JLabel lblUsesLeft = new JLabel("Uses Left: " + user.getOwnedShips().get(0).getSpecialsLeft() );				//AIRCRAFT CARRIER SPECIALS LEFT

		JLabel lblUsesLeft_1 = new JLabel("Uses Left: " + user.getOwnedShips().get(1).getSpecialsLeft());			//BATTLESHIP SPECIALS LEFT
		
		JLabel lblUsesLeft_2 = new JLabel("Uses Left: " + user.getOwnedShips().get(2).getSpecialsLeft());			//DESTROYER SPECIALS LEFT
		
		JLabel lblUsesLeft_3 = new JLabel("Uses Left: " + user.getOwnedShips().get(3).getSpecialsLeft());			//SUBMARINE SPECIALS LEFT
		
		JLabel lblUsesLeft_4 = new JLabel("Uses Left: No Limit");
		
		JLabel lblUsesLeft_5 = new JLabel("Uses Left: ");			//FIXME RECON PLANES SPECIALS LEFT
		
		JLabel lblUsesLeft_6 = new JLabel("Uses Left: ");			//FIXME RECON MOVE LEFT
		
		JLabel lblUsesLeft_7 = new JLabel("Uses Left: ");			//FIXME ANTI AIRCRAFT SPECIALS LEFT
		
		JLabel lblBattleship = new JLabel("ABILITIES");
		lblBattleship.setFont(new Font("Impact", Font.PLAIN, 25));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblReconPlanesLet, 0, 0, Short.MAX_VALUE)
												.addComponent(lblNewLabel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
												.addComponent(lblTheTomahawkMissile, 0, 0, Short.MAX_VALUE)
												.addComponent(lblApacheMissilesTarget, 0, 0, Short.MAX_VALUE)
												.addComponent(lblTheTorpedoHits, 0, 0, Short.MAX_VALUE)
												.addComponent(lblTheSonarScanner, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
											.addComponent(lblAntiaircraftMissilesChecks, 0, 0, Short.MAX_VALUE))
										.addGap(37))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblMoveARecon)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(btnFireTomahawkMissile)
											.addComponent(btnFireApacheMissile)
											.addComponent(btnFireTorpedo)
											.addComponent(btnFireExocetMissile)
											.addComponent(btnUseSonarScanner))
										.addGap(41)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblUsesLeft_4)
											.addComponent(lblUsesLeft)
											.addComponent(lblUsesLeft_3)
											.addComponent(lblUsesLeft_2)
											.addComponent(lblUsesLeft_1)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(btnUseReconPlanes)
											.addComponent(btnMovePlane)
											.addComponent(btnFireAntiaircraftMissle))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblUsesLeft_6)
											.addComponent(lblUsesLeft_5)
											.addComponent(lblUsesLeft_7))))
								.addContainerGap())
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblBattleship)
								.addGap(243)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnCancel)
							.addGap(271))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBattleship)
							.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnFireExocetMissile)
								.addComponent(lblUsesLeft))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnFireTomahawkMissile)
								.addComponent(lblUsesLeft_1)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTheTomahawkMissile)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblApacheMissilesTarget)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnFireApacheMissile)
							.addComponent(lblUsesLeft_2)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTheTorpedoHits)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnFireTorpedo)
							.addComponent(lblUsesLeft_3)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTheSonarScanner)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnUseSonarScanner)
								.addComponent(lblUsesLeft_4))
							.addGap(5)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblReconPlanesLet)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnMovePlane)
									.addComponent(lblUsesLeft_6))
								.addComponent(lblMoveARecon)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnUseReconPlanes)
								.addComponent(lblUsesLeft_5))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAntiaircraftMissilesChecks)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUsesLeft_7)
							.addComponent(btnFireAntiaircraftMissle)))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(btnCancel))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private class AbilitiesButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(okayExocet)) {
				if(user.getOwnedShips().get(0).getSpecialsLeft() > 0) {
					if(checkInputOK() == false) {		//Checks that the input was a coordinate and not random stuff
						JOptionPane.showMessageDialog(null, "<HTML><center>Your input was incorrect."
												+ "the launch of the Exocet missle was caneled.</center></HTML>");
						ExocetPreferenceFrame.dispose();
						ExocetPreferenceFrame.setVisible(false);
					}
					else {
						AirCraftCarrier acc = new AirCraftCarrier();
						user.getOwnedShips().get(0).setSpecialsLeft(user.getOwnedShips().get(0).getSpecialsLeft()-1);
						if(crossExocet.isSelected()) {
							acc.Exocet(true, coord, board);
						}
						else if (xExocet.isSelected()) {
							acc.Exocet(false, coord, board);
						}
					}
					ExocetPreferenceFrame.dispose();
					ExocetPreferenceFrame.setVisible(false);
					close(); 
				}
				else {
					JOptionPane.showMessageDialog(null, "<HTML><center>You have no Exocet missles left. "
												+ "<BR>Please select a differnt option</center></HTML>");
				}
			}
			if(source.equals(cancelExocet)) {
				ExocetPreferenceFrame.dispose();
				ExocetPreferenceFrame.setVisible(false);
				close();
			}
		}
	}
	public boolean checkInputOK() {
		int letter;
		int num;
		//String checkString = new String(exoShootCoor.toString());
		String checkString = new String(exoShootCoor.getText());
		checkString.toCharArray();
		if(checkString.length() > 1) {
			//Checking that the first character is a letter
			if((checkString.charAt(0) >= 'A') && (checkString.charAt(0) <= 'J')) {
				letter = checkString.charAt(0) - 65;
			}
			else if((checkString.charAt(0) >= 'a') && (checkString.charAt(0) <= 'j')) {
				letter = checkString.charAt(0) - 97;
			}
			else {
				return false;	//Appropriate letter was not selected
			}
			
			//Now checking that the second character is a number
			if((checkString.charAt(1) >= 1) && (checkString.charAt(1) >= 9)){
				if((checkString.charAt(1) == 1) && (checkString.charAt(2) == 0)){
					num = 10;
					coord = new Coordinate();
					Location loc = new Location(letter,num);
					coord.setCoord(loc);
					return true; //Yay!!! Correct shit was inputed!!
				}
				else {
					num = checkString.charAt(1) - 49;
					coord = new Coordinate();
					Location loc = new Location(letter,num);
					coord.setCoord(loc);
					return true; //Yay!! Correct shit was inputed!!
				}
			}
			else {
				return false; //Number was not selected
			}
		}
		return false;	//Not enough characters were written
	}
	public void close(){
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
