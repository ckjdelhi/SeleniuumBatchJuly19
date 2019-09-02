package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmailValidatorTest {
 
	private Utility obj=null;

	@BeforeTest
	public void setUp() {
		obj=new Utility();
	}
	
	@Test
	public void canTestValidEmailId() {
		boolean isValid=obj.validateEmail("chandan.krk@gmail.com");
		Assert.assertTrue(isValid);
	}
	@Test
	public void canTestInvalidEmailIIdWhenDotIsMissing() {
		boolean isValid=obj.validateEmail("chandan.krk@gmailcom");
		//Assert.assertFalse(isValid);
		Assert.assertEquals(isValid, false);
	}
	@Test
	public void canTestInvalidEmailIIdWhenAtTheRateIsMissing() {
		boolean isValid=obj.validateEmail("chandan.krkgmail.com");
		//Assert.assertFalse(isValid);
		Assert.assertEquals(isValid, false);
	}
	@Test
	public void canTestInvalidEmailIIdWhenAfterDotOne1LetterAvailabe() {
		boolean isValid=obj.validateEmail("chandan.krk@gmailco.m");
		Assert.assertFalse(isValid);
	}
	
	
}
