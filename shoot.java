import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shoot extends Actor
{
    GreenfootSound sonido_explosion = new GreenfootSound("Explosion.mp3");
    GreenfootSound sonido_vida = new GreenfootSound("BossShield.mp3");
    SimpleTimer t = new SimpleTimer();
    /**
     * Act - do whatever the shoot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public shoot()
    {
        t.mark();
    }
    
    public void act()
    {
        explosion ex = new explosion();
        World w = getWorld();
        this.setLocation(this.getX(), this.getY() - 5);
        int p=0;
        
        if(isAtEdge())
        {
            w.removeObject(this);
        }
        else
            if(isTouching(Obstaculo.class))
            {
                if(sonido_explosion.isPlaying()==true)
                {
                    sonido_explosion.stop();
                }
                w.addObject(ex, getX(), getY());
                MyWorld mw = (MyWorld)getWorld();
                mw.pts.Aumentar();
                removeTouching(Obstaculo.class);
                w.removeObject(this);
                //t.mark();
                sonido_explosion.play();
                Greenfoot.delay(3);
                w.removeObject(ex);
              
            }
        else{       
        Actor Finalboss = getOneObjectAtOffset(0, 0, Finalboss.class);
        if(sonido_vida.isPlaying()==true)
        {
            sonido_vida.stop();
        }
            if(Finalboss!=null)
                {
                sonido_vida.play();
                MyWorld mw = (MyWorld)getWorld();
                mw.vidJef.DisminuirJefe();
                w.removeObject(this);
                }
                    
            }
        }
        
    }

