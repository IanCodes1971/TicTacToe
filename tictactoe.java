//tictactoe
import java.util.*;
 
public class tictactoe 
{
	static String[] board; //tictactoe board
	//The idea of representing whose turn it is with a String came from the website.
    static String turn; //represents whose turn it is
	
	public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String win = null;
 
        for (int i = 0; i < 9; i++) 
		{
            board[i] = String.valueOf(i + 1);
        }
 
        System.out.println("Begin your 2 player game of Tic-Tac-Toe.");
        printBoard();
 
        System.out.println("X has the first turn. Enter a slot number to place an X in it:");
 
		//while no player has won do this
        while (win == null) 
		{
            int slot;
           
            //Exception handling.
            //slot will take input from user (1 to 9)
            //If it is not in range from 1 to 9 then it will say "Invalid input."
            try 
			{
                slot = input.nextInt();
                if (slot < 0 || slot > 9) 
				{
                    System.out.println("Invalid input; Please choose a valid slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) 
			{
                System.out.println("Invalid input; re-enter slot number:");
                continue;
            }
			
			//Deciding the turn.
            if (board[slot - 1].equals(String.valueOf(slot))) 
			{
                board[slot - 1] = turn;
 
                if (turn.equals("X")) 
				{
                    turn = "O";
                }
                else 
				{
                    turn = "X";
                }
 
                printBoard();
                win = checkWinner();
            }
            else 
			{
                System.out.println("Slot already taken; please choose a valid slot number:");
            }
        }
       
        //If no one wins or loses print draw case.
		//ignores win 
        if (win.equalsIgnoreCase("draw")) 
		{
            System.out.println("It's a draw! Thank you for playing.");
        }
       
        //Display win message
        else 
		{
            System.out.println(win + "'s win! Thank you for playing.");
        }
    }
	
	
   
    //switch statement that checks every combination of 3 in a row to check for a winner
    static String checkWinner()
    {
        for (int i = 0; i < 8; i++) 
		{
            String line = null;
			
			//heavily influenced by a website but I did write this myself
			//----------------------------------------------------------
            switch (i) 
			{
				case 0:
					line = board[0] + board[1] + board[2];
					break;
				case 1:
					line = board[3] + board[4] + board[5];
					break;
				case 2:
					line = board[6] + board[7] + board[8];
					break;
				case 3:
					line = board[0] + board[3] + board[6];
					break;
				case 4:
					line = board[1] + board[4] + board[7];
					break;
				case 5:
					line = board[2] + board[5] + board[8];
					break;
				case 6:
					line = board[0] + board[4] + board[8];
					break;
				case 7:
					line = board[2] + board[4] + board[6];
					break;
            }
			//------------------------------------------------------------
            
            if (line.equals("XXX")) //X wins if there are 3 Xs in a row
			{
                return "X";
            }
            else if (line.equals("OOO")) // O wins if there are 3 Xs in a row
			{
                return "O";
            }
        }
		
		//got this for loop from one of the websites in my works cited list
		//----------------------------------------------------------------------------
        for (int i = 0; i < 9; i++) 
		{
			//valueOf converts any data type to a string
			//asList turns the array into a list
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) 
			{
                break;
            }
			//if i=8 the board is full so it's a draw
            else if (i == 8) 
			{
                return "draw";
            }
        }
		//---------------------------------------------------------------------------
 
        //choosing a spot
        System.out.println("It's " + turn + "'s turn; enter a slot number to place "+ turn + " in:");
        return null;
    }
	
    //printing the board.
    /* |---|---|---|
       | 1 | 2 | 3 |
       |-----------|
       | 4 | 5 | 6 |
       |-----------|
       | 7 | 8 | 9 |
       |---|---|---|*/
   
   //the board
   //The idea for the way the board looks is from one of my sources, but I did this myself
    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }
}