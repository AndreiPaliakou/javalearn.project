package com.apaliakou.homework05.path_creating;

import com.apaliakou.homework05.structure_creating.Folder;

public class RootFolderPathImpl implements PathCreating {

    private Folder rootFolder;

    public RootFolderPathImpl(Folder rootFolder) {
        this.rootFolder = rootFolder;
    }

    public Folder getRootFolder() {
        return rootFolder;
    }

    public void setFolder(Folder rootFolder) {
        this.rootFolder = rootFolder;
    }

    @Override
    public void createPath() {
        System.out.println(rootFolder.getFolderName() + "/");
    }
}
