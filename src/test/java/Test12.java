

interface I1 {
	public void m1();

	public void m2();
}

public class Test12 {
	public static void main(String[] args) {
		I1 obj=new I1() {
			public void m1() {
				System.out.println("Inside M1");
			}
			public void m2() {
				System.out.println("Inside M2");
			}
		};
		obj.m1();
		
	}
}
