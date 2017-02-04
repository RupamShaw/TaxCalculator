package com.jagdiv.android.taxcalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dell on 11/05/2016.
 */
public class AustraliaTaxTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void should() {
        assertEquals(23097.0, AustraliaTax.Wealth.getWealth(95000, AustraliaTax.ResidentType.Resident.toString()),0);
        assertEquals("Resident",AustraliaTax.ResidentType.Resident.name());
    }

}