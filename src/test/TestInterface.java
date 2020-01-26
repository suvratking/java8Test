package test;

@FunctionalInterface
public interface TestInterface {

	default void show() {
		System.out.println("Inside Default Method from interface");
	}
	
	void print();
	
}
