import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Finalboss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Finalboss extends Actor
{
    int espera=0;
    Bosslife bl = new Bosslife();
    /**
     * Act - do whatever the Finalboss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setRotation(-270);
        GreenfootImage img = this.getImage();
        img.scale(250, 250);
        
        World w = getWorld();
        
        if(espera==0)
        {
            int x=Greenfoot.getRandomNumber(150);
            setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), 100);            
            espera = x;
        }
        else
        {
            espera--;
        }
        
        if(Greenfoot.getRandomNumber(150)<=4)
        {
            w.addObject(new bossShoot(), this.getX(), this.getY() +100);
        }
        
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
    

