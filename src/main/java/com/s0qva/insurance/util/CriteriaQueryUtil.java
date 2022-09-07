package com.s0qva.insurance.util;

public final class CriteriaQueryUtil {

    private CriteriaQueryUtil() {
    }

    public static String formatAsPatternMatching(String attribute) {
        return "%" + attribute + "%";
    }
}
