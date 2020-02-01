package day3.ro.db.hello;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * HelloWorldTest
 **/

public class HelloWorldTest {
    private String name;

    @Before
    public void setUp() throws Exception {
        this.name="all";
    }

    @Test
    public void testHello() {
        HelloWorld helloWorld=new HelloWorld();
        String ret=helloWorld.hello(this.name);
        Assert.assertEquals("Hello all",ret);
    }
}
