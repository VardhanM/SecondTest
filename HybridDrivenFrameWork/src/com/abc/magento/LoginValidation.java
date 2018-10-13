package com.abc.magento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * This class is to Automate Magento Application
 * @author vishnu
 * @version 1.6.0
 */

public class LoginValidation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		FileInputStream fis=new FileInputStream("src\\com\\abc\\utilities\\hybrid.properties");
		Properties p=new Properties();
		p.load(fis);

		String url=p.getProperty("url");
		String un=p.getProperty("un");
		String pw=p.getProperty("pw");
		String myacc=p.getProperty("myacc");
		String email=p.getProperty("email");
		String pwd=p.getProperty("pwd");
		String login=p.getProperty("login");
		String logout=p.getProperty("logout");

		driver.get(url);

		driver.findElement(By.xpath(myacc)).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(email)).sendKeys(un);
		Thread.sleep(2000);

		driver.findElement(By.xpath(pwd)).sendKeys(pw);
		Thread.sleep(2000);

		driver.findElement(By.xpath(login)).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(logout)).click();
		Thread.sleep(2000);

        FileOutputStream fos=new FileOutputStream("src\\\\com\\\\abc\\\\utilities\\\\hybrid.properties");
        p.setProperty("Result","pass");
        p.save(fos,"Test case passed....");
		driver.quit();


	}

}
