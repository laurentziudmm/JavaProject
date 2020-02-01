package day3.ro.db.hello;

import org.apache.log4j.Logger;

/**
 * Hello world
 **/

public class HelloWorld {
    private static final Logger logger = Logger.getLogger(HelloWorld.class.getName());

    /**
     * Saying Hello
     */
    private void hello(){
        //you can use IntelliJ Live template -> write “sout” and then press TAB
        System.out.println("Hello World!");
        logger.debug("Enters in hello() method from HelloWorld");
    }

    /**
     * Return "Hello" + name;
     * @param name - user input name
     * @return "Hello"+ User input name
     */
    public String hello(String name){
        logger.info("Enters in hello("+name+") from HelloWorld");
        return "Hello "+name;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld=new HelloWorld();
        helloWorld.hello();
        helloWorld.hello("Laurentiu");
    }
}
