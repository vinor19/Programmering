import java.util.ArrayList;
import java.util.Random;

public class MergeClient{

	public static void main(String[] args){
		Random ran = new Random();
		ArrayList<Integer> list = new ArrayList<>(4);
		for(int i = 0; i < 4; i++)
			list.add(ran.nextInt(500));
		System.out.println(list);
		System.out.println(MergeSort.mergeSort(list, 0, 3));
		System.out.println(list);
	}

}

