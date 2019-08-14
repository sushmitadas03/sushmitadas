package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertyFileReader {
		 
		 private Properties properties;
		
		 
		 String propertyFilePath = CommonMethods.getConfigPropertyFileName("data.properties");
		 		 
		 public PropertyFileReader(){
		 BufferedReader reader;
		 try {
			 reader = new BufferedReader(new FileReader(propertyFilePath));
			 properties = new Properties();
			 try {
				 	properties.load(reader);
				 	reader.close();
			 		} catch (IOException e) {
			 			e.printStackTrace();
			 		}
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
			 throw new RuntimeException("data.properties not found at " + propertyFilePath);
		 } 
		 }
		 
		 public String getDriverPath(){
			 String driverPath = properties.getProperty("driverPath");
			 if(driverPath!= null) 
				 return driverPath;
			 else 
				 throw new RuntimeException("driverPath not specified in the data.properties file."); 
		 }
		 
		 public String getDriverKey(){
			 String driverKey = properties.getProperty("driverKey");
			 if(driverKey!= null) 
				 return driverKey;
			 else 
				 throw new RuntimeException("driverKey not specified in the data.properties file."); 
		 }
		 
		 public String getPhoneNumber(){
			 String phoneNum = properties.getProperty("phone");
			 if(phoneNum!= null) 
				 return phoneNum;
			 else 
				 throw new RuntimeException("phone not specified in the data.properties file."); 
		 }
		 
		 public String getUsername(){
			 String user = properties.getProperty("username");
			 if(user!= null) 
				 return user;
			 else 
				 throw new RuntimeException("username not specified in the data.properties file."); 
		 }
		 public String getPassword(){
			 String password = properties.getProperty("password");
			 if(password!= null) 
				 return password;
			 else 
				 throw new RuntimeException("password not specified in the data.properties file."); 
		 }
		 
		 public long getImplicitlyWait() 
		 { 
			 String implicitlyWait = properties.getProperty("implicitlyWait");
			 if(implicitlyWait != null) 
				 return Long.parseLong(implicitlyWait);
			 else 
				 throw new RuntimeException("implicitlyWait not specified in the data.properties file."); 
		 }
		 
		 public String getApplicationUrl()
		 {
			 String url = properties.getProperty("url");
			 if(url != null) 
				 return url;
			 else 
				 throw new RuntimeException("url not specified in the data.properties file.");
		 }
		 
		
}
