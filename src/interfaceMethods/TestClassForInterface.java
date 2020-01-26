package interfaceMethods;

public class TestClassForInterface extends TestClass implements TestInterface{
	public static void main(String[] args) {		
		TestClass.method();
	}

	@Override
	public void foo() {
	}
}
