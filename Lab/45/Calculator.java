import java.util.Scanner;

public class Calculator{

	private static Scanner reader;
	private static Fraction fraction;
	private static List list;
	
	public static void main(String[] args){
		reader = new Scanner(System.in);
		System.out.println("Lommeregner åben");

			System.out.println("Hvad skal beregnes: ");
			String udtryk = reader.nextLine().trim();
			List list = tokenize(udtryk);
			System.out.println(parseExpression(list));	
	}
	
	/*
	 * Tokenizes a given string
	 */
	private static List tokenize(String s){
			return new List(s.split(" "));
	}
	
	/*
	 * Parses expression
	 */
	private static Fraction parseExpression(List sum){
		Fraction result = parseMultiplication(sum);
		if(sum.isEmpty()){
			return result;
		}else if(sum.head().equals("+")){
			sum.tail();
			Fraction toAdd = parseExpression(sum);
			result = result.add(toAdd);
			System.out.println("Add " + result.toString());
			return result;
		}else if(sum.head().equals("-")){
			sum.tail();
			Fraction toSub = parseExpression(sum);
			result = result.subtract(toSub);
			System.out.println("Sub " + result.toString());
			return result;
		}else{
			return result;
		}
	}
	
	private static Fraction parseMultiplication(List sum){
		Fraction result = parseTerm(sum);
		if(sum.isEmpty())
			return result;
		else if(sum.head().equals("*")){
			sum.tail();
			Fraction toMultiply = parseMultiplication(sum);
			result = result.multiply(toMultiply);
			System.out.println("Multiply " + result.toString());
			return result;
		}else if(sum.head().equals("/")){
			sum.tail();
			Fraction toDivide = parseMultiplication(sum);
			result = result.divide(toDivide);
			System.out.println("Divide " + result.toString());
			return result;
		}else{
			return result;
		}
	}
	
	private static Fraction parseTerm(List sum){
		if(sum.head().equals("(")){
			sum.tail();
			Fraction result = parseExpression(sum);
			sum.tail();
			return result;
		}
		Fraction result = new Fraction(Integer.valueOf(sum.head()));
		sum.tail();
		return result;		
	}

}