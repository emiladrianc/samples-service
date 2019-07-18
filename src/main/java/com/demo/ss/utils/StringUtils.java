package com.demo.ss.utils;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isNullOrEmpty(final String s) {
        return s == null || s.trim().isEmpty();
    }
}