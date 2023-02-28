package com.apaliakou.homework07;

import com.apaliakou.homework07.exceptions.ValidationFailedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationSystemTest {

    @Test
    public void testValidateInt() {
        ValidationSystem.getValidator(1);
        ValidationSystem.getValidator(5);
        ValidationSystem.getValidator(10);
    }

    @Test
    public void validateInt_IntValueOutOfBond_Exception() {
        // given
        Integer someValue = 0;
        String expectedMessage = "Sorry!!! This integer is not included in 1-10 range!!!";
        // when
        Exception exception = assertThrows(ValidationFailedException.class, () -> {
            ValidationSystem.getValidator(0);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void validateInt_ValueIsNull_Exception() {
        // given
        Integer someValue = 0;
        String expectedMessage = "Sorry!!! This value is null!!!";
        // when
        Exception exception = assertThrows(ValidationFailedException.class, () -> {
            ValidationSystem.getValidator(0);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void testValidateString() {
        ValidationSystem.getValidator("Hello");
        ValidationSystem.getValidator("Hello world, abc");
    }

    @Test
    public void validateString_FirstStringLetterIsNotCapital_Exception() {
        // given
        String someText = "hello";
        String expectedMessage = "Sorry!!! The string first letter is not a capital letter!!!";
        // when
        Exception exception = assertThrows(ValidationFailedException.class, () -> {
            ValidationSystem.getValidator("hello");
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void validateString_StringIsEmpty_Exception() {
        // given
        String someText = "";
        String expectedMessage = "Sorry!!! The string is empty!!!";
        // when
        Exception exception = assertThrows(ValidationFailedException.class, () -> {
            ValidationSystem.getValidator("");
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }
}