package com.apaliakou.homework05.path_creating;

import com.apaliakou.homework05.structure_creating.File;

public class FilePathImpl implements PathCreating {


    private File file;

    public FilePathImpl(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void createPath() {
        System.out.println("\t\t\t" + file.getFileName() + file.getFileExtension());

    }
}
