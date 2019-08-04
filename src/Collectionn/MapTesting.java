package Collectionn;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTesting {
      public static void main(String[] args) {
		Map mp = new Hashtable();
		mp.put(null, "pankaj1010");
		mp.put(null, "pankaj1323");
		mp.put("phonenumber", "9096744922");
		mp.put("address", "amravati");
		mp.put("employee id", 12458);
		mp.put("dob", "10/10/90");
		System.out.println(mp);
		//Set st = mp.entrySet();
	      System.out.println(mp.get(null));
		
	}
}
