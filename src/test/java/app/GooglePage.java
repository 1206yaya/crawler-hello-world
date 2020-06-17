package app;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

public class GooglePage {

	public String context() {
		System.out.println(">>>> GooglePage#context " + $(By.tagName("body")).getText());
		return $(By.tagName("body")).getText();
	}

}
