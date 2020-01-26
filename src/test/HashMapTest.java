package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.Entry.*;
import static java.util.stream.Collectors.*;

import javax.swing.RowFilter.ComparisonType;

public class HashMapTest {

	public static void main(String[] args) {
		//testAnagram();
		//removeDuplicateFromArray();
		//sortLinkedList();
		//removeWhiteSpace();
		//noOfVowelsCount();
		//getMpstOccuredElementFromString();
		//sortMap();
		streamTest();
	}

	private static void streamTest() {
		System.out.println(IntStream.range(1,  101).summaryStatistics().toString());	
		List<String> stream = Arrays.asList("ABC", "DEF", "GHI");
		stream.stream().max(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
	}

	private static void getMpstOccuredElementFromString() {
		String str = "jkwqohoidbxzcmnkbdaihhisdsdhkcxbvjhk";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : str.toCharArray()) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}
		System.out.println(map);
		map
        .entrySet()
        .stream()
        .sorted(comparingByValue())
        .collect(
            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                LinkedHashMap::new));
		
		Map<Character, Integer> sorted = map
		.entrySet()
		.stream()
		.sorted(Collections.reverseOrder(comparingByValue()))
		.collect(
				toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, 
				LinkedHashMap::new));
		
		Map<Character, Integer> sorted2 = map
		.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue())
		.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		
		
		Map<Character, Integer> sorted3 = map.entrySet()
		.stream().sorted(Map.Entry.comparingByValue())
		.collect(
				Collectors.toMap(element -> element.getKey(), 
								 element -> element.getValue(), 
								 (key, value) -> value, LinkedHashMap::new));
		
		
		System.out.println(map);
		System.out.println(sorted);
		System.out.println(sorted2);
		System.out.println(sorted3);
	}

	private static void sortLinkedList() {
		List<String> lList = new LinkedList<>();
		lList.add("a");
		lList.add("b");
		lList.add("c");
		lList.add("d");
		lList.add("e");
		lList.add("f");
		lList.add("g");
		lList.add("h");
		lList.add("i");
		lList.add("j");
		System.out.println(lList);
		Collections.reverse(lList);
		System.out.println(lList);
		reverseList2(lList);
	}
	
	private static void reverseList2(List<String> list) {
		System.out.println(list);
		for (int i = 0; i < list.size() / 2; i++) { 
            String temp = list.get(i); 
            list.set(i, list.get(list.size() - i - 1)); 
            list.set(list.size() - i - 1, temp); 
        } 
		System.out.println(list);
		
	}

	private static void removeWhiteSpace() {
		String str = "Hello How Are You";
		System.out.println(str.replaceAll("\\s", ""));
	}
	
	private static void noOfVowelsCount() {
		String str = "Hello How are you";
		int count = 0;
		char[] letters = str.toCharArray();
		for (char c : letters) {
			switch (c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
					count++;
				break;
			default:
			}
		}
		System.out.println("No of Vowels = "+count);
	}

	private static void removeDuplicateFromArray() {
		String srr1[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "8", "4", "5"};
		List<Object> list = Arrays.asList(srr1);
		System.out.println(list);
		List<Object> dList = list.stream().map(list1 -> list1).distinct().collect(toList());
		for (Object object : dList.toArray()) {
			System.out.println(object.toString());
		}
	}

	private static void testAnagram() {
		String str1 = "ram";
		String str2 = "mar";
		List<Character> charList1 = new ArrayList<Character>();
		List<Character> charList2 = new ArrayList<Character>();
		for (char car : str1.toCharArray()) {
			charList1.add(car);
		}
		for (char car : str2.toCharArray()) {
			charList2.add(car);
		}
		System.out.println(Arrays.asList(str1.toCharArray()));
		List<Character> sortedArr1 = charList1.stream().map(c -> c).sorted().collect(toList());
		List<Character> sortedArr2 = charList2.stream().map(c -> c).sorted().collect(toList());
		int i = 0;
		boolean status = true;
		for (Character character : sortedArr1) {
			if (!(character.toString().equalsIgnoreCase(sortedArr2.get(i).toString().toUpperCase()))) {
				status = false;
			}
			i++;
		}
		if (status) {
			System.out.println("String is anagram");
		}else {
			System.out.println("String is not anagram");
		}
	}

	public static char getFirstNonRepeatedChar(String str) { 
		Map<Character,Integer> counts = new LinkedHashMap<>(str.length()); 
		for (char c : str.toCharArray()) { 
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1); 
		} 
		for (Entry<Character,Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey(); 
			} 
		} 
		throw new RuntimeException("didn't find any non repeated Character"); 
	}

	private static void sortMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 3);
		map.put("B", 7);
		map.put("C", 6);
		map.put("D", 2);
		map.put("E", 5);
		map.put("F", 1);
		
		map = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (k, v) -> v, LinkedHashMap::new));
		
		//System.out.println(sorted);
		System.out.println(map);
	}

}
