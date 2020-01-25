public class StackTest{
	
	public static void main(String[] args){
		Stack<String> test = new Stack();
		String first = "Test";
		test.add(first);
		System.out.println(test.top());
		test.add("hjælp");
		System.out.println(test.top());
		test.pop();
		System.out.println(test.top());
		System.out.println(test.contains("test"));
		System.out.println(test.contains("Test"));
		test.add("nice");
		test.add("nigger");
		for(String s: test)
			System.out.println(s);
	}
}