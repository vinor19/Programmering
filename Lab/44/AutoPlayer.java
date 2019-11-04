import java.util.Random;

public class AutoPlayer{
	
	public String name;
	private TicTacToe board;
	
	public AutoPlayer(String name){
		this.name = name;		
	}
	
	public static void move(TicTacToe board){
		Random r = new Random();
		int cell = 0;
		do {
		cell = r.nextInt(8)+1;
			System.out.println(cell);
		} while ((cell < 1) || (cell > 9) || !board.isFree(cell));
		board.play(cell);
	}
}