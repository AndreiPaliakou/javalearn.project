package com.apaliakou.homework11.path_creating_composite_pattern;

import com.apaliakou.homework11.structure_creating.MyFolder;

public class FolderInFolderPathImpl implements PathCreating {
    private MyFolder folderInFolder;

    public FolderInFolderPathImpl(MyFolder folder) {
        this.folderInFolder = folder;
    }

    public MyFolder getFolderInFolder() {
        return folderInFolder;
    }

    public void setFolderInFolder(MyFolder folderInFolder) {
        this.folderInFolder = folderInFolder;
    }

    @Override
    public void createPath() {
        System.out.println("\t\t" + folderInFolder.getFolderName() + "/");
    }

    @Override
    public String toString() {
        return "\t\t" + folderInFolder.getFolderName() + "/\n";
    }
}
