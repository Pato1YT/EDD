import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstaculo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstaculo extends Actor
{
    GreenfootSound sonido_shoot = new GreenfootSound("Shoot.mp3");
    explosion ex = new explosion();

    /**
     * Act - do whatever the Obstaculo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        World w = getWorld();
        this.setLocation(this.getX(), this.getY() + 3);
        
        if(isAtEdge()){
            w.removeObject(this);
            }
            else{
            
        Actor Heroe = getOneObjectAtOffset(0, 0, Heroe.class);
        if(Heroe!=null)
        {
            MyWorld mw = (MyWorld)getWorld();
            getWorld().removeObject(Heroe);
            mw.vid.Disminuir();
            getWorld().addObject(new Heroe(), 450, 600);
        
        }
        }
        
        
    }
    }

