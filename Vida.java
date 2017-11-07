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
public class Vida {
    private Modelo modelo;
    private int x,y;
    private int ancho, alto;
    private Image imgVida;
    private boolean visible;
    private Rectangle mallaV;

    public Vida (Modelo modelo){
        this.modelo=modelo;
        imgVida=this.leerVida();
        ancho=imgVida.getWidth(null);
        alto=imgVida.getHeight(null);
        mallaV=new Rectangle(x,y,ancho,alto);
        visible=true;
        this.generarPosicion();
    }
    public Image leerVida(){
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
    private int generarX(){
        return ((int)(Math.random()*(Modelo.ANCHOGAME-ancho)));
    }     
    private int generarY(){
        return ((int)(Math.random()*(Modelo.ALTOGAME-alto)));
    }
    public Rectangle getMallaV(){
        return mallaV;
    }
    public void generarPosicion(){
        x=this.generarX();
        y=this.generarY();
        mallaV.setLocation(x, y);
    }
    public int getAnchoPers(){
        return ancho;
    }
    public int getAltoPers(){
        return alto;
    }
    public void dibujar(Graphics g){ 
        if(visible){
            g.drawImage(imgVida, x, y, null);
        }
    }
    public void setVisible(){
        visible=false;
        reiniciar();
    }
    public void reiniciar(){
        generarPosicion();
        visible=true;
    }
}
