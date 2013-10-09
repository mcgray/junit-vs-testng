package ua.com.mcgray.junitvstestng;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;

public class JUnitExpectedExceptionRule {

    @Rule
    public ExpectedException thrown =
            ExpectedException.none();

    @Category(FastTests.class)
    @Test
    public void testForNullInput() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(
                containsString("Input array should not be null or empty"));
        MergeSort.sort(null);

    }
}