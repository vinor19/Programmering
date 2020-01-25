public class Board{
	
	//Definerer attributter
	private Player player1;
	private Player player2;
	private Deck deck;
	private Card trumpCard;
	private Player next;
	private int moves;
	
	/* Tager to spillere som argument, laver et nyt spil med de to spillere, 40 kort
	 * i bunken, samt sætter værdierne next og moves til deres standardværdier.
	 * Efter alt dette sættes trumfkortet til det øverste kort, og der gives tre
 	 * kort til hver spiller fra bunken.
	 */
	public Board(Player player1, Player player2){
		this.player1 = player1;
		this.player2 = player2;
		this.deck = new Deck();
		this.trumpCard = this.deck.next();
		this.next = player1;
		this.moves = 0;
		
		for(int i = 0; i < 3; i++){
			this.player1.addToHand(this.deck.next());
			this.player2.addToHand(this.deck.next());
		}
	}
	
	//Getter for next
	public Player next(){
		return this.next;
	}
	
	//Getter for trumpCard
	public Card trumpCard(){
		return this.trumpCard;
	}
	
	//Retunerer true hvis spillet er slut (hvis moves >= 20)
	public boolean gameOver(){
		return moves >= 20;
	}
	
	/* Denne funktion spiller card1 fra next, og card2 fra den anden spiller. 
	 * Flytter kortene til collectedCards hos den spiller der vandt, og giver
	 * nye kort (hvis der er flere). Opdaterer next til den spiller der vandt
	 * runden.
	 */
	public Player move(Card card1, Card card2){
		//Finder ud af hvem 'den anden' spiller er.
		Player other = player1 == this.next ? player2 : player1;
		
		//Bruger ternary statements til definere og initialisere winner og loser.
		/*Player winner = card1.isHigherThan(card2) ? next : other;
		Player loser = card2.isHigherThan(card1) ? next : other;
		*/
		Player winner;
		Player loser;
		if (card1.suit == trumpCard.suit){
			if(card2.suit == trumpCard.suit){ //Begge er trumfkort, så vi kigger på værdien af kortene
				winner = card1.isHigherThan(card2) ? next : other;
				loser = card1.isHigherThan(card2) ? other : next;
			}
			else{ //card2.suit != trumpCard.suit
				//card1 er et trumfkort og det er card2 ikke, så card1 vinder
				winner = next;
				loser = other;
			}
		}
		else if (card2.suit == trumpCard.suit){ 
			//card2 er et trumfkort og det er card1 ikke, så card2 vinder
			winner = other;
			loser = next;
		}
		else if (card1.suit != card2.suit){ 
			//her er ingen af dem trumf, men card2 er ikke samme kulør som card1, hvilket gør card1 vinder
			winner = next;
			loser = other;
		}
		else { //card1.suit == card2.suit, de er samme kulør, så der tjekkes hvilket kort der har højest værdi
			winner = card1.isHigherThan(card2) ? next : other;
			loser = card1.isHigherThan(card2) ? other : next;
		}
		//Flytter kort rundt
		winner.addToCollectedCards(card1);
		winner.addToCollectedCards(card2);
		this.next.removeFromHand(card1);
		other.removeFromHand(card2);
		if(!this.deck.isEmpty()){
			winner.addToHand(this.deck.next());
			if(!this.deck.isEmpty())
				loser.addToHand(this.deck.next());
			else
				loser.addToHand(this.trumpCard);
		}
		next = winner;
		moves = moves + 1;
		return winner;
	}
}
