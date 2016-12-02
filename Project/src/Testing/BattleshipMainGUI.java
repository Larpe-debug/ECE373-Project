package Testing;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import base.Coordinate;
import base.GameBoard;


public class BattleshipMainGUI extends JFrame {
	
	private JButton[][] userButtonGrid = new JButton[10][10];
	private JButton[][] enemyButtonGrid = new JButton[10][10];
	
    JButton mainMenuButton;
    JButton helpButton;
    JButton restartButton;
    JButton abilityButton;
	
	public BattleshipMainGUI() {
		super("BATTLESHIP");
		setSize(1500,600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    buildGUI();
	    setVisible(true);	    
	}
	
	private void buildGUI() {
		int i, j;
		getContentPane().setLayout(new BorderLayout());
		
		//TITLE:		
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("BATTLESHIP");
		title.setFont(new Font("Impact", Font.PLAIN, 45));
		titlePanel.add(title);
		
		//USER PANEL:
	    JPanel userPanel = new JPanel();
	    userPanel.setLayout(new GridLayout(12,11));
	    
	    userPanel.add(new JLabel("\n"));		//All of these \n are me just trying to center it. When I tried making it all on the same line it didn't work .-.
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("<HTML><p>Your Ships:<BR> </HTML>"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));

	    
	    UserButtonListener userGridButtonListener = new UserButtonListener();
	    userPanel.add(new JLabel("\n"));
	    for(i = 0; i < 10; i++) {
	    	String Letters = new String("         " + Character.toString((char) (i + 65)));
	    	userPanel.add(new JLabel(Letters));
	    	
	    }
	    int k = 0;
		for(i = 0; i < 10; i++) {
			for(j = 0; j < 10; j++) {
				if(j ==0) {
					k = k + 1;
					userPanel.add(new JLabel("                " + Integer.toString(k)));
				}
				userButtonGrid[i][j] = new JButton(); 
				userButtonGrid[i][j].setBackground(new Color(175, 238, 238));
				userPanel.add(userButtonGrid[i][j]);
				userButtonGrid[i][j].addActionListener(userGridButtonListener);
			}
		}
	    
	    //ENEMY PANEL
	    JPanel enemyPanel = new JPanel();
	    JPanel enemyGridPanel = new JPanel();
	    enemyPanel.setLayout(new GridLayout(12,11));
	    
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("Enemy:"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    EnemyButtonListener enemyGridButtonListener = new EnemyButtonListener();

	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    for(i = 0; i < 10; i++) {
	    	String Letters = new String("         " + Character.toString((char) (i + 65)));
	    	enemyPanel.add(new JLabel(Letters));
	    }
	    k = 0;
		for(i = 0; i < 10; i++) {
			for(j = 0; j < 10; j++) {
				if(j ==0) {
					k = k + 1;
					enemyPanel.add(new JLabel("            " + Integer.toString(k)));
				}
				enemyButtonGrid[i][j] = new JButton(); 
				enemyButtonGrid[i][j].setBackground(Color.BLUE);
				enemyPanel.add(enemyButtonGrid[i][j]);
				enemyButtonGrid[i][j].addActionListener(enemyGridButtonListener);
			}
		}
	    
	    //GAME BUTTONS PANEL
	    JPanel gameButtonsPanel = new JPanel();
	    JPanel mainMenuButtonPanel = new JPanel();
	    JPanel helpButtonPanel = new JPanel();
	    JPanel restartButtonPanel = new JPanel();
	    JPanel abilityButtonPanel = new JPanel();
	    gameButtonsPanel.setLayout(new GridLayout(10,1));
	    
	    mainMenuButton = new JButton("Main Menu");
	    helpButton = new JButton("Help");
	    restartButton = new JButton("Restart");
	    abilityButton = new JButton("Ability");
	    abilityButton.setBackground(Color.GREEN);
	    
	    mainMenuButton.addActionListener(new SideButtonsListener());
	    helpButton.addActionListener(new SideButtonsListener());
	    restartButton.addActionListener(new SideButtonsListener());
	    abilityButton.addActionListener(new SideButtonsListener());
	    
	    
	    gameButtonsPanel.add(mainMenuButton);
	    gameButtonsPanel.add(helpButton);
	    gameButtonsPanel.add(restartButton);
	    gameButtonsPanel.add(abilityButton);
	    
	    getContentPane().add(userPanel, BorderLayout.WEST);
	    getContentPane().add(enemyPanel, BorderLayout.CENTER);
	    getContentPane().add(gameButtonsPanel,BorderLayout.EAST);
	    getContentPane().add(titlePanel, BorderLayout.NORTH); 
	    
	    this.setVisible(true);
		
	}
	
	private class UserButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i, j;
			Object source = e.getSource();
			
			for(i = 0; i < 10; i++) {
				for(j = 0; j < 10; j++){
					if (source == userButtonGrid[i][j]) {
						//FIXME
						//place(i,j);
						//setShip(Coordinate frontCoordinate, GameBoard Board)
						//But we first have to know what ship it is. 
						return;
					}
				}
			}
		}
	}
	
	private class EnemyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i, j;
			Object source = e.getSource();
			
			for(i = 0; i < 10; i++) {
				for(j = 0; j < 10; j++){
					if (source == enemyButtonGrid[i][j]) {
						//FIXME
						//shoot(i,j);
						return;
					}
				}
			}
		}
	}
	
	private class SideButtonsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
		    
			if (source == mainMenuButton) {
				//FIXME
			}
			else if (source == helpButton) {
				//FIXME
			}
			else if (source == restartButton) {
				//FIXME
			}
			else if (source == abilityButton) {
				//FIXME
			}
		}
	}
	
}

