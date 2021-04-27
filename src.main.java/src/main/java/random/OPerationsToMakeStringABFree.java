package src.main.java.random;

/**
 * https://www.geeksforgeeks.org/count-operations-make-stringab-free/
 * 
 * Given a string containing characters ‘a’ and ‘b’ only. Convert the given string into a string
 * in which there is no ‘ab’ substring. To make string ‘ab’ free we can perform an operation in 
 * which we select a ‘ab’ substring and replace it by ‘bba’.
 * Find the total number of operations required to convert the given string.
 *
 */
public class OPerationsToMakeStringABFree {

	public static void main(String[] args) {
		String s = "abbaa"; 
        System.out.println(abFree(s.toCharArray())); 
  
        s = "aab"; 
        System.out.println(abFree(s.toCharArray())); 
  
        s = "ababab"; 
        System.out.println(abFree(s.toCharArray())); 
	}
	
	public static int abFree(char[] s) {
		
		int bCount = 0;
		int res = 0;
		
		for(int i=0; i<s.length; i++) {
			if(s[s.length-i-1] == 'a') {
				res = res+bCount;
				bCount = bCount*2;
			}else {
				bCount = bCount + 1;
			}
		}
		return res;
	}
}
