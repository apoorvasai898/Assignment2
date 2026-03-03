package com.comcast.hrm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random rand = new Random();
		int num = rand.nextInt(5000);
		return num;
	}
	
	public String getSystemDateYYYYDDMM()
	{
		Date dateObj = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}

	public String getRequiredDateYYMMDD(int days) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar cal = Calendar.getInstance(); //getInstance() gives the current date
	    cal.add(Calendar.DAY_OF_MONTH, days);
	    return sdf.format(cal.getTime());
	    
//	    Calendar.getInstance() → initializes with current system date
//	    add() → correctly adds/subtracts days
//	    format() → converts to required string
//	    getTime() -> Gives the date in the form of Sat Jan 31 11:14:64 IST 2026
//	    Calendar.getInstance().getTime() returns the current system date and time.
	}

	
	
	
}
