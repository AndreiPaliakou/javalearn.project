package com.apaliakou.homework1202.inloops;

import com.apaliakou.homework1202.exceptions.NullInputListException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StatisticServiceInLoopsImplTest {
    private static List<Long> numbersList;
    private static List<Long> numbersList2;
    private static List<Long> numbersList3;
    private static List<Long> numbersList4;
    private static List<Long> numbersList5;

    private static Set<List<String>> mySet;
    private static StatisticServiceInLoopsImpl myObject;

    @BeforeAll
    public static void init() {
        numbersList = new ArrayList<>(List.of(new Long[]{11L, 22L, 33L, 44L}));
        numbersList2 = new ArrayList<>(List.of(new Long[]{11L, 21L, 33L, 43L}));
        numbersList3 = new ArrayList<>(List.of(new Long[]{}));
        numbersList4 = new ArrayList<>(List.of(new Long[]{4L, 2L, 1L, 3L}));
        numbersList5 = new ArrayList<>(List.of(new Long[]{0L, 0L, 0L, 0L}));
        List<String> stringsList1 = new ArrayList<>(List.of(new String[]{"dentist", "WELDER", "doctor", "tiger"}));
        List<String> stringsList2 = new ArrayList<>(List.of(new String[]{"first", "", "SECOND", "third", "kid", "cloud"}));
        mySet = new HashSet<>();
        mySet.add(stringsList1);
        mySet.add(stringsList2);
        myObject = new StatisticServiceInLoopsImpl();
    }

    @Test
    void sumEvenNumbers_PositiveTest() {
        // given
        long expectedResult = 66L;
        // when
        long actualResult = myObject.sumEvenNumbers(numbersList);
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void sumEvenNumbers_WithoutEvenNumbers_PositiveTest() {
        // given
        long expectedResult = 0L;
        // when
        long actualResult = myObject.sumEvenNumbers(numbersList2);
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void sumEvenNumbers_EmptyList_PositiveTest() {
        // given
        long expectedResult = 0L;
        // when
        long actualResult = myObject.sumEvenNumbers(numbersList3);
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void sumEvenNumbers_NullInput_Exception() {
        // given
        String expectedMessage = "The input list is null";
        // when
        Exception exception = assertThrows(NullInputListException.class, () -> {
            myObject.sumEvenNumbers(null);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void sortSquareOfDistinctNumbers_PositiveTest() {
        // given
        List<Long> expectedResult = new ArrayList<>(List.of(new Long[]{1L, 4L, 9L, 16L}));
        // when
        List<Long> actualResult = myObject.calculateSquareOfDistinctNumbers(numbersList4);
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void sortSquareOfDistinctNumbers_EmptyList_PositiveTest() {
        // given
        List<Long> expectedResult = new ArrayList<>(List.of(new Long[]{0L, 0L, 0L, 0L}));
        // when
        List<Long> actualResult = myObject.calculateSquareOfDistinctNumbers(numbersList5);
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void groupStringsByLastLetter() {
        // given
        Map<Character, List<String>> expectedResult = Map.of('R', new ArrayList<>(List.of(new String[]{"doctor", "tiger"})),
                'T', new ArrayList<>(List.of(new String[]{"dentist", "first"})),
                'D', new ArrayList<>(List.of(new String[]{"third", "kid", "cloud"})));
        // when
        Map<Character, List<String>> actualResult = myObject.groupStringsByLastLetter(mySet);
        // then
        assertEquals(expectedResult, actualResult);
    }
}