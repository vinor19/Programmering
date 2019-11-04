public class SumUpTo{
	public static int SumUpTo(int n){
		int i=1;
		int sumUpTo=0;
		while (i<n){
			sumUpTo=sumUpTo+i;
			i=i+1;
		}
		return(sumUpTo);
	}
	public static void main(String[] args){
	System.out.println(SumUpTo(20));

	}
}
