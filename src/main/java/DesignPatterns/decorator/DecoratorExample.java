package DesignPatterns.decorator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;

/**
 * Created by hakanmehmed on 04/07/2017.
 */
public class DecoratorExample {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("test.zip");
            os = new GZIPOutputStream(os);
            writeContentToOutputStream(os);
            os.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void writeContentToOutputStream(OutputStream os) throws IOException {
        String content = "Some text here....";
        os.write(content.getBytes(Charset.forName("UTF-8")));
    }
}
