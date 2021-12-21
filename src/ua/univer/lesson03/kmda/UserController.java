package ua.univer.lesson03.kmda;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserController {
    public static List<User> getUsersFromBINFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in= new ObjectInputStream(new FileInputStream(filename));
        List<User> usersFromFile = (List<User>) in.readObject();
        in.close();
        return usersFromFile;
    }

    public static void writeUserToBIN(List<User> maxSalaryUsers) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.bin"));
        out.writeObject(maxSalaryUsers);
        out.close();
    }

    public static List<User> getUserListFromURL(String url) throws IOException {
        List<User> userList = new ArrayList<>();
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(), "Windows-1251"));
     //   BufferedReader br =new BufferedReader(new FileReader(filename, Charset.forName("Windows-1251")));
        br.readLine();
        while (br.ready()){
            String str = br.readLine();
            String [] words = str.split(";");
            System.out.println(Arrays.toString(words));
            userList.add(new User(
                    words[0],
                    words[1],
                    Double.parseDouble(words[2].replace(",","."))
            ));
        }
        return userList;
    }

    public static List<User> getUserListFromCSV(String filename) throws IOException {
        List<User> userList = new ArrayList<>();
        BufferedReader br =new BufferedReader(new FileReader(filename, Charset.forName("Windows-1251")));
        br.readLine();
        while (br.ready()){
            String str = br.readLine();
            String [] words = str.split(";");
            System.out.println(Arrays.toString(words));
            userList.add(new User(
                    words[0],
                    words[1],
                    Double.parseDouble(words[2].replace(",","."))
            ));
        }
        return userList;
    }
}
