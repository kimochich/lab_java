package asm3.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    public static String getDivider() {
        return "+-----+-------------------+------+";
    }

    public static String formatBalance(double balance) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(balance)+"đ";
    }

    public static String getDateTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }
}
