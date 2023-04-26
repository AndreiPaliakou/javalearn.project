package com.apaliakou.homework1202.inloops;

import com.apaliakou.homework1202.exceptions.LowerCaseWordsAbsenceException;
import com.apaliakou.homework1202.exceptions.NullInputListException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatisticServiceInLoopsImpl implements StatisticServiceInLoops {

    private static final String NULL_INPUT_MESSAGE = "The input list is null";

    private static final String LOWER_CASE_WORDS_ABSENCE_EXCEPTION = "The set does not contain even one lower case word";

    @Override
    public long sumEvenNumbers(List<Long> numbers) {
        checkForNull(numbers);
        long sum = 0;
        for (Long number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
        return sum;
    }

    private void checkForNull(List<Long> numbers) {
        if (numbers == null) {
            throw new NullInputListException(NULL_INPUT_MESSAGE);
        }
    }

    public StatisticServiceInLoopsImpl() {
    }

    @Override
    public List<Long> calculateSquareOfDistinctNumbers(List<Long> numbers) {
        List<Long> myList = new ArrayList<>();
        for (Long number : numbers) {
            long temp = number * number;
            myList.add(temp);
        }
        Collections.sort(myList);
        return myList;
    }

    @Override
    public Map<Character, List<String>> groupStringsByLastLetter(Set<List<String>> strings) {
        checkSetOnLowerWordsAbsence(strings);
        Map<Character, List<String>> myMap = new HashMap<>();
        char lastLetterAsChar = 0;
        for (List<String> i : strings) {
            for (String j : i) {
                if (j.length() > 0) {
                    lastLetterAsChar = j.substring(j.length() - 1).toUpperCase().charAt(0);
                    if (myMap.containsKey(lastLetterAsChar)) {
                        separateLowerCaseWordsAndAddThemToMapWithKey(j, lastLetterAsChar, myMap);
                    } else {
                        separateLowerCaseWordsAndAddThemToMapWithoutKey(j, lastLetterAsChar, myMap);
                    }
                }
            }
        }
        System.out.println("Map with nulls: " + myMap);
        nullsCleaner(myMap);
        return myMap;
    }

    private void checkSetOnLowerWordsAbsence(Set<List<String>> strings) {
        for (List<String> i : strings) {
            for (String j : i) {
                Pattern pattern = Pattern.compile("[a-z]");
                Matcher matcher = pattern.matcher(j);
                if (matcher.find()) {
                    return;
                } else {
                    throw new LowerCaseWordsAbsenceException(LOWER_CASE_WORDS_ABSENCE_EXCEPTION);
                }
            }
        }
    }

    private void separateLowerCaseWordsAndAddThemToMapWithKey(String word, char lastLetterAsChar, Map<
            Character, List<String>> map) {
        Pattern pattern = Pattern.compile("[a-z]$");
        Matcher matcher = pattern.matcher(word);
        if (matcher.find()) {
            map.get(lastLetterAsChar).add(word);
        } else {
            map.get(lastLetterAsChar).add(null);
        }
    }

    private void separateLowerCaseWordsAndAddThemToMapWithoutKey(String word, char lastLetterAsChar, Map<
            Character, List<String>> map) {
        List<String> myList = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-z]$");
        Matcher matcher = pattern.matcher(word);
        if (matcher.find()) {
            myList.add(word);
        } else {
            myList.add(null);
        }
        map.put(lastLetterAsChar, myList);
    }

    private void nullsCleaner(Map<Character, List<String>> map) {
        for (Map.Entry<Character, List<String>> entry : map.entrySet()) {
            while (entry.getValue().contains(null)) {
                entry.getValue().remove(null);
            }
        }
    }
}

