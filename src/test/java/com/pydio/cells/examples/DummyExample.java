package com.pydio.cells.examples;

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
        org.junit.Assert.assertTrue(new ArrayList<String>().isEmpty());
        int order = "b".compareTo("c");
        int order2 = "d".compareTo("c");
        int order3 = "D".compareTo("c");
        System.out.println("Order: " + order);
        System.out.println("Order2: " + order2);
        System.out.println("Order3: " + order3);
    }

    @After
    public void tearThis() {
    }

    @AfterClass
    public static void tear() {
    }
}