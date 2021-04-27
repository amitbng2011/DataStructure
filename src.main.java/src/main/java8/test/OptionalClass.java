package src.main.java8.test;

import java.util.Optional;

/**
 * https://www.baeldung.com/java-optional
 * 
 * @author amit
 *
 */
public class OptionalClass {

	public static void main(String[] args) {
		
//		3 ways to create Optional object
		
//		1st way- create empty Optional
		Optional<String> o = Optional.empty();
		
//		2nd way - creating through of (which will throw null pointer if value is null)
		String str1="sdsd";
		Optional<String> optional1 = Optional.of(str1);
		System.out.println(optional1.isPresent());
		
//		3rd way - creating through ofNullable (which handles NPE)
		String str=null;
		Optional<String> optional = Optional.ofNullable(str);
		System.out.println(optional.isPresent());
		
		
//		# isPresent and ifPresent
		System.out.println(optional.isPresent()?"yes":"no");
		
		optional.ifPresent(s->System.out.print(s));
		
		
//		Get value from Optional
		
//		If value is present then return the length of the string
		optional1.ifPresent(value->System.out.println(value.length()));
		
//		Default Value With orElse()
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("else value");
		System.out.println(name);
		
//		How to get the value out of optional object
		System.out.println(optional1.get());
		
		try {
			Optional.ofNullable(null).orElseThrow(Exception::new);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception was thrown");
		}
	}
}
