package stream;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		String name = "Manmohan";
		
		for (int i = 0; i < name.length(); i++) {
			list.add(Character.toString(name.charAt(i)).toUpperCase());
		}
		
		Map<Object, Long> groupList = list.stream().collect(Collectors.groupingBy(l -> l, Collectors.counting())).
									  entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(Collectors.
									  toMap(K -> K.getKey(), V -> V.getValue(), (K, V) -> V, LinkedHashMap::new));
		System.out.println(groupList);
		
	}
	
}
