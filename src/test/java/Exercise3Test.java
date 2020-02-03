import exercices.exercise3.Exercise3;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class Exercise3Test {
    private Exercise3 exercise3;
    private String[] stringsToAddToSet = {"A", "collection", "that", "contains", "no", "duplicate", "elements", "."};

    @Before
    public void setUp() throws Exception {
        exercise3 = new Exercise3(Arrays.asList(stringsToAddToSet));

    }

    @Test
    public void testExercise3() throws Exception {
        exercise3.addElementsToSets();

    }
}
