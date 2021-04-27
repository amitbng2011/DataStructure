package src.main.java.random;

public class GenerateRandomNumber {

	public static void main(String[] args) {
		int max = 10;
		int min = 1;
		int range = max-min+1;
		int res = (int)(Math.random()*range)+min;
		System.out.println(res);

	}
}
