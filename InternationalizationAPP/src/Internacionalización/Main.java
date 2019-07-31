 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Internacionalización;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.net.URL;



/**
 *
 * @author macosx
 */
public class Main {
    public static int Nidiomas;
    public static int NUM_cadenas;
    public static int NUM_imagenes;
    public static  ArrayList <ArrayList<String>> cadena;
    public static  ArrayList <ArrayList<String>> imagenes;
    public static int idiomaElegido;
    public static String[] listaIdiomas;
    public static ArrayList <String> datosMetidos;
    public static int tamDatos;
    public static JFrame frame;
    public static JTextField textField;
    public static JTextField textField_1;
    public static JTextField textField_2;
    
     //Método para leer un fichero
    public static void leerFichero(BufferedReader b, String linea ) throws IOException{
        for (int i = 0; i < Nidiomas; i++){
            cadena.add(new ArrayList<>());
            cadena.get(i).add(linea);
            linea = b.readLine();
            NUM_cadenas = Integer.parseInt(linea);
           
            for (int j = 0; j < NUM_cadenas; j++){
                cadena.get(i).add(b.readLine());
            }
            
            NUM_imagenes = Integer.parseInt(b.readLine());
            imagenes.add(new ArrayList<>());
            
            for (int j = 0; j < NUM_imagenes; j++){
                imagenes.get(i).add(b.readLine());
            }
            linea = b.readLine();
        }
        listaIdiomas = new String[Nidiomas];
        for (int i = 0; i < Nidiomas; i++){
            listaIdiomas[i] = cadena.get(i).get(1);
        }
        leerDatos();                 
    }
    
    public static void leerDatos() throws IOException{
        String fichero = "datos.txt";
        FileReader f = null;
        f = new FileReader(fichero);
        BufferedReader b = new BufferedReader(f);
        String n = b.readLine();
        String linea = b.readLine();
        datosMetidos = new ArrayList<>();
        tamDatos = Integer.parseInt(n);
        
        for (int i = 0; i < tamDatos; i++){
            datosMetidos.add(linea);
            linea = b.readLine();
        }
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        //Declaración de variables
         String fichero = "fichero.txt";
        String n;
        int tamano;
        FileReader f = null;
        idiomaElegido = 0;
        
        //Lectura del fichero
        f = new FileReader(fichero);
        
        BufferedReader b = new BufferedReader(f);
        n = b.readLine();
        String linea = b.readLine();
        cadena = new ArrayList<>();
        imagenes = new ArrayList<>();
        Nidiomas = Integer.parseInt(n);

        leerFichero(b,linea);
        //Idioma p = new Idioma(cadena, Nidiomas, idiomaElegido, listaIdiomas);
        Principal p = new Principal(cadena, Nidiomas, idiomaElegido, listaIdiomas, datosMetidos);
        p.setVisible(true);
    }

    
}
