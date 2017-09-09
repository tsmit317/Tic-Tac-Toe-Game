/**
 * Class Game is the Driver for the TicTacToe program. 
 */
import java.util.*;

public class Game
{
    public static void main(String[ ] args)
    {
    	// Parameters
        Scanner in;
        Random rand;
        char choice;
        int toss;
        int row;
        int col;
        boolean winner;
        char winMarker;
        boolean draw;
        
        Board tictactoe;
        
        final char humanMarker;
        final char computerMarker;
        
        in = new Scanner(System.in);
        winMarker = ' ';
        rand = new Random( );
        winner = false;
        draw = false;
        tictactoe = new Board( );
        
        // Prompts user to pick heads or tails.
        // Used to determine playing order.
        System.out.println("Pick (h)eads or (t)ails");
        choice = in.next( ).charAt(0);
        toss = rand.nextInt(2);
        if(toss == 1 && choice == 'h')
        {
        	humanMarker = 'X';
        	computerMarker = 'O';
        }
        else
        {
            humanMarker = 'O';
            computerMarker = 'X';
        }
        System.out.println("You are " + humanMarker + " and the computer is " + computerMarker);
      
        // X goes first. 
        // Since the computer goes first in the while loop below, we check to see if the user is 'X'. 
        if(humanMarker == 'X')
        {
        	// Gets user input. Keeps prompting user if row and column are out of range.
            do
            {
            	System.out.print("Enter a row 1 to 3: ");
            	row = in.nextInt( );
            	System.out.print("Enter a column 1 to 3: ");
            	col = in.nextInt( );
            }while(!tictactoe.humanMoveOK(row, col));
            tictactoe.makeMove(row, col, humanMarker);
        }
        System.out.println(tictactoe); // Print board
        
        
        // Loops until there's a winner or there is a draw (no more spaces)
        while(!winner && draw == false)
        {
        	// Checks for draw
        	if(tictactoe.isADraw())
        	{
        		System.out.println("Game is a draw!");
        		draw = true;
        	}
        	
        	// Computers move
            tictactoe.computerMove(computerMarker);
            System.out.println("____________________________\n");
            System.out.println(tictactoe);
            
            // Checks for computer win
            winner = tictactoe.checkForWin(computerMarker);
            if(winner)
            {
              winMarker = computerMarker;
            }
            
            else 
            {
            	// Check for draw
            	if(tictactoe.isADraw())
            	{
            		System.out.println("Game is a draw!");
            		draw = true;
            	}
            	
            	// Prompt user for input
	            do
	            {
	            	System.out.print("Enter a row 1 to 3: ");
	            	row = in.nextInt( );
	            	System.out.print("Enter a column 1 to 3: ");
	            	col = in.nextInt( );
	            }while(!tictactoe.humanMoveOK(row, col));
	            
	            // Users move
	            tictactoe.makeMove(row, col, humanMarker);
	            
	            // Check for user win
	            winner = tictactoe.checkForWin(humanMarker);
	            
	            if(winner)
	            {
	               winMarker = humanMarker;
	            }
	            
	            if(tictactoe.isADraw())
	        	{
	        		System.out.println("Game is a draw!");
	        		draw = true;
	        	}
	        	
           }
          
        }//end of while loop for game 
        
        // Prints winner 
        if(!draw)
        {
	         System.out.println("___________________________");
	         System.out.println(tictactoe + "\n");
	         System.out.println("***********\n      " +winMarker + " wins!");
	    }
       
    } //end of main()
        
}