import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heroe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heroe extends Actor
{
    
    SimpleTimer t = new SimpleTimer();
    GreenfootSound sonido_shoot = new GreenfootSound("Shoot.mp3");

    public Heroe() {
        this.setRotation(-90);
        t.mark();
        
    }
    /**
     * Act - do whatever the Heroe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        if(Greenfoot.isKeyDown("W"))
        {
             setLocation(getX(), getY() - 6);
            }
        if(Greenfoot.isKeyDown("S"))
        {
             setLocation(getX(), getY() + 6);
        }
        if(Greenfoot.isKeyDown("A"))
        {
            setLocation(getX() - 6, getY());
        }
        if(Greenfoot.isKeyDown("D"))
        {
            setLocation(getX() + 6, getY());
        }
        
        shooter();
        
    }
    
    public void shooter() 
    {
        World w = getWorld();
        if(Greenfoot.isKeyDown("space") && (t.millisElapsed() > 500))
        {
            if(sonido_shoot.isPlaying()==false)
            {
            sonido_shoot.play();
            }
            w.addObject(new shoot(), this.getX(), this.getY() - 50);
            t.mark();
        }
        
    }
}
