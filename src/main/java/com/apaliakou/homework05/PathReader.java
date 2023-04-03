package com.apaliakou.homework05;

import java.util.Scanner;

public class PathReader {

    public static String read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root/folder/file path: ");
        String pathToFile = null;
        if(sc.hasNextLine()){
            pathToFile = sc.nextLine();
        }
        return pathToFile;
    }
}

