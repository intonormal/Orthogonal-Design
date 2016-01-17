package com.huangzewu;

import java.util.Optional;

/**
 * Created by huangzewu on 1/11/16.
 */
public class Util {
    public static <E> Optional<E> find(Iterable<? extends E> c, Predicate<? super E> p) {
        for(E t : c) {
            if(p.compare(t)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }
}
