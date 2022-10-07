package Splitting;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Method {

    public static void method1(String word){
        try {
            URL page = new URL("https://www.dictionary.com/browse/" + word);
            HttpURLConnection connect = (HttpURLConnection)page.openConnection();
            if(connect.getResponseCode()==200){
                InputStream inputStream = connect.getInputStream();
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader BufferedR = new BufferedReader((new InputStreamReader(inputStream)));
                String line = BufferedR.readLine();
                int adjectives = 0;
                int nouns =0;

                while(line!=null){
                    if (line.contains("adjective")){
                        adjectives++;
                    }
                    if (line.contains("noun")){
                        nouns++;
                    }
                    line = BufferedR.readLine();

                }
                if (nouns > adjectives){
                    System.out.println("this is a noun");
                }
                if (adjectives > nouns){
                    System.out.println("this is a adjective");
                }

            }
        } catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String []args){
        method1("happy");
    }
}
