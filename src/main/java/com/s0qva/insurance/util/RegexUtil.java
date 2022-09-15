package com.s0qva.insurance.util;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class RegexUtil {

    public Matcher createMatcher(String regex, String stringToSearch, int flagMatching) {
        return Pattern.compile(regex, flagMatching).matcher(stringToSearch);
    }

    public Matcher createMatcher(String regex, String stringToSearch) {
        return createMatcher(regex, stringToSearch, Pattern.CASE_INSENSITIVE);
    }
}
