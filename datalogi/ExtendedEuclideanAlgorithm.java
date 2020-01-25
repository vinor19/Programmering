import java.util.Scanner;
public class ExtendedEuclideanAlgorithm{
	
	private static int[] d = new int[50];
	private static int[] s = new int[50];
	private static int[] t = new int[50];
	private static int[] q = new int[50];
	private static int a;
	private static int b;
	
	public static void main(String[] args){
		init();
		int n = 1;
		while (d[n]>0){
			n = n + 1;
			q[n] = d[n-2] / d[n-1];
			d[n] = d[n-2]- q[n] * d[n-1];
			s[n] = s[n-2] - q[n] * s[n-1];
			t[n] = t[n-2] - q[n] * t[n-1];
		}
		int s1 = s[n-1];
		int t1 = t[n-1];
		int d1 = d[n-1];
		System.out.println("s = " + s1 + ", t = " + t1 + ", gcd(" + a + ", " + b + ") = " + d1);
	}
	
	private static void init(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Udregner gcd(a,b)");
		System.out.println("Hvad er a");
		a = reader.nextInt();
		System.out.println("Hvad er b");
		b = reader.nextInt();
		d[0] = a;
		s[0] = 0;
		t[0] = 1;
		d[1] = b;
		s[1] = 1;
		t[1] = 0;
	}
}