package mGameInfo.client.util;

public class Strings {
	public static String replaceString(String str){
		str = str.replaceAll(":", "");
		str = str.replaceAll("'", "");
		str = str.replaceAll(" ", "+");
		return str;
	}
	
	public static String replaceString2(String str){
		str = str.replace("+", "%2B");
		str = str.replaceAll("&", "%26");
		str = str.replaceAll(" ", "&");
		str = str.replaceAll(":", "%3A");
		str = str.replaceAll("/", "%2F");
		str = str.replaceAll("=", "%3D");
		return str;
	}
	
	public static String replaceStringTweet(String str){
		str = str.replaceAll(":", "");
		str = str.replaceAll("'", "");
		str = str.replaceAll(" ", "%2B");
		return str;
	}
	
	public static String replaceStringTweet2(String str){
		str = str.replaceAll("%2B", "");
		str = str.replace("+", "");
		return str;
	}

}
