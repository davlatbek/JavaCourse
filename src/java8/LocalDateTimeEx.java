package java8;

import java.time.*;
import java.time.temporal.TemporalAmount;

public class LocalDateTimeEx {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month: " + month +"day: " + day +"seconds: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        //12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        LocalDate date31 = LocalDate.parse("2018-08-08");
        System.out.println("date3: " + date31);

        //22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        //parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zoned time " + zonedDateTime);
        ZoneId zoneId = ZoneId.of("GMT+9");
        System.out.println("zoned time offset " + zonedDateTime.withZoneSameInstant(zoneId));
    }
}
