package com.accolite.mini_au;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Call {
	LocalDateTime call_start;
	LocalDateTime call_end;
	long d_minutes;
	long d_hours;
	long d_seconds;
	String number;
	public Call(String num)
	{
		d_minutes =0;
		d_hours = 0;
		d_seconds = 0;
		number = num;
		call_start = LocalDateTime.now();
	}
	
	public void calculateDuration()
	{
		
		
		
		d_hours = ChronoUnit.HOURS.between(call_start, call_end);
		d_minutes = ChronoUnit.MINUTES.between(call_start, call_end) - d_hours*60;
		d_seconds = ChronoUnit.SECONDS.between(call_start, call_end) - d_minutes*60 - d_hours*60*60; 

	}
	
	
	public void callEnd()
	{
		call_end = LocalDateTime.now();
		calculateDuration();
	}

	@Override
	public String toString() {
		return number+" "+ call_start.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + " duration: " + d_hours + ":" +d_minutes  + ":"
				+ d_seconds ;
	}
	
	
	
}
