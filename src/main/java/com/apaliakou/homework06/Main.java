package com.apaliakou.homework06;

import java.util.ArrayList;
import java.util.Arrays;

import static com.apaliakou.homework06.Text.*;

public class Main {
    public static void main(String[] args) {
        String text = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking up, what should he see but a Lamb just beginning to drink a little lower down.";
        System.out.println("An initial string: \n" + text + "\n");
        text = removePunctuations(text);
        System.out.println("An initial string without the punctuation: \n" + text + "\n");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(text.split(" ")));
        System.out.println("After the separate string division and ArrayList including: \n" + list + "\n");
        list.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("After the ArrayList alphabet sorting: \n" + list + "\n");
        shortenArrayList(list);
    }
}
