package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestForEverything {
    public static void main(String[] args) {
        Date dateNow = new Date();
        int hourNow;
        SimpleDateFormat formatDateNow = new SimpleDateFormat("hh");
        System.out.println(formatDateNow.format(dateNow));
        System.out.println(Integer.parseInt(formatDateNow.format(dateNow)));
    }
}
