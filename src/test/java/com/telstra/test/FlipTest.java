package com.telstra.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.ini4j.CommonMultiMap;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PgeFlip;
import utils.CommonMethods;
import utils.Driver;
import utils.PropertyFileReader;

public class FlipTest
{
	WebDriver driver = Driver.getCurrentDriver(); 
	PropertyFileReader propertyFile = new PropertyFileReader();;
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	PgeFlip pgeWorklist = new PgeFlip(driver);
	Actions actions = new Actions(driver);
	String input = "camera";
	
 
  @BeforeClass
  public void launchBrowser()
  {
	  System.out.println("Start");
	  
	    String path = propertyFile.getDriverPath();
	    String key = propertyFile.getDriverKey();
	    System.setProperty(key, path);
		WebDriver driver = Driver.getCurrentDriver(); 
  }
  
  public ChromeDriver getDriver ()
  {
      return (ChromeDriver) driver;
  }
		
  @AfterClass
  public void closeBrowser() throws InterruptedException
  {
	   Thread.sleep(2000);
	   driver.close();
	   driver.quit();
  }	

  @Test
  public void FirstFlip() throws Throwable{
	
	  launchAndLogin();	 
	  Assert.assertTrue("LoginName is not displayed!",CommonMethods.verifyElementExists(pgeWorklist.txt_loginNameDisplayed));
		 
	  //search Camera and add to cart
	  searchAndClickCamera();

	  //logout
	  logout();
  }
  
  public void launchAndLogin() throws Throwable 
  {
	  driver.manage().window().maximize();
	  driver.get(propertyFile.getApplicationUrl());
	  Thread.sleep(2000);
	  //click on login
	  System.out.println("Entering username and password....");
	  //pgeWorklist.login_flipkart.click();
	  	  
	  //enter username and password
	 (pgeWorklist.username_kart).sendKeys(propertyFile.getPhoneNumber());
	  (pgeWorklist.password_kart).sendKeys(propertyFile.getPassword());
	   actions.moveToElement(pgeWorklist.btn_login).click().perform();
	  	 
	  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(pgeWorklist.txt_loginNameDisplayed));
  }
  
  public void searchAndClickCamera() 
  {
	  
	  //search for camera
	  pgeWorklist.txt_searcharea.sendKeys(input);
	  pgeWorklist.btn_search.click();	  
	  executor.executeScript("arguments[0].scrollIntoView(true);", pgeWorklist.sec_pageLists);
	  pgeWorklist.item_last.click();
	  
	  //switch control to new window
	  String window = driver.getWindowHandle();
	  Set<String> windowIterator = driver.getWindowHandles();
	  for (String s : windowIterator) {
          String windowHandle = s; 
	      driver.switchTo().window(windowHandle); 
	  }
	  
	  //add item to cart
	  pgeWorklist.btn_addCart.click();
	  pgeWorklist.btn_placeOrder.click();
  }
  
  
  public void logout() throws Throwable{
	  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(pgeWorklist.btn_change));
	  pgeWorklist.btn_change.click();
	  pgeWorklist.item_logout.click();
	  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(pgeWorklist.username_kart));
	  Assert.assertTrue("Logout is not successful!",CommonMethods.verifyElementExists(pgeWorklist.username_kart));

  }
  

}
