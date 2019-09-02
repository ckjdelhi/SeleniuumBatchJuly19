package com.test;

import java.util.regex.Pattern;

public class Utility {
	private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public boolean validateEmail(String emailId) {
		final Pattern EMAIL_REGEX = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(emailId).matches();
	}
	
	/*public static void main(String []args) {
		Utility obj=new Utility();
		System.out.println(obj.validateEmail("chandan.krk@gmail.com"));
		System.out.println(obj.validateEmail("chandan.krk@gmailco.m"));
	}*/

}
