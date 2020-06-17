package app;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.WebDriverRunner;
public class GoogleCrawler {
	private SelenideConfig config = new SelenideConfig();
	
	private String timeFormat(long millis) {
		return String.format("%d min, %d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(millis),
			    TimeUnit.MILLISECONDS.toSeconds(millis) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
			);
	}
	@Test
	public void crawler() throws Exception {
		long start = System.currentTimeMillis();
		Configuration.browser = WebDriverRunner.CHROME;
		Configuration.headless = true;
		
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", Config.CHROMEDRIVER_FOR_WIN_PATH);
		} else {
			System.setProperty("webdriver.chrome.driver", Config.CHROMEDRIVER_FOR_LINUX_PATH);
			System.out.println("OS IS LINUX");
			System.out.println("chrome.driver path " + Config.CHROMEDRIVER_FOR_LINUX_PATH);
		}

		System.out.println("---------------- start open");
		GooglePage googlepage = open("https://www.google.co.jp", GooglePage.class);
		System.out.println("start getTitle");
		sleep();
		String actualTitile = googlepage.context();
		System.out.println("TITLE: " + actualTitile);
		assertThat(actualTitile, is(containsString("Google")));
		long end = System.currentTimeMillis();
		System.out.println(timeFormat(end - start));
	}
	
	
	private void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
