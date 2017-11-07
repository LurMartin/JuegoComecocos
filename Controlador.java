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
    private int y=0;
    private int x=0;
    public Controlador(){
        modelo=new Modelo();
        vista=new Vista(Modelo.ANCHOGAME, Modelo.ALTOGAME);
        vista.setImagen(modelo.imgPersonaje());
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
         switch (e.getKeyCode()) { 
            case KeyEvent.VK_DOWN: 
                vista.setPosicionYPersonaje(modelo.getPosicionYPersonaje()+y++); 
                break; 
            case KeyEvent.VK_UP: 
                vista.setPosicionYPersonaje(modelo.getPosicionYPersonaje()+y--);; 
                break; 
            case KeyEvent.VK_LEFT: 
                vista.setPosicionXPersonaje(modelo.getPosicionXPersonaje()+x--); 
                break; 
            case KeyEvent.VK_RIGHT: 
                 vista.setPosicionXPersonaje(modelo.getPosicionXPersonaje()+x++); 
                break; 
        } 
         vista.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        vista.setEmpezar(modelo.getEmpezar());
        vista.setSumarPuntos(modelo.getSumarPuntos());
        vista.repaint();
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
