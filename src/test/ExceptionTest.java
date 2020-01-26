package test;

public class ExceptionTest {

	public static void main(String[] args) {
		try {
			int x = 1/0;
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
