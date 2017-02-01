package com.test1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RTest extends TestBase {
	
	@Test (dataProvider = "dataProvider")
	  public void testSuccessfulBusinessAccountRegistration(String email, String fName, String lName, String password, 
			  String confirmPassword, String phoneNumber, String verificationCode, String zipcode, String businessname,
			  String addressone, String city, String state, String industry, String category) throws InterruptedException
	  {
		
		  
		loginpage.clickIAmABusinessLink()
				 .fillOutAccountInformation(email, fName, lName, password, confirmPassword)
				 .enterPhoneNumber(phoneNumber, verificationCode)
				 .enterZipCode(zipcode)
				 .enterBusinessNameNonExistant(businessname, addressone, city, state, zipcode, industry, category)
				 .isCreateBusinessAccountSuccessful(businessname, addressone);;
	  		 
	  }

}
