package com.jagdiv.android.taxcalculator;

/**
 * Created by Dell on 14/05/2016.
 */
public class ExampleUnit {
    public int add(int x, int y )
    {
        if( x == 0 ) throw new IllegalArgumentException();


        if( y == 0 ) throw new IllegalArgumentException();


        return x+y;
    }

}
