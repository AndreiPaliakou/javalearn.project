package com.apaliakou.homework05.path_creating;

import com.apaliakou.homework05.structure_creating.Folder;

public class FolderInFolderPathImpl implements PathCreating {
    private Folder folderInFolder;

    public FolderInFolderPathImpl(Folder folder) {
        this.folderInFolder = folder;
    }

    public Folder getFolderInFolder() {
        return folderInFolder;
    }

    public void setFolderInFolder(Folder folderInFolder) {
        this.folderInFolder = folderInFolder;
    }

    @Override
    public void createPath() {
        System.out.println("\t\t" + folderInFolder.getFolderName() + "/");
    }
}
