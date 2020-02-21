import java.util.ArrayList;
import java.util.Collections;

public class BoxClient{	

	public static void main(String[] args){
		
		//Test simple Box
		Box<String> box1 = new Box<>("Hey");
		System.out.println(box1.contents());

		//Test ArrayList Boc
		ArrayList<String> list1 = createArrayListString();
		Box<ArrayList<String>> box2 = new Box<>(list1);
		box2.apply((ArrayList<String> p) -> {p.sort(String::compareTo); return p;});
		for(String l : box2.contents())
			System.out.println(l);
		int length = box2.apply((ArrayList<String> p) -> {
			int sum = 0;
			for(String l : p)
				sum=sum+l.length();
			return sum;
		});
		System.out.println(length);
	}

	//Returns an ArrayList of type String
	public static ArrayList<String> createArrayListString(){
		ArrayList<String> output = new ArrayList<>();
		output.add("Help");
		output.add("abc");
		output.add("Nice");
		output.add("abc");
		
		return output;
	}
	
}