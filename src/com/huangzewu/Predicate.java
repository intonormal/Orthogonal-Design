package com.huangzewu;

/**
 * Created by huangzewu on 1/10/16.
 */
public interface Predicate<E> {
    boolean compare(E t);

    default Predicate<E> and(Predicate<? super E> other) {
        return e -> compare(e) && other.compare(e);
    }
    default Predicate<E> or(Predicate<? super E> other) {
        return e -> compare(e) || other.compare(e);
    }
}
