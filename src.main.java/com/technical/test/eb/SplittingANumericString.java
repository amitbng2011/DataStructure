package com.technical.test.eb;

/**
 * https://www.geeksforgeeks.org/splitting-numeric-string/
 * 
 * Approach : The idea is to take a substring from index 0 to any index i (i starting from 1) 
 * of the numeric string and convert it to long data type. Add 1 to it and convert the increased 
 * number back to string. Check if the next occurring substring is equal to the increased one. 
 * If yes, then carry on the procedure else increase the value of i and repeat the steps.
 * 
 */
public class SplittingANumericString {

	public static void main(String[] args) {
		String str = "124"; 
		split(str); 
	}

	public static void split(String str) { 
		int len = str.length(); 

		if (len == 1) { 
			System.out.println("Not Possible"); 
			return; 
		} 

		String s1 = "";
		String s2 = "";

		long num1;
		long num2; 

		for (int i = 0; i <= len / 2; i++) { 

			int flag = 0; // it will make sure if further processing is needed or not. 
			//At the end, if its 0 means possible

			//			Get first number substring and convert into number
			s1 = str.substring(0, i + 1);
			num1 = Long.parseLong((s1)); 

			//add 1 to the prev calculated number and convert back to string
			num2 = num1 + 1; 
			s2 = Long.toString(num2); // this is what suppose to be the valid next number

			int k = i + 1; // this is the length of suppose first number
			while (flag == 0) { 
				int l = s2.length();

				if (k + l > len) {  // if length of first and second number greater than length then break it not possible
					flag = 1; 
					break; 
				} 

				//Now check if expected string is similar to next number
				if ((str.substring(k, k + l).equals(s2))) {
					flag = 0; 

					// since above condition was true, lets increase the second number by 1
					num2++; 
					k = k + l; // update k from i+1 to k+length of the second number 

					if (k == len) // if sum of the length reaches to the limit break
						break; 
					// else convert 2nd number into string and compare
					s2 = Long.toString(num2); 
					l = s2.length(); 
					if (k + 1 > len) { 
						flag = 1; 
						break; 
					} 
				} else // if 2nd number is not same as expected update flag to 1
					flag = 1; 
			} 

			//			Now if flag is still 0 means we traversed and all the conditions were satisfied
			if (flag == 0) { 
				System.out.println("Possible"
						+ " " + s1); 
				break; 
			}
			//			not flag is 1 and we traversed completely
			else if (flag == 1 && i > len / 2 - 1) { 
				System.out.println("Not Possible"); 
				break; 
			} 
		} 
	}


}
