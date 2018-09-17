package cn.karlrixon;

import java.lang.String;

public class stringLearning {
	public static void main(String[] args) {
		String stra = "hello";
		char[] chArray = stra.toCharArray();		//toCharArray
		System.out.println(stra);
		String strb = new String(chArray, 1, 3);
		System.out.println(strb);
		System.out.println(stra.equals(strb));
		System.out.println(stra.compareTo(strb));
		System.out.println(stra.contains(strb));
		System.out.println(stra.indexOf(strb));
		System.out.println(stra.lastIndexOf(strb));
		String strc = stra.replaceAll("l+", "ii");
		System.out.println(strc);
		String strd = stra.substring(1, 4);
		System.out.println(strb == strd);
//		System.out.println(strd);
		String[] strs = stra.split("e");
		System.out.println("strs[0] = "+strs[0]+"\tstrs[1] = "+strs[1]);
		System.out.println(stra.toUpperCase());
		String stre = " hello world ";
		System.out.println(stre.trim());
		System.out.println("stre.length:"+stre.length()+"\tstre.trim.length:"+stre.trim().length());
		String strf = "";
		System.out.println(strf.isEmpty());
	}
}
