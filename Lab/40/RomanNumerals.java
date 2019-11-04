import java.util.Scanner;
public class RomanNumerals{
	public static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args){
		boolean exit = false;
		do{
			System.out.println("___________________________________________________________________________________________");
			System.out.println("This is the menu please pick from one of these options");
			System.out.println("[1] Convert a Roman numeral into an int");
			System.out.println("[2] Convert an int into a Roman numeral");
			System.out.println("[3] Add 2 Roman numerals to each other");
			System.out.println("[4] Finds the difference between 2 Roman numerals");
			System.out.println("[5] Is the Roman numeral valid");
			System.out.println("[0] Exit program");
			
			switch(reader.nextInt()){
				case 1: 
					System.out.println("What Roman numeral do you want to convert?");
					String roman = reader.next();
					if (isValid(roman)){
					System.out.println(romanToNum(roman));
					}else {
						System.out.println("Next time, input an actual Roman numeral");
					}
					break;
				case 2: 
					System.out.println("What integer do you want to convert?");
					int num = reader.nextInt();
					System.out.println(numToRoman(num)); break;
				case 3:
					System.out.println("What Roman numerals do you want to add?");
					System.out.print("First: ");
					String num1 = reader.next();
					if (isValid(num1)){
					System.out.print("Second: ");
					String num2 = reader.next();
					if (isValid(num2)){
					System.out.println(romanStringAdd(num1, num2));
					}else System.out.println("Next time, input an actual Roman numeral");}else {
						System.out.println("Next time, input an actual Roman numeral");
					}					break;
				case 4:
					System.out.println("What Roman numerals do you want to find the differnece off, first must be larger?");
					System.out.print("First: ");
					String num3 = reader.next();
					if (isValid(num3)){
					System.out.print("Second: ");
					String num4 = reader.next();
					if (isValid(num4)){
					System.out.println(romanDiff(num3, num4));
					}else System.out.println("Next time, input an actual Roman numeral");}else {
						System.out.println("Next time, input an actual Roman numeral");
					}break;
				case 5:
					System.out.println("Check if your Roman numeral is a valid Roman numeral");
					String roman1 = reader.next();
					System.out.println(isValid(roman1));break;
				case 0:
					exit = true;
			}
		}while(!exit);
	}

	//Converts a single roman numeral into its corresponding int.
	private static int convertRomanToNum(char c){
		char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		int[] numerical = {1, 5, 10, 50, 100, 500, 1000};
		int i = 0;
		int value=0;
		while (i<7){
			if (c == roman[i])
				value=numerical[i];
		i=i+1;
		}
		return value;
	}
		
	/*takes a roman numeral string and converts into int
	*
	*/
	private static int romanToNum(String num){
		int sum = 0;
			int i = 0;
			while (i<num.length()){
				sum = sum + convertRomanToNum(num.charAt(i));
				i = i + 1;
			}
		return sum;
	}
	
	//Takes an int and creates a corresponding roman numeral
	private static String numToRoman(int num){
		String roman="";
		
		int thound = (num / 1000) % 10;
		//System.out.println(tens);
		while (0<thound){
			thound = thound - 1;
			roman = roman + "M";
		}
		
		int hunds = (num / 100) % 10;
		//System.out.println(tens);
		if ((hunds-5)>0){
			hunds =  hunds - 5;
			roman=roman + "D";
		}
		while (0<hunds){
			hunds = hunds - 1;
			roman = roman + "C";
		}
		
		int tens = (num / 10) % 10;
		//System.out.println(tens);
		if ((tens-5)>0){
			tens = tens - 5;
			roman=roman + "L";
		}
		while (0<tens){
			tens = tens - 1;
			roman = roman + "X";
		}
		
		int ones = num % 10;
		//System.out.println(ones);
		if ((ones-5)>0){
			ones = ones - 5;
			roman=roman + "V";
		}
		while (0<ones){
			ones = ones - 1;
			roman = roman + "I";
		}
		return roman;
	}
	
	//Adds two Roman numerals to eachother, with out converting to ints
	private static String romanStringAdd(String num1, String num2){
		int i = 0;
		int j = 0;
		int k = 6;
		String mergedString = "";
		char[] romanNumerals = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		while (k>=0){
			while (i<num1.length() && num1.charAt(i) == romanNumerals[k]){
				mergedString = mergedString + romanNumerals[k];
				i=i+1;
			}
			while (j<num2.length() && num2.charAt(j) == romanNumerals[k]){
				mergedString = mergedString + romanNumerals[k];
				j=j+1;
			}
			k=k-1;
		}
		mergedString = mergedString.replace("IIIII", "V");
		mergedString = mergedString.replace("VV", "X");
		mergedString = mergedString.replace("XXXXX", "L");
		mergedString = mergedString.replace("LL", "C");
		mergedString = mergedString.replace("CCCCC", "D");
		mergedString = mergedString.replace("DD", "M");
		return mergedString;
	}
	
	//Finds the difference between the larger s1 and smaller s2
	private static String romanDiff(String s1, String s2){
		String diff = "";
		while (!romanStringAdd(s2, diff).equals(s1))
			diff = romanStringAdd(diff, "I");
		return diff;
	}
	
	//Checks if the roman numeral string is valid, aka does not contain more than 4 of I, X and C
	private static boolean isValid(String num){
		int i = 0;
		int k = 0;
		int countI = 0;
		int countX = 0;
		int countC = 0;
		int countL = 0;
		int countV = 0;
		int countD = 0;
		char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		boolean validChar = true;
		while (i<num.length()){
			if (num.charAt(i)=='I'){
				countI = countI + 1;
			}else if (num.charAt(i)=='X'){
				countX = countX + 1;
			}else if (num.charAt(i)=='C'){
				countC = countC + 1;
			}else if (num.charAt(i)=='L'){
				countL = countL + 1;
			}else if (num.charAt(i)=='V'){
				countV = countV + 1;
			}else if (num.charAt(i)=='D'){
				countD = countD + 1;
			}else if (num.charAt(i)=='M'){
			}else{
				validChar = false;
			}
			i = i + 1;
		}
		int j = 0;
		boolean rightOrder=true;
		while (j<num.length()-1){
			if (convertRomanToNum(num.charAt(j))<convertRomanToNum(num.charAt(j+1)))
				rightOrder=false;
			j=j+1;
		}
		return (countI<5 && countX<5 && countC<5 && countD<2 && countV<2 && countL<2 && validChar&&rightOrder);
	}
}