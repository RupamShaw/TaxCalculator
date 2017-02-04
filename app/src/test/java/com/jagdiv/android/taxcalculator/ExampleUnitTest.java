
package com.jagdiv.android.taxcalculator;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**connectInstrumentTest
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void addTest() throws Exception {
        ExampleUnit obj=new ExampleUnit();
        try {
            obj.add(0,0);
            Assert.fail("should throw exception");
        } catch(IllegalArgumentException e) {
            // expected
            System.out.print("errrrrrrrrrro");
        }
        assertEquals(4, 2 + 2);
    }
    @Test
    public void approach2() {
        ExampleUnit obj=new ExampleUnit();
        obj.add(0, 0);
    }
    @Test(expected=IllegalArgumentException.class)
    public void approach3() {
        ExampleUnit obj=new ExampleUnit();
        obj.add(0, 0);
    }
    @Test(expected=IllegalArgumentException.class)
    public void approach4() {
        ExampleUnit obj=new ExampleUnit();
        obj.add(4,2);
    }
    @Test(expected=IllegalArgumentException.class)
    public void approach5() {
        ExampleUnit obj=new ExampleUnit();
        assertEquals(6, obj.add(4,2));
    }
    @Ignore("its just to test")
    @Test(expected=IllegalArgumentException.class)
    public void approachignore() {
        ExampleUnit obj=new ExampleUnit();
        System.out.print("will not show");
        obj.add(0, 0);
    }
}