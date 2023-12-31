package com.MiniGame.TicTacToe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class TicTacToe implements ActionListener{
	private JFrame jf;
	private JPanel jp;
	private JLabel l1;
	JButton[] button= new JButton[9];
	JButton reset;
	private boolean player1;
	private boolean gamestatus= false;
	Random rand= new Random();
	
	TicTacToe() {
		jf= new JFrame("TicTacToe");
		jf.setSize(600,600);
		jf.setDefaultCloseOperation(3);
		jf.setLayout(new BorderLayout());
		
		l1= new JLabel();
		l1.setText("Welcome");
		l1.setForeground(new Color(45, 28, 110));
		l1.setFont(new Font("Brusher", Font.BOLD, 70));
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setPreferredSize(new Dimension(600,100));
		jf.add(l1, BorderLayout.NORTH);
		
		jp= new JPanel();
		jp.setLayout(new GridLayout(3,3));
		for (int i=0; i<9; i++) {
			button[i]= new JButton();
			button[i].addActionListener(this);
			jp.add(button[i]);
			button[i].setForeground(new Color(45, 28, 110));
			button[i].setFont(new Font("Ink Free", Font.BOLD, 60));
		}
		jf.add(jp, BorderLayout.CENTER);
		
		reset= new JButton("Reset");
		reset.addActionListener(this);
		reset.setForeground(new Color(45, 28, 110));
		reset.setFont(new Font("Ink Free", Font.BOLD, 60));
		jf.add(reset, BorderLayout.SOUTH);
		
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		
		firstTurn();	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TicTacToe();
	}
	
	private void firstTurn(){	
		
		//randomly generate 2 numbers to determine who gets to go first
		if (rand.nextInt(2)==0) {
			player1=true;
			l1.setText("X's Turn");
		}else {
			player1=false;
			l1.setText("O's Turn");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (!gamestatus) {
			for (int i=0; i<9; i++) {
				if (e.getSource()==button[i]) {
					if (player1) {
						if (button[i].getText().isEmpty()) {
							button[i].setText("X");
							player1=false;
							l1.setText("O's Turn");
							checkWin();
						}
					}else {
						if (button[i].getText().isEmpty()) {
							button[i].setText("O");
							player1=true;
							l1.setText("X's Turn");
							checkWin();
						}
					}
				}
			}
		}
		
		if (e.getSource()==reset) {
			resetGame();
		}
	}

	private void resetGame() {
		// TODO Auto-generated method stub
		for (int i=0; i<9; i++) {
			button[i].setText("");
			button[i].setBackground(null);
		}
			
		gamestatus=false;
		firstTurn();
	}

	public void checkWin() {
		//conditions to check if X won
		if (button[0].getText()=="X" 
				&& button[1].getText()=="X" 
					&& button[2].getText()=="X") {
			xLineSet(0,1,2);
			
		}
		if (button[3].getText()=="X" 
				&& button[4].getText()=="X" 
					&& button[5].getText()=="X") {
			xLineSet(3,4,5);
		}
		if (button[6].getText()=="X" 
				&& button[7].getText()=="X" 
					&& button[8].getText()=="X") {
			xLineSet(6,7,8);
		}
		if (button[0].getText()=="X" 
				&& button[3].getText()=="X" 
					&& button[6].getText()=="X") {
			xLineSet(0,3,6);
		}
		if (button[1].getText()=="X" 
				&& button[4].getText()=="X" 
					&& button[7].getText()=="X") {
			xLineSet(1,4,7);
		}
		
		if (button[2].getText()=="X" 
				&& button[5].getText()=="X" 
					&& button[8].getText()=="X") {
			xLineSet(2,5,8);
		}
		if (button[0].getText()=="X" 
				&& button[4].getText()=="X" 
					&& button[8].getText()=="X") {
			xLineSet(0,4,8);
		}
		if (button[2].getText()=="X" 
				&& button[4].getText()=="X" 
					&& button[6].getText()=="X") {
			xLineSet(2,4,6);
		}
		
		
		//conditions to check if O won
		if (button[0].getText()=="O" 
				&& button[1].getText()=="O" 
					&& button[2].getText()=="O") {
			oLineSet(0,1,2);
		}
		if (button[3].getText()=="O" 
				&& button[4].getText()=="O" 
					&& button[5].getText()=="O") {
			oLineSet(3,4,5);
		}
		if (button[6].getText()=="O" 
				&& button[7].getText()=="O" 
					&& button[8].getText()=="O") {
			oLineSet(6,7,8);
		}
		if (button[0].getText()=="O" 
				&& button[3].getText()=="O" 
					&& button[6].getText()=="O") {
			oLineSet(0,3,6);
		}
		if (button[1].getText()=="O" 
				&& button[4].getText()=="O" 
					&& button[7].getText()=="O") {
			oLineSet(1,4,7);
		}
		
		if (button[2].getText()=="O" 
				&& button[5].getText()=="O" 
					&& button[8].getText()=="O") {
			oLineSet(2,5,8);
		}
		if (button[0].getText()=="O" 
				&& button[4].getText()=="O" 
					&& button[8].getText()=="O") {
			oLineSet(0,4,8);
		}
		if (button[2].getText()=="O" 
				&& button[4].getText()=="O" 
					&& button[6].getText()=="O") {
			oLineSet(2,4,6);
		}
	}
	
	public void xLineSet(int a, int b, int c) {
		/* if the any of conditions from checkWin() is true 
		   then it passes the button index values as parameters to highlight
		   the alignment of button positions
		*/
		
		button[a].setBackground(new Color(230, 172, 202));
		button[b].setBackground(new Color(230, 172, 202));
		button[c].setBackground(new Color(230, 172, 202));
		gamestatus= true; //Disables the user from interacting with the game any further
		
	
	}
	
	public void oLineSet(int a, int b, int c) {
		/* if the any of conditions from checkWin() is true 
	 	   then it passes the button index values as parameters to highlight
	 	   the alignment of button positions
		*/
		
		button[a].setBackground(new Color(230, 172, 202));
		button[b].setBackground(new Color(230, 172, 202));
		button[c].setBackground(new Color(230, 172, 202));
		gamestatus= true; //Disables the user from interacting with the game any further
	}
}
