package com.huangzewu;

import org.junit.Test;

import java.util.ArrayList;

import static java.util.Optional.*;
import static com.huangzewu.Matchers.*;
import static com.huangzewu.Util.find;
import static com.huangzewu.PersonPredicates.*;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by huangzewu on 1/10/16.
 */
public class StudentTest {
    @Test
    public void findStudentByAge_EQSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(18, "", false));

        assertEquals(true, find(std, age(eq(18))).isPresent());
    }
    @Test
    public void findStudentByAge_EQFail() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(10, "", false));

        assertEquals(empty(), find(std, age(eq(18))));
    }
    @Test
    public void findStudentByName_Success() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(0, "horance", false));

        assertEquals(of(std.get(0)), find(std, name(eq("horance"))));
    }
    @Test
    public void findStudentByName_Fail() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(0, "a", false));

        assertEquals(empty(), find(std, name(eq("horance"))));
    }
    @Test
    public void findStudentByAge_NESuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(11, "", false));

        assertEquals(of(std.get(0)), find(std, age(not(18))));
    }
    @Test
    public void findStudentByAge_NEFail() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(10, "", false));

        assertEquals(empty(), find(std, age(not(10))));
    }
    @Test
    public void findStudentByAgeAndSexy_EQSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(18, "horance", false));

        assertEquals(of(std.get(0)), find(std, age(eq(18)).and(name(eq("horance")))));
    }
    @Test
    public void findStudentByAgeAndSexy_EQFail() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(18, "horance", false));

        assertEquals(empty(), find(std, age(eq(10)).and(name(eq("horance")))));
    }
    @Test
    public void findStudentByNameAndSexy_Success() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(0, "horance", true));

        assertEquals(true, find(std, name(eq("horance")).and(sexy(eq(true)))).isPresent());

    }
    @Test
    public void findStudentByAge_LtSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(11, "horance", false));

        assertEquals(find(std, age(lt(18))).isPresent(), true);
    }
    @Test
    public void findStudentByAge_GTSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(19, "horance", false));

        assertEquals(find(std, age(gt(18))).isPresent(), true);
    }
    @Test
    public void findStudentByName_ContainSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(19, "liu horance", false));

        assertEquals(find(std, name(contains("horance"))).isPresent(), true);
    }
    @Test
    public void findStudentByName_NotContainSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(19, "liu", false));

        assertEquals(find(std, name(not(contains("horance")))).isPresent(), true);
    }
    @Test
    public void findStudentByName_ContainFail() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(19, "liu", false));

        assertEquals(find(std, name(contains("horance"))).isPresent(), false);
    }
    @Test
    public void findStudentByName_StartWithSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(19, "horance liu", false));

        assertEquals(find(std, name(startWith("horance"))).isPresent(), true);
    }
    @Test
    public void findStudentByName_StartWithFail() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(19, "liu horance", false));

        assertEquals(find(std, name(startWith("horance"))).isPresent(), false);
    }
    @Test
    public void findStudentByName_StartWithIgnoringCaseSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(19, "Horance liu", false));

        assertEquals(find(std, name(starts_ignoring_case("horance"))).isPresent(), true);
    }
    @Test
    public void findStudentByName_AnyOfCaseSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(19, "liu123", false));

        assertEquals(find(std, name(anyof(contains("horance"), startWith("liu")))).isPresent(), true);
    }
    @Test
    public void findStudentByName_AllOfCaseSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        std.add(Person.student(19, "liu123 horance", false));

        assertEquals(find(std, name(anyof(contains("horance"), startWith("liu")))).isPresent(), true);
    }
    @Test
    public void findStudentByName_AlwaysCaseSuccess() {
        ArrayList<Person> std = new ArrayList<>();

        assertEquals(find(std, age(always(false))).isPresent(), false);
    }
}