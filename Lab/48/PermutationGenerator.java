import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class PermutationGenerator{
  public static void main(String args[]){
    Scanner reader = new Scanner(System.in);
    System.out.println("Venligst angiv en tekststreng");
    String input = reader.nextLine().trim();
	
	double startTime = System.nanoTime();
	
    List <String> perms = permutationsOf(input);
    for(String perm: perms)
      System.out.println(perm);
  
	double endTime = System.nanoTime();
 
	double durationInNano = (endTime - startTime)/1000000.0;  //Total execution time in nano seconds
	System.out.println(durationInNano);
  }
  /*
  *Returns a list of permutations of the string str.
  */
  private static List<String> permutationsOf(String str){
    if (str.equals("")) {
      List<String> perms = new ArrayList<String>();
      perms.add("");
      return perms;
    }else{
      List<String> perms = new ArrayList<String>();
      for(int i = 0; i< str.length();i++)
        for(String perm: permutationsOf(str.substring(0,i) + str.substring(i+1,str.length())))
          perms.add(str.charAt(i)+perm);
      return perms;
    }
  }
}