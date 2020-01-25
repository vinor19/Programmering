public class AutoPlayer extends Player{
	
	public Player player;
	
	public AutoPlayer(String name){
		super(name);
	}

	public Card next(){
		return hand()[0];
	}   

	public Card next(Card card){
		return hand()[0];
	}
}