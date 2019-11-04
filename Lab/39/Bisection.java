
public class Bisection{

	public static void main(String[] args){
		double error=0.00000000000000000001;
		double b = 2;
		double a = -1;
		
		System.out.println((bisection(a, b, error)));
		
		
	}

//function f
	private static double f(double x){
		return x*x-2;
	}
	
//Bisection method, a has to be smaller than b, 
	private static double bisection(double a, double b, double error){
		double c;
		while (b-a > error && f(a) != 0){
			c=(a+b)/2;
			System.out.println(a + " And f(a): " + f(a));
			if (f(a)*f(c)<0){
				b=c;
			} else{
				a=c;
			}
		}
		return a;
	}
	
	

}