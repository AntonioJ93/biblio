/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pryetsa.bibliotecav2;

import com.pryetsa.bibliotecav2.beans.DatosLogin;
import com.pryetsa.bibliotecav2.beans.Libro;
import com.pryetsa.bibliotecav2.beans.Usuario;
import com.pryetsa.bibliotecav2.controlador.ControladorLibro;
import com.pryetsa.bibliotecav2.controlador.ControladorLogin;
import com.pryetsa.bibliotecav2.controlador.Fachada;
import com.pryetsa.bibliotecav2.datosFichero.Escribir;
import com.pryetsa.bibliotecav2.datosFichero.PersistenciaLibro;
import com.pryetsa.bibliotecav2.datosFichero.PersistenciaUsuario;
import com.pryetsa.bibliotecav2.excepciones.LimiteDeIntentosSuperadoException;
import com.pryetsa.bibliotecav2.logica.Logica;
import com.pryetsa.bibliotecav2.servicios.ServiciosLibro;
import com.pryetsa.bibliotecav2.servicios.ServiciosSesion;
import com.pryetsa.bibliotecav2.vista.Vista;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pryet
 */
public class Main {
    
   
    public static void main(String[] args) {
//        PersistenciaLibro pLibro=new PersistenciaLibro(new HashMap<Libro,Set<Usuario>>());
//
        PersistenciaUsuario pUsuario=new PersistenciaUsuario(new HashMap<DatosLogin, Usuario>());
//        Libro elQuijote=new Libro("El quijote", "000");
//        Libro elQuijote2=new Libro("El quijote2", "002");
//        Libro elQuijote3=new Libro("El quijote3", "003");
//        Libro elQuijote4=new Libro("El quijote4", "004");
//        pLibro.getRegistroLibros().put(elQuijote, new HashSet<Usuario>());
//        pLibro.getRegistroLibros().put(elQuijote2, new HashSet<Usuario>());
//        pLibro.getRegistroLibros().put(elQuijote3, new HashSet<Usuario>());
//        pLibro.getRegistroLibros().put(elQuijote4, new HashSet<Usuario>());

//        Set<Usuario> lista=new HashSet<>();
        Usuario paco=new Usuario("Paco", "Sanchez");
       //lista.add(paco);
        
//        Map<Libro,List<Usuario>> mapa=new HashMap<>();
//        mapa.put(elQuijote, lista);


//        pLibro.getRegistroLibros().put(elQuijote, lista);
        pUsuario.getRegistroUsuarios().put(new DatosLogin("1234", "q"), paco);
//        
    new Escribir(pUsuario.getRegistroUsuarios()).execute();
            Fachada f=new Fachada();
            
            ControladorLogin cl=f.getControladorLogin();
            
        //ControladorLogin cl=new ControladorLogin(new Logica(pUsuario), new ServiciosSesion(pLibro), new Vista());
    
        
            cl.login();
        
        ControladorLibro cLib=f.getControladorLibro();
       //ControladorLibro cLib=new ControladorLibro(cl.getSesion(), pLibro, new Vista(), new Logica(pUsuario), new ServiciosLibro(pLibro),new ServiciosSesion(pLibro));
       cLib.alquilarLibro();
       cLib.devolverLibro();
       cLib.alquilarLibro();
       cLib.alquilarLibro();
       cLib.devolverLibro();
       cLib.devolverLibro();
       cLib.alquilarLibro();
       cLib.alquilarLibro();
       cl.logOut();
    
    }
}
