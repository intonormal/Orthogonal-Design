package com.huangzewu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static com.huangzewu.Util.find;
import static com.huangzewu.Matchers.*;
import static com.huangzewu.PersonPredicates.*;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by huangzewu on 1/10/16.
 */
public class TeacherTest {
    @Test
    public void findTeacherBySexy_Success() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.teacher(0, "", true));

        assertEquals(Optional.of(std.get(0)), find(std, sexy(eq(true))));
    }
    @Test
    public void findTeacherBySexy_Fail() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.teacher(0, "", false));

        assertEquals(Optional.empty(), find(std, sexy(eq(true))));
    }
}