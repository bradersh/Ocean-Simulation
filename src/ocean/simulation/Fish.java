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
public abstract class Fish extends Creature{

    protected int food;
            
    public Fish()
    {
        
    }
    
    protected Location eat(Location location, Field field)
    {
        return null;
    }
    
    public Fish(int depth, int width, int age) 
    {
        super(depth, width, age);
        food = RandomGenerator.getRandom().nextInt(30)+1; 
    }
    
    private void increaseHunger()
    {
        food--;
    }
    
    public Creature act(Field field)
    {
        Location newLoc = eat(location, field);//field.freeAdjacentLocation(location);
        if(newLoc != null) 
        {
            field.place(null, location);
            setLocation(newLoc);
            field.place(this, location);
        }
        else 
        {
            die(field);
        }
        
        increaseHunger();
        if(food <= 0)
        {
            die(field);
        }
        
        
        
        return super.act(field);
    }
    
    
}
