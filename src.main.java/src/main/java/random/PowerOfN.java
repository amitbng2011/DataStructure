package src.main.java.random;

import java.io.Serializable;

public class PowerOfN implements Serializable{

	public static void main(String[] args) {
		System.out.println(isPowerOftwo(6));
		System.out.println(isPowerOfThree(9));
		
		
		System.out.println(isPowerOfN(128, 2));
	}
	
	private static boolean isPowerOftwo(int number) {
		
		if(number == 0)
			return false;
		while(number != 1) {
			if(number%2 != 0)
				return false;
			number = number/2;
		}
		return true;
	}
	
	private static boolean isPowerOfThree(int number) {
		
		if(number == 0)
			return false;
		while(number != 1) {
			if(number % 3 != 0)
				return false;
			number = number/3;
		}
		return true;
	}
	
	
	private static boolean isPowerOfN(int number, int n) {
		
		if(number == 0)
			return false;
		
		while(number != 1) {
			if(number % n != 0)
				return false;
			number = number/n;
		}
		return true;
		
	}
}
