package serialization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PersonSerDeserTest {
    private Person person;


    @Before
    public void setUpPerson(){
        //todo de initialiat this.person
    }

    @Test
    public void testSerialiationDeserialization() throws Exception{
        PersonSerialization personSerialization=new PersonSerialization(this.person);
        personSerialization.serialize();
        Person deserPerson = PersonDeserialization.deserialize();
        Assert.assertEquals(this.person,deserPerson);
        Assert.assertEquals(this.person.getAge(),deserPerson.getAge());
        Assert.assertEquals(this.person.getFirstName(),deserPerson.getFirstName());
        Assert.assertEquals(this.person.getLastName(),deserPerson.getLastName());
    }
}
