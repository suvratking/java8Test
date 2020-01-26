package lamdaExamples;

@FunctionalInterface
public interface Interface1 {
	
	int showMessage(int msg, int msg2);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
		print(str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}

}
