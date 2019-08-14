package library;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionMethods {
	
	/**
	 * @author Chetana Kolgiri
	 * Description: Common method to click a WebElement 
	 */
	public static WebDriver driver;
	public static void clickElement(WebElement elem) {
		try {
			if (elem.isDisplayed()) {
				elem.click();
			}
			else{
				System.out.println(elem.getText() + " : Element not found");	
			
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	/**
	 * @author Chetana Kolgiri
	 * Description: Common method to Enter text  in textbox 
	 */
	public static void setTextBox(WebElement elem, String texttoEnter) {
		try {
			if (elem.isDisplayed()) {
				elem.sendKeys(texttoEnter);
			}
			else{
				System.out.println(elem.getText() + " : Element not found");	
			
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	/**
	 * @author Ganesh Babar
	 * @param elem Description: Common method to clear text in textbox
	 */
public static void clearTextBox(WebElement elem) {
		try {
			if (elem.isDisplayed()) {
				elem.clear();
			} else {
				System.out.println(elem.getText() + " : Element not found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void submitform(WebElement elem) {
	try {
		if (elem.isDisplayed()) {
			elem.click();
		} else {
			System.out.println(elem.getText() + " : Element not found");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void pause(int pauseTimeinSec) {
	try {
		Thread.sleep(pauseTimeinSec*1000);
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void selectOptionByIndex(WebElement ele, int elementIndex) {
	try {
		if(ele.isDisplayed()) {
			Select sel=new Select(ele);
			sel.selectByIndex(elementIndex);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	


public static void selectoptionByVisibleText(WebElement ele, String visibleText) {
	if(ele.isDisplayed()) {
		Select sel=new Select(ele);
		sel.selectByVisibleText(visibleText);
		
	}	
}

public static void selectByValue(WebElement ele, String value) {
	if(ele.isDisplayed()) {
		Select sel=new Select(ele);
		sel.selectByVisibleText(value);
	}	
}

public static void movetoChildWindow() {
	Set<String> handles=driver.getWindowHandles();

	String handle=driver.getWindowHandle();
	for(String a:handles) {
		if(!a.equals(handle)) {
			driver.switchTo().window(a);
		}
	}
}

public static void movescrolldown() {
	Actions act=new Actions(driver);
	act.moveByOffset(-10, -10).click().build().perform();
}

}
		




