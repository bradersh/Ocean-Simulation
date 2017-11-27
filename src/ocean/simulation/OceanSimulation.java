package ocean.simulation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bradersh
 */
public class OceanSimulation {

    private static Field field;
    private static SimulatorView simulatorView;
    private static ArrayList<Creature> creatureList;
    private static int count = ModelConstants.STARTING_STEP;
    private GUI gui;

    public OceanSimulation() {
        creatureList = new ArrayList<>();
        run();
    }

    public static void main(String args[]) {
        RandomGenerator.initialiseWithSeed(ModelConstants.RANDOM_SEED);
        OceanSimulation oc = new OceanSimulation();
    }

    private void run() {

        //Create gui for param setting
        gui = new GUI();

        //Only continue when gui has set params
        while (!gui.isRun()) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(OceanSimulation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Creates everything
        field = new Field(ModelConstants.DEFAULT_DEPTH, ModelConstants.DEFAULT_WIDTH);
        simulatorView = new SimulatorView(ModelConstants.DEFAULT_DEPTH, ModelConstants.DEFAULT_WIDTH);
        simulatorView.setVisible(true);
        simulatorView.setColor(ModelConstants.PLANKTON.getClass(), Color.black);
        simulatorView.setColor(ModelConstants.SARDINE.getClass(), Color.green);
        simulatorView.setColor(ModelConstants.SHARK.getClass(), Color.blue);
        populate();
        simulatorView.showStatus(count, field);
        simulate(ModelConstants.STEPS);
    }

    private static void populate() {

        //Use constants, checks to see if random value is above or below set value
        Random rnd = RandomGenerator.getRandom();
        for (int d = 0; d < field.getDepth(); d++) {
            for (int w = 0; w < field.getWidth(); w++) {
                int gen = rnd.nextInt(100);
                if (gen <= ModelConstants.sh) {
                    field.place(new Shark(d, w, rnd.nextInt(ModelConstants.SHARK_MAX_AGE)), d, w);
                    creatureList.add(field.getObjectAt(d, w));
                } else if (gen <= ModelConstants.sa) {
                    field.place(new Sardine(d, w, rnd.nextInt(ModelConstants.SARDINE_MAX_AGE)), d, w);
                    creatureList.add(field.getObjectAt(d, w));
                } else if (gen <= ModelConstants.p) {
                    field.place(new Plankton(d, w, rnd.nextInt(ModelConstants.PLANKTON_MAX_AGE)), d, w);
                    creatureList.add(field.getObjectAt(d, w));
                }
            }
        }
    }

    //The method for the simulation itself, shuffles the creature list and runs simulate on step until the count hits the step value
    private static void simulate(int numSteps) {
        for (int i = 0; i < numSteps; i++) {
            if (simulatorView.isViable(field)) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(OceanSimulation.class.getName()).log(Level.SEVERE, null, ex);
                }
                Collections.shuffle(creatureList, RandomGenerator.getRandom());
                simulateOneStep();
                simulatorView.showStatus(count, field);
            } else {
                break;
            }
        }
    }

    //Runs the step for each creature in the array list
    private static void simulateOneStep() {
        ArrayList<Creature> newCreatures = new ArrayList<Creature>();
        for (Creature c : creatureList) {
            if (c.isAlive()) {
                Creature newC = c.act(field);

                if (newC != null) {
                    newCreatures.add(newC);
                }
            }
        }

        for (Creature c : newCreatures) {
            creatureList.add(c);
        }

        count++;
    }

}
