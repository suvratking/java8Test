package lamdaExamples;

public class TestClassForFunctionalInterface {
	
	/*static Interface1 if1=new Interface1() {
		
		@Override
		public String showMessage(String msg) {
			return msg;
		}
	};*/
	
	static Interface1 if2=(val1, val2)->val1+val2;
	
	public static void main(String[] args) {
		//System.out.println(if1.showMessage("Hello Functional Interface"));
		if2.log("Default Mehod of interface");
		System.out.println(if2.showMessage(3,4));
	}

}
