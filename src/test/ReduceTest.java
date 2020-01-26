package test;

import java.util.ArrayList;
import java.util.List;

public class ReduceTest {

	public static void main(String[] args) {
		
		List<TestPojo> tpl = new ArrayList<TestPojo>();
		
		tpl.add(new TestPojo(53, 85));
		tpl.add(new TestPojo(63, 25));
		tpl.add(new TestPojo(13, 65));
		tpl.add(new TestPojo(53, 55));
		tpl.add(new TestPojo(83, 75));
		
		System.out.println(tpl.stream().map(tp -> (tp.getMark1() + tp.getMark2()) / 2.0 ).reduce(0.0 , (a, b) -> a + b));
		
		System.out.println(tpl);
		
	}
	
}
