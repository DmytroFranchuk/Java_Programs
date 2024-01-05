package org.example.level1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Tasks_1_5 {
    public static void main(String[] args) {
        //1.Создайте дату - 10 января 2020 (можете использовать любой класс), после попробуйте распечатать его
        // используя форматеры в виде 10/01/2020, 10-01-2020, 2020 January 10
        Calendar date = new GregorianCalendar(2020, Calendar.JANUARY, 10);

        DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(df1.format(date.getTime()));

        DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(df2.format(date.getTime()));

        DateFormat df3 = new SimpleDateFormat("yyyy MMMM dd");
        System.out.println(df3.format(date.getTime()));

        //2.Распечатайте текущее время, отнимите от текущего времени 10 часов и распечатайте, распечатайте время и сдвиг
        // (например 10 января 2020 12:00:00 +0200)
        LocalDateTime date1 = LocalDateTime.now();
        LocalDateTime newDate = date1.minusHours(10);
        OffsetDateTime offsetDateTime = newDate.atOffset(OffsetDateTime.now().getOffset());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss Z");
        System.out.println(offsetDateTime.format(formatter));

        //3.Исользуя LocalDate и Calendar (нужно написать два решения) достаньте информацию о:
        //
        //текущий день недели
        //текущий день в году
        //текущая неделя в месяце
        //текущий месяц
        currentDateUsingLocalDate();
        currentDateUsingCalendar();

        //4.Превратите строку 10/01/2020 в дату и прибавьте к ней 10 дней и распечатайте в виде 20-01-2020
        String dateStr = "10/01/2020";
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date strToDate = format1.parse(dateStr);
            System.out.println("task 4 date before: " + strToDate.toString());
            Calendar date4 = Calendar.getInstance();
            date4.setTime(strToDate);
            date4.roll(Calendar.DATE, 10);
            System.out.println("task 4 date after: " + format2.format(date4.getTime()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //5.Превратите строку 10 01 2020 10:00 в дату и прибавьте к ней 10 минут и распечатайте в виде 10-01-2020 10:10
        String dateStr2 = "10 01 2020 10:00";
        SimpleDateFormat format5_1 = new SimpleDateFormat("dd MM yyyy HH:mm");
        SimpleDateFormat format5_2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date strToDate5 = format5_1.parse(dateStr2);
            System.out.println("task 5 date before: " + strToDate5.toString());
            Calendar date5 = Calendar.getInstance();
            date5.setTime(strToDate5);
            date5.roll(Calendar.MINUTE, 10);
            System.out.println("task 5 date after: " + format5_2.format(date5.getTime()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void currentDateUsingLocalDate(){
        LocalDate currentDate = LocalDate.now();
        System.out.println("use Local Date");
        System.out.println("текущий день недели: " + currentDate.getDayOfWeek().name());
        System.out.println("текущий день в году: " + currentDate.getDayOfYear());
        System.out.println("текущая неделя в месяце: " + currentDate.get(WeekFields.of(DayOfWeek.MONDAY,1).weekOfMonth()));
        System.out.println("текущий месяц: " + currentDate.getMonth().name());
    }

    public static void currentDateUsingCalendar(){
        Calendar currentDate = Calendar.getInstance();
        String[] weekdaysName = {"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "November", "December"};

        System.out.println("use Calendar");
        System.out.println("текущий день недели: " + weekdaysName[currentDate.get(Calendar.DAY_OF_WEEK)]);
        System.out.println("текущий день в году: " + currentDate.get(Calendar.DAY_OF_YEAR));
        System.out.println("текущая неделя в месяце: " + currentDate.get(Calendar.WEEK_OF_MONTH));
        System.out.println("текущий месяц: " + monthName[currentDate.get(Calendar.MONTH)]);
    }
}