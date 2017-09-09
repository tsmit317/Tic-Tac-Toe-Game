import java.util.*;
/**
 * TicTacToe game for ITCS 1213 - Intro to Computer Science II. 
 * Class Board contains all of the methods for the game. 
 * 
 * @author (Taylor Smith) 
 * @version (a version number or a date)
 */
public class Board
{
   char [ ] [ ] gameBoard;
   
   /**
    * Constructor for class Board. Initializes a 3x3 2D array to be used as a game board for TicTacToe
    */
   public Board( )
   {
       gameBoard = new char[3][3];
       for(int row = 0; row < 3; row++)
        for(int col = 0; col < 3; col++)
            gameBoard[row][col] = '-';
   }
   
   /**
    * checkForWin - Overloaded method checks board to see if player has connected three marks vertically, horizontally, or diagonally.
    * 
    * @param marker - The players (comp or user) 'X' or 'O'
    * @param board - 3x3 2D Array used as game board
    * @return boolean for win 
    */
   public boolean checkForWin (char marker, char[ ][ ] board)
   {
	   System.out.println("In CFW2P");
       boolean isAWinner = false;
       int consecutive;
       int revConsecutive;
       
       consecutive = 0;
       revConsecutive = 0;
       
       for(int row = 0; row < 3 && consecutive != 3; row++)
       {
	         consecutive = 0;
	         for(int col = 0; col < 3; col ++)
	         {
		          if(board[row][col] == marker)
		          {
		             consecutive++;
		          }
	         }
	         
	         if (consecutive == 3)
	         {
	        	 isAWinner = true;
	         }
       }
       
       if(!isAWinner)
       {
          for(int col = 0; col < 3 && consecutive != 3; col++)
          {
             consecutive = 0;
             for(int row = 0; row < 3; row ++)
             {
	             if(board[row][col] == marker)
	             {
	                consecutive++;
	             }
             }
           }
          
           if(consecutive == 3)
           {
              isAWinner = true;
           }
        }
        else if(!isAWinner)
        {
        	if((board[0][0] == marker && board[1][1] == marker && board[2][2] == marker)
        			|| (board[2][0] == marker && board[1][1] == marker && board[0][2] == marker)){
        		isAWinner = true;
        	}
        	
        /*Note: I realized I could just hard code the diagonals after I wrote the code below*/
//        	for(int col = 0; col < 3 && consecutive != 3; col++)
//            {
//              consecutive = 0;
//              if(board[col][col] == marker)
//              {
//                 consecutive++;
//              }
//            }
//        	
//            if(consecutive == 3)
//            {
//               isAWinner = true;
//            }
//            else{
//            	
//            	for(int row = 2; row >=0 && consecutive != 3; row--)
//                {
//            		// 00 01 02
//            		// 10 11 12
//            		// 20 21 22
//                  consecutive = 0;
//                  int col = 0;
//                  if(board[row][col] == marker)
//                  {
//                     consecutive++;
//                  }
//                  col++;
//                }
//            	if(consecutive == 3)
//                {
//                   isAWinner = true;
//                }
//            }
//        }
        
        }
       
       return isAWinner;
    } 
    
   /**
    * checkForWin - Overloaded method checks board to see if player has connected three marks vertically, horizontally, or diagonally.
    * @param marker - The players (comp or user) 'X' or 'O'
    * @return boolean whether three marks were connected
    */
     public boolean checkForWin (char marker)
   {
       boolean isAWinner = false;
       int consecutive;
       int row;
       int col;
       System.out.println("IN check1P");
       consecutive = 0;
       //Check each Row
       for( row = 0; row < 3 && consecutive != 3; row++)
       {
          	System.out.println("check row");

         consecutive = 0;
         for(col = 0; col < 3; col ++)
         {
           if(gameBoard[row][col] == marker)
              consecutive++;
         }
       }
       if (consecutive == 3)
       {
         isAWinner = true;
       }
       
       // Check each column
       if(!isAWinner)
       {
          	System.out.println("check col");

          for(col = 0; col < 3 && consecutive != 3; col++)
           {
             consecutive = 0;
             for(row = 0; row < 3; row ++)
             {
               if(gameBoard[row][col] == marker){
                 consecutive++;
               }
             }
           }
          if(consecutive == 3)
          {
        	  isAWinner = true;
          }
       }
       //Check Diagonal
       if(!isAWinner)
       {
       	System.out.println("check diag");

       		if((gameBoard[0][0] == marker && gameBoard[1][1] == marker && gameBoard[2][2] == marker)
       		  ||(gameBoard[2][0] == marker && gameBoard[1][1] == marker && gameBoard[0][2] == marker))
       		{
       		   isAWinner = true;
       		}
       }
       return isAWinner;
    } 
    
