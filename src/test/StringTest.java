package test;

public class StringTest {

	public static void main(String[] args) {
		//check();
		multipy("a+b+c");
	}

	private static void check() {
		String str1 = "ABCDEFGHIJKL";
		String str2 = "DEF";
		if (str1.contains(str2)) {
			String srtArr = str1.split(str2)[0];
			System.out.println((srtArr.length()));			
 		} else {

		}
	}
	
	private static void multipy(String str) {
		String[] strArr = str.split("\\+");
		for (int i = 0; i < strArr.length; i++) {
			for (int j = 0; j < strArr.length; j++) {
				System.out.println(strArr[i]+strArr[j]);
			}
		}
	}
	
}
