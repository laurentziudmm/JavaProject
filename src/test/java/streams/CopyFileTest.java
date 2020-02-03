package streams;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * CopyFileTest
 **/

public class CopyFileTest {
    private String sourcePath;
    private String destinationPath;
    private String fileName;
    @Before
    public void setUp() throws Exception {
        sourcePath="D:\\PROJECTS\\DB\\cursuri\\finale\\Day4\\PracticeStreams\\src\\main\\resources";
        destinationPath="D:\\PROJECTS\\DB\\cursuri\\finale\\Day4\\PracticeStreams\\src\\main\\resources1";
        fileName="img1.jpg";
    }

    @Test
    public void copy() {
        long size1=FileHelper.size(sourcePath+File.separator+fileName);
        new CopyFile(sourcePath, destinationPath, fileName).copy();
        long size2 = FileHelper.size(destinationPath+File.separator+fileName);
        Assert.assertEquals(size1,size2);
    }
}