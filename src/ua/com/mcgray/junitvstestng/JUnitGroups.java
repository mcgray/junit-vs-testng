package ua.com.mcgray.junitvstestng;

/**
 * @author orezchykov
 * @since 09.10.13
 */

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(FastTests.class)
@Categories.ExcludeCategory(SlowTests.class)
@Suite.SuiteClasses( { JUnitArraySortParametrizedTest.class,
        JUnitExpectedExceptionRule.class })
public class JUnitGroups {


}
