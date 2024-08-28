package com.java.atlassian;

public class TestClass {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

/**
 * file1.txt (size: 100) --- Null
 *
 * file2.txt (size: 200) in collection "collection1,collection2,null,collection1", Empty
 *
 * collection1 --
 *
 * Priority
 *
 * file3.txt (size: 200) in collection "collection1"
 *
 * file4.txt (size: 300) in collection "collection2"
 *
 *
 * file5.txt (size: 10) -- Null
 *
 *
 *
 * Top 5 == 1
 * Query ::
 *
 * Total Size --
 *
 * TopNCollection --
 *
 * Group File based on Collection
 * Sort the grouping get Top N
 *
 * HashMap DS
 *
 * HashMap <String,Integer>
 *
 * </String,Integer>
 *
 * <Collection Name, Double>
 *
 *   O(N) + O(NLOngN) == O(NLogN)
 *
 *   FileCollection
 *   String fileName
 *   Double size
 *   String collectionName
 *
 *
 *   CollectionName --
 *   Size
 *   totalFiles
 *
 *   List<FileCollection></FileCollection>
 *
 *   O(N) + O(NLOngN) == O(NLogN)
 *
 *
 *
 *   O(1) time look Up
 *
 *
 *
 *
 *
 *
 */