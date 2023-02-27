package session09;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateInternationalApplication {
    public static void main(String[] args) {
        Date today;
        String strDate;
        DateFormatDateFormatter;
        Locale locale = new Locale("ja","JP");
        today = new Date();
        strDate = dateFormat.format(today);
        System.out.println(strDate);
    }
}
