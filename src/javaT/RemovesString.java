package javaT;

public class RemovesString {
//	public static String onlyRemove(String is, int i, int j) {
//		String val = "";
//		StringBuffer fb = new StringBuffer(is);
//		if (is.charAt(i) == is.charAt(j)) {
//			val = fb.substring(i + 1, j);
//			j = val.length();
//			if (j == 1)
//				return "";
//		}
//		return onlyRemove(val, 0, j - 1);
//	}

	public static String reduceString(String is) {
		if (is.equals(""))
			return "";
		String val = "";
		int len = is.length() - 1;
		StringBuffer fb = new StringBuffer(is);
		if (is.charAt(0) == is.charAt(len)) {
			val = fb.substring(1, len);
			if (val.length() == 1)
				return "";
		} else {
			return is;
		}
		return reduceString(val);
	}

	public static void main(String[] args) {
		System.out.println(reduceString("12133221"));
	}

//	private static char[] stringRemove(String s) {
//		if(s.charAt(0)==s.charAt(s.length()-1))
//		{
//			onlyRemove(s, 0, s.length()-1);
//		}
//	}

}
