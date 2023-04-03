package com.apaliakou.homework11.structure_creating;

public class MyFile {
    String fileName;
    String fileExtension;

    public MyFile(String newFile, String fileExtension) {
        this.fileName = newFile;
        this.fileExtension = fileExtension;
    }

    public MyFile(){}

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public String toString() {
        return "MyFile {file = " + fileName + "," + " fileExtension = " + fileExtension + '}';
    }
}
