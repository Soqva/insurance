package com.s0qva.insurance.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CriteriaQueryUtil {

    public String formatAsPatternMatching(String attribute) {
        return "%" + attribute + "%";
    }
}
