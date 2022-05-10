package com.crm.VtigerBRAJ.genericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * its used to generate random number
	 * @return
	 */
	public int getrandomNum() {
		
		Random r=new Random();
		int randomNum = r.nextInt(1000);
		return randomNum;
	}
	/**
	 * used to get system date& time in IST format
	 * @return
	 */
	public String getsystemDateAndTime() {
		Date date=new Date();
		return date.toString().replace(":", "-");
	}
	public String getsystemDateWithFormat() {
		Date date=new Date();
		String dateAndTime=date.toString();
		
		String YYYY=dateAndTime.split(" ")[5];
		String DD=dateAndTime.split(" ")[2];
		int MM=date.getMonth()+1;
		String finalFormate=YYYY+"_"+MM+"_"+MM+"_"+DD;
		return finalFormate;
		
	}

}
