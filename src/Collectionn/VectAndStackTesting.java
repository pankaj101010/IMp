package Collectionn;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class VectAndStackTesting {

	public static void main(String[] args) {
		
		Stack gh = new Stack();
		gh.add(48376);
		gh.add("ksjdv");
		gh.add('f');
		gh.add(017);
		
		System.out.println(gh.push(17));
//		gh.push(32);
//		gh.pop();
//		System.out.println(gh.peek());
//		System.out.println(gh);
//		System.out.println(gh.peek());
		
	
		ListIterator itr  = gh.listIterator();
		while (itr.hasNext()) {
			System.out.print(itr.next());
			System.out.println(itr.previous());
		}
		System.out.println();
		
/*		Vector v = new Vector(gh);
		     v.add("panka");
		     v.add(12);
		     v.add(34);
		     v.add('a');
		     v.add(12.3f);
		     v.add(null);
		     v.add(null);
		     v.add(gh);
		     v.addAll(gh);
		     System.out.println(v);
		     //Collections.sort(v); -- here we get the class cast exception if we are trying to
		     // sort the heterogenius objects.
		     Enumeration en = v.elements();
		     while (en.hasMoreElements()) {
				Object object = en.nextElement();
				System.out.println(object);	
			}
 
*/	
		}

}
