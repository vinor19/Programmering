import java.util.Scanner;

public class Durations{

	public static void main(String[] args){
		int seconds;
		Scanner keyboard = new Scanner(System.in); //Makes it easy to call upon keyboard in puts later on
		System.out.println("How many seconds: ");
		seconds = keyboard.nextInt(); //Sets the 'variable seconds' to the integer you input
		int outSeconds, outMinutes, outHours;
		outHours = seconds/3600; //This is integer division, so it only outputs the integers, which is only the hours
		seconds = seconds-(outHours*3600); //Remove the ammount of seconds that is used on the hours so it isn't included in the future
		outMinutes = seconds/60;
		seconds = seconds-(outMinutes*60);
		outSeconds = seconds; //The reason I don't just print out seconds, is just for naming conventions, and it wouldn't in this code make any difference
		System.out.println("The duration is: " + outHours + ":" + outMinutes + ":" + outSeconds); //This is standard format hh:mm:ss
	}
}