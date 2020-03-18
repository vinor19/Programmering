import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Week9{


	public static void main(String[] args){
		
		//Excercises 1
		/*
		try {
			Files.lines(Paths.get( "test.txt" ))
			.filter(line -> line.endsWith("."))
			.forEach(System.out::println);
		} catch( IOException e ) {
			e.printStackTrace();
		}
		
		//Excercises 2
		try {
			ArrayList<String> beginsWithC = new ArrayList<>(Files.lines(Paths.get( "test.txt" ))
			.filter(line -> line.startsWith("C"))
			.collect(Collectors.toList()));
		} catch( IOException e ) {
			e.printStackTrace();
		}
		
		//Excercises 3
		try {
			System.out.println(Files.lines(Paths.get( "test.txt" ))
			.filter(line -> line.contains("l")&&line.contains("L"))
			.count());
		} catch( IOException e ) {
			e.printStackTrace();
		}
		*/
		
		//Excercises 3
		try {
			System.out.println(Files.lines(Paths.get( "test.txt" ))
			.filter(line -> line.contains("C"))
			.mapToInt((line) -> {
				
				String[] linesWithC = line.split("C");
				return linesWithC.length-1;
				/*
				int numCs = 0;
				for(int i = 0;i>line.length();i++)
					if (line.charAt(i) == 'C')
						numCs = numCs + 1;
				return numCs;
				*/
			})
			.sum());
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}








}