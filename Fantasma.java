/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comecocos;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

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

    public Fantasma (Modelo modelo){
        this.modelo=modelo;
        imgFantasma=this.leerFantasma();
        ancho=imgFantasma.getWidth(null);
        alto=imgFantasma.getHeight(null);
        malla=new Rectangle(x,y,ancho,alto);
        visible=true;
        
        Timer timer=new Timer (1000,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                generarPosicion();
            }
        });
        timer.start();
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
    }
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
