package kr.or.ddit.util;

public class MyUtils {
	
private static MyUtils myutils;
	
//	public static MyUtils getInstance() {
//		if(myutils == null) {
//			myutils = new MyUtils();
//		}
//		return myutils;
//	}
	

	public boolean isEmpty(String str) {
		if(str==null) {
			return true;
		}else if("".equals(str)){
			return true;
		}else {
			return false;
		}
	}
}
