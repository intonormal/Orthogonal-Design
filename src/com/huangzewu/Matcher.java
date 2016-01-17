package com.huangzewu;

/**
 * Created by huangzewu on 1/10/16.
 */
public interface Matcher<T> {
    boolean matches(T actual);
}
