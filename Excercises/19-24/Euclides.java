public class Euclides{
	public static void main(String[] args){
		int m=297;
		int n=99;
		System.out.println("Greatest common divisor of "+m+" and "+n+" is: "+gcd2(m, n));
	}
//Calculates the greatest common divisor of m and n
	public static int gcd(int m, int n){
		while (m!=n){
			if (m>n)
				m = m-n;
			else
				n = n-m;
		}
		return n;
	}
	public static int gcd2(int m, int n){
		int oldn=0;
		while (n!=0){
			oldn=n;
			n=m%n;
			m=oldn;
		}
		return m;
	}
}