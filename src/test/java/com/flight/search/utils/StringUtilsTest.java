package com.flight.search.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    public void isEmptyWhenValueIsNullReturnTrue() {
        assertTrue(StringUtils.isEmpty(null));
    }

    public void isEmptyWhenValueIsEmptyReturnTrue() {
        assertTrue(StringUtils.isEmpty(""));
    }

    public void isEmptyWhenValueIsNotEmptyReturnFalse() {
        assertFalse(StringUtils.isEmpty("Value"));
    }
}
