package ocean.simulation;

import java.util.Iterator;

/**
 *
 * @author Bradersh
 */
public class Shark extends Fish {

    public Shark(int depth, int width, int age) {
        super(depth, width, age);
    }

    public Shark() {
         
    }

    // A method which removes the shark if its age has surpassed the defined max age
    public Creature act(Field field) {

        if (age >= ModelConstants.SHARK_MAX_AGE) {
            die(field);
        }
        return super.act(field);
    }

    // A method which checks for sardines(food) around the shark. If an instance of sardine is found, removes it, adds food to the shark and moves the shark to that location
    protected Location eat(Location location, Field field) {

        Iterator adjacent = field.adjacentLocations(location);
        while (adjacent.hasNext()) {
            Location next = (Location) adjacent.next();
            if (field.getObjectAt(next) instanceof Sardine) {
                food = food + ModelConstants.SARDINE_FOOD_VALUE;
                field.getObjectAt(next).die(field);
                return next;
            }
        }
        return field.freeAdjacentLocation(location);
    }

    /**
     * Tries and creates a new shark
     *
     * @param location sharks location
     * @param field the field
     * @return new shark if made
     */
    protected Creature breed(Location location, Field field) {
        if (age >= ModelConstants.BREEDING_AGE_SHARK) {
            Location breedingSpace = field.freeAdjacentLocation(location);
            if (breedingSpace != null) {
                if ((RandomGenerator.getRandom().nextInt(100) + 1) <= ModelConstants.BREEDING_PROBABILITY_SHARK) {
                    field.place(new Shark(breedingSpace.getRow(), breedingSpace.getCol(), 0), breedingSpace);
                    return field.getObjectAt(breedingSpace);
                }
            }
        }
        return null;
    }

}
