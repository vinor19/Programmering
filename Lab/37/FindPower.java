public class FindPower{

	public static void main(String[] args){
	int k=7;
	System.out.println(findPower(k));	
	}
	public static int findPower(int k){
		int n=0;
		int i=1;
		int power=2;
		while (firstDigit(power)!=k){
			n=i;
			power=power*2;
			i=i+1;
			System.out.println(power);
		}
		return n;
	}
	public static int firstDigit(int n){
		while (n>=10)
			n=n/10;
		return n;
	}
}