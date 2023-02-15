package org.sample;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasicTest extends BaseClass {
	
	public static void main(String[] args) throws IOException {
		
		launchBrowser("chrome");
		maximizeWindow();
		launchUrl("https://www.facebook.com/");
		screenshot("fb-1");
		title();
		currentUrl();
		WebElement emailBox = driver.findElement(By.id("email"));
		passValue(emailBox, "abc@gmail.com");
		WebElement pwdBox = driver.findElement(By.name("pass"));
		passValue(pwdBox, "12345678");
		screenshot("fb-2");
		closeBrowser();
		
	}

}
