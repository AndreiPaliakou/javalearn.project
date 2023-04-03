package com.apaliakou.homework11.path_creating_composite_pattern;

import com.apaliakou.homework11.structure_creating.MyFile;

public class FileInRootPathImpl implements PathCreating {

    private MyFile file;

    public FileInRootPathImpl(MyFile file) {
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
        System.out.println(file.getFileName() + file.getFileExtension());

    }

    @Override
    public String toString() {
        return file.getFileName() + file.getFileExtension();
    }
}
