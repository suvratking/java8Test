package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		sort(12, "1 3 4 1 3 6 7 8 9 0 3 3");
		//sort2("12 8", "9 3 0 4 2 6 8 7 5 1 12 11");
	}

	private static void sort2(String lengthAndOrder, String numberString) {
		
		int length = Integer.parseInt(lengthAndOrder.split(" ")[0]);
		int reverse = Integer.parseInt(lengthAndOrder.split(" ")[1]);
		
		String[] numberStringArr = numberString.split(" ");
		
		List<Integer> firstUnsortList = new ArrayList<>();
		List<Integer> secondUnsortList = new ArrayList<>();
		
		for(int i = 0; i < reverse; i++) {
			firstUnsortList.add(Integer.parseInt(numberStringArr[i]));
		}
		
		for(int i = reverse ; i < numberStringArr.length; i++) {
			secondUnsortList.add(Integer.parseInt(numberStringArr[i]));
		}
		
		Collections.sort(firstUnsortList);
		Collections.reverse(firstUnsortList);
		Collections.sort(secondUnsortList);
		
		System.out.println(firstUnsortList);
		System.out.println(secondUnsortList);
		
		firstUnsortList.addAll(secondUnsortList);
		
		System.out.println(firstUnsortList);
		
	}

	private static void sort(int length, String numberString) {
		List<Integer> intList = new ArrayList<>();
		List<Integer> newIntList = new ArrayList<>();
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		
		String[] numberArr = numberString.split(" ");
 		
		for(int i = 0; i < length; i++) {
			intList.add(Integer.parseInt(numberArr[i]));
		}
		
		for(int number : intList) {
			frequencyMap.put(number, frequencyMap.containsKey(number) ? frequencyMap.get(number) + 1 : 1);
		}
		
		frequencyMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(e -> {
			for(int i = 0; i < e.getValue(); i++) {
				newIntList.add(e.getKey());
			}
		});
		newIntList.forEach(l -> System.out.print(l+" "));
		
	}
	
}
