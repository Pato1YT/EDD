import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    int espera;
    public lifes vid;
    public score pts;
    public Bosslife vidJef;
    GreenfootSound sonido_ambiente = new GreenfootSound("BackGround.mp3");
    GreenfootSound sonido_jefe = new GreenfootSound("FinalBossSong.mp3");
    GreenfootSound grito_jefe = new GreenfootSound("JefeCry.mp3");
    GreenfootSound juego_t = new GreenfootSound("GameOver.mp3");
    GreenfootSound juego_g = new GreenfootSound("Win.mp3");
    Finalboss fb = new Finalboss();
    SimpleTimer t = new SimpleTimer();
    
    public void act()
    {   
        if(sonido_jefe.isPlaying() && t.millisElapsed()>=10000)
        {
            grito_jefe.play();
            t.mark();
        }
        
        if(sonido_ambiente.isPlaying()==false)
        {
            if(sonido_jefe.isPlaying()==false)
            {
                sonido_ambiente.play();
            }
            else
            {
                sonido_ambiente.stop();
            }
        
        }
        if(pts.p <=10)
        {
            showText("Puntos: "+pts.p+" Vidas: "+vid.c, 100, 25);
        }else{
            showText("Puntos: "+pts.p+" Vidas: "+vid.c, 100, 25);
            showText("El Jefe esta llegando...", 110, 50);
        }
    
        if(pts.p>=20 && fb!=null)
        {
            addObject(fb, 450, 100);
            showText("Puntos: "+pts.p+" Vidas: "+vid.c, 100, 25);
            showText("Langosta Espacial: "+vidJef.v, 110, 50);
            sonido_ambiente.stop();
            if(sonido_jefe.isPlaying()==false)
            {
                sonido_ambiente.stop();
                sonido_jefe.play();
                grito_jefe.play();
            }
            //Greenfoot.delay(10);'
            
            
        }
        
        
        if(espera==0)
        {
            Obstaculo o = new Obstaculo();
            this.addObject(o, Greenfoot.getRandomNumber(getWidth()), 0);
            //int x = (int)(Math.random()*ancho);
            espera = 30;
        }
        else
            espera--;
            
        if(vid.c ==0)
        {
            gameOver();
        }else{
            if(vidJef.v==0)
            {
                gameWin();
            }
        }
    }
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        this.espera = 30;
        prepare();
        vid = new lifes();
        pts = new score();
        vidJef = new Bosslife();
        t.mark();

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Heroe heroe = new Heroe();
        addObject(heroe,450,600);
        Obstaculo obstaculo = new Obstaculo();
        addObject(obstaculo,487,31);
    }
    
    public void gameOver(){
        removeObjects(getObjects(null));
        if(sonido_ambiente.isPlaying()==true || sonido_jefe.isPlaying()==true)
        {
            sonido_ambiente.stop();
            sonido_jefe.stop();
            grito_jefe.stop();
            
        }
        juego_t.play();
        showText("", 100, 25);
        showText("", 110, 50);
        GreenfootImage go = new GreenfootImage("PERDISTE PAPU :(", 48, Color.RED, null); 
        getBackground().drawImage(go, (getWidth() - go.getWidth())/2, (getHeight() - go.getHeight())/2);
        GreenfootImage puntosf = new GreenfootImage("PUNTOS: "+pts.p, 48, Color.WHITE, null);
        getBackground().drawImage(puntosf, (getWidth() - go.getWidth())/2 + 60, (getHeight() - go.getHeight())/2 + 50);
    }
    
    public void gameWin(){
        removeObjects(getObjects(null));
        if(sonido_ambiente.isPlaying()==true || sonido_jefe.isPlaying()==true)
        {
            sonido_ambiente.stop();
            sonido_jefe.stop();
            grito_jefe.stop();
        }
        juego_g.play();
        showText("", 100, 25);
        showText("", 110, 50);
        GreenfootImage go = new GreenfootImage("FELICIDADES TILIN :D", 48, Color.YELLOW, null); 
        getBackground().drawImage(go, (getWidth() - go.getWidth())/2, (getHeight() - go.getHeight())/2);
        GreenfootImage puntosf = new GreenfootImage("PUNTOS: "+pts.p, 48, Color.WHITE, null);
        getBackground().drawImage(puntosf, (getWidth() - go.getWidth())/2 + 70, (getHeight() - go.getHeight())/2 + 50);
    }
    
}
