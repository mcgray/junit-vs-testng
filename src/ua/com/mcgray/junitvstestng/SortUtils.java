package ua.com.mcgray.junitvstestng;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author orezchykov
 * @since 05.10.13
 */
public class SortUtils {

    private static Random random;

    private SortUtils() {

    }

    public static int[] generateRandomArray(int length) {
        random = new Random(new Date().getTime());
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(length);
        }
        return result;
    }

    public static int[] generateRandomSortedArray(int length) {
        int[] array = generateRandomArray(length);
        Arrays.sort(array);
        return array;
    }

    public static int[] generateRandomReversedArray(int length) {
        int[] array = generateRandomSortedArray(length);
        for (int i = 0; i <= array.length / 2; i++) {
            swap(array, i, array.length - 1 - i);
        }
        return array;
    }

    public static int[] generateSortedArray(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static int[] generateReversedArray(int length)  {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = length - i - 1;
        }
        return result;
    }

    public static int[] generateShuffledArray(int length) {
        random = new Random(new Date().getTime());
        int[] result = generateSortedArray(length);
        for (int i = 0; i < length; i++) {
            int change = i + random.nextInt(length - i);
            swap(result, i, change);
        }

        return result;
    }

    private static void swap(final int[] result, final int i, final int change) {
        int temp = result[i];
        result[i] = result[change];
        result[change] = temp;

    }
}
