package exercices.exercise3;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * Exercise 3: Fill three Set implementations that you know (Hint: they were described during
 * the earlier presentation) with the List<String> that is given to this class by
 * its constructor.
 * <p>
 * Check out the elements that the list mentioned above contains and then, add them
 * to your three Sets. After this check out the elements of your Sets. What do you
 * remark? What could be the reason?
 * <p>
 * Finally, add to the one of the three Sets some elements
 * that already exist in the Set (e.g add("that") and add("collection"))
 * <p>
 * To run your implementation, run the Exercise3Test class.
 */
public class Exercise3 {
    public static final Logger LOGGER = Logger.getLogger(Exercise3.class);
    // List containing some elements that need to be added into the Set
    private List<String> listToAdd;

    public Exercise3(List<String> l) {
        listToAdd = l;
    }

    public void addElementsToSets() {

        LOGGER.debug("The elements that will be added to the Sets: ");
        // TODO Exercise #3 a) Check the content of the elements you will add into the Set
        // TODO Exercise #3 b) add the elements from listToAdd to the Sets
        if (listToAdd == null || listToAdd.size() == 0) {
            return;
        }
        Set<String> firstSet = new HashSet<String>(listToAdd);
        Set<String> secondSet = new LinkedHashSet<String>(listToAdd);
        Set<String> thirdSet = new TreeSet<String>(listToAdd);


        // TODO Exercise #3 c) Check the content of the Sets
        LOGGER.debug("\nThe elements contained in the first Set: ");
        LOGGER.debug(firstSet);

        LOGGER.debug("\nThe elements contained in the second Set: ");
        LOGGER.debug(secondSet);

        LOGGER.debug("\nThe elements contained in the third Set: ");
        LOGGER.debug(thirdSet);


        LOGGER.debug("\nThe elements contained in the TreeSet after inserting two duplicates: ");

        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?
        thirdSet.add("A");
        thirdSet.add("no");
        LOGGER.debug("\nThe elements contained in the TreeSet after inserting two duplicates: ");
        LOGGER.debug(thirdSet);
    }
}
