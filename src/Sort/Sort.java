package Sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by borisgrunwald on 12/10/2016.
 */
public class Sort {

    public static <E extends Comparable<E>> void bubbleSort (E[] arr) {

        E temp;

        for (int k = 0; k < arr.length - 1; k++) {
            for (int i = 0; i < arr.length - k - 1; i++) {
                if(arr[i].compareTo(arr[i+1]) == 1) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }

            }
        }

    }

    public static <E extends Comparable<E>> void bubbleSort (E[] arr, Comparator<? super E> comparator) {

        E temp;

        for (int k = 0; k < arr.length - 1; k++) {
            for (int i = 0; i < arr.length - k - 1; i++) {
                if(comparator.compare(arr[i],arr[i+1]) == 1) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }

            }
        }

    }

    public static <E extends Comparable<E>> void mergeSort(E[] arr) {


        if(arr.length > 1) {

            E[] left = Arrays.copyOfRange(arr,0,arr.length/2);
            E[] right = Arrays.copyOfRange(arr,arr.length/2,arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr,left,right);

        }


    }

    public static <E extends Comparable<E>> void mergeSort(E[] arr, Comparator<? super E> comparator) {


        if(arr.length > 1) {

            E[] left = Arrays.copyOfRange(arr,0,arr.length/2);
            E[] right = Arrays.copyOfRange(arr,arr.length/2,arr.length);

            mergeSort(left, comparator);
            mergeSort(right, comparator);

            merge(arr,left,right, comparator);

        }


    }

    private static <E extends Comparable<E>> void merge(E[] arr, E[] left, E[] right, Comparator<? super E> comparator) {

        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if(i2 >= right.length || i1 < left.length && comparator.compare(left[i1], right[i2]) < 0 ) {
                arr[i] = left[i1];
                i1++;
            } else {
                arr[i] = right[i2];
                i2++;
            }
        }

    }

    protected static <E extends Comparable<E>> void merge(E[] arr, E[] left, E[] right) {

        //System.out.println("Merging " + Arrays.toString(left) + " and " + Arrays.toString(right));

        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if(i2 >= right.length || i1 < left.length && left[i1].compareTo(right[i2]) < 0 ) {
                arr[i] = left[i1];
                i1++;
            } else {
                arr[i] = right[i2];
                i2++;
            }
        }

        //System.out.println("into " + Arrays.toString(arr));

    }

    public static int binarySearch(int[] numbers, int target) {
        return binarySearch(numbers, target, 0, numbers.length-1);
    }

    private static int binarySearch(int[] numbers, int target, int min, int max) {


        if(max < min) {
            return -1;
        } else {
            int mid = (min+max) / 2;

            if(numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                return binarySearch(numbers, target, mid+1, max);
            } else {
                return binarySearch(numbers,target, min, mid-1);
            }

        }



    }

    private static <E extends Comparable<E>> E[] leftHalf (E[] arr) {
        int size = arr.length/2;
        E[] left = (E[]) new Object[size];
        for (int i = 0; i <  left.length; i++) {
            left[i] = arr[i];
        }
        return left;
    }


}
