package Sort;

import java.util.concurrent.*;

/**
 * Created by borisgrunwald on 14/10/2016.
 */
public class MergeSort {

    public static <E extends Comparable<E>> void mergeSort(E[] arr) {


        if (arr.length > 1) {

            E[] left = Sort.leftHalf(arr);
            E[] right = Sort.rightHalf(arr,left);

            ExecutorService service = Executors.newFixedThreadPool(2);

            Future<E[]> task1 = service.submit(new MergeThread<E>(left));
            Future<E[]> task2 = service.submit(new MergeThread<E>(right));

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
