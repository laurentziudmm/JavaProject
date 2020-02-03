package streams.files;

import java.io.*;

/**
 * CopyFile
 **/

public class CopyFile {
    private String sourcePath;
    private String destinationPath;
    private String fileName;

    CopyFile(String sourcePath, String destinationPath, String fileName) {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        this.fileName = fileName;
    }
    public void copy(){

        //noinspection ResultOfMethodCallIgnored
        new File(destinationPath).mkdirs();

        try(InputStream is=new FileInputStream(sourcePath+ File.separator+fileName);
            OutputStream os=new FileOutputStream(destinationPath+File.separator+fileName)){
            int r;
            while((r=is.read())!=-1){
                os.write(r);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
