package gui.util;

import java.util.Arrays;
import java.util.List;

public class ListTimes {
	
	public List<String> listHour(){
		List<String> hhList = Arrays.asList(
			"00","01","02","03","04","05","06","07","08","09",
			"10","11","12","13","14","15","16","17","18","19",
			"20","21","22","23");
		return hhList;
	}
	
	public List<String> listMinute(){
		List<String> mmList = Arrays.asList(
			"00","05","10","15","20","25","30","35","40","45","50","55");	
		return mmList;
	}
}
