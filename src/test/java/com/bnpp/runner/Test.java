package com.bnpp.runner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bnpp.utilities.Configurations;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver", Configurations.chromeDriverPath);
		 driver=new ChromeDriver();
		driver.get("https://int-acc-ewev.consorsbank.de/home");
		List<WebElement> a=driver.findElements(By.xpath("//li[@class=' has-dropdown ']"));
		System.out.println(a.size());

		if (a.size()==0){
				System.out.println("No element present");
				return;
			}
			else
				return;
		}
		
				
		
	}


