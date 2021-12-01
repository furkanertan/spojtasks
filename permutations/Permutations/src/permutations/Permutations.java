package permutations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Permutations {
	static Set<String> result = new HashSet<>();
	static int maxSibling = 0;
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        Integer numberN = scanner.nextInt();
        Integer maxSibling = maxPermutation("",numberN.toString());
        System.out.println("Largest sibling of " + numberN + " : " + maxSibling);
        System.out.println("All siblings of " + numberN + " :");
        System.out.println(Arrays.toString(result.toArray()));
        scanner.close();
    }
 
    private static int maxPermutation(String processed, String nextNumber) {
    	if (nextNumber.length() == 0) {
            result.add(processed);
            if(Integer.valueOf(processed) > maxSibling) {
            	maxSibling = Integer.valueOf(processed);
            }
        } else {
            for (int i = 0; i < nextNumber.length(); i++) {
                String nextOne = nextNumber.substring(i, i + 1);
                String otherNumbers = nextNumber.substring(0, i) + nextNumber.substring(i + 1);
                maxPermutation(processed + nextOne, otherNumbers);
            }
        }
        return maxSibling;
    }
}
