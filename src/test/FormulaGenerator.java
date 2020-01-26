package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FormulaGenerator {
	public static void main(String[] args) {
		System.out.println(generateSquareFormula2("a+b"));
	}
	
	private static String generateSquareFormula(String statement) {
		String formula = "";
		String[] charArr = statement.split("\\+");
		for (int i = 0; i < charArr.length; i++) {
			for (int j = 0; j < charArr.length; j++) {
				formula+=charArr[i]+charArr[j]+"+";
			}
		}
		if(Character.toString(formula.charAt(formula.length() - 1)).equalsIgnoreCase(Character.toString('+'))) formula = formula.substring(0, formula.length() - 1);
		String[] formulaArr = formula.split("\\+");
		Arrays.sort(formulaArr);
		List<String> formulaList = Arrays.asList(formulaArr);
		Map<String, Integer> map = new HashMap<>();
		formulaList.stream().map(l -> {
			char[] charArray = l.toCharArray();
			Arrays.sort(charArray);
			String value = "";
			for (int j = 0; j < charArray.length; j++) {
				value+=charArray[j];
			}
			return value;
		}).sorted().forEach(l -> map.put(l, map.containsKey(l) ? map.get(l) + 1 : 1));
		List<String> formulaList2 = new ArrayList<String>();
		for (String key : map.keySet()) {
			if(map.get(key) == 2) formulaList2.add(2+key);
			else formulaList2.add(key);
		}
		String result = formulaList2.stream().map(l -> {
			char[] charArray = l.toCharArray();
			return charArray[0] == charArray[1] ? Character.toString(charArray[1])+"^2" : l;
		}).reduce("", (a, b) -> a+"+"+b);
		if(Character.toString(result.charAt(0)).equalsIgnoreCase(Character.toString('+')))  
			return result.substring(1, result.length()) ;
		return result;
	}
	
	private static String generateSquareFormula2(String str) {
		String formula[] = {""};
		String[] charArr = str.split("\\+");
		List<String> sqrList = new ArrayList<>();
		List<String> mlList = new ArrayList<>();
		for (int i = 0; i < charArr.length; i++) {
			for (int j = 0; j < charArr.length; j++) {
				if(charArr[i].equalsIgnoreCase(charArr[j])) {
					sqrList.add(charArr[j]+"^2");
				}else {
					char[] charArray =(charArr[i]+charArr[j]).toCharArray();
					Arrays.sort(charArray);
					mlList.add(new String(charArray));
				}
			}
		}
		Collections.sort(mlList);
		Set<String> mlSet = new HashSet<>();
		mlList.forEach(e -> mlSet.add(2+e));
		sqrList.addAll(mlSet);
		sqrList.forEach(l -> formula[0]+=l+"+");
		return formula[0].substring(0, formula[0].length() - 1);
	}
}

