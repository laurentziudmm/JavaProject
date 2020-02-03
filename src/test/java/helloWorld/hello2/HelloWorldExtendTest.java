package helloWorld.hello2;

import helloWorld.hello.HelloWorld;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HelloWorldExtendTest {
    private String name;

    @Before
    public void setUp() throws Exception {
        this.name="all";
    }

    @Test
    public void testHello() {
        HelloWorld helloWorld=new HelloWorldExtend();
        String ret=helloWorld.hello(this.name);
        Assert.assertEquals("From extend Hello all",ret);
    }
}