package ua.univer.lesson03;

import java.io.*;

public class DataOutputStreamExample {
    static final double[] price = { 15.43, 10.12, 50.8, 249.56, 18.99 };
    static final int[] qty = { 10, 23, 45, 14, 2 };
    static final String[] items = { "keyboard", "mouse", "core java ebook", "ups", "pen drive", };
    public static void main(String[] args) {
        try (
// Create File output Stream. data.txt should be in classpath or provide fully qualified path
                OutputStream os = new FileOutputStream("data.txt");
// Create Buffered stream. You can skip this step also
                BufferedOutputStream bos = new BufferedOutputStream(os);
// create data output stream
                DataOutputStream out = new DataOutputStream(bos)
        ) {
            for (int i = 0; i < price.length; i++) {
                out.writeUTF(items[i]);
                out.writeInt(qty[i]);
                out.writeDouble(price[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
