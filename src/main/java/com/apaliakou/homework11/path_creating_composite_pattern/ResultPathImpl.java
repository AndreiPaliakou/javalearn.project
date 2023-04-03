package com.apaliakou.homework11.path_creating_composite_pattern;

import java.util.ArrayList;
import java.util.List;

public class ResultPathImpl implements PathCreating {

    private String pathName;

    private List<PathCreating> innerFoldersAndFilesPaths;

    public ResultPathImpl(String pathName) {
        this.pathName = pathName;
        this.innerFoldersAndFilesPaths = new ArrayList<>();
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public List<PathCreating> getInnerFoldersAndFilesPaths() {
        return innerFoldersAndFilesPaths;
    }

    public void setInnerFoldersAndFilesPaths(List<PathCreating> innerFoldersAndFilesPaths) {
        this.innerFoldersAndFilesPaths = innerFoldersAndFilesPaths;
    }

    @Override
    public String toString() {
        return pathName + innerFoldersAndFilesPaths;
    }

    @Override
    public void createPath() {
        innerFoldersAndFilesPaths.forEach(PathCreating::createPath);
    }

    public void addPath(PathCreating path) {
        innerFoldersAndFilesPaths.add(path);
    }
}
