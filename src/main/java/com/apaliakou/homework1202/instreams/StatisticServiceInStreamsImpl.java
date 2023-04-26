package com.apaliakou.homework1202.instreams;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class StatisticServiceInStreamsImpl implements StatisticServiceInStreams {

    @Override
    public long countEvenNumbers(List<Long> numbers) {
        Predicate<Long> evenNumberCondition = x -> x % 2 == 0;
        return numbers.stream().filter(evenNumberCondition).reduce(Long::sum).orElse(0L);
    }

    @Override
    public List<Long> calculateSquareOfDistinctNumbers(List<Long> numbers) {
        UnaryOperator<Long> squareValue = x -> x * x;
        return numbers.stream().map(squareValue).sorted().collect(Collectors.toList());
    }

    @Override
    public Map<Character, List<String>> groupStringsByLastLetter(Set<List<String>> stringLists) {

        Map<Character, List<String>> myMap;

        List<Character> listOfUpperCaseLetters = stringLists.stream().flatMap(Collection::stream).filter(anyWord -> !Objects.equals(anyWord, "")).
                map(anyWord -> anyWord.substring(anyWord.length() - 1).toUpperCase().charAt(0)).toList();
        System.out.println(listOfUpperCaseLetters);

        Set<Character> setOfUpperCaseLetters = new HashSet<>(listOfUpperCaseLetters);
        System.out.println(setOfUpperCaseLetters);

        myMap = stringLists.stream().flatMap(Collection::stream).
                filter(anyWord -> {
                    Pattern pattern = Pattern.compile("[a-z]$", Pattern.UNICODE_CASE);
                    Matcher matcher = pattern.matcher(anyWord);
                    return matcher.find();
                }).
                collect(Collectors.groupingBy(wordInLowerCase -> wordInLowerCase.charAt(wordInLowerCase.length() - 1)));

        return myMap.keySet().stream().collect(Collectors.toMap(key -> key.toString().toUpperCase().charAt(0), myMap::get));
    }
}

