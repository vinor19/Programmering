import java.util.Random;

public class Sort{
	
	public static void main(String[] args){
	Random random = new Random();
	
	int[] test = new int[100];
	for(int i = 0; i < test.length; i++)
		test[i] = random.nextInt(10);
	long time1 = System.nanoTime();
	insertionsort(test);
	long time2 = System.nanoTime();
	System.out.println(time2-time1);
	}
	
	//Sorts a given array
	public static void insertionsort(int[] v){
		for (int j = 1; j< v.length; j++){
			int key = v[j];
			int i = j-1;
			while (i>0 && v[i]>key){
				v[i+1] = v[i];
				i = i-1;
			}
			v[i+1] = key;
		}	
	}
}