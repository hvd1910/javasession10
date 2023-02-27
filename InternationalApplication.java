package session09;

import com.sun.jdi.IntegerValue;


import java.text.NumberFormat;
import java.util.ResourceBundle;
import java.util.Locale;

public class InternationalApplication {
    public void printValue(Locale currenLocale) {
        IntegerValue = new Integer(123456);

        Double amt = new Double(34587.246);
        NumberFormat numFormatObj;
        String valueDisplay;
        String amtDisplay;
        numFormatObj = NumberFormat.getNumberInstance(currentLocale);
        valueDisplay = numFormatObj.format(value);
        amtDisplay = numFormatObj.format(amt);
        System.out.println(valueDisplay + "" + currentLocale.toString());
        System.out.println(amtDisplay + "" + currenLocale.toString());
    }


    public static void main(String[] args) {
        String language;
        String country;
        if(args.length != 2){
            language = new String("en");
            country = new String("US");
        }
        else{
            language = new String(args[0]);
            country = new String(args[1]);
        }
        Locale currentLocale;
        ResourceBundle messages;
        currentLocale = newLocale(language, country);
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        System.out.println(messages.getString("greeting"));
        System.out.println(messages.getString("inquiry"));
        System.out.println(messages.getString("farewell"));
        printValue(currentLocale);
    }
}



