package com.huangzewu;

import java.util.Comparator;

/**
 * Created by huangzewu on 1/13/16.
 */
public class Ordering {
    public static <T extends Comparable<T>> Comparator<T> natural() {
        return (t1, t2) -> t1.compareTo(t2);
    }
}
