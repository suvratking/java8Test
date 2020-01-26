package test;

public class TestPojo {
	
	public TestPojo(int mark1, int mark2) {
		super();
		this.mark1 = mark1;
		this.mark2 = mark2;
	}
	private int mark1;
	private int mark2;
	public int getMark1() {
		return mark1;
	}
	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}
	public int getMark2() {
		return mark2;
	}
	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}
	@Override
	public String toString() {
		return "TestPojo [mark1=" + mark1 + ", mark2=" + mark2 + "]";
	} 
	
	
	
}
