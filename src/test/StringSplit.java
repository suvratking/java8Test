package test;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {
	public static void main(String[] args) {
		String str = "Hello_World_How_Are_You";
		
		int startingIndex = 0;
		int lastIndex = 0;
		List<String> splitList = new ArrayList<>();
		
		for (int i = 0; i < str.length(); i++) {
			if(Character.toString(str.charAt(i)).equals("_")) {
				lastIndex = i;
				String str2 = "";
				for (int j = startingIndex; j < lastIndex; j++) {
					str2 += str.charAt(j);
				}
				startingIndex = i + 1;
				splitList.add(str2);
			}
		}
		System.out.println(splitList);
	}
}
