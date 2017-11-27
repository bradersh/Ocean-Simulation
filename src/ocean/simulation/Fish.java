package ocean.simulation;

/**
 *
 * @author Bradersh
 */
public abstract class Fish extends Creature {

    //Only Shark and Sardine require food
    protected int food;

    public Fish() {

    }

    protected Location eat(Location location, Field field) {
        return null;
    }

    //When the fish is created it assigns it a random amount of food
    public Fish(int depth, int width, int age) {
        super(depth, width, age);
        food = RandomGenerator.getRandom().nextInt(30) + 1;
    }

    //Method which increases the hunger by 1 and is called in act
    private void increaseHunger() {
        food--;
    }

    public Creature act(Field field) {
        //Try and eat a plankton. get its location
        Location newLoc = eat(location, field);

        //If found new location move to it
        if (newLoc != null) {
            field.place(null, location);
            setLocation(newLoc);
            field.place(this, location);
        } else {
            die(field);
        }

        //Increase hunger levels
        increaseHunger();
        if (food <= 0) {
            die(field);
        }

        return super.act(field);
    }

}
