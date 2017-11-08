/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comecocos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Lourdes
 */
public class Vista extends JFrame {
    private Personaje personaje;
    private Modelo modelo;
    private ArrayList <Fantasma> fantasmas;
    private Vida vida;
    private int ancho;
    private int alto;
    private Font font;
    private String empezar;
    private String titulo;
    private String puntos="0";
    private String msg;
    
    public Vista(int ancho,int alto){
        this.msg="";
        this.alto=alto;
        this.ancho=ancho;
        //empezar="Haz click para comenzar el juego";
        titulo="COMECOCOS";
        this.setBounds(10, 10, ancho, alto);
        font= new Font("Arial", Font.BOLD, 20);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, ancho, alto);
        personaje.dibujar(g);
        vida.dibujar(g);
        for(int i=0;i<fantasmas.size();i++){
            fantasmas.get(i).dibujar(g);
        }
        g.setColor(Color.WHITE);
        g.setFont(font);   
        //g.drawString(empezar,150, 100);
        //g.drawString(titulo, 250, 200);
        g.drawString("Puntuación: ",10,modelo.ALTOGAME-30);
        g.drawString(puntos,130,modelo.ALTOGAME-30);
        g.drawString(msg,100 , 100);
    }
    public void setSumarPuntos(int puntos){
        this.puntos=puntos+"";
    }
    public void setPersonaje(Personaje personaje){
        this.personaje=personaje;
    }
    public void setFantasma(ArrayList <Fantasma> fantasmas){
        this.fantasmas=fantasmas;
    }
    public void setMsg(String msg){
        this.msg=msg;
    }
    public void setVida(Vida vida){
        this.vida=vida;
    }
}
