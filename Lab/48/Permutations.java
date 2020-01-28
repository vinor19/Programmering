import java.util.Scanner;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
public class Permutations{

	private static String output;
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Hvilken string vil du lave permutations af?");
		String test = reader.nextLine().trim();
		String[] testSplit = test.split("");
		output = "";
		double startTime = System.nanoTime();
		
		allPermutations(testSplit.clone());
		
		double endTime = System.nanoTime();
 
		double durationInNano = (endTime - startTime)/1000000.0;  //Total execution time in nano seconds
		System.out.println(durationInNano);
		System.out.println(output);
		
	}
	
	//start kald for den rekursive løsning
	public static void allPermutations(String[] perm){
		allPerm(perm.length, perm);
	}
	
	public static void allPerm(int n, String[] perm){
		if (n == 1)
			printArray(perm);
		else{
			for(int i = 0; i < n-1; i++) {
				allPerm(n - 1, perm);
				if(n % 2 == 0) {
					swap(perm, i, n-1);
				} else {
					swap(perm, 0, n-1);
				}
			}
			allPerm(n - 1, perm);
		}
	}
	
	private static void swap(String[] input, int a, int b) {
		String tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}
	
	private static void printArray(String[] input) {

	}
}