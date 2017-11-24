package ocean.simulation;

/**
 *
 * @author Bradersh
 */
public class ModelConstants {

    public static int DEFAULT_DEPTH = 100;
    public static int DEFAULT_WIDTH = 100;
    public static Plankton PLANKTON = new Plankton();
    public static Sardine SARDINE = new Sardine();
    public static Shark SHARK = new Shark();
    public static int BIRTH_AGE = 0;
    public static int p = 60;
    public static int sa = 10;
    public static int sh = 5;
    public static int STARTING_STEP = 0;
    public static int SHARK_MAX_AGE = 150;
    public static int SARDINE_MAX_AGE = 75;
    public static int PLANKTON_MAX_AGE = 100;
    public static int PLANKTON_FOOD_VALUE = 4;
    public static int SARDINE_FOOD_VALUE = 14;
    public static int RANDOM_SEED = 21;
    public static int BREEDING_PROBABILITY_SHARK = 15;
    public static int BREEDING_PROBABILITY_SARDINE = 50;
    public static int BREEDING_PROBABILITY_PLANKTON = 15;
    public static int BREEDING_AGE_SHARK = 25;
    public static int BREEDING_AGE_SARDINE = 12;
    public static int BREEDING_AGE_PLANKTON = 0;
    public static int STEPS = 1000;

    public static void SetConstants(int DEFAULT_DEPTH, int DEFAULT_WIDTH, int p, int sa, int sh, int SHARK_MAX_AGE, int SARDINE_MAX_AGE, int PLANKTON_MAX_AGE, int PLANKTON_FOOD_VALUE, int SARDINE_FOOD_VALUE, int RANDOM_SEED, int BREEDING_PROBABILITY_SHARK, int BREEDING_PROBABILITY_SARDINE, int BREEDING_PROBABILITY_PLANKTON, int BREEDING_AGE_SHARK, int BREEDING_AGE_SARDINE, int BREEDING_AGE_PLANKTON, int STEPS) {
        ModelConstants.DEFAULT_DEPTH = DEFAULT_DEPTH;
        ModelConstants.DEFAULT_WIDTH = DEFAULT_WIDTH;
        ModelConstants.p = p;
        ModelConstants.sa = sa;
        ModelConstants.sh = sh;
        ModelConstants.SHARK_MAX_AGE = SHARK_MAX_AGE;
        ModelConstants.SARDINE_MAX_AGE = SARDINE_MAX_AGE;
        ModelConstants.PLANKTON_MAX_AGE = PLANKTON_MAX_AGE;
        ModelConstants.PLANKTON_FOOD_VALUE = PLANKTON_FOOD_VALUE;
        ModelConstants.SARDINE_FOOD_VALUE = SARDINE_FOOD_VALUE;
        ModelConstants.RANDOM_SEED = RANDOM_SEED;
        ModelConstants.BREEDING_PROBABILITY_SHARK = BREEDING_PROBABILITY_SHARK;
        ModelConstants.BREEDING_PROBABILITY_SARDINE = BREEDING_PROBABILITY_SARDINE;
        ModelConstants.BREEDING_PROBABILITY_PLANKTON = BREEDING_PROBABILITY_PLANKTON;
        ModelConstants.BREEDING_AGE_SHARK = BREEDING_AGE_SHARK;
        ModelConstants.BREEDING_AGE_SARDINE = BREEDING_AGE_SARDINE;
        ModelConstants.BREEDING_AGE_PLANKTON = BREEDING_AGE_PLANKTON;
        ModelConstants.STEPS = STEPS;
    }
}
