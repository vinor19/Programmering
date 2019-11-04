public class Stars{
	
	public static void main (String[] args){
		
		//stars(n);
		//linesOfStars(n);
		//triangle(n);
		downToOne(1);
		downToOne(2);
		downToOne(3);
		downToOne(5);
		downToOne(7);
		downToOne(11);
		downToOne(13);
	}

//Prints a row of n stars n>=0
	public static void stars(int n){
	int i = 1;
	while (i <= n){
		System.out.print("*");
		i = i + 1;
	}
	System.out.println();
	}
	
//Prints rows of stars incrementing by one until the last row has n stars n>=0
	public static void linesOfStars(int n){
		System.out.println("This is " + n + " ammount of rows with incrementing stars");
		int i = 1;
		while (i <= n){
			stars(i);
			i = i + 1;
		}
	}
	
	//Making a triangle og "*" being n high n>=0
	public static void triangle(int n){
		System.out.println("This is " + n + " large triangle of stars");
		int i = 0;
		while (i<n){
			for (int j=1; j<=n*2; j++){
				if (j == n-i)
					while (j<n+i+1){
						System.out.print("*");
						j = j + 1;
					}
				else
					System.out.print(" ");
			}
			System.out.println();
			i=i+1;
		}
	}
	
// Find out how many steps it takes n to reach 1, while using if odd n*3+1 and if even n/2, we assume x>0
	public static void downToOne(int n){
		int steps = 0;
		while (n != 1){
			steps = steps + 1;
			if (n%2==0)
				n=n/2;
			else
				n=n*3+1;		
		}
		System.out.println("This is how many steps it takes to reach 1: " + steps);
	}
}