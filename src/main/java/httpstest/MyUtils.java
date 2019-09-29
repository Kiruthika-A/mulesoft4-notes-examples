package httpstest;

import java.util.Random;

public class MyUtils {
	public String s ;
	public MyUtils(String str) {
		s = str;
	}
	public static String appendRandom(String base) {
		return base + new Random().nextInt();
	}
	public String ObjMethod(String here) {
		return  "This is object method";
	}
}
