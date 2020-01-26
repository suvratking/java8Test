package test;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class TestClass {

	public static void main(String[] args) {
		/*String s1 = "All";
		String s2 = "All";
		String s3 = new String("Alal");
		System.out.println(s1);
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		
		LocalDateTime date = LocalDateTime.now();
		System.out.println(date.getYear());
		System.out.print(date.getMonth().name().toString());
		System.out.printl
		in(date.getYear());*/
		//mapTest();
//		TestInterface ti = () -> System.out.println("hi");
//		ti.show();
//		ti.print();
//		
//		DecimalFormat df = new DecimalFormat("#");
//		
//		System.out.println(df.format(IntStream.range(1, 201).mapToObj(x -> Double.parseDouble(Integer.toString(x))).reduce(1.0, (a, b) -> a * b)));
		
		//printSeries(16);
		
//		wordChange("hi", "how", "are you");
		
		numberSeries2(16);
		
	}
	
	
	private static void numberSeries2(int numberOfElements) {
		int length = numberOfElements/2;
		List<Long> lList1 = LongStream.rangeClosed(0, length).map(number -> number * 2).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		List<Long> lList2 = LongStream.rangeClosed(0, length).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		List<Long> finalList = new ArrayList<>();
		
		String fResult = "";
		
		System.out.println(lList1);
		System.out.println(lList2);
		
		for (int i = 0; i < lList1.size(); i++) {
			fResult += lList1.get(i) + ", " + lList2.get(i) + ", ";
		}
		
		System.out.println(fResult);
	}


	private static void wordChange(String first, String second, String third) {
		String firstWord = "";
		String secondWord = "";
		String thirdWord = "";
		
		for(int i = 0; i < first.toCharArray().length; i++) {
			if(Character.toString(first.charAt(i)).equalsIgnoreCase("a") ||
			   Character.toString(first.charAt(i)).equalsIgnoreCase("e") ||
			   Character.toString(first.charAt(i)).equalsIgnoreCase("i") ||
			   Character.toString(first.charAt(i)).equalsIgnoreCase("o") ||
			   Character.toString(first.charAt(i)).equalsIgnoreCase("u")) {
				firstWord += "$";				
			}else {
				firstWord += Character.toString(first.charAt(i));	
			}
		}
		
		for(int i = 0; i < second.toCharArray().length; i++) {
			if(Character.toString(second.charAt(i)).equalsIgnoreCase("a") ||
			   Character.toString(second.charAt(i)).equalsIgnoreCase("e") ||
			   Character.toString(second.charAt(i)).equalsIgnoreCase("i") ||
			   Character.toString(second.charAt(i)).equalsIgnoreCase("o") ||
			   Character.toString(second.charAt(i)).equalsIgnoreCase("u")) {
				secondWord += Character.toString(second.charAt(i));
			}else {
				secondWord += "#";		
			}
		}
		
		System.out.println(firstWord + secondWord + third.toUpperCase());
		
	}


	public String getName(Object obj) {
		System.out.println("Inside Name");
		return obj.toString();
	}
	
	public int getRoll(Object obj) {
		System.out.println("Inside Roll");
		return Integer.parseInt(obj.toString()) * Integer.parseInt(obj.toString());
	}
	
	public double getMark(Object obj) {
		System.out.println("Inside Mark");
		return Double.parseDouble(obj.toString()) * 1.5;
	}
	
	private static void mapTest() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 2);
		map.put("E", 4);
		map.put("D", 3);
		map.put("C", 5);
		map.put("B", 1);
		//map.forEach((K, V) -> System.out.println("Key = " + K + " Value = " + V));
		
		out.println(IntStream.range(0, 100).filter(number -> number % 2 == 0).reduce(0, (int number1, int number2) -> number1 + number2));
		
		//System.out.println(LongStream.generate(() -> Long.parseLong(Double.toString(Math.random()).split(".")[0])).sum());
		
		//DoubleStream.
		
		map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByKey()))
		.collect(Collectors.toMap(K -> K.getKey(), K -> K.getValue(), (K, V) -> V, LinkedHashMap::new)).
		forEach((K, V) -> System.out.println("Key = " + K + " Value = " + V));
		
	} 
	
	
	
	private static int isEven(int number) {
		if(number % 2 == 0) {
			return number;
		}
		return -1;
	}
	
	
	private static void printSeries(int position) {
		long posValue = 1;
		if(position % 2 != 0) {
			position++;
			posValue = 2;
		}
		long start1 = 1;
		long start2 = 1;
		int loopLength = position/2;
		String result1 = "";
		String result2 = "";
		String fresult = "";
		for (int i = 0; i < loopLength; i++) {
			result1 +=  start1 + ", " ;
			start1 = start1 * 2;
		}
		for (int i = 0; i < loopLength; i++) {
			result2 +=  start2 + ", " ;
			start2 = start2 * 3;
		}
		System.out.println(result1);
		System.out.println(result2);
		String[] FRArray1 = result1.substring(0, result1.length() - 2).split(",");
		String[] FRArray2 = result2.substring(0, result2.length() - 2).split(",");
		for (int i = 0; i < FRArray2.length; i++) {
			fresult += FRArray1[i] + ", " + FRArray2[i] + ", ";
		}
		System.out.println(fresult);
		System.out.println("Result = '" + fresult.split(",")[(int) (position - posValue)].trim() + "'");
		
	}
	
	
}
