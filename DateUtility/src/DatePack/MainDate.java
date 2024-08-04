package DatePack;

import java.util.HashMap;
import java.util.Map;

class MyDate{
	private int date;
	private int month;
	private int year;
	static DateHelper helper=new DateHelper();
	private static String MonthName[]= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	private static final Map<String, Integer> monthMap = new HashMap();
	public MyDate() {
		
	}
	
	public MyDate(int date, int month, int year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
	public MyDate(String date) {
		MyDate stringdate=parseDate(date);
		this.setDate(stringdate.getDate());
		this.setMonth(stringdate.getMonth());
		this.setYear(stringdate.getYear());
	}
	public static MyDate parseDate(String date) {
        String[] dateParts = date.split("-");
        int dateValue = Integer.parseInt(dateParts[0]);
        int monthValue;
        try {
            monthValue = Integer.parseInt(dateParts[1]);
        } catch (NumberFormatException e) {
            monthValue = monthMap.get(dateParts[1].toLowerCase());
        }
        int yearValue = Integer.parseInt(dateParts[2]);
        return new MyDate(dateValue, monthValue, yearValue);
    }
	
	

	public void addDay(int days) {
		int nday=helper.findDaysFromJan(this.getMonth(),this.getYear())+this.getDate()+days;
		int year=this.getYear();
		while(nday>helper.getNumberOfDayInYear(year)) {
			nday-=helper.getNumberOfDayInYear(year);
			year++;
		}
		int month=1;
		while(nday>helper.getDaysInMonth(month,year)) {
			nday-=helper.getDaysInMonth(month,year);
			month++;
		}
		this.setDate(nday);
		this.setMonth(month);
		this.setYear(year);
	}
	
	public void subtractDay(int days) {
		helper=new DateHelper();
		int nday = helper.findDaysFromJan(this.month, this.year) + this.date - days;
		int year = this.year;
		while (nday <= 0) {
			year--;
			nday += helper.getNumberOfDayInYear(year);
		}
		this.date=31;
		this.month=12;
		this.year=year - 1;
		addDay(nday);
	}
	
	public static int differenceDate(MyDate date1,MyDate date2) {
		if(helper.datePosition(date1,date2)==false) {
			MyDate tdate=date1;
			date1=date2;
			date2=tdate;
		}
		 if (date1.getYear() == date2.getYear()) {
	            return Math.abs(helper.findNumberOfDays(date2) - helper.findNumberOfDays(date1));
	        }
		 int daysBetweenYears = 0;
		 daysBetweenYears = helper.getNumberOfDayInYear(date1.getYear()) - (helper.findDaysFromJan(date1.month, date1.year) + date1.date);
		 for (int year = date1.getYear() + 1; year < date2.getYear(); year++) {
             daysBetweenYears += helper.getNumberOfDayInYear(year);
         }
         daysBetweenYears +=(helper.findDaysFromJan(date2.month, date2.year) + date2.date);
		return daysBetweenYears;
	}
	public MyDate subtract(int days) {
		return new MyDate();
	}
	public MyDate differnce(int days) {
		return new MyDate();
	}
	
	public int getDate() {
		return date;
	}
	
	public void setDate(int date) {
		this.date = date;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Date: " + date + "-" + MonthName[month-1] + "-" + year;
	}
	static {
        monthMap.put("jan", 1);
        monthMap.put("feb", 2);
        monthMap.put("mar", 3);
        monthMap.put("apr", 4);
        monthMap.put("may", 5);
        monthMap.put("jun", 6);
        monthMap.put("jul", 7);
        monthMap.put("aug", 8);
        monthMap.put("sep", 9);
        monthMap.put("oct", 10);
        monthMap.put("nov", 11);
        monthMap.put("dec", 12);
    }
}
public class MainDate {

	public static void main(String[] args) {
		MyDate date=MyDate.parseDate("2-8-2024");
//		MyDate date=MyDate.parseDate("31-12-2026");
//		MyDate date=new MyDate(10,3,2025);
		date.addDay(1000);
		System.out.println(date);
		
		date.subtractDay(450);
		System.out.println(date);
		
		System.out.println(MyDate.differenceDate(new MyDate(1,1,2024),new MyDate(2,8,2024)));
	}

}

