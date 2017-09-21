package kpartition;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yuhaowang on 9/13/17.
 */
public class KPartition {
    /**
     *
     * @param list
     * @param k
     * @return
     */
    //time complexity: O(k^n), space complexity: O(n + k)
    public boolean separate(List<Integer> list, int k) {
        if (list == null) {
            return false;
        }
        int n = list.size();
        if (n < k) {
            return false;
        }
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }

        if (sum % k != 0) {
            return false;
        }

        int[] sumArray = new int[k];

        Arrays.fill(sumArray, sum / k);

        return subsetSum(list, n - 1, sumArray, k);
    }

    /**
     *
     * @param list
     * @param size
     * @param sumArray
     * @param k
     * @return
     */
    private boolean subsetSum(List<Integer> list, int size, int[] sumArray, int k) {
        if (checkSum(sumArray, k)) {
            return true;
        }
        if (size < 0) {
            return false;
        }
        boolean res = false;

        for (int i = 0; i < k; i++) {
            if (!res && sumArray[i] - list.get(size) >= 0) {
                sumArray[i] = sumArray[i] - list.get(size);
                res = subsetSum(list, size - 1, sumArray, k);
                sumArray[i] = sumArray[i] + list.get(size);
            }
        }
        return res;
    }

    /**
     *
     * @param sumArray
     * @param k
     * @return
     */
    private boolean checkSum(int[] sumArray, int k) {
        boolean found = true;
        for (int i : sumArray) {
            if (i != 0) {
                found = false;
            }
        }
        return found;
    }

}
