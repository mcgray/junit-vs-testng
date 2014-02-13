package ua.com.mcgray.junitvstestng;

/**
 * @author orezchykov
 * @since 09.10.13
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        JUnitArraySortParametrizedTest.class,
        JUnitExpectedExceptionRule.class
})
public class JUnitSuite {

}
