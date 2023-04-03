package com.apaliakou.homework05.path_creating;

import com.apaliakou.homework05.structure_creating.Folder;

public class FolderInRootPathImpl implements PathCreating {

    private Folder folderInRoot;

    public FolderInRootPathImpl(Folder folder) {
        this.folderInRoot = folder;
    }

    public Folder getFolderInRoot() {
        return folderInRoot;
    }

    public void setFolderInRoot(Folder folderInRoot) {
        this.folderInRoot = folderInRoot;
    }

    @Override
    public void createPath() {
        System.out.println("\t" + folderInRoot.getFolderName() + "/");
    }
}
