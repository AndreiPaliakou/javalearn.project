package com.apaliakou.homework11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static void readStructureFromFile(File myFile) {
        try {
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String structure = sc.nextLine();
                System.out.println(structure);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
