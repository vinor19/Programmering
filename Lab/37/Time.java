import java.util.Scanner;

public class Time{

	public static void main(String[] args){
		int hours, minutes, seconds;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many hours: ");
		hours = keyboard.nextInt();
		System.out.println("How many minutes: ");
		minutes = keyboard.nextInt();
		System.out.println("How many seconds: ");
		seconds = keyboard.nextInt();
		int timeInSeconds = hours*3600 + minutes*60 + seconds; //The calculation is based one 60 seconds=1 minute, 60 minutes= 1 hour, therefore 60*60 seconds = 1 hour, and then i just convert it backwards
		System.out.println("The time in seconds is: " + timeInSeconds);
	}
}