package Day3.ro.db.hello2;

import Day3.ro.db.hello.HelloWorld;

/**
 * HelloWorldExtend
 **/

public class HelloWorldExtend extends HelloWorld{
    @Override
    public String hello(String name) {
        return "From extend "+super.hello(name);
    }
}
