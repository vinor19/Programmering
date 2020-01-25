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
		try{
		Fraction f = parseExpression(list);
		System.out.println(f);
		f.simplify();
		System.out.println(f);
		System.out.println(f.value());
		System.out.println("Lavet om til et heltal + broek " + f.integerPart() + " + " + f.properPart());
		}catch(IncorrectInputException e){
			System.out.print(e.getMessage());
		}
		
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
	private static Fraction parseExpression(List sum)throws IncorrectInputException{
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
	
	private static Fraction parseMultiplication(List sum)throws IncorrectInputException{
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
	
	private static Fraction parseTerm(List sum) throws IncorrectInputException{
		if(sum.head().equals("(")){
			sum.tail();
			Fraction result = parseExpression(sum);
			if (sum.head().equals(")"))
			sum.tail();
		else
			throw new IncorrectInputException("forventede ), men fik: " + sum.head());
			return result;
		}
		try{
		Fraction result = new Fraction(Integer.valueOf(sum.head()));
		sum.tail();
		return result;
		} catch(NumberFormatException e){
			throw new IncorrectInputException("Forventet et tal, fik: " + sum.head());
		}
	}


}