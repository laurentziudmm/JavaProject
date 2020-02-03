package streams;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * InsertToFile
 **/

public class InsertToFile {
    private String sourcePath;
    private String fileName;

    InsertToFile(String sourcePath, String fileName) {
        this.sourcePath = sourcePath;
        this.fileName = fileName;
    }

    public void insert(String name) {
        try (RandomAccessFile raf = new RandomAccessFile(sourcePath + File.separator + fileName + ".txt", "rw")) {
            String str = raf.readLine();

            raf.seek(str.indexOf("!"));

            raf.writeBytes(" " + name + "!");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
