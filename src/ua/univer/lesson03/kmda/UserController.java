package ua.univer.lesson03.kmda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserController {
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
