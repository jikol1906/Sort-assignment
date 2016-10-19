package Sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Created by borisgrunwald on 16/10/2016.
 */
public class SortTest {

    Integer[] unSorted;
    Integer[] toBeSorted;


    @Before
    public void setUp() throws Exception {

        unSorted = new Integer[] {4,6,7,1,4,9,324,6543,23,43,23,543,234};
        toBeSorted = new Integer[] {4,6,7,1,4,9,324,6543,23,43,23,543,234};
        Arrays.sort(toBeSorted);


    }

    @Test
    public void bubbleSort() throws Exception {

        Sort.bubbleSort(unSorted);

        assertArrayEquals(unSorted, toBeSorted);


    }

    @Test
    public void bubbleSortWithComparator() throws Exception {

        Sort.bubbleSort(unSorted, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {

                return o2-o1;

            }
        });

        assertArrayEquals(unSorted,toBeSorted);

    }

    @Test
    public void mergeSort() throws Exception {

        Sort.mergeSort(unSorted);

        assertArrayEquals(unSorted,toBeSorted);

    }

    @Test
    public void mergeSortWithComparator() throws Exception {

        Sort.mergeSort(unSorted, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        assertArrayEquals(unSorted,toBeSorted);

    }

    @Test
    public void quickSort() throws Exception {

        Sort.quickSort(unSorted);

        assertArrayEquals(unSorted,toBeSorted);

    }

    @Test
    public void quickSortWithComparator() throws Exception {

        Sort.quickSort(unSorted, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        assertArrayEquals(unSorted,toBeSorted);

    }



}