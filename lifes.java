import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lifes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lifes extends Actor
{
    GreenfootSound sonido_vidam = new GreenfootSound("PerderVida.mp3");
    /**
     * Act - do whatever the lifes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int c=3;
    
    public lifes() 
    {
        
    }
    public void act()
    {
        
    }
    
    public void Disminuir()
    {
        c--;
        if(sonido_vidam.isPlaying()==true)
        {
            sonido_vidam.stop();
        }
        
        if(sonido_vidam.isPlaying()==false)
        {
            sonido_vidam.play();    
        }
        //if(c==0)
        //{
            //Greenfoot.stop();
        //}
    }
}
