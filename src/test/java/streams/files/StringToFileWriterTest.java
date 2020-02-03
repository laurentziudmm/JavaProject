package streams.files;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * StringToFileWriterTest
 **/

public class StringToFileWriterTest {
    private String fileName;
    private String basePath;
    private String message;
    @Before
    public void setUp() throws Exception {
        this.fileName="StringToFile";
        this.basePath="D:\\PROJECTS\\DB\\cursuri\\finale\\Day4\\PracticeStreams\\src\\main\\resources";
        this.message="Hello World!";
    }

    @Test
    public void write() {
        new StringToFileWriter(fileName, basePath).write(message);
        String fileContent=FileToStringReader.readFile(basePath+ File.separator+fileName+".txt");
        Assert.assertEquals(message,fileContent);
    }
}