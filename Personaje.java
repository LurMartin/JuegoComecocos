/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comecocos;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
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
public class Personaje {
    private Modelo modelo;
    private int x,y;
    private int ancho, alto;
    private Image imgPersonaje;
    private boolean visible;
    private Rectangle malla;
    private String msg;
    private boolean fin; 

    public Personaje (Modelo modelo){
        this.modelo=modelo;
        imgPersonaje=this.leerPersonaje();
        ancho=imgPersonaje.getWidth(null);
        alto=imgPersonaje.getHeight(null);
        x=10;
        y=10;
        malla=new Rectangle(x,y,ancho,alto);
        msg="";
        fin=false;
        visible=true;
    }
    public Image leerPersonaje(){
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
    public Rectangle getMalla(){
        return malla;
    } 
    public int getX(){
        return x;
    }
    public void setX(int x) {
        if(!validarPosicion()){
            msg="Fin del juego";  
            fin=true;
        }else if(!validarPosicionVida()){
            modelo.setSumarPuntos();
        }else{
            if(!fin){
                msg="";
                this.x = x;
                malla.setLocation(x,y);
            }
        }
    }
    public int getY(){
        return y;
    }
    public void setY(int y) {
        if(!validarPosicion()){
            msg="Fin del juego"; 
            fin=true;
        }else if(!validarPosicionVida()){
            modelo.setSumarPuntos();
            
        }else{
            if(!fin){
                msg="";
                this.y = y;
                malla.setLocation(x,y);
            }
        }
    }
    public Image getPersonaje(){
        return imgPersonaje;
    }
    public int getAnchoPers(){
        return ancho;
    }
    public int getAltoPers(){
        return alto;
    }
    public void dibujar(Graphics g){ 
        g.drawImage(imgPersonaje, x, y, null);
    }
    public boolean validarPosicion(){
        boolean colision=true;
        ArrayList <Fantasma> lista=modelo.getFantasmas();
        Fantasma otra;  
        Rectangle mallaOtra;
        for(int i=0;i<lista.size();i++){
            otra=lista.get(i);
            //if(this==otra) continue;
            mallaOtra=otra.getMalla();
            if(malla.intersects(mallaOtra)){
                colision=false;
                break;
             }
        }
        return colision;
    }
    public boolean validarPosicionVida(){
        boolean colision=true;
        Vida otraVida=modelo.getVida();
        Rectangle mallaOtraVida=otraVida.getMallaV();
        System.out.println(malla);
        if(malla.intersects(mallaOtraVida)){
            colision=false;
            otraVida.setVisible();
        }
        return colision;
    }
    public String getMsg(){
        return msg;
    }
    public boolean isFin(){
        return fin;
    }
    public void setFin(boolean fin){
        this.fin=fin;
        msg="¡¡EMPIEZA A JUGAR!!!";
    }
}
