package XO_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class XO_game extends JFrame implements ActionListener{

	Random random = new Random(); //to check who will begin the game
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	Boolean player1_turn;
	//we can add Boolean player2_turn but if player1_turn is False player2_turn will be True 
	public XO_game() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.getContentPane().setBackground(new Color(50,50,50));
		this.setLayout(new BorderLayout());
		//initialize title of the game
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free",Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("XO game");
		textField.setOpaque(true);
		//add textField to textPanel and add textPanel to the frame
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,800,100);//(x,y,width,height)
		titlePanel.add(textField);
		this.add(titlePanel,BorderLayout.NORTH);//we resize the frame and the content will adjust to the new size
		//work on buttonPanel and add it to the frame
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		for(int i =0;i<9;i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV BOli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			//it means that the button cannot receive the focus when using keyboard navigation or other focus-related operations.
			buttons[i].addActionListener(this);
		}
		this.add(buttonPanel);
		
		this.setVisible(true);
		this.firstTurn();
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource() == buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText() == "") {
						//buttons[i].getText() == "" condition to allow to players click into button just one time
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn = false;
						textField.setText("O turn");
						this.check();//after each step we have to check if the game is over or not
					}
				}
				else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn = true;
						textField.setText("X turn");
						this.check();
					}
					
				}
			}
		}
		
	}
	
	public void firstTurn() {
		//to dispaly "XO game" before generate the first player
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			//random.nextInt(2) Generates a random integer between 0 and 2 exclusive.
			player1_turn = true;
			textField.setText("X turn");
		}
		else {
			player1_turn = false;
			textField.setText("O turn");
		}
	}
	
	public void check() {
		//Check X win conditions
		if((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
			xWins(0, 1, 2);	
		}
		if((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
			xWins(3, 4, 5);	
		}
		if((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
			xWins(6, 7, 8);	
		}
		if((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
			xWins(0, 3, 6);	
		}
		if((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
			xWins(1, 4, 7);	
		}
		if((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
			xWins(2, 5, 8);	
		}
		if((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
			xWins(0, 4, 8);	
		}
		if((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
			xWins(2, 4, 6);	
		}
		//Check O win conditions
		if((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
			oWins(0, 1, 2);	
		}
		if((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))) {
			oWins(3, 4, 5);	
		}
		if((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			oWins(6, 7, 8);	
		}
		if((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
			oWins(0, 3, 6);	
		}
		if((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
			oWins(1, 4, 7);	
		}
		if((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			oWins(2, 5, 8);	
		}
		if((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			oWins(0, 4, 8);	
		}
		if((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
			oWins(2, 4, 6);	
		}
		//check if no one wins
		Boolean winnerExist = false;
		int i = 0;
		while(!winnerExist && i<9) {
			if(!buttons[i].getText().equals(""))
				i++;
			else
				winnerExist = true;
		}
		if(!winnerExist) {
			for(i=0;i<9;i++)
				buttons[i].setEnabled(false);
			textField.setText("No one wins!");
		}
	}

	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		//stop playing
		for(int i=0;i<9;i++)
			buttons[i].setEnabled(false);
		textField.setText("X wins");
	}

	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		//stop playing
		for(int i=0;i<9;i++)
			buttons[i].setEnabled(false);
		textField.setText("O wins");
	}
}


