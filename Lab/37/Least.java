public class Least{
	public static void main(String[] args){
		int m=6;
		int n=213;
		int k=161;
		int l=3;
		System.out.println(lcm(m, n));
		System.out.println(firstDigit(n));
		System.out.println(firstDigitInBase(n, k));
		System.out.println(isPalandrome(n));
		System.out.println(findPower(l));
		
	}
//Finds the least common multiple of m and n
	public static int lcm(int m, int n){
		int i=1;
		while ((n*i)%m != 0)
			i=i+1;
		return (n*i);
	}
	//First digit in a number that is a base 10 number
	public static int firstDigit(int n){
		while (n>=10)
			n=n/10;
		return n;
	}
	//First digit in a number that is a base k number
	public static int firstDigitInBase(int n, int k){
		int oldn=0;
		while (n-(n/k)>0){
			oldn=n;
			n=n/k;
		}
		return oldn%k;
	}
	//Checks if an integer is a palandrome
	public static boolean isPalandrome(int n){
		int reversed=0;
		int original=n;
		while (n>0){
			int digit = n % 10;
			reversed = reversed * 10 + digit;
			n = n / 10;
		}
		return original==reversed;
	}
	
	/*Returns the smallest number n such that 2^n starts with k, I assume k is an integer from 1-9
	* Also 2^n can not exceed the bit limit of int, which means 7 and 9 can't be done
	*/
	public static int findPower(int k){
		int n=0;
		int i=0;
		int power=1;
		while (firstDigit(power)!=k){
			i=i+1;
			n=i;
			power=power*2;
			System.out.println(power); //used to check if the number exceeds the limit, it will loop around to 0 if it does
		}
		return n;
	}
}

