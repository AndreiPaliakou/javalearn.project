package com.apaliakou.homework05.structure_creating;

public class File {
    String fileName;
    String fileExtension;

    public File(String newFile, String fileExtension) {
        this.fileName = newFile;
        this.fileExtension = fileExtension;
    }

    public File(){}

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
        return "MyFile{" +
                "file='" + fileName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }
}
