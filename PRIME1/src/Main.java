import java.util.*;

public class Main {
    static int[] primes = new int[4000];
    static int numPrimes = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        fillPrimeArray();
        int countOfNumbers,firstNumber,secondNumber;
        countOfNumbers = in.nextInt();
        for (int t = 0; t < countOfNumbers; t++) {
            System.out.println("");
            firstNumber = in.nextInt();
            secondNumber = in.nextInt();
            if (firstNumber < 2) {
                firstNumber = 2;
            }
            boolean[] isPrime = new boolean[100001];
            for (int j = 0; j < 100001; j++) {
                isPrime[j] = true;
            }

            for (int i = 0; i < numPrimes; i++) {
                int p = primes[i];
                int start;
                if (p >= firstNumber) {
                    start = p * 2;
                }
                else {
                    start = firstNumber + ((p - firstNumber % p) % p);
                }

                for (int j = start; j <= secondNumber; j += p) {
                    isPrime[j - firstNumber] = false;
                }
            }

            //printing primeNumbers between first and second number
            for (int i = firstNumber; i <= secondNumber; i++) {
                if (isPrime[i-firstNumber]) {
                    System.out.println(i);
                }
            }
        }
    }

    //Fill prime array at the beginning
    static void fillPrimeArray(){
        primes[numPrimes++] = 2;
        for (int i = 3; i <= 32000; i+=2) {
            boolean isPrime = true;
            double cap = Math.sqrt(i) + 1.0;

            for (int j = 0; j < numPrimes; j++) {
                if (j >= cap) break;
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[numPrimes++] = i;
            }
        }
    }
}