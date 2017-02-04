package com.jagdiv.android.taxcalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.EditText;

/**
 * Created by Dell on 12/05/2016.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
super.setUp();
    }


    @Override
    public void tearDown() throws Exception {
super.tearDown();
    }
    @SmallTest
    public void testeditText() {
        EditText et=(EditText)getActivity().findViewById(R.id.editTextIncome);
       assertNotNull(et);
       // assertEquals(23097.0, AustraliaTax.Wealth.getWealth(95000, AustraliaTax.ResidentType.Resident.toString()),0);
        //assertEquals("Resident", AustraliaTax.ResidentType.Resident.name());
    }
}