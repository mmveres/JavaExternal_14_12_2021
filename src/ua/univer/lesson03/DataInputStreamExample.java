package ua.univer.lesson03;

import java.io.*;

public class DataInputStreamExample {
    public static void main(String[] args) {
        double price;
        int quantity;
        String item;
        try (
// create input stream. Same rules applies to file name again
                InputStream is = new FileInputStream("data.txt");
// create buffered input stream. you can skip this.
                BufferedInputStream bis = new BufferedInputStream(is);
// create data input stream to read data in form of primitives.
                DataInputStream in = new DataInputStream(bis);) {
            System.out.println("Selected items are");
            while (in.available() > 0) {
                item = in.readUTF();
                quantity = in.readInt();
                price = in.readDouble();
                System.out.format("%-20s %-10d $%.2f%n", item, quantity, price);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
