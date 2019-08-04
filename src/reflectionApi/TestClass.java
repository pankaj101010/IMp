package reflectionApi;

public class TestClass {
  public static void main(String[] args) throws NoSuchFieldException, SecurityException, ClassNotFoundException {
	    Class c = ReflectionDemo.class;
	    String d = c.toGenericString();
	    if (c.getModifiers() == 1) {
			
	    	System.out.println(c.isPrimitive());
		}
	        System.out.println(c.getClass()+" "+ c.getModifiers());
	    		
	    		
     }
}
