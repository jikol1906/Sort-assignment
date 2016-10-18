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

        String time = "12:00:00AM";



        System.out.println(time(time));



    }



    public static String time(String time) {

        String hours = null;

        if(time.substring(time.length()-2).equals("PM")) {
            if(time.substring(0,2).equals("12")) {
                hours = "00";
            } else hours = String.valueOf(Integer.valueOf(time.substring(0,2))+12);
            return hours+time.substring(2,time.length()-2);
        } else {
            return time.substring(0, time.length() - 2);
        }

    }


}
