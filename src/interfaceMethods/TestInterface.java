package interfaceMethods;

public interface TestInterface {

	default void method1() {
		System.out.println("From test interface");
		privatMehod();
	}
	
	static void privatMehod() {
		System.out.println("From test interface static");
	}
	
	void foo();
	
}
