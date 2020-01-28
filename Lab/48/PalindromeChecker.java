import java.util.Scanner;
public class PalindromeChecker{
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Hvilken string vil du tjekke?");
		String test = reader.nextLine().trim();
		Boolean isPalindrome = isPalindrome(test, 0);
		System.out.println("Er " + test + " en palindrome? " + isPalindrome);
	}
	
	//Checker om en String er palindrome, precondition er når funktionen bliver kaldt originalt skal det være med 0
	public static boolean isPalindrome(String s, int i){
		if (i >= s.length()-1-i)
			return (s.charAt(i) == s.charAt(s.length()-1-i));
		else //i<s.length()-i
			return ((s.charAt(i) == s.charAt(s.length()-i-1)) && isPalindrome(s, i+1));
	}
}