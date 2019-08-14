package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import utils.Browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

public class BrowserFactory {
	private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    private static final String BROWSER_PROP_KEY = "browser";
    
    
    public static final WebDriver getBrowser() {
        Browsers browser;
        WebDriver driver;

       if(System.getProperty(BROWSER_PROP_KEY)==null){
           browser = Browsers.CHROME;//FIREFOX;
       }else{
           browser = Browsers.browserForName(System.getProperty(BROWSER_PROP_KEY));
       }

       switch(browser){
           case CHROME:
               driver = createChromeDriver();        	 
               break;
//           case IE:
//               driver = createIEDriver();
//               //System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
//               break;
           case FIREFOX:
        	   driver = createFirefoxDriver();//(getFirefoxProfile(profileName));        	   
               LOGGER.info("******* Opening the Firefox Browser **************");               
               break;
           default:
               driver = createFirefoxDriver();        	   
               break;
       }

       return driver;
   }


   private static WebDriver createFirefoxDriver( ){

   DesiredCapabilities cap = new DesiredCapabilities();
           cap.setJavascriptEnabled(true);
           cap.setBrowserName("firefox");
           System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
           return new FirefoxDriver(cap);      
   }
   
   private static WebDriver createChromeDriver() {
      
       DesiredCapabilities cap = new DesiredCapabilities();
       cap.setJavascriptEnabled(true);
       cap.setBrowserName("chrome");                    
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");  
       return new ChromeDriver(cap);
   }
}
