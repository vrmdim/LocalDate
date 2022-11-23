package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Test {

  public static void main(String[] args) {

    /*
     * Opciones .now()
     */
    System.out.println(LocalDate.now()); // 2022-11-23
    System.out.println(LocalTime.now()); // 19:03:12.134193
    System.out.println(LocalDateTime.now()); // 2022-11-23T19:03:35.010253
    System.out.println(LocalDate.now().getDayOfMonth()); // 23
    System.out.println(LocalDate.now().getDayOfWeek()); // WEDNESDAY
    System.out.println(LocalDate.now().getMonth()); // NOVEMBER
    System.out.println(LocalDate.now().lengthOfMonth()); // 30
    System.out.println(LocalDate.now().withDayOfYear(5)); // 2022-01-05
    System.out.println(LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES"))); // noviembre

    /*
     * Opciones .of()
     */
    System.out.println(LocalDate.of(2012, Month.MAY, 14)); // 2012-05-14
    System.out.println(LocalDate.of(1988, 11, 9)); // 1988-11-09

    LocalDate yesterday = LocalDate.now().minusDays(1);
    LocalDate today = LocalDate.now();
    LocalDate tomorrow = LocalDate.now().plusDays(1);

    System.out.println(today.compareTo(tomorrow)); // -1
    System.out.println(today.compareTo(yesterday)); // 1
    System.out.println(today.isAfter(tomorrow)); // false
    System.out.println(today.isAfter(yesterday)); // true

    /*
     * Formateo
     */
    Locale spanishLocale = new Locale("es", "ES");
    LocalDateTime date = LocalDateTime.now();
    String year = date.format(DateTimeFormatter.ofPattern("yyyy", spanishLocale));
    String month = date.format(DateTimeFormatter.ofPattern("MMMM", spanishLocale));
    String day = date.format(DateTimeFormatter.ofPattern("dd", spanishLocale));
    String dayOfWeek = date.format(DateTimeFormatter.ofPattern("EEEE", spanishLocale));
    String hour = date.format(DateTimeFormatter.ofPattern("HH", spanishLocale));
    String minute = date.format(DateTimeFormatter.ofPattern("mm", spanishLocale));

    String text = String.format("La fecha de hoy es %1$s, %2$s de %3$s de %4$s, a las %5$s:%6$s.", dayOfWeek, day,
        month, year, hour, minute);

    System.out.println(text); // La fecha de hoy es miércoles, 23 de noviembre de 2022, a las 19:58.

    /*
     * Cambio de zona horaria
     */
    ZoneId spainZone = ZoneId.of("Europe/Madrid"); // https://garygregory.wordpress.com/2013/06/18/what-are-the-java-timezone-ids/
    ZoneId japanZone = ZoneId.of("Japan");
    LocalDateTime timeNow = LocalDateTime.now();
    ZonedDateTime localTime = ZonedDateTime.of(timeNow, spainZone);
    ZonedDateTime japanTime = localTime.withZoneSameInstant(
        japanZone);

    DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

    System.out.println("En Japón son: " + japanTime.format(format)); // En Japón son: Nov 24 2022 04:28 AM
  }
}
