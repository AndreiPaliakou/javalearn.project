package com.apaliakou.homework05.structure_creating;

import java.util.ArrayList;

public class Folder implements FileSystem {

    private String folderName;
    private ArrayList<Folder> folders;
    private ArrayList<File> files;

    public Folder(String folderName) {
        this.folderName = folderName;
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
    }
    public Folder() {}

    public String getFolderName() {
        return this.folderName;
    }

    public ArrayList<Folder> getFolders() {
        return this.folders;
    }

    public ArrayList<File> getFiles() {
        return this.files;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public void setFolders(ArrayList<Folder> folders) {
        this.folders = folders;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "MyFolder{" +
                "folderName='" + folderName + '\'' +
                ", folders=" + folders +
                ", files=" + files +
                '}';
    }

    @Override
    public void addFolder(Folder newFolder) {
        folders.add(newFolder);
    }

    @Override
    public void addFile(File newFile) {
        files.add(newFile);
    }
}