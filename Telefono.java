import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Stack;


/**
 *Telefono for prog
 * 
 * @author Miguel Sobrino
 * @version 14/04/2015
 */
public class Telefono
    {
        private static final int ESPACIO = 10;
        private static final String MENSAJE_LLAMADA = "Llamando";
        
        private JFrame telefono;
        private JTextField display;
        private Stack<String> pilaLlamadas;
        private JButton botonBorrar;
        private JButton botonLimpiar;
        private JButton botonRepetir;
        private JButton botonLlamar;
    
        public Telefono()
        {
            crearTelefono();
            
            
        }
        
        private void crearTelefono()
        {
            pilaLlamadas = new Stack<String>();
            telefono = new JFrame("Teléfono");
            
            JPanel contenidoTelefono = (JPanel)telefono.getContentPane();
            contenidoTelefono.setLayout(new BorderLayout(ESPACIO,ESPACIO));
            contenidoTelefono.setBorder(new EmptyBorder(ESPACIO,ESPACIO,ESPACIO,ESPACIO));
            
            display = new JTextField();
            contenidoTelefono.add(display, BorderLayout.NORTH);
            
            JPanel panelBotones = new JPanel(new GridLayout (5,3,ESPACIO,ESPACIO));
            
            agregarBotonNumero(panelBotones, "1");
            agregarBotonNumero(panelBotones, "2");
            agregarBotonNumero(panelBotones, "3");
            
            agregarBotonNumero(panelBotones, "4");
            agregarBotonNumero(panelBotones, "5");
            agregarBotonNumero(panelBotones, "6");
            
            agregarBotonNumero(panelBotones, "7");
            agregarBotonNumero(panelBotones, "8");
            agregarBotonNumero(panelBotones, "9");
            
            agregarBotonBorrar(panelBotones, "B");
            agregarBotonNumero(panelBotones, "0");
            agregarBotonLimpiar(panelBotones, "L");
            
            agregarBotonRetroceso(panelBotones, "R");
            agregarBotonLlamar(panelBotones, "LL");
            agregarBoton(panelBotones, "C");
            
            contenidoTelefono.add(panelBotones, BorderLayout.CENTER);
            
            telefono.pack();
            telefono.setVisible(true);
        }
        
        private void agregarBotonNumero (JPanel panel, String textoBoton)
        {
            JButton boton = new JButton(textoBoton);
            panel.add(boton);
            boton.setToolTipText ("Marca el " + textoBoton);
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evento)
                {
                    String numTelefono = display.getText();
                    if(!numTelefono.equals (MENSAJE_LLAMADA)){
                        display.setText (numTelefono + evento.getActionCommand());
                    }
                }
                    
            });
                        
        }
        
         private void agregarBotonBorrar (JPanel panel, String textoBoton)
        {
            botonBorrar = new JButton(textoBoton);
            panel.add(botonBorrar);
            botonBorrar.setEnabled(false);
            botonBorrar.setToolTipText ("Borra el último dígito");
            botonBorrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evento)
                {
                    String numTelefono = display.getText();
                    if(!numTelefono.equals ("") && !numTelefono.equals(null)){
                        int longitud = numTelefono.length();
                        display.setText(numTelefono.substring(0,longitud-1));
                    }

                }
                    
            });
            
            
        }
        
        private void agregarBotonLlamar (JPanel panel, String textoBoton)
        {
            JButton boton = new JButton(textoBoton);
            panel.add(boton);
            boton.setEnabled(false);
            boton.setToolTipText ("Llama");
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evento)
                {
                    String numTelefono = display.getText();
                    display.setText(MENSAJE_LLAMADA);
                    pilaLlamadas.push(numTelefono);

                }
                    
            });
            
            
        }
        
       private void agregarBotonRetroceso (JPanel panel, String textoBoton)
        {
            JButton boton = new JButton(textoBoton);
            panel.add(boton);
             boton.setEnabled(false);
            boton.setToolTipText ("Marca el " + textoBoton);
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evento)
                {
                    String numTelefono = display.getText();
                    if(!numTelefono.equals (MENSAJE_LLAMADA)){
                        if(!pilaLlamadas.empty()){
                            display.setText(pilaLlamadas.pop());
                        }
                    }
                }
                    
            });
                        
        }
        
              private void agregarBotonLimpiar (JPanel panel, String textoBoton)
        {
            JButton boton = new JButton(textoBoton);
            panel.add(boton);
            boton.setEnabled(false);
            boton.setToolTipText ("Limpia el display");
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evento)
                {
                    display.setText("");
                }
                    
            });
                        
        }
        
                private void agregarBoton (JPanel panel, String textoBoton)
        {
            JButton boton = new JButton(textoBoton);
            panel.add(boton);
            
        }
 
    
    
}
