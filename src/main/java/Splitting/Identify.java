package Splitting;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Identify {

    private ArrayList nounsList = new ArrayList();

    private ArrayList verbList = new ArrayList();
    private ArrayList adjectiveList = new ArrayList();

    //////////////////////////////////////////////////////////

    public ArrayList getNounsList() {
        return nounsList;
    }

    public ArrayList getVerbList() {
        return verbList;
    }

    public ArrayList getAdjectiveList() {
        return adjectiveList;
    }
    ///////////////////////////////////////////////////////////////

    public void identify1(String word) {
        try {
            URL page = new URL("https://dictionary.cambridge.org/dictionary/english/" + word);
            HttpURLConnection connect = (HttpURLConnection) page.openConnection();
            if (connect.getResponseCode() == 200) {
                InputStream inputStream = connect.getInputStream();
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader BufferedR = new BufferedReader((new InputStreamReader(inputStream)));
                String line = BufferedR.readLine();

                while (line != null) {
                    //System.out.println(line);
                    if (line.contains("posgram dpos-g hdib lmr-5\"><span class=\"pos dpos\" title=\"A word that describes a noun or pronoun.") || ((line.contains("class=\"posgram dpos-g hdib lmr-5\"><span class=\"pos dpos\" title=\"A word that refers to a person, place, idea, event or thing.")))) {
                        nounsList.add(word);
                        return;
                    }

                    if (line.contains("posgram dpos-g hdib lmr-5\"><span class=\"pos dpos\" title=\"A word that describes an action, condition or experience.")) {
                        verbList.add(word);
                        return;
                    }

                    if (line.contains("adjective")) {
                        adjectiveList.add(word);
                    }

                    line = BufferedR.readLine();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


