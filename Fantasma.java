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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Lourdes
 */
public class Fantasma {
    private Modelo modelo;
    private int x,y;
    private int ancho, alto;
    private Image imgFantasma;
    private boolean visible;
    private Rectangle malla;
    private long tInicio, tCambio, tAhora;

    public Fantasma (Modelo modelo){
        tInicio=System.nanoTime();
        System.out.println("tinicio"+tInicio);
        tCambio=500000000L;
        this.modelo=modelo;
        imgFantasma=this.leerFantasma();
        ancho=imgFantasma.getWidth(null);
        alto=imgFantasma.getHeight(null);
        malla=new Rectangle(x,y,ancho,alto);
        visible=true;
        tAhora=System.nanoTime();
        System.out.println("tAhora: "+tAhora);
        if(tInicio-tAhora>tCambio){
            this.generarPosicion();
        }
    }
    public Image leerFantasma(){
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
    private int generarX(){
        return ((int)(Math.random()*(Modelo.ANCHOGAME-ancho)));
    }     
    private int generarY(){
        return ((int)(Math.random()*(Modelo.ALTOGAME-alto)));
    }
    public Rectangle getMalla(){
        return malla;
    }
    public void generarPosicion(){
        x=this.generarX();
        y=this.generarY();
        malla.setLocation(x, y);
        /*do{
            x=this.generarX();
            y=this.generarY();
            malla.setLocation(x, y);
        }while(!validarPosicion());    */
    }
    /*
    private boolean validarPosicion(){
        //necesito crear la malla, acceder al array de las brujas, hacer un for para recogerlo y comprobar la posicion
        boolean colision=true;
        //malla=new Rectangle(x,y,ancho,alto);//Esto lo quito de aqui y lo pongo en el constructor para que cada bruja genere su malla
        ArrayList <Bruja> lista=game.getBrujas();
        Bruja otra; //va cogiendo de la lista una bruja por una para comparar su posición, 
        Rectangle mallaOtra; //Este es el rectangulo de la bruja de la lista
        for(int i=0;i<lista.size();i++){
            otra=lista.get(i);
            if(this==otra) continue; //Como una de las brujas otra va a coincidir consigo misma dentro de la lista, dice, que continue ya que sí es una posición valida
            mallaOtra=otra.getMalla();//Es mejor que cada bruja calcula su malla
            //mallaOtra=new Rectangle(otra.x,otra.y,otra.ancho, otra.alto);
            if(malla.intersects(mallaOtra)){
                colision=false;
                break;
            }
        }
        return colision;
    }
    */
    public int getAnchoPers(){
        return ancho;
    }
    public int getAltoPers(){
        return alto;
    }
    public void dibujar(Graphics g){ 
        if(visible){
            g.drawImage(imgFantasma, x, y, null);
        }
    }
}
