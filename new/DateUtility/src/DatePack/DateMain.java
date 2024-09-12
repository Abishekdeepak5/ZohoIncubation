package DatePack;

public class DateMain {
	static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	static int getNumberOfDayInYear(int year) {
		if(isLeapYear(year)) {
			return 366;
		}
		return 365;
	}
	static int getNumberOfMonth(int month,int yyyy) {
		int[] months= {31,28,31,30,31,30,31,31,30,31,30,31};
		if(month-1==1 && isLeapYear(yyyy)) {
			return months[1]+1;
		}
		return months[month-1];
	}
	
	static int findNumberOfDays(int mm,int yyyy) {
		int month=1;
		int days=0;
		while(month<mm) {
			days+=getNumberOfMonth(month,yyyy);
			month++;
		}
		return days;
	}
	
	public  void addDay(int dd,int mm,int yyyy,int num) {
		System.out.println(findNumberOfDays(mm,yyyy));
		int nday=findNumberOfDays(mm,yyyy)+dd+num;
		int year=yyyy;
		while(nday>getNumberOfDayInYear(year)) {
			nday-=getNumberOfDayInYear(year);
			year++;
		}
		System.out.println(nday);
		int month=1;
		while(nday>getNumberOfMonth(month,year)) {
			System.out.println(getNumberOfMonth(month,year)); 
			nday-=getNumberOfMonth(month,year);
			month++;
		}
		System.out.println(nday+" "+month+" "+year);
	}
	public static void main(String[] args) {
		System.out.println("Hello");
		addDay(31,12,2023,10);      
		
		
	}

}


//int month = 1;
//while (nday >helper.getDaysInMonth(month, year)) {
//	nday -= helper.getDaysInMonth(month, year);
//	month++;
//}
//this.setDate(nday);
//this.setMonth(month);
//this.setYear(year);







//public static MyDate parseDate(String date) {
//	String[] dateParts=date.split("-");
//	MyDate dateObj=new MyDate();
//	int dateValue,MonthValue,yearValue;
//	dateValue=Integer.parseInt(dateParts[0]);
//	try {
//		MonthValue= Integer.parseInt(dateParts[1]);
//    } catch (NumberFormatException e) {
//    	MonthValue = monthMap.get(dateParts[1].toLowerCase());
//    }
//	yearValue=Integer.parseInt(dateParts[2]);
//	return new MyDate(dateValue,MonthValue,yearValue);
//}
