package Sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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

        assertEquals(unSorted, toBeSorted);


    }

    @Test
    public void bubbleSort1() throws Exception {

    }

    @Test
    public void mergeSort() throws Exception {

    }

    @Test
    public void mergeSort1() throws Exception {

    }

    @Test
    public void quickSort() throws Exception {

    }

    @Test
    public void quickSort1() throws Exception {

    }

    @Test
    public void binarySearch() throws Exception {

    }

}