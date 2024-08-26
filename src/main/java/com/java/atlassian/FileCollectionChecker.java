package com.java.atlassian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileCollectionChecker {

    public Double totalSize(List<FileCollection> fileCollectionList){
        if(fileCollectionList==null || fileCollectionList.isEmpty())
            return 0d;
        return fileCollectionList.stream().mapToDouble(e->e.getSize()).sum();
    }


    public List<String> findTopNCollection(List<FileCollection> fileCollectionList, int n){
        List<String> topNCollections = new ArrayList<>();
        if(fileCollectionList==null || fileCollectionList.isEmpty() || n<=0)
            return topNCollections;
        //Grouping Data
        Map<String,Double> fileCollectionMap = new HashMap<>();
        for(FileCollection fileCollection : fileCollectionList){
            if(fileCollection.getCollectionName()!=null && !fileCollection.getCollectionName().isBlank()){
                fileCollectionMap.putIfAbsent(fileCollection.getCollectionName(),0d);
                fileCollectionMap.put(fileCollection.getCollectionName(),fileCollectionMap.get(fileCollection.getCollectionName())+fileCollection.getSize());
            }
        }
        System.out.println(fileCollectionMap);
        //Sorting Data
        List<Map.Entry<String, Double>> sortedEntryList = fileCollectionMap.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue())).collect(Collectors.toUnmodifiableList());
        for(int i=0;i<Math.min(n,sortedEntryList.size());i++){
            topNCollections.add(sortedEntryList.get(i).getKey());
        }
        return topNCollections;
    }




}
