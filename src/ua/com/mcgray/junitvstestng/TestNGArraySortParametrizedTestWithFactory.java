package ua.com.mcgray.junitvstestng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author orezchykov
 * @since 12.02.14
 */
public class TestNGArraySortParametrizedTestWithFactory implements ITest {

    private int[] arrayToSort;

    public TestNGArraySortParametrizedTestWithFactory(final int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    @Factory
    public static Object[] create() {
        final Random random = new Random(new Date().getTime());
        List<TestNGArraySortParametrizedTestWithFactory> result = new ArrayList<>(5);
        int startLength = 5;
        for (int i = 0; i < 5; i++) {
            int operation = random.nextInt(3);
            switch (operation) {
                case 0:
                    result.add(new TestNGArraySortParametrizedTestWithFactory(SortUtils.generateRandomArray(startLength)));
                    break;
                case 1:
                    result.add(new TestNGArraySortParametrizedTestWithFactory(SortUtils.generateRandomSortedArray(startLength)));
                    break;
                case 2:
                    result.add(new TestNGArraySortParametrizedTestWithFactory(SortUtils.generateRandomReversedArray(startLength)));
                    break;
            }

            startLength++;
        }
        return result.toArray();
    }

    @Test
    public void testIntArraySort() {
        int[] sortedArray = MergeSort.sort(arrayToSort);
        Arrays.sort(arrayToSort);
        assertThat(sortedArray, equalTo(arrayToSort));
    }

    @Override
    public String getTestName() {
        return "Array to sort: " + Arrays.toString(arrayToSort);
    }
}
