import Sort.MergeSort;
import Sort.Sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by borisgrunwald on 12/10/2016.
 */
public class RunProgram {


    public static void main(String[] args) {

        Random r = new Random();

        Integer[] list = new Integer[100];

        for (int i = 0; i < list.length; i++) {

            list[i] = r.nextInt(1000);

        }




        Sort.quickSort(list);

        System.out.println(Arrays.toString(list));














    }


}
