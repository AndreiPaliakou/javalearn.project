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
        int i;
        ArrayList<String> suppList = new ArrayList<>();
        for (i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                suppList.add(list.get(i - 1));
            }
        }
        suppList.add(list.get(0));
        System.out.println("The new suppList: " + suppList); // it can be to be deleted
        System.out.println(list.get(0).toUpperCase().charAt(0) + ": " + suppList.get(0) + " " + suppList.size());
        list.removeAll(suppList);
        System.out.println(list); // it can be to be deleted
        System.out.println();

        for (int j = 0; j < list.size(); j++){
            shortenArrayList(list);
        }
    }
}

