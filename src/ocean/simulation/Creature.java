/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocean.simulation;

/**
 *
 * @author Bradersh
 */
public abstract class Creature {
   
    protected Location location;
    protected boolean alive;
    protected int age; 
           
    public Creature()
    {
        
    }
    
    public Creature(int depth,int width, int age)
    {
        this.age = age; 
        location = new Location(depth, width); 
        alive = true;
    }

    public int getAge() 
    {
        return age;
    }
    
    public void incrementAge()
    {
        age++;
    }
    
    public Creature act(Field field)
    {
        incrementAge();
         return breed(location, field);
    }
    
    protected Creature breed(Location location, Field field)
    {
        return null;
    }
            
    public boolean isAlive()
    {
        return alive;
    }
    
    public void setLocation(Location newLoc)
    {
        location = newLoc;
    }
    
    public void die(Field field)
    {
        alive = false;
        field.place(null, location);
    }
}


