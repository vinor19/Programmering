public class BoxClient{

	public static void main(String[] args){
		Box<String> box1 = new Box<String>("Test");
		System.out.println(box1.contents());
		
		
	}


}