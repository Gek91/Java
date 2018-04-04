package trying.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ZonedEntity {

	public static void main(String[] args) {
		
		localTimeZoned() ;
		
		offset();
		
		zoned();
	}
	
	private static void localTimeZoned() {
		
		ZoneId zone1 = ZoneId.of("Europe/Paris");
		LocalTime time1 = LocalTime.now(zone1);
		
		ZoneId zone2 = ZoneId.of("Europe/London");
		LocalTime time2 = LocalTime.now(zone2);
		
		LocalTime time3 = LocalTime.now(Clock.systemUTC());
		
		ZoneId localZone = ZoneId.systemDefault();
				
		System.out.println("time in Paris: " + time1);
		System.out.println("time in London: " + time2);
		System.out.println("time in UTC: " + time3);
		System.out.println("local zone: " + localZone);
	}
	
	private static void offset() {
		
		LocalTime time1 = LocalTime.now();
		
		ZoneOffset offset = ZoneOffset.of("+05:00");

		OffsetTime offsetTime1 = OffsetTime.of(time1, offset);
		
		OffsetTime offsetTime2 = offsetTime1.withOffsetSameInstant(ZoneOffset.ofHours(-2));
		
		System.out.println("time: " + time1);
		System.out.println("time +5 offset: " + offsetTime1);
		System.out.println("time -2 offset: " + offsetTime2);
		
	}
	
	private static void zoned() {
		
		ZonedDateTime zonedNow = ZonedDateTime.now(ZoneId.of("Europe/Berlin"));
		
		ZonedDateTime zoneNowAmerica = zonedNow.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
		
		ZoneOffset offsetHere = zonedNow.getOffset();
		
		ZoneOffset offsetAmerica = zoneNowAmerica.getOffset();
		
		System.out.println("zonedNow: " + zonedNow);
		System.out.println("zoneNowAmerica: " + zoneNowAmerica);
		System.out.println("offset here: " + offsetHere);
		System.out.println("offset zoneNowAmerica: " + offsetAmerica);
	}
	

    
}