    /**
     * computerMove - Method used to place computers mark. Checks to see where empty spaces are, then randomly chooses a position. 
     * @param marker - The players (comp or user) 'X' or 'O'
     */
    public void computerMove(char marker)
    {
        boolean canComputerWin = false;
        char[ ][ ] copyBoard;
        int row;
        int col;
        int tryRow;
        int tryCol;
        row = 0;
        col = 0;
        
       //Check for a win in a row     
       for(row= 0; row < 3 && !canComputerWin; row++)
       {
           for(col = 0; col < 3 && !canComputerWin; col++)
           {
        	   // Looks for blank space in row.
               if(gameBoard[row][col] == '-')
               {
            	 // If there is, it copies the board and sets its marker in the empty space.
                 copyBoard = copyTheBoard( );
                 copyBoard[row][col] = marker;
                 canComputerWin = checkForWin(marker, copyBoard);
               }
           }
        }
        
        if(!canComputerWin)
        {
           for(col = 0; col< 3 && !canComputerWin; col++)
           {
              for(row = 0; row < 3 && !canComputerWin; row++)
              {
                 if(gameBoard[row][col] == '-')
                 {
                   copyBoard = copyTheBoard( );
                   copyBoard[row][col] = marker;
                   canComputerWin = checkForWin(marker, copyBoard);
                  }
               }
            }
        }
       
        if(canComputerWin){
           gameBoard[row-1][col-1] = marker;
        }
        else
        {
            boolean placed = false;
            Random rand = new Random();
        	
            do
            {
            	tryRow = rand.nextInt(3);
            	tryCol = rand.nextInt(3);
            	if(gameBoard[tryRow][tryCol] == '-')
            	{
            		gameBoard[tryRow][tryCol] = marker;
            		placed = true;
            	}
            }	while(!placed);
         }
          
      }
      
     /**
      * humanMoveOK - Method determines if a users selected move is within the games parameters. 
      * In other words, checks to make sure the numbers are between 1 and 3 since the board is 3x3
      * @param row - Row 1 - 3
      * @param col - Column 1 - 3
      * @return boolean 
      */
     public boolean humanMoveOK(int row, int col)
     {
          return row <= 3 && col <= 3 && gameBoard[row-1][col-1] == '-';
     }
      
     /**
      * makeMove - Method places users mark on the board.
      * @param row - Row 1 - 3
      * @param col - Column 1 - 3
      * @param marker - The players (comp or user) 'X' or 'O'
      */
     public void makeMove(int row, int col, char marker)
     {
        gameBoard[row-1][col-1] = marker;
     }
               
     /**
      * copyTheBoard - Method copies global game board array to local array. 
      * Used when checking computers choice.        
      * @return array - Copied 2D array game board. 
      */
     private char[ ][ ] copyTheBoard( )
     {
         char [ ][ ] temp = new char[3][3];
         for(int row = 0; row < 3; row++)
         {
        	 for(int col = 0; col < 3; col++)
        	 {
        		 temp[row][col] = gameBoard[row][col];
        	 }
         }
         return temp;
     }
     
    /**
     * isDraw - Method checks the game board to see if the game is a draw. 
     * Very simple, just checks if there are any free spaces.          
     * @return boolean - true if there's a draw 
     */
    public boolean isADraw()
    {
    	boolean isDraw = true;
    	for(int row = 0; row < 3; row++)
    	{
    		for(int col = 0; col < 3; col++)
    		{
    			if(gameBoard[row][col] == '-')
    			{
    				isDraw = false;
    			}
    		}
    	}
    	
    	return isDraw;
    }
     
    /**
     * toString - Method prints a visual of the game board.
     * @return String - Visual representation of a TicTacToe board
     */
     public String toString( )
     {
         String result = "";
         int row;
         int col;
         result += "    1  2   3\n";
         for(row = 0; row < 3; row++)
         {
             result += "\n" + (row+1);
             for(col = 0; col < 3; col++)
             { 
              
               result += "  " + gameBoard[row][col] + " ";
              
             }
           
         }
         return result;
     }     
             
         
         
          
   
   
}