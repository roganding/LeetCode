package hackerrank.algorithms;

public class TwelveTo24Hour {


    public static String timeConversion(String s) {
        // Write your code here
        if (s == null || (!s.endsWith("PM") && !s.endsWith("AM"))) {
            return null;
        }
        int length = s.length();
        boolean isAm = s.endsWith("AM");
        return convert24HourFormat(s.substring(0, 2), isAm) + s.substring(2, length - 2);
    }

    public static String convert24HourFormat(String hoursStr, boolean isAm) {
        int hours = Integer.parseInt(hoursStr);
        if (isAm) {
            if (hours >= 0 && hours <= 11) {
                return hoursStr;
            }
            return '0' + String.valueOf(hours - 12);
        } else {
            if (hours >= 0 && hours <= 11) {
                return String.valueOf(hours + 12);
            }
            return hoursStr;
        }
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("12:05:45AM"));

        System.out.println(timeConversion("01:05:45PM"));

    }
}