package com.apaliakou.homework11;

import com.apaliakou.homework11.path_creating_composite_pattern.*;
import com.apaliakou.homework11.structure_creating.MyFile;
import com.apaliakou.homework11.structure_creating.MyFolder;

public class PathBuilder {


    public void addRootFolderPath(String[] substrings, MyFolder rootFolder, ResultPathImpl path) {
        for (String substring : substrings) {
            if (substring.matches("\\w.++") && substring.equals(rootFolder.getFolderName())) {
                PathCreating currentRootFolderPath = new RootFolderPathImpl(rootFolder);
                path.addPath(currentRootFolderPath);
            }
        }
    }

    public void addFolderInRootPath(String[] substrings, MyFolder folderInRoot, ResultPathImpl path) {
        for (String substring : substrings) {
            if (substring.matches("\\w.++") && substring.equals(folderInRoot.getFolderName())) {
                PathCreating currentFolderInRootPath = new FolderInRootPathImpl(folderInRoot);
                path.addPath(currentFolderInRootPath);
            }
        }
    }

    public void addFolderInFolderPath(String[] substrings, MyFolder folderInFolder, ResultPathImpl path) {
        for (String substring : substrings) {
            if (substring.matches("\\w.++") && substring.equals(folderInFolder.getFolderName())) {
                PathCreating currentFolderInFolderPath = new FolderInFolderPathImpl(folderInFolder);
                path.addPath(currentFolderInFolderPath);
            }
        }
    }

    public void addFileInFolderPath(String[] substrings, MyFile file, ResultPathImpl path) {
        for (String substring : substrings) {
            char pointSymbol = '.';
            boolean pointExists = substring.contains(String.valueOf(pointSymbol));
            if ((pointExists) && substring.equals(file.getFileName() + file.getFileExtension())) {
                PathCreating currentFilePath = new FileInFolderPathImpl(file);
                path.addPath(currentFilePath);
            }
        }
    }

    public void addFileInRootPath(String[] substrings, MyFile file, ResultPathImpl path) {
        for (String substring : substrings) {
            char pointSymbol = '.';
            boolean pointExists = substring.contains(String.valueOf(pointSymbol));
            if ((pointExists) && substring.equals(file.getFileName() + file.getFileExtension())) {
                PathCreating currentFilePath = new FileInRootPathImpl(file);
                path.addPath(currentFilePath);
            }
        }
    }

    public ResultPathImpl buildPath(String pathToFile, MyFolder root, MyFolder folder1, MyFolder folder2, MyFile file1, MyFile file2, MyFile file3) {
        String[] substrings = pathToFile.split("/");
        ResultPathImpl path = new ResultPathImpl("path");
        addRootFolderPath(substrings, root, path);
        addFolderInRootPath(substrings, folder1, path);
        addFileInFolderPath(substrings, file1, path);
        addFolderInFolderPath(substrings, folder2, path);
        addFileInFolderPath(substrings, file2, path);
        addFileInRootPath(substrings, file3, path);
        path.createPath();
        PathSaver pathSaver = new PathSaver();
        pathSaver.saveStructureToFile(path);
        return path;
    }
}