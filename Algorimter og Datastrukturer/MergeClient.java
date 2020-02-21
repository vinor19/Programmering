import java.util.ArrayList;
import java.util.Random;

public class MergeClient{

	public static void main(String[] args){
		Random ran = new Random();
		ArrayList<Integer> list = new ArrayList<>(16);
		for(int i = 0; i < 16; i++)
			list.add(ran.nextInt(500));
		System.out.println(list);
		MergeSort.mergeSort(list, 0, 15);
		System.out.println(list);
	}

}

