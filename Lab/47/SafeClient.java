import java.util.Scanner;
public class SafeClient{

	public Safes safe;
	
	public static void main(String[] args){
		
		int[] password = {1, 2, 3};
		
		Safes test = new Safes(password);
		
		test.store("Hej med dig");
		
		System.out.println(test.contents() + "1");
		
		test.reset();
		
		System.out.println(test.contents() + "1");
		
		test.insert(1);
		System.out.println(test.contents() + "2"+ test.locked());
		test.insert(2);
		System.out.println(test.contents() + "3"+ test.locked());
		test.insert(3);
		System.out.println(test.contents() + "4"+ test.locked());
		test.insert(1);
		System.out.println(test.contents() + "5"+ test.locked());
		test.insert(1);
		System.out.println(test.contents() + "6"+ test.locked());
		test.insert(2);
		System.out.println(test.contents() + "7"+ test.locked());
		test.insert(3);
		System.out.println(test.contents() + "8"+ test.locked());
		test.insert(1);
		System.out.println(test.contents() + "9"+ test.locked());
		test.insert(2);
		System.out.println(test.contents() + "10"+ test.locked());
		test.insert(1);
		System.out.println(test.contents() + "11"+ test.locked());
		test.insert(2);
		System.out.println(test.contents() + "12"+ test.locked());
		test.insert(3);
		System.out.println(test.contents() + "13"+ test.locked());
		
	}
}