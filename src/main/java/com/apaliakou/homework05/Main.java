package com.apaliakou.homework05;

import com.apaliakou.homework05.structure_creating.File;
import com.apaliakou.homework05.structure_creating.Folder;

import java.io.FileNotFoundException;
import java.io.UncheckedIOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Folder root = new Folder("root");
        System.out.println("root folder: " + root + "\n");

        Folder folder1 = new Folder("folder1");
        root.addFolder(folder1);
        System.out.println("root folder after the folder1 adding : " + root + "\n");

        File file1 = new File("file1", ".txt");
        folder1.addFile(file1);
        System.out.println("folder1 after the file1 adding : " + folder1 + "\n");

        Folder folder2 = new Folder("folder2");
        folder1.addFolder(folder2);

        File file2 = new File("file2", ".doc");
        folder2.addFile(file2);

        System.out.println("root name: " + root.getFolderName() + "\n"
                + "root folders: " + root.getFolders() + "\n"
                + "root files: " + root.getFiles() + "\n");

        System.out.println("folder1 name: " + folder1.getFolderName() + "\n"
                + "folder1 folders: " + folder1.getFolders() + "\n"
                + "folder1 files: " + folder1.getFiles() + "\n");

        PathBuilder pathBuilder = new PathBuilder();
        while (true) {
            String pathToFile = PathReader.read();
            if (pathToFile == null || pathToFile.equals("exit")) {
                break;
            }
            try {
                pathBuilder.buildPath(pathToFile, root, folder1, folder2, file1, file2);
            } catch (UncheckedIOException e) {
                e.printStackTrace();
            }
        }
    }
}