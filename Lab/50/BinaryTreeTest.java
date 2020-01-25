import java.util.ArrayList;
public class BinaryTreeTest{

	public static void main(String[] args){
		//Tester sum()
		BinaryTree<Double> doubleTree = new BinaryTree<Double>();
		doubleTree.add(3.0);
		doubleTree.add(3.0);
		doubleTree.add(3.0);
		doubleTree.add(3.1);
		System.out.println(sum(doubleTree));
		
		//Tester zeros
		BinaryTree<Integer> intTree = new BinaryTree<Integer>();
		intTree.add(0);
		intTree.add(0);
		intTree.add(29);
		intTree.add(0);
		intTree.add(2);
		intTree.add(5);
		intTree.add(0);
		intTree.add(5);
		intTree.add(0);
		System.out.println(zeros(intTree));
		
		//tester count
		BinaryTree<String> stringTree = new BinaryTree<String>();
		stringTree.add("Hej");
		stringTree.add("Hej");
		stringTree.add("Hej");
		stringTree.add("Hej2");
		System.out.println(count(stringTree, "Hej"));
		
		//Tester toArrayList()
		System.out.println(toArrayList(intTree));
		
		//Tester selectLarger()
		System.out.println(selectLarger(intTree, 3));
		
		//Tester mostLeftTurns()
		System.out.println(intTree.height());
		System.out.println(intTree.toString());
		System.out.println(mostLeftTurns(intTree));
	}
	/*
	 * Recursive metode der udregner summen af alle værdier i t
	 */
	public static double sum(BinaryTree<Double> t){
		if(t.isEmpty())
			return 0;
		else
			return t.root() + sum(t.left()) + sum(t.right());
	}
	
	/*
	 * Returnere antallet af nuller i et integer binært træ
	 */
	public static int zeros(BinaryTree<Integer> s){
		if(s.isEmpty())
			return 0;
		else if (s.root() == 0)
			return 1 + zeros(s.left()) + zeros(s.right());
		else //s.root() != 0
			return 0 + zeros(s.left()) + zeros(s.right());
	}

	/*
	 * Returnere antallet af s i t
	 */
	public static int count(BinaryTree<String> t, String s){
		if(t.isEmpty())
			return 0;
		else if (t.root().equals(s))
			return 1 + count(t.left(), s) + count(t.right(), s);
		else //!t.root().equals(s)
			return 0 + count(t.left(), s) + count(t.right(), s);
	}
	
	/*
	 * Returnere en liste over alle elementer i træet
	 */
	public static ArrayList<Integer> toArrayList(BinaryTree<Integer> t){
		ArrayList<Integer> output = new ArrayList<Integer>();
		if(t.isEmpty())
			return output;
		else{
			output.add(t.root());
			output.addAll(toArrayList(t.left()));
			output.addAll(toArrayList(t.right()));
			return output;
		}
	}

	/*
	 * returnere en liste over elementer i træet der er større end n
	 */
	public static ArrayList<Integer> selectLarger(BinaryTree<Integer> t, int n){
		ArrayList<Integer> output = new ArrayList<Integer>();
		if(t.isEmpty())
			return output;
		else{
			if(t.root() > n)
				output.add(t.root());
			output.addAll(selectLarger(t.left(), n));
			output.addAll(selectLarger(t.right(), n));
			return output;
		}
	}

	/*
	 * Returnere det højest antal valg det venstre barn skal lave for at komme 
	 * hentil hvilken som helst blad
	 */
	public static int mostLeftTurns(BinaryTree<?> t){
		if(t.isEmpty())
			return 0;
		else
			return Math.max(1+mostLeftTurns(t.left()),mostLeftTurns(t.right()));
	}
}