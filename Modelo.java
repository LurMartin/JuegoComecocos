/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comecocos;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
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
    private Fantasma fantasma;
    private int puntos, y, x;
    private boolean fin;
    
    
    public Modelo(){
        personaje=new Personaje(this);
        x=10;
        y=10;
        fantasma=new Fantasma(this);
    }
    
    public int getSumarPuntos(){
        return puntos+=10; //Se suman 10 puntos cada vez que se coje una vida
    }
    /*
    public void choqueFantasma(){
        boolean muerto=false;
        if(xPersonaje==xFantasma && yPersonaje==yFantasma){ //Usar funcion intersect
            muerto=true;
        }
        if(muerto){
            reiniciarJuego();
        }
        //Si la posicion del personaje coincide con la posicion del fantasma entonces han chocado
        //llamada a la funcion reiniciarJuego()
    }
    public void choqueVida(){
        boolean vida=false;
        if(xPersonaje==xVida && yPersonaje==yVida){ //Usar funcion intersect
            vida=true;
        }
        if(vida){
            getSumarPuntos();
        }
        //Si choca con una vida
        //llamada a sumarPuntos();
    }
*/
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
    public Fantasma getFantasma(){
        return fantasma;
    }
}
