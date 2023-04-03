package com.apaliakou.homework11;

import com.apaliakou.homework11.structure_creating.MyFile;
import com.apaliakou.homework11.structure_creating.MyFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UncheckedIOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        MyFolder root = new MyFolder("root");
        System.out.println("root folder: " + root + "\n");

        MyFolder folder1 = new MyFolder("folder1");
        root.addFolder(folder1);
        System.out.println("root folder after the folder1 adding : " + root + "\n");

        MyFile file1 = new MyFile("file1", ".txt");
        folder1.addFile(file1);
        System.out.println("folder1 after the file1 adding : " + folder1 + "\n");

        MyFolder folder2 = new MyFolder("folder2");
        folder1.addFolder(folder2);

        MyFile file2 = new MyFile("file2", ".doc");
        folder2.addFile(file2);

        MyFile file3 = new MyFile("file3", ".pdm");
        root.addFile(file3);

        System.out.println("root name: " + root.getFolderName() + "\n"
                + "root folders: " + root.getFolders() + "\n"
                + "root files: " + root.getFiles() + "\n");

        System.out.println("folder1 name: " + folder1.getFolderName() + "\n"
                + "folder1 folders: " + folder1.getFolders() + "\n"
                + "folder1 files: " + folder1.getFiles() + "\n");

        PathBuilder pathBuilder = new PathBuilder();

        String pathToFile;
        while (true) {
            pathToFile = PathScanner.read();
            if (pathToFile.equals("exit")) {
                System.out.println("Exit were entered!!! The program was closed!!!");
                break;
            }
            try {
                pathBuilder.buildPath(pathToFile, root, folder1, folder2, file1, file2, file3);
            } catch (UncheckedIOException e) {
                e.printStackTrace();
            }
            FileReader.readStructureFromFile(new File("Structure.txt"));
        }
    }
}