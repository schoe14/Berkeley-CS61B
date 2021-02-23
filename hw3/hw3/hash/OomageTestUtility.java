package hw3.hash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* todo:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int N = oomages.size();
        int[] arr = new int[M];
        LinkedList<Oomage>[] list = new LinkedList[M];
        for (Oomage oomage : oomages) {
            int bucketNum = (oomage.hashCode() & 0X7FFFFFFF) % M;
//            System.out.println("hashcode: " + oomage.hashCode());
//            System.out.println("bucketNum: " + bucketNum);
//            System.out.println("oomage: " + oomage);
            if (list[bucketNum] == null) {
                list[bucketNum] = new LinkedList<>();
            }
            list[bucketNum].add(oomage);
//            System.out.println("-----bucket " + bucketNum + " size: " + list[bucketNum].size());
            if (list[bucketNum].size() > N / 2.5) {
                return false;
            }
            arr[bucketNum] = list[bucketNum].size();
        }
        Arrays.sort(arr);
        if (arr[M - 1] < N / 50) {
            return false;
        }
        return true;
    }
}
