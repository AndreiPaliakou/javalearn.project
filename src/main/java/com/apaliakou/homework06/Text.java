package com.apaliakou.homework06;

import java.util.ArrayList;

public class Text {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                '}';
    }

    public static String removePunctuations(String source) {
        return source.replaceAll("\\p{Punct}", "");
    }

    public static void shortenArrayList(ArrayList<String> list) {
        ArrayList<String> subList = new ArrayList<>();
        ArrayList<String> subList1 = new ArrayList<>();
        ArrayList<String> subList2 = new ArrayList<>();
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                subList.add(list.get(i));1
            } else {
                subList1.add(list.get(1));
                subList2.add(list.get(0));
            }
        }
        subList.add(list.get(1));
        System.out.println(subList);
        System.out.println(list.get(1).toUpperCase() + ": " + subList.get(1) + " " + subList.size());
        list.removeAll(subList);
        System.out.println(list);
    }
}
