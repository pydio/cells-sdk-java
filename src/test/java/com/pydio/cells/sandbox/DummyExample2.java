package com.pydio.cells.sandbox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DummyExample2 {

    private int result = 0;

    @Before
    public void setupThis() {
        result++;
    }

    @Test
    public void method() {
        org.junit.Assert.assertEquals(result, 1);
    }

    @After
    public void tearThis() {
        result++;
    }

}