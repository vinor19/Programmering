import java.util.scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Mirror{
	
	public static void main(String[] args){
	File text = new File("test.txt");
	
	Scanner reader = new Scanner(text)
	
	while(reader.hasNextLine()){
		int i = 0;
		String linje = reader.nextLine();
		String outputLinje = "";
		while (i<linje.length()){
			outputLinje = outputLinje + linje.charAt(linje.length()-i);
			System.out.println(outputLinje);
		}
	}
	}
}