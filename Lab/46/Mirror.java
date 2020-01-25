import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Mirror{
	
	public static void main(String[] args) throws FileNotFoundException{
		File text = new File("test.txt");
		Scanner reader = new Scanner(text);
		PrintWriter outputStream = new PrintWriter("output.txt");
		while(reader.hasNextLine()){
			int i = 0;
			String linje = reader.nextLine();
			String outputLinje = "";
			while (i<linje.length()){
				outputLinje = outputLinje + linje.charAt(linje.length()-i-1);
				System.out.println(outputLinje);
				i=i+1;
			}
			outputStream.println(outputLinje);
		}
		outputStream.close();
	}
}