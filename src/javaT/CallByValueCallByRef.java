package javaT;

public class CallByValueCallByRef {
	int p;
	int q;

	public static void main(String[] args) {
		CallByValueCallByRef obj = new CallByValueCallByRef();
		int x = 10;
		int y = 20;
		obj.add(x, y);// Call by value Or Pass by value

		obj.p = 15;
		obj.q = 75;
       System.out.println(obj);
		obj.swap(obj);
		System.out.println("p=:: "+obj.p);
		System.out.println("q::  "+obj.q);

	}

	public int add(int a, int b) {
		a = 30;
		b = 20;
		int c = a + b;
		System.out.println("Value of c "+c);
		return c;
	}

	
	public void swap(CallByValueCallByRef t) {
		int temp;
		System.out.println(t.p);
		temp = t.p;// temp=60
		System.out.println(temp);
		t.p = t.q;// p=70
		t.q = temp;// q=60
  System.out.println(t);
	}

}
