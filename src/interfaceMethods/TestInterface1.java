package interfaceMethods;

public interface TestInterface1 {

	default void method() {
		System.out.println("From test interface1");
		privatMehod();
	}
	
	static void privatMehod() {
		System.out.println("From test interface1 static");
	}
	
	
}
