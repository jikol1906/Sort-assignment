package Sort;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * Created by borisgrunwald on 14/10/2016.
 */
public class MergeSort {

    public static <E extends Comparable<E>> void mergeSort(E[] arr) {


        if (arr.length > 1) {

            E[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
            E[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

            ExecutorService service = Executors.newFixedThreadPool(2);

            Future<E[]> task1 = service.submit(new MergeThread<>(left));
            Future<E[]> task2 = service.submit(new MergeThread<>(right));

            service.shutdown();


            try {
                Sort.merge(arr, task1.get(), task2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


    }


}
