package com.apaliakou.homework05;

import com.apaliakou.homework05.path_creating.*;
import com.apaliakou.homework05.structure_creating.File;
import com.apaliakou.homework05.structure_creating.Folder;

public class PathBuilder {


    public void addRootFolderPath(String[] substrings, Folder rootFolder, ResultPathImpl path) {
        for (String substring : substrings) {
            if (substring.matches("\\w.++") && substring.equals(rootFolder.getFolderName())) {
                PathCreating currentRootFolderPath = new RootFolderPathImpl(rootFolder);
                path.addPath(currentRootFolderPath);
            }
        }
    }

    public void addFolderPathInRoot(String[] substrings, Folder folderInRoot, ResultPathImpl path) {
        for (String substring : substrings) {
            if (substring.matches("\\w.++") && substring.equals(folderInRoot.getFolderName())) {
                PathCreating currentFolderInRootPath = new FolderInRootPathImpl(folderInRoot);
                path.addPath(currentFolderInRootPath);
            }
        }
    }

    public void addFolderPathInFolder(String[] substrings, Folder folderInFolder, ResultPathImpl path) {
        for (String substring : substrings) {
            if (substring.matches("\\w.++") && substring.equals(folderInFolder.getFolderName())) {
                PathCreating currentFolderInFolderPath = new FolderInFolderPathImpl(folderInFolder);
                path.addPath(currentFolderInFolderPath);
            }
        }
    }

    public void addFilePath(String[] substrings, File file, ResultPathImpl path) {
        for (String substring : substrings) {
            char pointSymbol = '.';
            boolean pointExists = substring.contains(String.valueOf(pointSymbol));
            if ((pointExists) && substring.equals(file.getFileName() + file.getFileExtension())) {
                PathCreating currentFilePath = new FilePathImpl(file);
                path.addPath(currentFilePath);
            }
        }
    }

    public ResultPathImpl buildPath(String pathToFile, Folder root, Folder folder1, Folder folder2, File file1, File file2) {
        String[] substrings = pathToFile.split("/");
        ResultPathImpl path = new ResultPathImpl("path");
        addRootFolderPath(substrings, root, path);
        addFolderPathInRoot(substrings, folder1, path);
        addFilePath(substrings, file1, path);
        addFolderPathInFolder(substrings, folder2, path);
        addFilePath(substrings, file2, path);
        path.createPath();
        return path;
    }
}