package streams.files;

import java.io.*;

public class StreamExample {
    public static void main(String[] args) {
        write("Some Text");
    }
    private static void write(String text) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(
                    "D:\\test.txt"
            );
            for (char c : text.toCharArray()) {
                outputStream.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

