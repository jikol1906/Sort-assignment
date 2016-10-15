package Sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by borisgrunwald on 12/10/2016.
 */
public class Sort {

    public static <E extends Comparable<E>> void bubbleSort (E[] arr) {

        for (int k = 0; k < arr.length - 1; k++) {
            for (int i = 0; i < arr.length - k - 1; i++) {
                if(arr[i].compareTo(arr[i+1]) == 1) {
                    swap(arr, i, i+1);
                }

            }
        }

    }

    public static <E extends Comparable<E>> void bubbleSort (E[] arr, Comparator<? super E> comparator) {

        for (int k = 0; k < arr.length - 1; k++) {
            for (int i = 0; i < arr.length - k - 1; i++) {
                if(comparator.compare(arr[i],arr[i+1]) == 1) {
                    swap(arr, i, i+1);
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

    public static <E extends Comparable<E>> void quickSort(E[] arr) {
        
        quickSort(arr, 0, arr.length-1);

    }

    public static <E extends Comparable<E>> void quickSort(E[] arr, int start, int end) {
        
        if(start < end) {
            int sortedIndex = partition(arr, start, end);
            quickSort(arr, start, sortedIndex-1);
            quickSort(arr, sortedIndex+1, end);
        }
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int start, int end) {

        E pivot = arr[end];
        int wall = start-1;

        for (int i = start; i < end; i++) {
            if(arr[i].compareTo(pivot) < 0) {
                wall++;
                if(!arr[wall].equals(arr[i])) {
                    swap(arr, wall, i);
                }

            }

        }

        if(wall+1 != end) {
            swap(arr, wall + 1, end);
        }
        return wall+1;
        
        


    }
    
    private static <E> void swap(E[] arr, int index1, int index2) {
        E temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        
    }



    //Bonus

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




}
