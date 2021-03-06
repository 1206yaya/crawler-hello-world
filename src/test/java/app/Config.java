package app;

import java.io.File;
import java.nio.file.Paths;

public class Config {
	public final static String PROJ_DIR = Paths.get(System.getProperty("user.dir")).toString();
	private static final String RESOURCES_DIR = Paths.get(PROJ_DIR, "src", "main", "resources").toString();
	private static final String CHROMEDRIVER_DIR = Paths.get(RESOURCES_DIR, "chromedriver").toString();
//	public static final String CHROMEDRIVER_FOR_WIN_PATH = Paths.get(CHROMEDRIVER_DIR, "chromedriver72.exe").toString();
	public static final String CHROMEDRIVER_FOR_WIN_PATH = Paths.get("C:\\Users\\aya-win10\\engineering\\tools\\crawler-driver\\chromedriver\\chromedriver72.exe").toString();
	public static final String CHROMEDRIVER_FOR_LINUX_PATH = Paths.get("/var/lib/jenkins/crawler-driver/chromedriver/chromedriver").toString();
	
}
