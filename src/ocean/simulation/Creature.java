package ocean.simulation;

/**
 *
 * @author Bradersh
 */
public abstract class Creature {

    protected Location location;
    protected boolean alive;
    protected int age;

    public Creature() {

    }

    public Creature(int depth, int width, int age) {
        this.age = age;
        location = new Location(depth, width);
        alive = true;
    }

    //Returns age
    public int getAge() {
        return age;
    }

    //Increments the age by 1 and is called in the act method
    public void incrementAge() {
        age++;
    }

    //Calls the increment age method and breed
    public Creature act(Field field) {
        incrementAge();
        return breed(location, field);
    }

    protected Creature breed(Location location, Field field) {
        return null;
    }

    //Returns the boolean value of alive
    public boolean isAlive() {
        return alive;
    }

    public void setLocation(Location newLoc) {
        location = newLoc;
    }

    //When the creature dies, it sets alive to false and removes it from its location
    public void die(Field field) {
        alive = false;
        field.place(null, location);
    }
}
