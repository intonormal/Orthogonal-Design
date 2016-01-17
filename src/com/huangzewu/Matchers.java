package com.huangzewu;

//import com.google.common.collect.Ordering;

/**
 * Created by huangzewu on 1/11/16.
 */
public final class Matchers {
    public static <T> Matcher<T> eq(T expected) {
        return actual -> expected.equals(actual);
    }
    public static <T extends Comparable<T>> Matcher<T> gt(T expected) {
        return actual -> compare(actual, expected) > 0;
    }
    public static <T extends Comparable<T>> Matcher<T> lt(T expected) {
        return actual -> compare(actual, expected) < 0;
    }
    private static <T extends Comparable<T>> int compare(T actual, T expected) {
        return Ordering.<T>natural().compare(actual, expected);
    }
    public static Matcher<String> contains(String expected) {
        return actual -> actual.contains(expected);
    }
    public static Matcher<String> startWith(String expected) {
        return actual -> actual.startsWith(expected);
    }
    public static Matcher<String> starts_ignoring_case(String substr) {
        return str -> lower(str).startsWith(lower(substr));
    }
    public static <T> Matcher<T> not(Matcher<T> matcher) {
        return actual -> !matcher.matches(actual);
    }
    public static <T> Matcher<T> not(T expected) {
        return not(eq(expected));
    }
    private static String lower(String s) {
        return s.toLowerCase();
    }
    private Matchers() {
    }
    @SafeVarargs
    private static <T> Matcher<T> combine(boolean shortcut, Matcher<? super T>... matchers) {
        return actual -> {
            for (Matcher<? super T> matcher : matchers) {
                if (matcher.matches(actual) == shortcut) {
                    return shortcut;
                }
            }
            return !shortcut;
        };
    }
    @SafeVarargs
    public static <T> Matcher<T> allof(Matcher<? super T>... matchers) {
        return combine(false, matchers);
    }
    @SafeVarargs
    public static <T> Matcher<T> anyof(Matcher<? super T>... matchers) {
        return combine(true, matchers);
    }
    public static <E> Matcher<E> always(boolean bool) {
        return e -> bool;
    }
}
