package Sort;

import java.util.concurrent.Callable;




/**
 * Created by borisgrunwald on 14/10/2016.
 */

public class MergeThread<E extends Comparable<E>> implements Callable<E[]> {


    E[] arr;

    public MergeThread(E[] arr) {
        this.arr = arr;
    }


    public E[] call() throws Exception {

        Sort.mergeSort(arr);
        return arr;

    }
}

