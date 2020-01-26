package java8NewFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

//a simple program to demonstrate the use of stream in java 

class Demo 
{ 
	public static void main(String args[]) 
	{ 
		
		Map<String, Object> map = new TreeMap<String, Object>();
		for (int j = 0; j < 5; j++) {
			map.put("Key"+(j+1), "Value"+(j+1));
		}

		map.forEach((k, v)->System.out.println(k+v));
		
		// create a list of integers 
		List<Integer> number = Arrays.asList(2,3,4,5); 

		// demonstration of map method 
		List<Integer> square = number.stream().map(x -> x*x).collect(Collectors.toList()); 
		System.out.println(square); 

		// create a list of String 
		List<String> names = Arrays.asList("Reflection","Collection","Stream"); 

		// demonstration of filter method 
		List<String> result = names.stream().filter(s->s.contains("e")).collect(Collectors.toList()); 
		System.out.println(result); 

		// demonstration of sorted method 
		List<String> show = names.stream().sorted().collect(Collectors.toList()); 
		System.out.println(show); 

		// create a list of integers 
		List<Integer> numbers = Arrays.asList(2,3,4,5,2); 

		// collect method returns a set 
		Set<Integer> squareSet = numbers.stream().map(x->x*x).collect(Collectors.toSet()); 
		System.out.println(squareSet); 

		// demonstration of forEach method 
		number.stream().map(x->x*x).forEach(y->System.out.println(y)); 

		// demonstration of reduce method 
		int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i); 

		System.out.println(even); 
	} 
} 
