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

        Integer[] arr = {3,8,4,6,9,2,5,0,5,3,2,5,54,25,645,45,435,364,575,68,564,634,35,234};



        Sort.quickSort(arr);

        System.out.println(Arrays.toString(arr));




    }






}
