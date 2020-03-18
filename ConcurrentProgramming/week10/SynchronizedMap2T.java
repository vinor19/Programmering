import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SynchronizedMap2T
{
	public static void main(String[] args)
	{
		Map< String, Integer > results1 = new HashMap<>();
		Map< String, Integer > results2 = new HashMap<>();
		
		
		Thread t1 = new Thread( () -> {
			try {
				Files.lines( Paths.get( "text1.txt" ) )
					.flatMap( s -> Stream.of( s.split( " " ) ) )
					.forEach( word -> {
							results1.merge( word, 1, Integer::sum );
					} );
			} catch( IOException e ) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread( () -> {
			try {
				Files.lines( Paths.get( "text2.txt" ) )
					.flatMap( s -> Stream.of( s.split( " " ) ) )
					.forEach( word -> {
							results2.merge( word, 1, Integer::sum );
					} );
			} catch( IOException e ) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();		
		} catch( InterruptedException e ) {
			e.printStackTrace();
		}
		Map< String, Integer > resultsFinal = new HashMap<>(results1);
		results2.forEach((word, count) -> resultsFinal.merge(word, count, Integer::sum));				
		System.out.println(resultsFinal);
	}
}