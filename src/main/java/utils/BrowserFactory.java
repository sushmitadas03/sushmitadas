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
    //private static final String RUNLOCATION_PROP_KEY = "runLocation";
  //  private static final String ENVIRONEMNT_PROP_KEY = "envType";
//
//    private static WebDriver createFirefoxDriver(FirefoxProfile firefoxProfile) {
//        //return new FirefoxDriver(firefoxProfile);
//        return new FirefoxDriver();
//    }

//    private static FirefoxProfile getFirefoxProfile(String profileName) {
//        ProfilesIni profile = new ProfilesIni();
//        FirefoxProfile ffProfile = profile.getProfile(profileName); // firefox profile **
//        ffProfile.setAcceptUntrustedCertificates(true);
//        ffProfile.setAssumeUntrustedCertificateIssuer(true);
//        String environment = System.getProperty(ENVIRONEMNT_PROP_KEY);
//       
//        return ffProfile;
//    }

//    private static void addAllBrowserSetup(WebDriver driver) {
//        String runLocation = System.getProperty(RUNLOCATION_PROP_KEY);
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            driver.manage().window().maximize();
//
//    }
    
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
        	   //System.setProperty("webdriver.chrome.driver", "/src/main/resources/driver/chromedriver.exe");
               //driver.manage().window().maximize();
               break;
//           case IE:
//               driver = createIEDriver();
//               //System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
//               break;
           case FIREFOX:
        	   driver = createFirefoxDriver();//(getFirefoxProfile(profileName));
        	   //System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
               LOGGER.info("******* Opening the Firefox Browser **************");
               //driver.manage().window().maximize();
               break;
           default:
               driver = createFirefoxDriver();
        	   //System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
               //driver.manage().window().maximize();
               break;
       }
//       addAllBrowserSetup(driver);
       return driver;
   }

//   public static final WebDriver getBrowser(String profileName) {
//       Browsers browser;
//       WebDriver driver;
//
//       if(System.getProperty(BROWSER_PROP_KEY)==null){
//           browser = Browsers.FIREFOX;
//       }else{
//           browser = Browsers.browserForName(System.getProperty(BROWSER_PROP_KEY));
//       }
//
//       switch(browser){
//           case CHROME:
//        	   //System.setProperty("webdriver.chrome.driver", "/src/main/resources/driver/chromedriver.exe");
//              driver = createChromeDriver();
//               break;
//           case IE:
//              driver = createIEDriver();
//               //System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
//               break;
//           case FIREFOX:
//        	   //System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
//              driver = createFirefoxDriver();
//               LOGGER.info("******* Opening the Firefox Browser **************");
//               break;
//           default:
//               driver = createFirefoxDriver();
//        	   //System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
//               break;
//       }
//      // addAllBrowserSetup(driver);
//       return driver;
//   }

//   private static WebDriver createIEDriver() {
//       //RunLocation runLocation = RunLocation.runLocationForName(System.getProperty(RUNLOCATION_PROP_KEY));
////       DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
//	   DesiredCapabilities cap = new DesiredCapabilities();
////
//       //cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
////       //cap.setCapability(CapabilityType.PROXY, Environment.setProxy(System.getProperty(ENVIRONEMNT_PROP_KEY)));
//       cap.setJavascriptEnabled(true);
//       cap.setBrowserName("internet explorer");
//       System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "src/main/resources/driver/IEDriverServer.exe");
//       return new InternetExplorerDriver(cap);
//          
//   }

   private static WebDriver createFirefoxDriver( ){
//       //RunLocation runLocation = RunLocation.runLocationForName(System.getProperty(RUNLOCATION_PROP_KEY));
//       DesiredCapabilities cap =  DesiredCapabilities.firefox();
   DesiredCapabilities cap = new DesiredCapabilities();
//
//          // if("windows")
//           //    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");             
//           //cap.setCapability(CapabilityType.PROXY, Environment.setProxy(System.getProperty(ENVIRONEMNT_PROP_KEY)));
          // cap.setPlatform(getPlatform());
           cap.setJavascriptEnabled(true);
           cap.setBrowserName("firefox");
           System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
           return new FirefoxDriver(cap);      
   }
//   
//
   private static WebDriver createChromeDriver() {
      // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
       //RunLocation runLocation = RunLocation.runLocationForName(System.getProperty(RUNLOCATION_PROP_KEY));
       //boolean proxyExtFlag = System.getProperty("proxypass")!=null;
       //DesiredCapabilities cap = DesiredCapabilities.chrome();
       DesiredCapabilities cap = new DesiredCapabilities();

       //cap.setCapability(CapabilityType.PROXY, Environment.setProxy(System.getProperty(ENVIRONEMNT_PROP_KEY)));
       //cap.setPlatform(getPlatform());
       cap.setJavascriptEnabled(true);
       cap.setBrowserName("chrome");
       // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");              
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");  
       return new ChromeDriver(cap);
   }
}
