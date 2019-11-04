public class FindingK{
	
	public static void main(String[] args){
		int X[] = new int[5];
		int Y[] = new int[5];
		X[0]=1;
		X[1]=3;
		X[2]=5;
		X[3]=7;
		X[4]=9;
		Y[0]=2;
		Y[1]=4;
		Y[2]=6;
		Y[3]=8;
		Y[4]=10;
		findingK(X,Y,4);
	}

	
	public static void findingK(int X[], int Y[], int k){
		int i=0;
		int j=Y.length-1;
		while ((i<X.length&&j>=0)){
			if (k>X[i]+Y[j]){
				i=i+1;
				System.out.println(i);
			}else if (k<X[i]+Y[j]){
				j=j-1;
				System.out.println(j);
			}else{
				System.out.println(k + " is the sum of " + X[i] + " and " + Y[j]);
				return;
			}
		}
		System.out.println("There are no two numbers which sum is equal to k");
	}

}