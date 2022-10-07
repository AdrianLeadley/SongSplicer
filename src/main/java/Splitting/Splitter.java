package Splitting;

import java.util.ArrayList;
import java.util.Arrays;

public class Splitter {

    public static <T> ArrayList<String> removeDuplicates(String[] list)
    {
        // Create a new ArrayList
        ArrayList<String> newList = new ArrayList<>();

        // Traverse through the first list
        for (String element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        // return the new list
        return newList;
    }

    public static ArrayList<String> wordify(String song){
        String[] words = song.split("\\W+");
        //System.out.println(Arrays.toString(words));
        ArrayList<String>
                newList = removeDuplicates(words);
        //System.out.println("ArrayList with duplicates removed: " + newList);
        return newList;

    }
}
