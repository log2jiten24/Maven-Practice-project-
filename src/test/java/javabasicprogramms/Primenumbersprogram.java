package javabasicprogramms;

public class Primenumbersprogram {
	
	
	//how to find prime numbers 
	
	//13//13/2 -- it can be divisible by only itself or it can be divided by 1 
	
	//2 is the lowest prime number 
	
	public static boolean isPrime(int num) {
		
		if (num <= 1 ) {
		return false;
		}
		
	for (int i = 2 ; i < num ; i ++ ) {
		
		if (num % i == 0) {
			
			return false ;
		}
	}
    //if remainder comes then come out of for loop 
	return true ;
}
	
	//method to print the prime numbers between range 
	
	public static void getPrimeNumbers (int num) {
		
		for (int i = 2 ; i <=num ; i ++) {
			
			if (isPrime(i)) 
				
			System.out.print(i + " ");	
				}	
	}
	
	public static void main (String [] args) {
		
		System.out.println ("2 is prime number :" + isPrime(2));
		
		System.out.println ("16 is prime number :" + isPrime(16));
		
		System.out.println ("17 is prime number :" + isPrime(17));
		
		getPrimeNumbers(200);
	}
   }