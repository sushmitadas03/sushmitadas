package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;
import utils.PropertyFileReader;

public class PgeFlip {
	WebDriver objAdminDriver = Driver.getCurrentDriver();
	PropertyFileReader propertyFile = new PropertyFileReader();	
	
	//Constructor
    public PgeFlip(WebDriver objAdminDriver){
        this.objAdminDriver = objAdminDriver;
        //This initElements method will create all WebElements
        PageFactory.initElements(objAdminDriver, this);
    }

	@FindBy(xpath = "//div/a[contains(text(),'Login & Signup')]")
    public WebElement login_flipkart;  
	
	@FindBy(xpath = "//div[@class='_1XBjg- row']//div/input[@class='_2zrpKA _1dBPDZ']")
	public WebElement username_kart ;
	
	@FindBy(xpath = "//div[@class='_1XBjg- row']//div/input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	public WebElement password_kart;
	
	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']") 
	public WebElement btn_login;

	
	@FindBy(xpath = "//div[@class='Y5-ZPI']//div/input[@class='LM6RPg']")
	public WebElement txt_searcharea;
	
	@FindBy(xpath = "//button[@class='vh79eN']")
	public WebElement btn_search;
	
//	@FindBy(xpath = "//div[@class='_1tz-RS']//div//img[contains(@title,'Flipkart')]")
//	public WebElement txt_flipkartDisplayed;
	
	@FindBy(xpath = "//div[@class='_3pNZKl']//div[contains(text(),'Sushmita')]")
	public WebElement txt_loginNameDisplayed;
	
	@FindBy(xpath = "//div[@class='_2zg3yZ']")
	public WebElement sec_pageLists;
	
	@FindBy(xpath = "//div[@class='_1OCn9C']")
	public WebElement item_last;
	
	@FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	public WebElement btn_addCart;
	
	@FindBy(xpath = "//button[@class='_2AkmmA iwYpF9 _7UHT_c']")
	public WebElement btn_placeOrder;
	
	@FindBy(xpath = "//button[contains(text(),'Change')]")
	public WebElement btn_change;
	
	//logout
	@FindBy(xpath = "//div[@class='_2aUbKa']")
	public WebElement ico_loginName;
	
	//@FindBy(xpath = "//ul[@class='account-dropdown']//*[contains(@href,'logout')]")
	@FindBy(xpath = "//a[contains(@class,'_2fqf-l')]")
	public WebElement item_logout;
		
    
    // should be logged out now.
   // .validatePresent(By.cssSelector("a[href*='/login']"));
	
	
	
}
