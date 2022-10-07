import Splitting.Identify;
import Splitting.Splitter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args) {


        Splitter splitter = new Splitter();
        ArrayList<String> newList =  splitter.wordify("verb, evolution");
        Identify identify = new Identify();

        for (int i = 0; i < newList.size(); i++) {
            identify.identify1(newList.get(i));
        }

        System.out.println(identify.getNounsList());;

    }
}

