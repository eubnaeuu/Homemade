package kr.or.ddit.util;

public class MyUtils {

	private static MyUtils myUtils;

//	public static MyUtils getInstance() {
//		if(myutils == null) {
//			myutils = new MyUtils();
//		}
//		return myutils;
//	}

	public static void setMyUtils(MyUtils myUtils) {
		MyUtils.myUtils = myUtils;
	}

	public boolean isEmpty(String str) {
		if (str == null) {
			return true;
		} else if ("".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

}
