package base;

public class AppData {
	public static String platform = System.getProperty("platform", "android");
	public static String isCloud = System.getProperty("isCloud","false");	
	public static String useGesturePlugin = System.getProperty("useGesturerPlugin", "false");
	public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "false");

}
