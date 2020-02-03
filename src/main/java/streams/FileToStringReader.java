package streams;

import java.io.*;

/**
 * FileToStringReader
 **/

public class FileToStringReader {
    public static String readFile(String file){
        try (RandomAccessFile raf=new RandomAccessFile(file,"r")){
            return raf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
