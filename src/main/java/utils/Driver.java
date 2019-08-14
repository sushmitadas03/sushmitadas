package utils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
//import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;

public class Driver {
	private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    private static WebDriver mDriver;
    //private static WebDriverWait wait;
    Properties ENV=null;
    
	public synchronized static WebDriver getCurrentDriver(){
        if (mDriver==null) {
            try {
                mDriver = BrowserFactory.getBrowser();
                if(mDriver!=null)
                    mDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (UnreachableBrowserException e) {
                e.printStackTrace();
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
        }
        return mDriver;
    }

//    public synchronized static WebDriver initialiseDriver(){
//            try {
//                mDriver = BrowserFactory.getBrowser();
//                
//                    mDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            } catch (UnreachableBrowserException e) {
//                e.printStackTrace();
//            } catch (WebDriverException e) {
//                e.printStackTrace();
//
//            }
//        return mDriver;
//    }
    

}
