public class ModTest{

public static void main(String[] args){

	System.out.println(exp(2003, 601, 4001));



}

public static int exp(int a, int k, int n){
	if (k == 0)
		return 1;
	else if (k==1)
		return (a % n);
	else if (k % 2 == 1){
		System.out.println("Odd");
		return(a*exp(a,k-1,n)%n);
	}else{
		int c = exp(a,k/2,n);
		System.out.println("Even");
		return (c*c)%n;
	}
}

}