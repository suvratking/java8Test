package interfaceMethods;

public class TestClass {
	public static void method() {
		TestInterface ti = () -> System.out.println("Testing");
		ti.foo();
		ti.method1();
		TestInterface.privatMehod();
	}
	public static void main(String[] args) {
		method();
	}
}