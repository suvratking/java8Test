package stream;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class StramTest {
	
	public static void main(String[] args) {
		execute();
	}

	static void execute() {
		BigDecimal fact = Stream.iterate(new BigDecimal(1), num -> {
			System.out.println("Number ==== " + num.toEngineeringString());
			return num.add(new BigDecimal(1));
		}).limit(500000).
				reduce(new BigDecimal(1), (a, b) -> a.multiply(b));
		System.out.println("Factorial ==== " + fact.toEngineeringString().length());
	}
	
}
