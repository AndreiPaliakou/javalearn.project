package com.apaliakou.homework11;

import java.util.Scanner;

public class PathScanner {

    public static String read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root/folder/file path: ");
        String pathToFile = null;
        if (sc.hasNextLine()) {
            pathToFile = sc.nextLine();
        } return pathToFile;
    }
}

