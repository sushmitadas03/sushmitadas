package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

	 WebDriver objDriver = Driver.getCurrentDriver();
	// JavascriptExecutor executor = (JavascriptExecutor)objDriver;

	    public static boolean verifyElementExists(WebElement webElement) throws IOException {
	        boolean linkFound = false;
	        try{
	            webElement.getText();
	            linkFound = true;
	        }catch (NoSuchElementException e) {
	            linkFound = false;
	        }
	        return linkFound;
	    } 
	    
	    public static void clickviaJS(WebElement element) {
	        JavascriptExecutor executor = (JavascriptExecutor)Driver.getCurrentDriver();
	        executor.executeScript("arguments[0].click();", element);
	    }
	    
	    public static boolean verifyElementExists(By by) {
	        boolean blnElementFound = true;
	        Driver.getCurrentDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	        try{
	            Driver.getCurrentDriver().findElement(by);
	            
	        }catch(Exception NoSuchElementException) {
	            blnElementFound = false;
	            
	        }
	        Driver.getCurrentDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        return blnElementFound;
	    }
	    
	    public static String getConfigPropertyFileName(String propFileName){
	        String filePath = "\\src\\test\\resources\\Environment\\"+propFileName;
	        String propFileName1=System.getProperty("user.dir") + filePath.replace('\\', File.separatorChar);
	        return propFileName1;
	    }
	    
//	    public static void mouseHoverByJavaScript(WebElement targetElement)
//	    {
//
//	        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
//	                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
//	                "arguments[0].dispatchEvent(evObj);";
//	        executor.executeScript("arguments[0].scrollIntoView(true);", targetElement);
//	        ((JavascriptExecutor)BrowserDriver.getCurrentDriver()).executeScript(javaScript, targetElement);
//	    }
	    
}
