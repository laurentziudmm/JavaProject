package streams;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;


public class InsertToFileTest {

    private String sourcePath;
    private String fileName;
    private String name;

    @Before
    public void setUp() throws Exception {
        sourcePath = "D:\\PROJECTS\\DB\\cursuri\\finale\\Day4\\PracticeStreams\\src\\main\\resources\\";
        fileName = "StringToFile";
        name = "Viorel";

    }

    @Test
    public void insert() {

        InsertToFile insertToFile=new InsertToFile(
                sourcePath,
                fileName
        );
        insertToFile.insert(name);
        String content=FileToStringReader.readFile(sourcePath+ File.separator+fileName+".txt");
        Assert.assertEquals("Hello World Viorel!",content);

    }
}