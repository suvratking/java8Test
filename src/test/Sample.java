package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Sample {
	public static boolean isGreaterThan3(int number) {
		return number > 3;
	}
	public static boolean isEven(int number) {
		return number % 2 == 0;
	}
	public static Integer doubleIt(int number) {
		return number * 2;
	}
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(0, 1, 2, 3, 8, 3, 9, 5, 3, 7, 1, 10, 4);
		Predicate<Integer> isGreaterThan3 = number -> number > 3;
		Predicate<Integer> isEven = number -> number % 2 == 0;
		Function<Integer, Predicate<Integer>> isGreater = number -> number1 -> number1 > number;
		System.out.println(
				intList.stream()
				.sorted()
				.filter(isGreater.apply(3))
				.filter(isEven)
				.map(Sample::doubleIt)
				.findFirst()
				.get()
				);
	}

}
