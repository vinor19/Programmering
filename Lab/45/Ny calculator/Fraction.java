public class Fraction{

	private int numerator, denominator;
	
	/*
	 * Constructor ud fra ingen heltal
	 */
	public Fraction(){
		numerator = 1;
		denominator = 1;
	}
	
	/*
	 * Constructor der laver ud fra et heltal.
	 */
	public Fraction(int numerator){
		this.numerator = numerator;
		denominator = 1;
	}
	
	/*
	 * Constructor der laver ud fra to heltal.
	 */
	public Fraction(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/*
	 * Getters
	 */
	public int numerator(){
		return numerator;
	}
	
	public int denominator(){
		return denominator;
	}
	
	/*
	 * Ingen setters
	 */
	
	/*
	 * En metode der laver adition af to brøker
	 */
	public Fraction add(Fraction f){
		return new Fraction(this.numerator*f.denominator() + f.numerator*this.denominator, this.denominator*f.denominator);
	}
	
	/*
	 * En metode der laver trækker to brøkere fra hinanden
	 */
	public Fraction subtract(Fraction f){
		return new Fraction(this.numerator*f.denominator() - f.numerator*this.denominator, this.denominator*f.denominator);
	}
	
	/*
	 * En metode der laver multiplikation af to brøker
	 */
	public Fraction multiply(Fraction f){
		return new Fraction(this.numerator*f.numerator,this.denominator*f.denominator);
	}
	
	/*
	 * En metode der laver division af to brøker
	 */
	public Fraction divide(Fraction f){
		return new Fraction(this.numerator*f.denominator,this.denominator*f.numerator);
	}
	
	/*
	 * Simplificere brøken
	 */
	public void simplify(){
		int i = 2;
		while (i<=Math.min(numerator, denominator)){
			if (numerator%i == 0 && denominator%i == 0){
				numerator = numerator/i;
				denominator = denominator/i;
			}else
				i=i+1;
		}
	}
	
	/*
	 * Returnere værdien af brøkeren som en double
	 */
	public double value(){
		return (double)numerator/denominator;
	}
	
	/*
	 * Returnere heltaldelen af brøkeren
	 */
	public int integerPart(){
		return numerator/denominator;
	}
	
	/*
	 * Returnere brøkdelen af brøkeren
	 */
	public Fraction properPart(){
		this.simplify();
		return new Fraction(numerator%denominator, denominator);
	}
	
	/*
	 * To string overskrevet
	 */
	public String toString(){
		return "" + numerator + "/" + denominator;
	}
	
	/*
	 * Tjekker om to fractions er ens
	 */
	public boolean equals(Object o){
	if (this==o)
		return true;
	if (o == null)
		return false;
	if (!(o instanceof Fraction))
		return false;
	Fraction other = (Fraction)o;
	return ((this.denominator == other.denominator) && 
		(this.numerator == other.numerator));
	}
	
	/*
	 * laver en kopi
	 */
	public Fraction copy(){
		return new Fraction(numerator, denominator);
	}
	
	/*
	 * overskriv hashCode
	 */
	public int hashCode(){
		return numerator+denominator*31;	
	}
}