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
    public static final int ANCHOGAME=600;
    public static final int ALTOGAME=600;
    private int xPersonaje, yPersonaje, anchoPersonaje, altoPersonaje;
    private int xFantasma, yFantasma,anchoFantasma,altoFantasma;
    private int xVida, yVida,anchoVida,altoVida;
    private int puntos;
    public Modelo(){
        altoPersonaje=50;
        anchoPersonaje=50;
        anchoFantasma=50;
        altoFantasma=50;
        anchoVida=50;
        altoVida=50;
        //Darle la primera posicion al personaje.
        reiniciarJuego();
    }
    public Image imgPersonaje(){
        String RUTA="/img/";
        String fichero="comecocos.png";
        URL url=this.getClass().getResource(RUTA+fichero);
        Image imagen=null;
        try {
            imagen=ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagen;
    }
    
    public Image imgFantasma(){
        String RUTA="/img/";
        String fichero="fantasma.png";
        URL url=this.getClass().getResource(RUTA+fichero);
        Image imagen=null;
        try {
            imagen=ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagen;
    }
    public Image imgVida(){
        String RUTA="/img/";
        String fichero="vida.png";
        URL url=this.getClass().getResource(RUTA+fichero);
        Image imagen=null;
        try {
            imagen=ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagen;
    }
    public int getPosicionXPersonaje(){
        xPersonaje=(int)(Math.random()*(ANCHOGAME-anchoPersonaje));
        return xPersonaje;
    }
    public int getPosicionYPersonaje(){
        yPersonaje=(int)(Math.random()*(ALTOGAME-altoPersonaje));
        return yPersonaje;
    }
    
    public int getPosicionXFantasma(){
        xFantasma=(int)(Math.random()*(ANCHOGAME-anchoFantasma));
        return xFantasma;
    }
    public int getPosicionYFantasma(){
        yFantasma=(int)(Math.random()*(ALTOGAME-altoFantasma));
        return yFantasma;
    }
    public int getPosicionXVida(){
        xVida=(int)(Math.random()*(ANCHOGAME-anchoVida));
        return xVida;//retornar la posicion de la vida
    }
    public int getPosicionYVida(){
        yVida=(int)(Math.random()*(ALTOGAME-altoVida));
        return yVida;//retornar la posicion de la vida
    }
    public int getSumarPuntos(){
        return puntos+=10; //Se suman 10 puntos cada vez que se coje una vida
    }
    public void reiniciarJuego(){ //todo a cero
        xPersonaje=50;
        yPersonaje=50;
        puntos=0;
    }
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
    public String getEmpezar(){
        return "Haz click para comenzar el juego";
    }
    
}
