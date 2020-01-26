package java8NewFeatures;

import java.util.Arrays;
import java.util.List;

public class MethodReferance<T extends Number> {
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("ABC", "DEF", "GHI");
		names.forEach(MethodReferance::lowerPrinter);
		MethodReferance<Long> m = new MethodReferance<>();
		System.out.println(m.add(5.6874589655874599666554444, 78));
	}
	
	public static void lowerPrinter(String str) {
		System.out.println( str.toLowerCase());
	}
	
	
	@SuppressWarnings({ "hiding" })
	public <Long, T extends Number> long add(T t, T t1) {
		return  t.longValue()+t1.longValue();
	}
	
}
