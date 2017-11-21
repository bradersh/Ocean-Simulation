/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocean.simulation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Bradersh
 */
public class OceanSimulation {
    private static Field field;
    private static SimulatorView simulatorView;
    private static OceanSimulation oceanSimulation;
    private static ArrayList<Creature> creatureList; 
    private static int count = ModelConstants.STARTING_STEP; 
    
    public OceanSimulation (int depth, int width)
    {
        if(depth <= 0)
                {
                    depth = ModelConstants.DEFAULT_DEPTH;
                }
        if(width <= 0)
                {
                    width = ModelConstants.DEFAULT_WIDTH;
                }
        creatureList = new ArrayList<Creature>(); 
        field = new Field(depth,width);
        simulatorView = new SimulatorView(depth,width);
        simulatorView.setColor(ModelConstants.PLANKTON.getClass(), Color.black);
        simulatorView.setColor(ModelConstants.SARDINE.getClass(), Color.green);
        simulatorView.setColor(ModelConstants.SHARK.getClass(), Color.blue);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RandomGenerator.initialiseWithSeed(ModelConstants.RANDOM_SEED);
        oceanSimulation = new OceanSimulation(0,0);
        populate(); 
        simulatorView.showStatus(0,field);
        simulate(10000); 
    }
    
    private static void populate()
    {
        Random rnd = RandomGenerator.getRandom();
        for(int d = 0; d < field.getDepth(); d++)
        {
            for(int w = 0; w < field.getWidth(); w++)
            {
                int gen = rnd.nextInt(100);
                if(gen <= ModelConstants.sh) 
                {
                    field.place(new Shark(d,w,rnd.nextInt(ModelConstants.SHARK_MAX_AGE)),d,w);
                    creatureList.add(field.getObjectAt(d,w));
                }
                else if(gen <= ModelConstants.sa) 
                {
                    field.place(new Sardine(d,w,rnd.nextInt(ModelConstants.SARDINE_MAX_AGE)),d,w);
                    creatureList.add(field.getObjectAt(d,w));
                } 
                else if (gen <= ModelConstants.p) 
                {
                    field.place(new Plankton(d,w,rnd.nextInt(ModelConstants.PLANKTON_MAX_AGE)),d,w);
                    creatureList.add(field.getObjectAt(d,w));
                } 
            }
        }
    }
    
    private static void simulate(int numSteps)
    {
        for(int i=0; i < numSteps; i++)
        {
            if(simulatorView.isViable(field))
            {
                Collections.shuffle(creatureList, RandomGenerator.getRandom());
                simulateOneStep();
                simulatorView.showStatus(count,field);
            }
            else break;
        }
    }
    
    private static void simulateOneStep()
    {
        ArrayList<Creature> newCreatures = new ArrayList<Creature>();
        for(Creature c: creatureList)
        {
            if(c.isAlive())
            {
                Creature newC = c.act(field);
                
                if(newC != null){
                    newCreatures.add(newC);
                }
            }
        }
        
        for(Creature c: newCreatures)
        {
            creatureList.add(c);
        }
        
        count++;
    }
    
}
