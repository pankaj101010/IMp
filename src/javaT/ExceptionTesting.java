package javaT;

public class ExceptionTesting {

	public static void main(String[] args) {
		try {
			System.out.println("program start");
			//System.exit(0);
			int x = 10/0;
		}
		catch(Exception e){
			System.out.println("program in middle");
			Runtime.getRuntime().exit(1);
		}
		finally{
			System.out.println("program ends");
		}

	}

}
