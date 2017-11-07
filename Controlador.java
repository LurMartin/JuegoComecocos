/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comecocos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Lourdes
 */
public class Controlador implements MouseListener,KeyListener{
    private Vista vista;
    private Modelo modelo;
    private Personaje personaje;
    
    public Controlador(){
        modelo=new Modelo();
        vista=new Vista(modelo.ANCHOGAME, modelo.ALTOGAME);
        personaje=modelo.getPersonaje();
        vista.setPersonaje(personaje);
        vista.setFantasma(modelo.getFantasma());
        this.vista=vista;
        vista.addKeyListener(this);
        vista.addMouseListener(this);
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
 
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            personaje.setY(modelo.moverAbajoPers()); 
        }else if(e.getKeyCode()==KeyEvent.VK_UP){
            personaje.setY(modelo.moverArribaPers());
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            personaje.setX(modelo.moverIzqPers()); 
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            personaje.setX(modelo.moverDerPers()); 
        }
        vista.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //vista.setEmpezar(modelo.getEmpezar());
        //vista.setSumarPuntos(modelo.getSumarPuntos());
        //vista.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
