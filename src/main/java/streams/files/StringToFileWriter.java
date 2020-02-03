package streams.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *StringToFileWriter
 **/

public class StringToFileWriter {
    //the file name
    private String fileName;
    //the absolute file path where the file will be saved
    private String basePath;


    StringToFileWriter(String fileName, String basePath) {
        this.fileName = fileName;
        this.basePath = basePath;
    }

    /**
     * Method writes the text message to file
     * @param text - message
     */
    public void write(String text){
        try (Writer fileWriter=new FileWriter(basePath+ File.separator+fileName+".txt")){
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
