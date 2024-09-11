package array;

import java.util.stream.Stream;

public class Test {
	
	public static void main(String... programmingKT) {
		Stream.of("Toby",null, "Anna", "Elsa", "Alex")
		      .filter(n -> n != null)
		 	  .filter(n -> n.length() == 4)
		      .sorted()
		      .limit(1)
		      .forEach(System.out::println); 
	}
}
