package com.example.projects.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private static Logger log = LoggerFactory.getLogger(DateUtils.class);
    public final static long MS = 1;

    public final static long SECOND_MS = MS * 1000;

    public final static long MINUTE_MS = SECOND_MS * 60;

    public final static long HOUR_MS = MINUTE_MS * 60;

    public final static long DAY_MS = HOUR_MS * 24;

    public final static String NORM_DATE_PATTERN = "yyyy-MM-dd";

    public final static String NORM_2_DATE_PATTERN = "yyyy/MM/dd";

    public final static String NORM_TIME_PATTERN = "HH:mm:ss";

    public final static String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public final static String NORM_2_DATETIME_PATTERN = "yyyy-MM-dd HH:mm";

    public final static String NORM_3_DATETIME_PATTERN = "dd/MM/yyyy HH:mm";

    public final static String HTTP_DATETIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";

    public final static String NORM_3_DATE_PATTERN = "dd/MM/yyyy";

    public final static String NORM_2_TIME_PATTERN = "HH:mm";

    public static String now() {
        return formatDateTime(new Date());
    }

    public static String today() {
        return formatDate(new Date());
    }

    public static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String formatDateTime(Date date) {
        return new SimpleDateFormat(NORM_DATETIME_PATTERN).format(date);
    }

    public static String formatHttpDate(Date date) {
        return new SimpleDateFormat(HTTP_DATETIME_PATTERN, Locale.US).format(date);
    }

    public static String formatDate(Date date) {
        return new SimpleDateFormat(NORM_DATE_PATTERN).format(date);
    }

    public static Date parse(String dateString, String format) {
        try {
            return (new SimpleDateFormat(format)).parse(dateString);
        } catch (ParseException e) {
            log.error("Parse " + dateString + " with format " + format + " error!", e);
        }
        return null;
    }

    public static Date parseDateTime(String dateString) {
        try {
            return new SimpleDateFormat(NORM_DATETIME_PATTERN).parse(dateString);
        } catch (ParseException e) {
            log.error("Parse " + dateString + " with format " + new SimpleDateFormat(NORM_DATETIME_PATTERN).toPattern() + " error!", e);
        }
        return null;
    }

    public static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat(NORM_DATE_PATTERN).parse(dateString);
        } catch (ParseException e) {
            log.error("Parse " + dateString + " with format " + NORM_DATE_PATTERN + " or" + NORM_2_DATE_PATTERN + " error!", e);
        }

        try {
            return new SimpleDateFormat(NORM_2_DATE_PATTERN).parse(dateString);
        } catch (ParseException e) {
            log.error("Parse " + dateString + " with format " + NORM_2_DATE_PATTERN + " error!", e);
        }
        return null;
    }

    public static Date parseTime(String timeString) {
        try {
            return new SimpleDateFormat(NORM_TIME_PATTERN).parse(timeString);
        } catch (ParseException e) {
            log.error("Parse " + timeString + " with format " + NORM_TIME_PATTERN + " error!", e);
        }
        return null;
    }

    public static Date parse(String dateStr) {
        int length = dateStr.length();
        try {
            if (length == DateUtils.NORM_DATETIME_PATTERN.length()) {
                return parseDateTime(dateStr);
            } else if (length == DateUtils.NORM_DATE_PATTERN.length()) {
                return parseDate(dateStr);
            } else if (length == DateUtils.NORM_TIME_PATTERN.length()) {
                return parseTime(dateStr);
            }
        } catch (Exception e) {
            log.error("Parse " + dateStr + " with format normal error!", e);
        }
        return null;
    }

    public static Date yesterday() {
        return offsiteDate(new Date(), Calendar.DAY_OF_YEAR, -1);
    }

    public static Date lastWeek() {
        return offsiteDate(new Date(), Calendar.WEEK_OF_YEAR, -1);
    }

    public static Date lastMouth() {
        return offsiteDate(new Date(), Calendar.MONTH, -1);
    }

    public static Date offsiteDate(Date date, int calendarField, int offsite) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(calendarField, offsite);
        return cal.getTime();
    }

    public static long diff(Date subtrahend, Date minuend, long diffField) {
        long diff = minuend.getTime() - subtrahend.getTime();
        return diff / diffField;
    }

    public static long spendNt(long preTime) {
        return System.nanoTime() - preTime;
    }

    public static long spendMs(long preTime) {
        return System.currentTimeMillis() - preTime;
    }

    public static Date atStartOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return localDateTimeToDate(startOfDay);
    }

    public static Date atEndOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return localDateTimeToDate(endOfDay);
    }

    private static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Instant parseStartOfDay(String dateStr) {
        Date date = parse(dateStr);
        if (date != null) {
            date = atStartOfDay(date);
            return dateToLocalDateTime(date).toInstant(ZoneOffset.ofHours(+7));
        }
        return null;
    }

    public static Instant parseStartOfDay2(String dateStr) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
            if (date != null) {
                date = atStartOfDay(date);
                return dateToLocalDateTime(date).toInstant(ZoneOffset.ofHours(+7));
            }
        } catch (ParseException e) {
        }
        return null;
    }

    public static Instant parseEndOfDay(String dateStr) {
        Date date = parse(dateStr);
        if (date != null) {
            date = atEndOfDay(date);
            return dateToLocalDateTime(date).toInstant(ZoneOffset.ofHours(+7));
        }
        return null;
    }

    public static Instant getTimeStart(String dateText) {
        try {
            LocalDateTime date = LocalDateTime.parse(dateText + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return date.toInstant(ZoneOffset.ofHours(+7));
        } catch (DateTimeParseException e) {
        }
        return null;
    }

    public static Instant getTimeFinish(String dateText) {
        try {
            LocalDateTime date = LocalDateTime.parse(dateText + " 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return date.toInstant(ZoneOffset.ofHours(+7));
        } catch (DateTimeParseException e) {
        }
        return null;
    }

    public static Instant getTimeFromMilliSecond(long time) {
        try {
            Date date = new Date(time);
            Instant instant = date.toInstant();
            return instant;
        } catch (DateTimeParseException e) {
        }
        return null;
    }

    public static Date getFirstDayOfCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DATE, 1);
        return DateUtils.atStartOfDay(calendar.getTime());
    }

    public static Date getFirstDayOfCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK, 1);
        return DateUtils.atStartOfDay(calendar.getTime());
    }

    public static Integer getDayCount(String start, String end) {
        Integer diff = -1;
        try {
            Date dateStart = parseDate(start);
            Date dateEnd = parseDate(end);

            //time is always 00:00:00, so rounding should help to ignore the missing hour when going from winter to summer time, as well as the extra hour in the other direction
            diff = Math.toIntExact(Math.round((dateEnd.getTime() - dateStart.getTime()) / (double) 86400000));
        } catch (Exception e) {
            //handle the exception according to your own situation
        }
        return diff + 1;
    }

    public static Instant parseToInstant(String dateStr, String format) {
        Date date;
        try {
            date = new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            return null;
        }

        return date.toInstant();
    }

    public static String convertFromInstantToString(Instant instant) {
        Date myDate = Date.from(instant.plus(7, ChronoUnit.HOURS));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(myDate);
        return formattedDate;
    }

    public static String convertFromInstantToHour(Instant instant) {
        Date myDate = Date.from(instant);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String formattedDate = formatter.format(myDate);
        return formattedDate;
    }

    public static String convertFromInstantToHour2(Instant instant) {
        Date myDate = Date.from(instant.plus(7, ChronoUnit.HOURS));
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String formattedDate = formatter.format(myDate);
        return formattedDate;
    }

    public static ZoneId getZoneHCM() {
        return ZoneId.of("Asia/Ho_Chi_Minh");
    }

    public static String formatInstantAsString(Instant date, String pattern) {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(pattern)
                .withZone(getZoneHCM());
        return DATE_TIME_FORMATTER.format(date);
    }

    public static Instant nowInstant() {
        Instant instant = Instant.now(Clock.system(getZoneHCM()));
        return instant;
    }

    public static boolean timestampInRange(Instant startTime, Instant endTime, Instant currentTime) {
        return !currentTime.isBefore(startTime) && !currentTime.isAfter(endTime);
    }

    public static boolean timestampInRange(Instant startTimeConfig, Instant endTimeConfig, Instant startTime, Instant endTime) {
        return (startTimeConfig.isBefore(startTime) && endTimeConfig.isAfter(endTime)) || (startTimeConfig.equals(startTime) || endTime.equals(endTimeConfig));
    }

    private static String modifyAddLeadingZeros(int number) {
        if (number > 9) {
            return String.valueOf(number);
        }
        return "0" + number;
    }

    public static String friendlyTimeOfDayFormat(Instant startTime) {
        ZonedDateTime ofStartZoned = startTime.atZone(ZoneId.of("Asia/Ho_Chi_Minh"));
        LocalTime localTime = ofStartZoned.toLocalTime();
        if (localTime.isBefore(LocalTime.of(12, 0, 0))) {
            return "Buổi sáng";
        }
        return "Buổi chiều";
    }

    public static String getFriendlyTimeFormat(Instant start, Instant end) {
        return LocalTime.from(start.atZone(getZoneHCM()))
                + " - " + LocalTime.from(end.atZone(getZoneHCM()));
    }

    public static boolean compareDate(Instant validDate) {
        return validDate.toEpochMilli()- Instant.now().toEpochMilli() > 0;
    }
}
