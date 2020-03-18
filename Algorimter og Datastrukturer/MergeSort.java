import java.util.ArrayList;


public class MergeSort{
	
	public static int mergeSort(ArrayList<Integer> list, int p, int r){
		if (p < r){
			int q = (p+r)/2;
			return (mergeSort(list, p, q) + mergeSort(list, q+1, r) +  merge(list, p, q, r));
		}
		return 0;
	}

	public static int merge(ArrayList<Integer> list, int p, int q, int r){
		int count = 0;
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for(int i = 0; i < n1; i++)
			L[i] = list.get(p+i);
		for(int j = 0; j < n2; j++)
			R[j] = list.get(q+j+1);
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = p; k < r+1; k++){
			if (L[i] <= R[j]){
				list.set(k, L[i]);
				i = i + 1;
			}else{
				list.set(k, R[j]);
				count = count + n1 - i;
				j = j + 1;
			}	
		}
		return count;
	}
}