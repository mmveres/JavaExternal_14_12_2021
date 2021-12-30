package ua.univer.lesson06;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,3,34,5,623,4,1,1,1,1);
        Set<Integer>  set = new HashSet<>(integerList);
        List<Integer> uniqIntegerList = new ArrayList<>(set);
        System.out.println(uniqIntegerList);

        String str = "mama mila ramu ramu mila mila mamamama";
        Set<String> uniqWord = new HashSet<>(Arrays.asList(str.split(" ")));
        System.out.println(uniqWord);

     //   Map<String, Integer> freqWord = getFreqWordFromTXT("resources"+ File.separator+"word.txt");
        Map<String, Map<String,Integer>> freqWordURL = new TreeMap<>();
        for (int i = 1; i < 10; i++) {
          //  System.out.println("https://www.stihi-rus.ru/World/Shekspir/"+i+".htm");
            Map<String, Integer> freqWord = getFreqWordFromURL("https://www.stihi-rus.ru/World/Shekspir/"+i+".htm");
            for (var key: freqWord.keySet()) {
                if(!freqWordURL.containsKey(key))
                    freqWordURL.put(key, new TreeMap<>());
                freqWordURL.get(key).put("https://www.stihi-rus.ru/World/Shekspir/"+i+".htm", freqWord.get(key));
            }
        }
        System.out.println(freqWordURL);

    }
    private static Map<String, Integer> getFreqWordFromURL(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(), "Windows-1251"));
        while (br.ready()) {
            sb.append(br.readLine() + " ");
        }
        Map<String, Integer> freqWord = getFreqWordFrom(sb.toString());
        return freqWord;
    }

        private static Map<String, Integer> getFreqWordFromTXT(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while(br.ready()){
            sb.append(br.readLine()+" ");
        }
        Map<String, Integer> freqWord = getFreqWordFrom(sb.toString());
        return freqWord;
    }

    private static Map<String, Integer> getFreqWordFrom(String str) {
        String[] words = str.split(" ");
        Map <String, Integer> freqWord = new HashMap<>();
        for (var word: words) {
            if(!freqWord.containsKey(word))
                freqWord.put(word, 1);
            else freqWord.put(word, freqWord.get(word)+1);
        }
        return freqWord;
    }
}
