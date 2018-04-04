package trying.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalEntities {

	
	public static void main(String[] args) {
	
		
		currentDateTimeBasic();
		
		customDateTime();
		
		parseString();
	}
	
	private static void currentDateTimeBasic() {
		
		//date time of the current local, no timezone specified
		LocalDateTime currentDateTime = LocalDateTime.now();
		
		LocalDate currentDate = currentDateTime.toLocalDate();
		
		LocalTime currentTime = currentDateTime.toLocalTime();
				
		System.out.println("Current datetime: " + currentDateTime );
		System.out.println("Current date: " + currentDate);
		System.out.println("Current time: " + currentTime);
		System.out.println(currentDateTime.getDayOfMonth() + "/" +  currentDateTime.getMonth() + "/" + currentDateTime.getYear() + " " 
		+ currentDateTime.getHour() + ":"+ currentDateTime.getMinute() + ":" +	currentDateTime.getSecond() + ":" + currentDateTime.getNano());
		
		currentDate = LocalDate.now();
		
		currentTime = LocalTime.now();
		
		System.out.println("Current date: " + currentDate);
		System.out.println("Current time: " + currentTime);
	}
	
	private static void customDateTime() {
		
		LocalDate currentDate = LocalDate.of(2012, 12, 24);
		
		LocalTime currentTime = LocalTime.of(12, 24);
		
		LocalDateTime currentDateTime = LocalDateTime.of(currentDate, currentTime);

		System.out.println("Current datetime: " + currentDateTime );
		System.out.println("Current date: " + currentDate);
		System.out.println("Current time: " + currentTime);
	}
	
	private static void parseString() {
		
		LocalTime currentTime = LocalTime.parse("20:15:20");
		
		System.out.println("Hours:" + currentTime.getHour());
		System.out.println("Minutes:" + currentTime.getMinute());
		System.out.println("Seconds:" + currentTime.getSecond());
		
		LocalDate currentDate = LocalDate.parse("2007-12-03");
		
		System.out.println("Year:" + currentDate.getYear());
		System.out.println("Month:" + currentDate.getMonth());
		System.out.println("Day:" + currentDate.getDayOfMonth());
		
		LocalDateTime currentDateTime = LocalDateTime.parse("2007-12-03T10:15:30");
		
		System.out.println(currentDateTime.getDayOfMonth() + "/" +  currentDateTime.getMonth() + "/" + currentDateTime.getYear() + " " 
				+ currentDateTime.getHour() + ":"+ currentDateTime.getMinute() + ":" +	currentDateTime.getSecond() + ":" + currentDateTime.getNano());

	}
}
