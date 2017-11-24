package ocean.simulation;

/**
 *
 * @author Bradersh
 */
public class Plankton extends Creature {

    public Plankton(int depth, int width, int age) {
        super(depth, width, age);
    }

    public Plankton() {

    }

    public Creature act(Field field) {

        if (age >= ModelConstants.PLANKTON_MAX_AGE) {
            die(field);
        }
        return super.act(field);
    }

    protected Creature breed(Location location, Field field) {
        Location breedingSpace = field.freeAdjacentLocation(location);
        if (breedingSpace != null) {
            if ((RandomGenerator.getRandom().nextInt(100) + 1) <= ModelConstants.BREEDING_PROBABILITY_PLANKTON) {
                field.place(new Plankton(breedingSpace.getRow(), breedingSpace.getCol(), 0), breedingSpace);
                return field.getObjectAt(breedingSpace);
            }
        }
        return null;
    }

}
