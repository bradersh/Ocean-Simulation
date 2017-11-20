/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocean.simulation;

import java.util.Iterator;

/**
 *
 * @author Bradersh
 */
public class Sardine extends Fish{
    
    public Sardine() 
    {
        super();
    }
    
    public Sardine(int depth, int width,int age) 
    {
        super(depth, width, age);
    }
    
    public Creature act(Field field)
    {
        
        if(age >= ModelConstants.SARDINE_MAX_AGE)
        {
            die(field);
        }
        return super.act(field);
    }
    
    protected Location eat(Location location, Field field)
    {
        Iterator adjacent = field.adjacentLocations(location);
        while(adjacent.hasNext()) {
            Location next = (Location) adjacent.next();
                if(field.getObjectAt(next) instanceof Plankton) 
                {
                    food = food + ModelConstants.PLANKTON_FOOD_VALUE;
                    field.getObjectAt(next).die(field);
                    return next;
                }
        }
        
        return field.freeAdjacentLocation(location);
    }
    
    protected Creature breed(Location location, Field field)
    {        
        if(age >= ModelConstants.BREEDING_AGE_SARDINE)
        {
            Location breedingSpace = field.freeAdjacentLocation(location);
            if(breedingSpace != null)
            {
                if((RandomGenerator.getRandom().nextInt(100)+1) <= ModelConstants.BREEDING_PROBABILITY_SARDINE)
                    {
                        System.out.println("a breeding bitch");
                        field.place(new Sardine(breedingSpace.getRow(), breedingSpace.getCol(),0), breedingSpace); 
                        return field.getObjectAt(breedingSpace);
                    }
            }
        }
        return null;
    }

    
    
}
