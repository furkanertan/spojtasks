import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int numberCount = scn.nextInt();
            for(int i = 0; i< numberCount; i++){
                String nextNumber = scn.next();
                if(checkAllNines(nextNumber)){
                    allNineNextPalindrome(nextNumber);
                    continue;
                }else if(checkAllZeros(nextNumber)){
                    allZeroNextPalindrome(nextNumber);
                    continue;
                }
                findNextPalindrome(nextNumber);
            }
        }

    static boolean checkAllNines(String number){
        char[] arrNumber = number.toCharArray();
        for(int i = 0 ; i < arrNumber.length;i++){
            if(arrNumber[i] != '9'){
                return false;
            }
        }
        return true;
    }

    static void allNineNextPalindrome(String number){
        char[] arrNumber = number.toCharArray();
        String nextPalindrome = "1";
        for(int i = 0; i < arrNumber.length;i++){
            if(i != arrNumber.length-1){
                nextPalindrome = nextPalindrome.concat("0");
            }else{
                nextPalindrome = nextPalindrome.concat("1");
            }
        }
        System.out.println(nextPalindrome);
    }
    //Numbers are always displayed without leading zeros. but I put for the case that we should consider
    static boolean checkAllZeros(String number){
        char[] arrNumber = number.toCharArray();
        for(int i = 0 ; i < arrNumber.length;i++){
            if(arrNumber[i] != '0'){
                return false;
            }
        }
        return true;
    }

    static void allZeroNextPalindrome(String number){
        char[] arrNumber = number.toCharArray();
        String nextPalindrome = "1";
        for(int i = 0; i < arrNumber.length-1;i++){
            if(i != arrNumber.length-2){
                nextPalindrome = nextPalindrome.concat("0");
            }else{
                nextPalindrome = nextPalindrome.concat("1");
            }
        }
        System.out.println(nextPalindrome);
    }
    static void findNextPalindrome(String number){
        int leftP,rightP,nSize;
        char[] arrNumber = String.valueOf(number).toCharArray();
        nSize = String.valueOf(number).length();
        leftP = nSize/2;
        rightP = nSize/2;
        if(nSize%2==0){
            leftP-= 1;
        }
        while(leftP >= 0 && arrNumber[leftP] == arrNumber[rightP]){
            leftP-= 1;
            rightP+=1;
        }
        if(leftP < 0 || arrNumber[leftP] < arrNumber[rightP]){
            leftP = nSize/2;
            rightP = nSize/2;
            if(nSize%2==0){
                leftP-= 1;
            }
            int carry  =1;
            while(leftP >= 0){
                int num = (arrNumber[leftP] - '0') + carry;
                carry = num/10;
                arrNumber[leftP] = (char) ((num%10) + '0');
                arrNumber[rightP] = arrNumber[leftP];
                leftP-= 1;
                rightP+=1;
            }
        }else{
            while(leftP >= 0){
                arrNumber[rightP] = arrNumber[leftP];
                leftP-= 1;
                rightP+=1;
            }
        }
        System.out.println(String.valueOf(arrNumber));
    }
}