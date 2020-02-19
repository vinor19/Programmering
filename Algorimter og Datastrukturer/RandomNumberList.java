import java.util.ArrayList;
import java.util.Collections;

public class RandomNumberList{

	public static void main(String[] args){
		int n = 4;
		System.out.println(randomList(n));
		
		
	}

	public static ArrayList randomList(int n){
		
		ArrayList<Integer> listOfInts = new ArrayList<>();
		for(int i = 0; i<n;i++)
			listOfInts.add(i);
		Collections.shuffle(listOfInts);
		return listOfInts;
	}
}