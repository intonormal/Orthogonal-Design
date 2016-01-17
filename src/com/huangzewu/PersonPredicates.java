package com.huangzewu;

/**
 * Created by huangzewu on 1/10/16.
 */
public final class PersonPredicates {
    public static <E extends Person> Predicate<E> age(Matcher<Integer> m) {
        return s -> {
            return m.matches(s.age());
        };
    }
    public static <E extends Person> Predicate<E> name(Matcher<String> m) {
        return s -> m.matches(s.name());
    }
    public static <E extends Person> Predicate<E> sexy(Matcher<Boolean> b) {
        return s -> b.matches(s.sexy());
    }
}
