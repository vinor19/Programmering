import java.util.Scanner;
public class ScrambleIt{
	
	public static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("Hvilken tekst vil du gerne aendre paa? ");
		String input = reader.nextLine().trim();
		System.out.println(input + "|");
		boolean cont = true;
		do{
			System.out.println("[1] Fjerner vokaler fra teksten");
			System.out.println("[2] Fjerner mellemrum og laver nye med et givet interval, som er større end 0");
			System.out.println("[3] Spejler orderne");
			System.out.println("[4] Seperare teksten i blokke med en givet laengde, og spejler dem");
			System.out.println("[5] Rykker hvert ords bogstaver med et givet antal");
			switch(reader.nextInt()){
				case 1: 
					input = vowelRemove(input);
					System.out.println("Her er den nye tekst: " + input); break;
				case 2:
					System.out.println("Hvilket interval skal de nye mellemrum laves ved: ");
					int nSpace = reader.nextInt();
					input = spaces(input, nSpace);
					System.out.println("Her er den nye tekst: " + input); break;
				case 3:
					input = reverse(input);
					System.out.println("Her er den nye tekst: " + input); break;
				case 4:
					System.out.println("Hvilket interval skal der laves blokke der skal spejles: ");
					int nBlock = reader.nextInt();
					input = blockReverse(input, nBlock);
					System.out.println("Her er den nye tekst: " + input); break;
				case 5:
					System.out.println("Hvor mange pladser skal der rykkes: ");
					int nMove = reader.nextInt();
					input = move(input, nMove);
					System.out.println("Her er den nye tekst: " + input); break;
			}
			System.out.print("Fortsaet? (J/N) ");
			String answer = reader.next();
			cont = (answer.toUpperCase().charAt(0)!='N');
		}while(cont);
	}
	
	//Fjerne vokaler i en givet String
	private static String vowelRemove(String s){
		int i = 0;
		String output = s;
		output = output.replace("a", "");
		output = output.replace("e", "");
		output = output.replace("i", "");
		output = output.replace("o", "");
		output = output.replace("u", "");
		output = output.replace("y", "");
		output = output.replace("A", "");
		output = output.replace("E", "");
		output = output.replace("I", "");
		output = output.replace("O", "");
		output = output.replace("U", "");
		output = output.replace("Y", "");
		return output;
	}
	
	//Fjerne mellemrum og laver nye med et interval n
	private static String spaces(String s, int n){
		String output = "";
		for (int i = 0; i<s.length(); i++)
			if (s.charAt(i)!= ' ')
				output = output + s.charAt(i);
		String outputMellemrum = "";
		for (int i = 0; i<output.length(); i++){
			outputMellemrum = outputMellemrum + output.charAt(i);
			if ((i%n) == n-1)
				outputMellemrum = outputMellemrum + " ";
		}
		return outputMellemrum;
	}
	
	//Spejler hvert individuelt ord
	private static String reverse(String s){
		String output = "";
		int i = 0;
		int j = 0;
		while (i<s.length()){
			if (s.charAt(i) == ' '){
				String reverse = s.substring(j, i);
				j=i+1;
				int k = reverse.length();
				while (k>0){
					output = output + reverse.charAt(k-1);
					k=k-1;
				}
				output = output + " ";
			}
			i = i + 1;
		}
		String reverse = s.substring(j, i);
		j=i;
		int k = reverse.length();
		while (k>0){
			output = output + reverse.charAt(k-1);
			k=k-1;
		}
		System.out.println(output);
		return output;
	}
	
	//Laver blokke og spejler dem
	private static String blockReverse(String s, int m){
		String output = "";
		int i = 0;
		int j = 0;
		while (i<s.length()){
			if (i%m == 0){
				String reverse = s.substring(j, i);
				j=i;
				int k = reverse.length();
				while (k>0){
					output = output + reverse.charAt(k-1);
					k=k-1;
				}
			}
			i = i + 1;
		}
		String reverse = s.substring(j, i);
		j=i;
		int k = reverse.length();
		while (k>0){
			output = output + reverse.charAt(k-1);
			k=k-1;
		}
		return output;
	}
	
	//rykker hvert individuelt ords bogstaver med n pladser
	private static String move(String s, int n){
		String output = "";
		int i = 0;
		int j = 0;
		while (i<s.length()){
			if (s.charAt(i) == ' '){
				String reverse = s.substring(j, i);
				j=i+1;
				String help = "";
				int k = n;
				while (k>0){
					if (!reverse.equalsIgnoreCase("")){
						help = reverse.substring(reverse.length()-1, reverse.length());
						help = help + reverse.substring(0, reverse.length()-1);
						reverse = help;
					}
					k=k-1;
				}
				while (k<0){
					if (!reverse.equalsIgnoreCase("")){
						help = reverse.substring(1, reverse.length());
						help = help + reverse.substring(0, 1);
						reverse = help;
					}
					k=k+1;
				}
				output = output + help + " ";
			}
			i = i + 1;
		}
		if (s.charAt(i-1) != ' '){
			String reverse = s.substring(j, i);
					String help = "";
					int k = n;
					while (k>0){
						help = reverse.substring(reverse.length()-1, reverse.length());
						help = help + reverse.substring(0, reverse.length()-1);
						reverse = help;
						k=k-1;
					}
					while (k<0){
						help = reverse.substring(1, reverse.length());
						help = help + reverse.substring(0, 1);
						reverse = help;
						k=k+1;
					}
				output = output + help;
		}
		return output ;
	}
}