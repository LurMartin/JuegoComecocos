/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comecocos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

/**
 *
 * @author Lourdes
 */
public class Controlador implements KeyListener{
    private Vista vista;
    private Modelo modelo;
    
    public Controlador(){
        modelo=new Modelo();
        vista=new Vista(modelo.ANCHOGAME, modelo.ALTOGAME);
        this.vista=vista;
        vista.addKeyListener(this);
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*Al pulsar INTRO se inicia el juego y aparecen el personaje, la vida y los fantasmas*/
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            vista.setPersonaje(modelo.getPersonaje());
            vista.setVida(modelo.getVida());
            vista.setFantasma(modelo.getFantasmas());
            modelo.reiniciar();
            vista.setMsg(modelo.setMsg());
            vista.repaint();
        }
        /*AL pulsar ESC se sale del juego y se cierra la ventana*/
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        /*CONTROL DEL PERSONAJE DEL JUEGO, con las teclas de flechas del teclado se modifica la posición del personaje*/
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            modelo.enviarY(modelo.moverAbajoPers()); 
        }else if(e.getKeyCode()==KeyEvent.VK_UP){
            modelo.enviarY(modelo.moverArribaPers());
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            modelo.enviarX(modelo.moverIzqPers()); 
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            modelo.enviarX(modelo.moverDerPers()); 
        }
        vista.setMsg(modelo.setMsg());//aparece un mensaje de fin de juego si se choca el personaje con un fantasma
        vista.setSumarPuntos(modelo.getSumarPuntos()); //Aumenta el contador si se come una vida
        vista.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

   
    
}
