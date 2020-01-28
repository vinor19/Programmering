public class SecondAssignment{
	
	public static void main(String[] args){
		//printMultiples();
		//System.out.println(sumUpTo(10));
		//System.out.println(sumBeyond(10));
		//System.out.println(sumBetween(10, 20));
		//System.out.println(sumEven(10));
		//System.out.println(factorial(10));
		//System.out.println(doubleFactorial(10));
		System.out.println(fibonacci(4));
	}
	//Prints all multiples of 7 that are less than 500 and larger than 0
	public static void printMultiples(){
		int i = 7;
		while(i<500){
			System.out.println(i);
			i=i+7;
		}
	}

	//Prints all multiples of seven smaller than n
	public static void printMultiples(int n){
		int i = 7;
		while(i<n){
			System.out.println(i);
			i=i+7;
		}
	}

	//Prints all multiples of k smaller than n
	public static void printMultiples(int k, int n){
		int i = k;
		while(i<n){
			System.out.println(i);
			i=i+k;
		}
	}

	//sums up all natural numbers smaller than natural
	public static int sumUpTo(int n){
		int sum=0;
		for(int i = 0; i<n; i++)
			sum=sum+i;
		return sum;
	}

	//Finds the least n, such that all natural numbers before it summed exceeds k
	public static int sumBeyond(int k){
		int n=0;
		int sum=0;
		while(sum<=k){
			n=n+1;
			sum=sum+n;
		}
		return n;
	}

	//Computes the sum between all the natural numbers between n and m (including them) @precondition: m<n
	public static int sumBetween(int m, int n){
		int sum = m;
		for(int i = m+1; i<=n;i++)
			sum=sum+i;
		return sum;
	}
	
	//Computes the sum of all even numbers smaller than n.
	public static int sumEven(int n){
		int i = 0;
		int sum = 0;
		while (i < n){
			sum = sum + i;
			i = i + 2;
		}
		return sum;
	}
	
	//Return the factorial of n
	public static int factorial(int n){
		int sum = 1;
		for(int i = 1; i<=n; i++)
			sum=sum*i;
		return sum;
	}
	
	//Returns the double factorial of n (if even it's 2*4*6... odd 1*3*5...
	public static int doubleFactorial(int n){
		int sum = 1;
		int i;
		if (n%2==1)
			i = 1;
		else
			i = 2;
		while(i<=n){
			sum=sum*i;
			i=i+2;
		}
		return sum;
	}
	
	//Returns the n'th fibonacci number
	public static int fibonacci(int n){
		int base1 = 0;
		int base2 = 1;
		int fibonacciNumber = 1;
		for(int i = 0; i < n; i++){
			fibonacciNumber = base1 + base2;
			base1=base2;
			base2=fibonacciNumber;	
		}
		return fibonacciNumber;
		
	}
	
	
	
	
	
}