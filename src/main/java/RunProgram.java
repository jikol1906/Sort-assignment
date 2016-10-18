import Sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by borisgrunwald on 12/10/2016.
 */
public class RunProgram {


    public static void main(String[] args) {

        Random r = new Random();

        String[] list = new String[10];

        list[0] = "lul";
        list[1] = "hee";
        list[2] = "hva";
        list[3] = "ncie";
        list[4] = "drgdr";
        list[5] = "huhu";
        list[6] = "yea";
        list[7] = "wow";
        list[8] = "suchstring";
        list[9] = "hvafaen";

        Lock



        long startTime = System.currentTimeMillis();

        Sort.quickSort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        long endTime = System.currentTimeMillis();


        System.out.println(Arrays.toString(list));














    }


}
