package ocean.simulation;

import java.util.Iterator;

/**
 *
 * @author Bradersh
 */
public class Sardine extends Fish {

    public Sardine() {

    }

    public Sardine(int depth, int width, int age) {
        super(depth, width, age);
    }

    // A method which removes the shark if its age has surpassed the defined max age
    public Creature act(Field field) {

        if (age >= ModelConstants.SARDINE_MAX_AGE) {
            die(field);
        }

        return super.act(field);
    }

    // A method which checks for plankton(food) around the sardine. If an instance of plankton is found, removes it, adds food to the sardine and moves the sardine to that location
    protected Location eat(Location location, Field field) {

        Iterator adjacent = field.adjacentLocations(location);
        while (adjacent.hasNext()) {
            Location next = (Location) adjacent.next();
            if (field.getObjectAt(next) instanceof Plankton) {
                food = food + ModelConstants.PLANKTON_FOOD_VALUE;
                field.getObjectAt(next).die(field);
                return next;
            }
        }

        return field.freeAdjacentLocation(location);
    }

    /**
     * Tries and creates a new sardine
     *
     * @param location sardines location
     * @param field the field
     * @return new sardine if made
     */
    protected Creature breed(Location location, Field field) {
        if (age >= ModelConstants.BREEDING_AGE_SARDINE) {
            Location breedingSpace = field.freeAdjacentLocation(location);
            if (breedingSpace != null) {
                if ((RandomGenerator.getRandom().nextInt(100) + 1) <= ModelConstants.BREEDING_PROBABILITY_SARDINE) {
                    field.place(new Sardine(breedingSpace.getRow(), breedingSpace.getCol(), 0), breedingSpace);
                    return field.getObjectAt(breedingSpace);
                }
            }
        }
        return null;
    }

}
