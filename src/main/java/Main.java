import Dictionaries.Nouns;
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
        ArrayList<String> newList =  splitter.wordify("I don't know what you've been told\n" +
                "But time is running out, no need to take it slow\n" +
                "I'm stepping to you toe-to-toe\n" +
                "I should be scared, honey, maybe so\n" +
                "But I ain't worried 'bout it right now (right now)\n" +
                "Keeping dreams alive (hey!), 1999, heroes\n" +
                "I ain't worried 'bout it right now (right now)\n" +
                "Swimmin' in the floods (hey!), dancing on the clouds below\n" +
                "I ain't worried 'bout it\n" +
                "I ain't worried 'bout it\n" +
                "Hey!\n" +
                "I don't know what you've been told\n" +
                "But time is running out, so spend it like it's gold\n" +
                "I'm living like I'm nine-zeros\n" +
                "Got no regrets, even when I'm broke, yeah");
        Identify identify = new Identify();

        for (int i = 0; i < newList.size(); i++) {
            identify.identify1(newList.get(i));
        }

        System.out.println(identify.getNounsList());
        System.out.println(identify.getVerbList());;
        System.out.println(identify.getAdjectiveList());;
        System.out.println(identify.getPronounList());

    }
}

