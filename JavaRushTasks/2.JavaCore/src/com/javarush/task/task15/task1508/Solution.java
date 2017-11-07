package com.javarush.task.task15.task1508;

/* 
ООП - Перегрузка - убираем лишнее
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        long millisecondsDate= 1487821200000L;
        Date date = new Date(millisecondsDate);
        SimpleDateFormat formating = new SimpleDateFormat("dd.MM.yy HH:mm");
        System.out.println(String.valueOf(formating.format(date.getTime())));

    }
}
