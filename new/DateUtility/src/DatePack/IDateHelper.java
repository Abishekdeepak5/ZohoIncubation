package DatePack;

import java.util.HashMap;
import java.util.Map;

public interface IDateHelper {
	boolean isLeapYear(int year);
	int getNumberOfDayInYear(int year);
	int getDaysInMonth(int month,int yyyy);
	int findDaysFromJan(int mm,int yyyy);
	boolean datePosition(MyDate date1,MyDate date2);
}

class DateHelper implements IDateHelper{
	@Override
	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	@Override
	public int getNumberOfDayInYear(int year) {
		if(isLeapYear(year)) {
			return 366;
		}
		return 365;
	}
	
	@Override
	public int getDaysInMonth(int month,int yyyy) {
		int[] months= {31,28,31,30,31,30,31,31,30,31,30,31};
		if(month-1==1 && isLeapYear(yyyy)) {
			return months[1]+1;
		}
		return months[month-1];
	}
	
	@Override
	public int findDaysFromJan(int mm,int yyyy) {
		int month=1;
		int days=0;
		while(month<mm) {
			days+=this.getDaysInMonth(month,yyyy);
			month++;
		}
		return days;
	}
	
	@Override
	public boolean datePosition(MyDate date1,MyDate date2) {
		if(date1.getYear()==date2.getYear()) {
			if(date1.getMonth()==date2.getMonth()) {
				if(date1.getDate()>date2.getDate()) {
					return false;
				}else {
					return true;
				}
			}
			else if(date1.getMonth()>date2.getMonth()) {
				return false;
			}
		}
		else if(date1.getYear()>date2.getYear()) {
			return false;
		}
		return true;
	}
	
	 int findNumberOfDays(MyDate date) {
	        int days = date.getDate();
	        for (int i = 1; i < date.getMonth(); i++) {
	            days += getDaysInMonth(i, date.getYear());
	        }
	        return days;
	    }
	 
	 
}