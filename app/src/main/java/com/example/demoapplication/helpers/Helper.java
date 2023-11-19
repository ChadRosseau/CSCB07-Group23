package com.example.demoapplication.helpers;

import android.os.Build;

import java.time.Instant;

public abstract class Helper {
    public static long createTimestamp() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return System.currentTimeMillis() / 1000L;
        }
        return Instant.now().getEpochSecond();
    }
}
