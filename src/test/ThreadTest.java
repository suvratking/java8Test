package test;

import java.util.stream.IntStream;

public class ThreadTest {

	public static void main(String[] args) {
		
		IntStream.range(1, 101).forEach(i -> {
			new Thread(() -> System.out.println("Printing")).start();;
		});
		
	}
	
}
