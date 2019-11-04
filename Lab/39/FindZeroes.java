public class FindZeroes{

	public static void main(String[] args){
		int i=0;
		while (f(i)!=0)
			i=i+1;
		System.out.println("The smallest n such that the function f equals 0 is: " + i);
	}

//Returns the least n in which f(n)=0
	private static int f(int n){
		return n+1;
	}
}

