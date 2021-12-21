package ua.univer.lesson03;

import java.io.*;
import java.util.Arrays;

public class ProgramTxt {
    public static void main(String[] args) throws IOException {
        int [] arr = {1,2,3,23,4,5,6,54,6};
    //    writeArrToCSV(arr);
        System.out.println(Arrays.toString(getArrFromCSV("resources"+ File.separator+"text.csv")));
    }
    private static void writeArrToDir(int[] arr) throws IOException {
        File dir = new File("resources"+ File.separator+"arr");
        if (!dir.exists()) dir.mkdir();

        for (int i = 0; i< arr.length; i++) {
            try(FileWriter fw = new FileWriter("resources"+ File.separator+"arr"+File.separator+"el"+i+".txt")){
                fw.write(String.valueOf(arr[i]));
            }
        }

    }

    private static void writeArrToTXT(int[] arr) throws IOException {
        FileWriter fw = new FileWriter("resources"+ File.separator+"text.txt");
        for (int el: arr) {
            fw.write(String.valueOf(el)+",");
           // fw.flush();
        }
        fw.close();
    }
    private static void writeArrToCSV(int[] arr) throws IOException {
        FileWriter fw = new FileWriter("resources"+ File.separator+"text.csv");
        for (int el: arr) {
            fw.write(String.valueOf(el)+";");
            // fw.flush();
        }
        fw.close();
    }

    private static int[] getArrFromTXT(String filename) throws IOException {
        BufferedReader br =new BufferedReader( new FileReader(filename));
        int[] arrInt = null;
        while(br.ready()) {
          String [] elems =  br.readLine().split(",");
            arrInt = new int[elems.length];
            for (int i = 0; i < elems.length ; i++) {
                arrInt[i] = Integer.parseInt(elems[i]);
            }
        }
       return arrInt;
    }

    private static int[] getArrFromCSV(String filename) throws IOException {
        BufferedReader br =new BufferedReader( new FileReader(filename));
        int[] arrInt = null;
        while(br.ready()) {
            String [] elems =  br.readLine().split(";");
            arrInt = new int[elems.length];
            for (int i = 0; i < elems.length ; i++) {
                arrInt[i] = Integer.parseInt(elems[i]);
            }
        }
        return arrInt;
    }
}
