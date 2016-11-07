///////////////////////////////////////////////////////////////////////////////////
////////////////DemoStockMarket//////////////////////////////////////////////////

package com.jpm.stockmarket.demo;

import java.util.Calendar;
import java.util.Date;

public class Utils {
	private static final int SAMPLE_TIME = 5; // 5 seconds

	// Returns current Time
	public static Date GetCurrentTime() {
		return new Date();
	}

	// Returns the Start Time (5 minutes before the current time)
	public static Date getStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, -SAMPLE_TIME);
		return cal.getTime();
	}
}
