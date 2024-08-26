package com.java.atlassian;

import java.util.List;

public class FileCollection {

    private String fileName;
    private Double size;
    private String collectionName;
    private List<String> collectionNames;

    public FileCollection(String fileName, Double size, String collectionName) {
        this.fileName = fileName;
        this.size = size;
        this.collectionName = collectionName;
    }

    public FileCollection(String fileName, Double size) {
        this.fileName = fileName;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public Double getSize() {
        return size;
    }

    public String getCollectionName() {
        return collectionName;
    }

    @Override
    public String toString() {
        return "FileCollection{" +
                "fileName='" + fileName + '\'' +
                ", size=" + size +
                ", collectionName='" + collectionName + '\'' +
                '}';
    }
}
