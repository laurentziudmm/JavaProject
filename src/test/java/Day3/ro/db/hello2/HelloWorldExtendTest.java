package Day3.ro.db.hello2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Day3.ro.db.hello.HelloWorld;


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