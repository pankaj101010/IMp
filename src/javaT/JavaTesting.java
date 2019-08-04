package javaT;

import java.io.IOException;
import java.util.Arrays;

public class JavaTesting {
	public static int check(int a , int b) {
		int total =0;
		try {
			System.out.println("Execution  starts");
			throw new IOException("pankaj");
			// total = a/0;
			// return a-b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.toString());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
	       e.printStackTrace();
			return a*b;
			
		}
		  finally{ 
			  System.out.println("execution end"); 
			  return a+b; 
			  }
		 
		
	}
 public static void main(String[] args) {
	 
	 int [] g = {2,9,2,9,7,2,4,7};
	 int [] r = {7,6,5,4,3,2};
	int [] w = Arrays.copyOf(g, 10);
	Arrays.fill(g, 50);
	//System.out.println(g.length);
	for (int i : g) {
		System.out.print(i);
	}
	 
	 System.out.println();
	 int n=5,x,value;
	 for (int i = 1; i <=n; i++) {
		 x = n-1;
		value = i; 
		for (int j = 1; j <=i; j++) {
			System.out.print(value+" ");
			value+=x;
			x--;
		}
		System.out.println();
	}
	
	}
}
