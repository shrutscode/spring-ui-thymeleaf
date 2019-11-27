package com.exercise.uidemo.web;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {
	
	/**
	 * 
	 * @param stDate
	 * @param endDate
	 * @return the number of days between stDate and endDate
	 */
	public static long getDateDiff(String stDate, String endDate) {
		
		return ChronoUnit.DAYS.between(LocalDate.parse(stDate), LocalDate.parse(endDate));
		
	}

}
