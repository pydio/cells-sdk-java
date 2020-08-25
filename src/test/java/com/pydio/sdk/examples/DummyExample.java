package com.pydio.sdk.examples;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DummyExample {
    @BeforeClass
    public static void setup() {
    }

    @Before
    public void setupThis() {
    }

    @Test
    public void method() {
        org.junit.Assert.assertTrue(new ArrayList().isEmpty());
    }

    @After
    public void tearThis() {
    }

    @AfterClass
    public static void tear() {
    }
}