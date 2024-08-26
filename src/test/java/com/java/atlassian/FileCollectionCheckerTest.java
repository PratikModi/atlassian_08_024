package com.java.atlassian;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FileCollectionCheckerTest {

    /**
     * file1.txt (size: 100) --- Null
     * <p>
     * file2.txt (size: 200) in collection "collection1"
     * <p>
     * file3.txt (size: 200) in collection "collection1"
     * <p>
     * file4.txt (size: 300) in collection "collection2"
     * <p>
     * <p>
     * file5.txt (size: 10) -- Null
     */
    @Test
    public void testTotalSize() {
        FileCollection collection1 = new FileCollection("file1.txt", 100d);
        FileCollection collection2 = new FileCollection("file2.txt", 200d, "collection1");
        FileCollection collection3 = new FileCollection("file3.txt", 200d, "collection1");
        FileCollection collection4 = new FileCollection("file4.txt", 300d, "collection2");
        FileCollection collection5 = new FileCollection("file5.txt", 10d);

        List<FileCollection> fileCollectionList = List.of(collection1, collection2, collection3, collection4, collection5);
        FileCollectionChecker checker = new FileCollectionChecker();
        Double totalSize = checker.totalSize(fileCollectionList);
        //System.out.println(totalSize);
        Assert.assertEquals(810d, totalSize, 0d);
    }

    @Test
    public void testTopNCollection() {
        FileCollection collection1 = new FileCollection("file1.txt", 100d);
        FileCollection collection2 = new FileCollection("file2.txt", 200d, "collection1");
        FileCollection collection3 = new FileCollection("file3.txt", 200d, "collection1");
        FileCollection collection4 = new FileCollection("file4.txt", 300d, "collection2");
        FileCollection collection5 = new FileCollection("file5.txt", 10d);

        List<FileCollection> fileCollectionList = List.of(collection1, collection2, collection3, collection4, collection5);
        FileCollectionChecker checker = new FileCollectionChecker();
        List<String> actualResult = checker.findTopNCollection(fileCollectionList, 1);
        System.out.println(actualResult);
        Assert.assertEquals(1, actualResult.size());
        Assert.assertEquals(List.of("collection1"/*, "collection2"*/), actualResult);
    }
}
