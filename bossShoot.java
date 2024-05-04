import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bossShoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bossShoot extends Actor
{
    GreenfootSound sonido_im = new GreenfootSound("Impacto.mp3");
    /**
     * Act - do whatever the bossShoot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public bossShoot()
    {
        GreenfootImage img = this.getImage();
        img.scale(50, 50);
        //img.fillRect(0, 0, 30, 30);
    }
    
    public void act()
    {
        World w = getWorld();
        this.setLocation(this.getX(), this.getY() + 4);
        
        if(isAtEdge())
        {
            w.removeObject(this);
        }
        else
            if(isTouching(Heroe.class))
            {
                MyWorld mw = (MyWorld)getWorld();
                removeTouching(Heroe.class);
                mw.vid.Disminuir();
                getWorld().addObject(new Heroe(), 450, 600);
                w.removeObject(this);
                
                
            }
            else
                if(isTouching(shoot.class))
                {
                    if(sonido_im.isPlaying()==true)
                    {
                    sonido_im.stop();
                    }
                    removeTouching(shoot.class);
                    w.removeObject(this);
                    sonido_im.play();
                }
        
    
        }
    }
    
