package ua.com.mcgray.junitvstestng;

import java.util.Arrays;

/**
 * @author orezchykov
 * @since 05.10.13
 */
public class MergeSort {

    private static int[] getRigt(final int[] arrayToSort) {
        return Arrays.copyOfRange(arrayToSort, arrayToSort.length / 2, arrayToSort.length);
    }

    private static int[] getLeft(final int[] arrayToSort) {
        int length = arrayToSort.length / 2;
        return Arrays.copyOfRange(arrayToSort, 0, length);
    }

    public static int[] sort(int[] arrayToSort) {
        if (arrayToSort == null || arrayToSort.length == 0)
            throw new IllegalArgumentException("Input array should not be null or empty!");
        if (arrayToSort.length > 2) {
            int[] merge = merge(sort(getLeft(arrayToSort)), sort(getRigt(arrayToSort)));
            return merge;
        } else {
            if (arrayToSort.length == 2) {
                if (arrayToSort[0] > arrayToSort[1]) {
                    int temp = arrayToSort[0];
                    arrayToSort[0] = arrayToSort[1];
                    arrayToSort[1] = temp;
                }
            }
            return arrayToSort;
        }

    }

    public static int[] merge(final int[] left, final int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int leftIndex = 0, rightIndex = 0, i = 0;
        int max = leftLength + rightLength;
        int[] result = new int[max];
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[i] =left[leftIndex];
                leftIndex++;
            } else {
                result[i] = right[rightIndex];
                rightIndex++;
            }
            i++;
        }
        if (leftIndex >= leftLength) {
            while (rightIndex < rightLength) {
                result[i] = right[rightIndex];
                rightIndex++;
                i++;
            }
        } else {
            while (leftIndex < leftLength) {
                result[i] = left[leftIndex];
                leftIndex++;
                i++;
            }

        }

        return result;
    }
}
