/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pryetsa.bibliotecav2.datosFichero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frans
 */
public class Leer implements CommandFile{
    private Map datos = new HashMap<>();

    public Leer( Map datos) {
        this.datos=datos;
    }

    public Map getDatos() {
        return datos;
    }
    
    @Override
    public void execute() {
        try (FileInputStream lectura = new FileInputStream("biblioteca.bin"); ObjectInputStream ois = new ObjectInputStream(lectura)) {
            Map users = (Map) ois.readObject();
            System.out.println(users);
            datos=users;
            // esto es un ejemplo
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
