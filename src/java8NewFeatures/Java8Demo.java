package java8NewFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Java8Demo {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		//intList.forEach(Java8Demo::devideIt);
		
		Function<Integer, Integer> fn = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer t) {
				System.out.println("no = "+t);
				return t;
			}
		};
		
		BinaryOperator<Integer> bo = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				System.out.println("Number is = "+u);
				return t+u;
			}

			
		};
		
		System.out.println(intList.stream().map(fn).reduce(0, bo));
	}
	
	
	public static void devideIt(long no) {
		double x = no/2;
		System.out.println(x);
	}
}
