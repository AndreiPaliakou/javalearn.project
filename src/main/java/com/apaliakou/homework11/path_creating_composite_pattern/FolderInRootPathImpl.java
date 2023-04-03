package com.apaliakou.homework11.path_creating_composite_pattern;

import com.apaliakou.homework11.structure_creating.MyFolder;

public class FolderInRootPathImpl implements PathCreating {

    private MyFolder folderInRoot;

    public FolderInRootPathImpl(MyFolder folder) {
        this.folderInRoot = folder;
    }

    public MyFolder getFolderInRoot() {
        return folderInRoot;
    }

    public void setFolderInRoot(MyFolder folderInRoot) {
        this.folderInRoot = folderInRoot;
    }

    @Override
    public void createPath() {
        System.out.println("\t" + folderInRoot.getFolderName() + "/");
    }

    @Override
    public String toString() {
        return "\t" + folderInRoot.getFolderName() + "/\n";
    }
}
