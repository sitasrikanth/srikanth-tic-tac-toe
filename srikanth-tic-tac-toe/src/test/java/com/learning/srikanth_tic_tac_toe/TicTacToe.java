package com.learning.srikanth_tic_tac_toe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

		private String playerName = null;
		int matrix = 3;
		String playerSymbol = null;
		Scanner scan = new Scanner(System.in);
		String computerSymbol = null;
		String[][] board = new String[matrix][matrix];
		int playerPosition =0;
		int computerPosition =0;
		
		String[][] newBoard = new String[3][3];	
		String playerI_P = null;
		String computerI_P = null;	
		

		public static void main(String args[]) {
			TicTacToe titactoe = new TicTacToe();
			
			titactoe.welcome();
			titactoe.enterYourDetails();
			titactoe.createMatrix();
			titactoe.printmatrix();	
			titactoe.playGame();
			System.out.println("test");
		}
		
		
		private void playGame() {
			printmatrix();
			while (true) {
				boolean isUserPositionValid = false;
				System.out.println(playerName+ " please, enter your matrix position");
				playerI_P = scan.next();
				int I = Integer.parseInt(playerI_P.substring(0, 1));
				int J = Integer.parseInt(playerI_P.substring(2));
				isUserPositionValid = checkUserInputPosition(I, J);
				if(isUserPositionValid) {
					userPlay(I, J);
					computerPlay();
				}

			}

		}

		private void userPlay(int I, int J) {
			boolean isPlayerMoveDone = false;
			for (int i = 0; i < newBoard.length; i++) {
				for (int j = 0; j < newBoard[i].length; j++) {
					if (i == I - 1 && j == J - 1) {
						newBoard[i][j] = playerSymbol;
						isPlayerMoveDone  = true;
						break;
					}
				}
				if (isPlayerMoveDone  == true)
					break;
					
			}
			printmatrix();
		}
		
		private void computerPlay() {
			boolean isComputerMoveDone = false;
			int i; int j;
			 while(!isComputerMoveDone) {
				 i =0; j=0;
				 if(newBoard[1][1]==null) {
					 newBoard[1][1] = computerSymbol;
					 isComputerMoveDone = true;
				 }else {
					 i = Integer.parseInt(generateRandomNo(3,0));
					 j = Integer.parseInt(generateRandomNo(3,0));
					 if(newBoard[i][j]==null) {
						 newBoard[i][j]=computerSymbol;
						 isComputerMoveDone = true;
					 }
					 
				 }
				 
			 }
			printmatrix();
		}

		private boolean checkUserInputPosition(int I, int J) {
			boolean isUserPositionValid = false;
			for (int i = 0; i < newBoard.length; i++) {
				for (int j = 0; j < newBoard[i].length; j++) {
					if ((i == I - 1 && j == J - 1) && newBoard[i][j] ==null) {
						isUserPositionValid  = true;
						break;
					}
				}
				if (isUserPositionValid  == true)
					break;				
			}
			if (isUserPositionValid  == false){
				System.out.println("Error!!, Please enter correct position ");
			}
			return isUserPositionValid;
		}
		
		
		private void printmatrix(){
			  System.out.println("---------------------");
			  System.out.println("Tic Tac Toe");
			  System.out.println("---------------------");
			  for(int i=0;i<newBoard.length;i++) {
				  int s=1;
				  for(int j=0;j<newBoard[i].length;j++) {
					//  newBoard[i][j]= (i+1)+"x"+(j+1);
					  System.out.print(newBoard[i][j] + "| \t");
				  }
				  System.out.println();
				  	  
			  }
			//System.out.println("hai");
			  System.out.println("=============================");		
		}
		
		
		
		
		
		
		private String generateRandomNo(int max, int min) {
			Random random = new Random();
			int no = random.nextInt(max - min) + min;
			return String.valueOf(no);
			
		}	
		
		private void welcome() {
			System.out.println("=====================================");
			System.out.println("Hello, Lets play the game Tic Tac Toe");
			System.out.println("=====================================");
		}
		
		
		private void enterYourDetails() {		
			System.out.println("Please enter your name");	
			playerName = scan.nextLine();
			System.out.println("Please enter your symbol; * or 0");
			SymbolSelection();
			System.out.println("Let's start the Game.. \n Good Luck !! \t"+playerName);
			
		}
		
		private void SymbolSelection() {		
			//asking the user for symbol selection
			playerSymbol = scan.next();
			if(playerSymbol.contains("*"))
				computerSymbol = "0";
			else
				computerSymbol = "*";	
		}	
		
		private boolean isMatrixEnd(int no) {
			if(no==3) 
				return true;
			else
				return false;
					
		}
		
		private void createMatrix() {
			for(int i=1; i<=matrix;i++)
			{			
				for(int j=1;j<=matrix;j++) {
					board[i-1][j-1] = String.valueOf(i+j);
				}
						
			}		
		}
		


}
