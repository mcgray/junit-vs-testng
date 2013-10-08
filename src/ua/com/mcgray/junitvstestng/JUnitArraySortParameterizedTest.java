package ua.com.mcgray.junitvstestng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author orezchykov
 * @since 05.10.13
 */

@RunWith(Parameterized.class)
public class JUnitArraySortParameterizedTest {

    //TODO: Write a rule to make a test description pretty

    @Parameter
    public int[] arrayToSort;

    @Parameters(name = "{index}: ArrayToSort - {0}")
    public static Collection<Object[]> getArrayToSort() {
        final Random random = new Random(new Date().getTime());
        List<Object[]> result = new ArrayList<Object[]>(5);
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
        return result;
    }

    @Test
    public void testIntArraySort() {
        int[] sortedArray = MergeSort.sort(arrayToSort);
        Arrays.sort(arrayToSort);
        assertThat(sortedArray, equalTo(arrayToSort));
    }

}
