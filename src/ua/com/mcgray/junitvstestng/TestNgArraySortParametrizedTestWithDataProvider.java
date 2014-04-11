package ua.com.mcgray.junitvstestng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author orezchykov
 * @since 05.10.13
 */
public class TestNgArraySortParametrizedTestWithDataProvider {

    public static final String EXPECTED_ERROR_MESSAGE = "Input array should not be null or empty!";

    @DataProvider(name = "arrayProvider")
    public Iterator<Object[]> arrayProvider() {
        final Random random = new Random(new Date().getTime());
        List<Object[]> result = new ArrayList<>(5);
        int startLength = 5;
        for (int i = 0; i < 5; i++) {
            int operation = random.nextInt(3);
            switch (operation) {
                case 0:
                    result.add(new Object[]{SortUtils.generateRandomArray(startLength)});
                    break;
                case 1:
                    result.add(new Object[]{SortUtils.generateRandomSortedArray(startLength)});
                    break;
                case 2:
                    result.add(new Object[]{SortUtils.generateRandomReversedArray(startLength)});
                    break;
            }

            startLength++;
        }
        return result.iterator();
    }

    @Test(dataProvider = "arrayProvider")
    public void testIntArraySort(int[] arrayToSort) {
        int[] sortedArray = MergeSort.sort(arrayToSort);
        Arrays.sort(arrayToSort);
        assertThat(sortedArray, equalTo(arrayToSort));
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = EXPECTED_ERROR_MESSAGE,
            groups = "nullTest")
    public void testForNullInput() {
        MergeSort.sort(null);

    }
}
