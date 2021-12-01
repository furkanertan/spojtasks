import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int charCount = scn.nextInt();
        char[] arrDNA = scn.next().toCharArray();
        int A = 0, B = 0;
        char next;
        for(int i=0;i<charCount;i++){
            next = arrDNA[i];
            //Check if character is A and count mutations
            if (next== 'A') {
                //When next element is A no process required, but when it is B try with +1 and take minimum
                A = Math.min(A, B+1);
                B = Math.min(A+1, B+1);
            }
            //Check if character is B and count mutations
            else {
                //When next element is B no process required, but when it is A try with +1 and take minimum
                B = Math.min(A+1, B);
                A = Math.min(A+1, B+1);
            }
        }
        System.out.print(Math.min(A, B+1));
    }
}
