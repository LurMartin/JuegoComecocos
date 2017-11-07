/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pmdm.trabajocomecocos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class Vista extends JFrame{
    private int ancho=600;
    private int alto=600;
    private Font font;
    private String empezar="Pulse Intro para comenzar el juego";
    private String titulo="COMECOCOS";
    private Image imagen;
    public Vista(int ancho,int alto){
        this.alto=alto;
        this.ancho=ancho;
        this.setBounds(0, 0, ancho, alto);
        font= new Font("Arial", Font.BOLD, 20);
        this.setVisible(true);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, ancho, alto);
        g.setColor(Color.WHITE);
       // g.drawRect(xRect, yRect, 30, 30);
        g.setFont(font);   
        g.drawString(empezar,150, 100);
        g.drawString(titulo, 250, 200);
        g.drawImage(imagen, 150, 300, this);
    }
    
    public void setEmpezar(String empezar){
        this.empezar=empezar;
    }
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public void setPosicionXPersonaje(int xPersonaje){
        this.xPersonaje=xPersonaje;
    }
    public void setPosicionYPersonaje(int yPersonaje){
        this.yPersonaje=yPersonaje;
    }
    public void setPosicionXFantasma(int xFantasma){
        this.xFantasma=xFantasma;
    }
    public void setPosicionYFantasma(int yFantasma){
        this.yFantasma=yFantasma;
    }
    public void setPosicionXVida(int xVida){
        this.xVida=xVida;
    }
    public void setPosicionYVida(int yVida){
        this.yVida=yVida;
    }
    public void setSumarPuntos(int puntos){
        this.puntos=puntos;
    }
    public void setImagen(Image personaje){
        this.imagen=personaje;
    }
}


