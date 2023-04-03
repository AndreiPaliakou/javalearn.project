package com.apaliakou.homework11.structure_creating;

import java.util.ArrayList;

public class MyFolder implements FileSystem {

    private String folderName;
    private ArrayList<MyFolder> folders;
    private ArrayList<MyFile> files;

    public MyFolder(String folderName) {
        this.folderName = folderName;
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
    }
    public MyFolder() {}

    public String getFolderName() {
        return this.folderName;
    }

    public ArrayList<MyFolder> getFolders() {
        return this.folders;
    }

    public ArrayList<MyFile> getFiles() {
        return this.files;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public void setFolders(ArrayList<MyFolder> folders) {
        this.folders = folders;
    }

    public void setFiles(ArrayList<MyFile> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "MyFolder {folderName = " + folderName + "/" + " folders = " + folders + " files = " + files + '}';
    }

    @Override
    public void addFolder(MyFolder newFolder) {
        folders.add(newFolder);
    }

    @Override
    public void addFile(MyFile newFile) {
        files.add(newFile);
    }
}