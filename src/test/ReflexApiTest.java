package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflexApiTest {
	public static void main(String[] args) {
		String[] mNames = {"Roll", "Name", "Mark"};
		TestClass tc = new TestClass();
		for (int i = 0; i < mNames.length; i++) {
			try {
				Method method = Class.forName("test.TestClass").getMethod("get"+mNames[i], new Class[] {Object.class});
				System.out.println(method.invoke(tc, 5).toString());
			} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
				System.err.println(e.getMessage());
				//e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.err.println(e.getMessage());
				//e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				//e.printStackTrace();
			} catch (InvocationTargetException e) {
				System.err.println(e.getMessage());
				//e.printStackTrace();
			}catch (Exception e) {
				System.err.println(e.getMessage());
				//e.printStackTrace();
			}
		}
	}
}
