package com.apaliakou.homework11.path_creating_composite_pattern;

import com.apaliakou.homework11.structure_creating.MyFile;

public class FileInFolderPathImpl implements PathCreating {


    private MyFile file;

    public FileInFolderPathImpl(MyFile file) {
        this.file = file;
    }

    public MyFile getFile() {
        return file;
    }

    public void setFile(MyFile file) {
        this.file = file;
    }

    @Override
    public void createPath() {
        System.out.println("\t\t\t" + file.getFileName() + file.getFileExtension());

    }

    @Override
    public String toString() {
        return "\t\t\t" + file.getFileName() + file.getFileExtension();
    }
}
