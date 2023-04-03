package com.apaliakou.homework11.path_creating_composite_pattern;

import com.apaliakou.homework11.structure_creating.MyFolder;

public class RootFolderPathImpl implements PathCreating {

    private MyFolder rootFolder;

    public RootFolderPathImpl(MyFolder rootFolder) {
        this.rootFolder = rootFolder;
    }

    public MyFolder getRootFolder() {
        return rootFolder;
    }

    public void setFolder(MyFolder rootFolder) {
        this.rootFolder = rootFolder;
    }

    @Override
    public void createPath() {
        System.out.println(rootFolder.getFolderName() + "/");
    }

    @Override
    public String toString() {
        return "\n" + rootFolder.getFolderName() + "/\n";
    }
}
