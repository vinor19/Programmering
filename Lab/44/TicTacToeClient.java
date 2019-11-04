import java.util.Scanner;
import java.util.Random;

public class TicTacToeClient {

    private static TicTacToe board;
    private static String nameX, nameO;
    private static Scanner input;
    /*
     * Initialization.
     */
    private static void init() {
        board = new TicTacToe();
        System.out.print("Who is playing X? ");
        nameX = input.nextLine().trim();
        System.out.print("Your opponent is ");
        nameO = "Hr. Robot";
    }

    /*
     * Main program.
     */
    /*public static void main(String[] args) {
        input = new Scanner(System.in);
        init();
        boolean goOn = true;
        while (goOn) {
            // play
            System.out.println("It is "+(board.nextPlayer()=='X' ? nameX : nameO)+"'s turn.");
            System.out.println("Current board state:");
            System.out.println(board);
            int cell;
            do {
                System.out.print("Where do you want to play? ");
                cell = input.nextInt();
                if ((cell < 1) || (cell > 9))
                    System.out.println("Invalid cell number.");
                else if (!board.isFree(cell))
                    System.out.println("That cell is not free.");
            } while ((cell < 1) || (cell > 9) || !board.isFree(cell));
            board.play(cell);
            goOn = false;
            if (board.hasWon('X'))
                System.out.println(nameX + " has won.");
            else if (board.hasWon('O'))
                System.out.println(nameO + " has won.");
            else if (board.isFull())
                System.out.println("We have a draw :-(");
            else
                goOn = true;
        }
        input.close();
    }*/
	
	public static void main(String[] args){
		input = new Scanner(System.in);
        init();
        boolean goOn = true;
		while(goOn){
			System.out.println("It is "+nameX+"'s turn.");
			System.out.println("Current board state:");
			System.out.println(board);
			int cell;
            do {
                System.out.print("Where do you want to play? ");
                cell = input.nextInt();
                if ((cell < 1) || (cell > 9))
                    System.out.println("Invalid cell number.");
                else if (!board.isFree(cell))
                    System.out.println("That cell is not free.");
            } while ((cell < 1) || (cell > 9) || !board.isFree(cell));
            board.play(cell);
            goOn = false;
            if (board.hasWon('X'))
                System.out.println(nameX + " has won.");
            else if (board.hasWon('O'))
                System.out.println(nameO + " has won.");
            else if (board.isFull())
                System.out.println("We have a draw :-(");
            else{
				System.out.println("It is "+(board.nextPlayer()=='X' ? nameX : nameO)+"'s turn.");
				System.out.println("Current board state:");
				System.out.println(board);
				
				//autoPlayerMoveSimple(board);
				
				autoPlayerMoveAdvanced(board);
				
				goOn = false;
				if (board.hasWon('X'))
					System.out.println(nameX + " has won.");
				else if (board.hasWon('O'))
					System.out.println(nameO + " has won.");
				else if (board.isFull())
					System.out.println("We have a draw :-(");
				else
					goOn = true;
			}
				
                
		}
	}
	
	//Random
	private static void autoPlayerMoveSimple(TicTacToe board){
		Random r = new Random();
		int cell = 0;
		do {
		cell = r.nextInt(8)+1;
			System.out.println(cell);
		} while ((cell < 1) || (cell > 9) || !board.isFree(cell));
		board.play(cell);
		System.out.println("Your opponent chose: " + cell);
	}
	
	//No lose
	private static void autoPlayerMoveAdvanced(TicTacToe board){
		boolean winNext = false;
		int i = 0;
		int winAt = 0;
		while (i<10){
			if (board.isFree(i)){
				board.board[i] = 'O';
				if (board.hasWon('O')){
					winNext = true;
					winAt=i;
				}
				board.board[i] = '-';
			}
			i = i + 1;
		}
		if (winNext)
			board.play(winAt);
		else{
			boolean loseNext = false;
			int j = 0;
			int loseAt = 0;
			while (j<10){
				if (board.isFree(j)){
					board.board[j] = 'X';
					if (board.hasWon('X')){
						loseNext = true;
						loseAt=j;
					}
					board.board[j] = '-';
				}
				j = j + 1;
			}
			if (loseNext)
				board.play(loseAt);
			else{
				Random r = new Random();
				int cell = 0;
				do {
				cell = r.nextInt(8)+1;
					System.out.println(cell);
				} while ((cell < 1) || (cell > 9) || !board.isFree(cell));
				board.play(cell);
				System.out.println("Your opponent chose: " + cell);
			}
		}
	}    
}