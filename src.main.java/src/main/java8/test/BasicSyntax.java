package src.main.java8.test;

/**
 * Lambda Expressions Example
 * 
 * parameter -> expression body
 * 
 * @author amit
 *
 */
public class BasicSyntax {

	public static void main(String[] args) {
	
		BasicSyntax tester = new BasicSyntax();
		
		MathOperation addition = (int a, int b) -> a+b;
		MathOperation substraction = (a, b) -> a-b;
		MathOperation multiplication = (a, b) -> {
			return a*b;
		};
		MathOperation division = (int a, int b) -> a/b; 
		
		System.out.println("addition "+tester.operate(4,  5, addition));
		System.out.println("substraction "+tester.operate(10,  5, substraction));
		System.out.println("multiplication "+tester.operate(4,  5, multiplication));
		System.out.println("division "+tester.operate(15,  5, division));
		
	}
	
	
	interface MathOperation {
	      int operation(int a, int b);
	   }
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	
}
