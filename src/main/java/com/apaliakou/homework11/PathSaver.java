package com.apaliakou.homework11;

import com.apaliakou.homework11.path_creating_composite_pattern.ResultPathImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PathSaver {

    public void saveStructureToFile(ResultPathImpl path){
        String pathStructureForDiskSaving = path.toString();
        try {
            File myFile = new File("Structure.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
                System.out.println("Absolute path: " + myFile.getAbsolutePath());

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try(FileWriter myWriter = new FileWriter("Structure.txt")){
            myWriter.write(pathStructureForDiskSaving);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
