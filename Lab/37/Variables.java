public class Variables{
	
	public static void main(String[] args){
		int varOne = 1;
		int varTwo = 2;
		float varThree = 3.1f;
		double varFour = 3.5;
		double varFive = 4.5;
		int i = 1;
		int j = 2;
		int k = 4;
		int average = (i+j+k)/3; //I do this as an integer, because it looks better in this case, if I needed this for some important calculations, I would use a double
		System.out.println("First variable is varOne: " + varOne);
		System.out.println("Second variable is varTwo: " + varTwo);
		System.out.println("Third variable is varThree: " + varThree);
		System.out.println("Fourth variable is varFour: " + varFour);
		System.out.println("Fifth variable is varFive: " + varFive);
		System.out.println("The average of i, j and k is: " + average);
	}
}