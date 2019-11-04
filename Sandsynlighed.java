public class Sandsynlighed{

	public static void main(String[] args){
		System.out.println(sandsynlighed(1178, 1000000));
	}
	
	public static double sandsynlighed(int n, int k){
		int i=0;
		double sandsynlighed=1;
		while (i<n){
			sandsynlighed=sandsynlighed*(k-i)/k;
			i=i+1;
		}
		return(sandsynlighed);
	}
}