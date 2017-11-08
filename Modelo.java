/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comecocos;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Lourdes
 */
public class Modelo {
    public static final int ANCHOGAME=1000;
    public static final int ALTOGAME=700;
    private Personaje personaje;
   //private Fantasma fantasma2;
    private ArrayList <Fantasma> fantasmas;
    private int NFANTASMAS=3;
    private Vida vida;
    private int puntos, y, x;
 
    
    public Modelo(){
        personaje=new Personaje(this);
       x=10;
        y=10;
        //fantasma=new Fantasma(this);
        vida=new Vida(this);
        fantasmas=new ArrayList <Fantasma> ();
        for(int i=0;i<NFANTASMAS;i++){
            fantasmas.add(new Fantasma(this));
        }
    }
    public int getSumarPuntos(){
        return puntos; //Se suman 10 puntos cada vez que se coje una vida
    }
    public void setSumarPuntos(){
        puntos+=10;
        System.out.println("puntos: "+puntos );
    }
    public Personaje getPersonaje(){
        return personaje;
    }
    public int moverAbajoPers(){
        y+=10;
        if(y > (ALTOGAME-(personaje.getAltoPers()))){
            y=0;
        }
        return y;
    }
    public int moverArribaPers(){
        y-=10;
        if(y <0 ){
            y=(ALTOGAME-(personaje.getAltoPers()));
        }
        return y;
    }
    public int moverIzqPers() {
        x -= 10;
        if (x < 0) {
            x = (ANCHOGAME-(personaje.getAnchoPers()));
        }
        return x;
    }
    public int moverDerPers() {
        x += 10;
        if (x > (ANCHOGAME-(personaje.getAnchoPers()))) {
            x = 0;
        }
        return x;
    }
    public ArrayList <Fantasma> getFantasmas(){
        return fantasmas;
    }
    public Vida getVida(){
        return vida;
    }
}
