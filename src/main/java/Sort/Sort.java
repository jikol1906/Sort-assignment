package Sort;


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
                if(comparator.compare(arr[i],arr[i+1]) < 0) {
                    swap(arr, i, i+1);
                }

            }
        }

    }

    public static <E extends Comparable<E>> void mergeSort(E[] arr) {


        if(arr.length > 1) {

            E[] left = leftHalf(arr);
            E[] right = rightHalf(arr,left);

            mergeSort(left);
            mergeSort(right);

            merge(arr,left,right);

        }


    }

    public static <E extends Comparable<E>> void mergeSort(E[] arr, Comparator<? super E> comparator) {


        if(arr.length > 1) {

            E[] left = leftHalf(arr);
            E[] right = rightHalf(arr,left);

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
            E median = medianOfThree(arr, start, end);
            int sortedIndex = partition(arr, start, end, median);
            quickSort(arr, start, sortedIndex-1);
            quickSort(arr, sortedIndex+1, end);
        }
    }


    /**
     * Places the last element in the array in its sorted position.
     * @return the sorted element
     */

    private static <E extends Comparable<E>> int partition(E[] arr, int start, int end, E pivot) {

        int wall = start-1;

        for (int i = start; i < end-1; i++) {
            if(arr[i].compareTo(pivot) < 0) {
                wall++;
                if(!arr[wall].equals(arr[i])) {
                    swap(arr, wall, i);
                }

            }

        }


        if(wall+1 != end) {
            swap(arr, wall + 1, end-1);
        }
        return wall+1;
        
        


    }


    private static <E extends Comparable<E>> E medianOfThree(E[] arr, int start, int end) {

        int center = (start+end)/2;
        
        if (arr[start].compareTo(arr[center]) > 0) swap(arr,start,center);
        if (arr[start].compareTo(arr[end]) > 0) swap(arr, start, end);
        if (arr[center].compareTo(arr[end]) > 0) swap(arr,center,end);

        swap(arr,center,end-1);

        return arr[end-1];

    }


    public static <E extends Comparable<E>> void quickSort(E[] arr, Comparator<? super E> comp) {

        quickSort(arr, 0, arr.length-1,comp);

    }


    private static <E extends Comparable<E>> void quickSort(E[] arr, int start, int end, Comparator<? super E> comp) {

        if(start < end) {
            int sortedIndex = partition(arr, start, end, comp);
            quickSort(arr, start, sortedIndex-1, comp);
            quickSort(arr, sortedIndex+1, end, comp);
        }
    }


    /**
     * Places the last element in the array in its sorted position.
     * @return the sorted element
     */

    private static <E extends Comparable<E>> int partition(E[] arr, int start, int end, Comparator<? super E> comp) {

        E pivot = arr[end];
        int wall = start-1;

        for (int i = start; i < end; i++) {
            if(comp.compare(arr[i],pivot) < 0) {
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


    @SuppressWarnings("unchecked")
    protected static <E extends Comparable<E>> E[] leftHalf(E[] arr) {

        E[] toReturn = (E[]) new Comparable[arr.length/2];
        System.arraycopy(arr,0,toReturn,0,toReturn.length);
        return toReturn;

    }

    @SuppressWarnings("unchecked")
     protected static <E extends Comparable<E>> E[] rightHalf(E[] arr, E[] leftHalf) {

        E[] toReturn =(E[]) new Comparable[arr.length-leftHalf.length];
        System.arraycopy(arr,leftHalf.length,toReturn,0,toReturn.length);
        return toReturn;

    }



    //Bonus

    public static int binarySearch(int[] numbers, int target) {
        return binarySearch(numbers, target, 0, numbers.length-1);
    }

    private static int binarySearch(int[] numbers, int target, int min, int max) {


        if(max < min) {
            return -1;
        } else {
            int center = (min+max) / 2;

            if(numbers[center] == target) {
                return center;
            } else if (numbers[center] < target) {
                return binarySearch(numbers, target, center+1, max);
            } else {
                return binarySearch(numbers,target, min, center-1);
            }

        }



    }




}
