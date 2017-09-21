package mutidimensionarray;


/**
 * Created by yuhaowang on 9/17/17.
 */
public class MultiDimensionArray {

    public static int getValueByIndex(int... indexOfDimension) {
        //I just choose a value by random in order to compile java file successfully
        int value = (int)(Math.random() * 10);

        return value;
    }

    /**
     *
     * @param mArray
     * @param lengthOfDeminsion
     * @return
     */
    //time complexity: O(n), space complexity: O(L), length of array of lengthOfDeminsion
    public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) {
        if (lengthOfDeminsion == null || lengthOfDeminsion.length == 0) {
            return null;
        }

        int length = lengthOfDeminsion.length;
        int[] cur = new int[length];

        long result = 0L;
        int right = 0;

        OUTER_LOOP:
        while (true) {
            result += getValueByIndex(cur);

            right = length - 1;
            cur[right]++;

            while (cur[right] > lengthOfDeminsion[right] - 1) {
                cur[right--] = 0;
                if (right < 0) {
                    break OUTER_LOOP;
                }
                cur[right]++;
            }
        }
        return result;
    }


}
