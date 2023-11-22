package com.example.demoapplication.helpers;

import android.os.Build;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

public abstract class Helper {
    public static long createTimestamp() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return System.currentTimeMillis() / 1000L;
        }
        return Instant.now().getEpochSecond();
    }

    public static String formatTimestamp(long timestamp) {
        Date date = new Date ();
        date.setTime(timestamp*1000);
        // Create a SimpleDateFormat object with the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.CANADA);

        // Format the date using the SimpleDateFormat
        return dateFormat.format(date);
    }
}
