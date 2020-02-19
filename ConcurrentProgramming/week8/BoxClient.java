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
		//box2.apply((p) -> );
	}

	//Returns an ArrayList of type String
	public static ArrayList<String> createArrayListString(){
		ArrayList<String> output = new ArrayList<>();
		output.add("Help");
		output.add("Nice");
		output.add("abc");
		return output;
	}
	
}