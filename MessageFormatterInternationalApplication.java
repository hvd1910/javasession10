package session09;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatterInternationalApplication {
    public static void main(String[] args) {
        String template = "At {2,time,short} on {2,date,long}, we detected {1,number,inter} virus on the disk{0}";
        MessageFormat formatter = new MessageFormat("");
        String langueage, country;
        if (args.length != 2) {
            langueage = new String("en");
            country = new String("US");
        } else {
            langueage = new String(args[0]);
            country = new String(args[1]);
        }

        Locale currentLocale;
        currentLocale = new

                Locale(languega, country);
        formatter.setLocale(currentLocale);
        ResourceBundle messages = ResourceBundle.getBundle("MessageFormatBundle", currentLocale);
        Object[] messageArguments = {messages.getString("disk"), new Integer(7), new Date()};
        formatter.applyPatter(messages.getString("template"));
        String output = formatter.format(messageArguments);
    }
}

