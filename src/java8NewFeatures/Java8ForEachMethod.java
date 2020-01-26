package java8NewFeatures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Java8ForEachMethod {

	Java8ForEachMethod(){
		
		List<Integer> myList=new ArrayList<Integer>();
		for (int i = 0; i < 20; i++) {
			myList.add(i);	
		}
		
		Iterator<Integer> itr=myList.listIterator();
		while (itr.hasNext()) {
			int value = (int) itr.next();
			System.out.println("Value from Iteratot : @ "+value);
			
		}
		
		for (int value : myList) {
			System.out.println("Value from forEach : @ "+value);
		}
		
		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer value) {
				System.out.println("Value : @ "+value);
				
			}
		});

		myList.forEach(value->System.out.println("From Lamda : @ "+value));
		
	}
	
	public static void main(String[] args) {
		new Java8ForEachMethod();
	}
	
}
