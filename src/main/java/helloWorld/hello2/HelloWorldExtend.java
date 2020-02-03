package helloWorld.hello2;

import helloWorld.hello.HelloWorld;

/**
 * HelloWorldExtend
 **/

public class HelloWorldExtend extends HelloWorld{
    @Override
    public String hello(String name) {
        return "From extend "+super.hello(name);
    }
}
