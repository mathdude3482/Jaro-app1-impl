package baseline;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void valid_description() {
        assertTrue(Validator.validDescription("Hi!"));
    }
    @Test
    void invalid_description() {
        assertFalse(Validator.validDescription("    "));
        assertFalse(Validator.validDescription(""));
        String toTest = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "hi";

        assertFalse(Validator.validDescription(toTest));
    }
    @Test
    void invalidDueDate() {
        assertFalse(Validator.validDueDate("150-03-01"));
        assertFalse(Validator.validDueDate("2004-7-01"));
        assertFalse(Validator.validDueDate("2024-01-5"));
        assertFalse(Validator.validDueDate("1994-13-01"));
        assertFalse(Validator.validDueDate("1228-00-06"));
        assertFalse(Validator.validDueDate("1776-04-50"));
    }
    @Test
    void invalid_February_date() {
        assertFalse(Validator.validDueDate("2002-02-29"));
    }

    @Test
    void valid_Feburary_date() {
        assertTrue(Validator.validDueDate("1996-02-29"));
    }

    @Test
    void valid_date() {
        assertTrue(Validator.validDueDate("2021-11-06"));
    }
}