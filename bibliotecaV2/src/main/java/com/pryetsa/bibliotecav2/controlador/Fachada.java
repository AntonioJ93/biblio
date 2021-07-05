/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pryetsa.bibliotecav2.controlador;

import com.pryetsa.bibliotecav2.datosFichero.CommandFile;
import com.pryetsa.bibliotecav2.datosFichero.Leer;
import com.pryetsa.bibliotecav2.datosFichero.PersistenciaLibro;
import com.pryetsa.bibliotecav2.datosFichero.PersistenciaUsuario;
import com.pryetsa.bibliotecav2.logica.Logica;
import com.pryetsa.bibliotecav2.servicios.ServiciosLibro;
import com.pryetsa.bibliotecav2.servicios.ServiciosSesion;
import com.pryetsa.bibliotecav2.vista.Vista;

/**
 *
 * @author pryet
 */
public class Fachada {
    private final ControladorLogin cLog;
    private final ControladorLibro cLib;
    private  PersistenciaUsuario pUsuario;
    private final PersistenciaLibro pLibro;
    private Leer leerUsuarios;
    private CommandFile leerLibros;
    public Fachada(){//iniciamos los componentes de la aplicación
        pUsuario=new PersistenciaUsuario();
        pLibro=new PersistenciaLibro();
        //leer datos
        leer();
        
        //creamos los controladores
        cLog=new ControladorLogin(new Logica(pUsuario), new ServiciosSesion(pLibro), new Vista());
        cLib =new ControladorLibro(cLog.getSesion(), pLibro, cLog.getVista(), cLog.getLog(), new ServiciosLibro(pLibro), cLog.getsSesion());
    }
    
    private void leer(){
        leerUsuarios=new Leer(pUsuario.getRegistroUsuarios());
        leerUsuarios.execute();
        
        leerLibros=new Leer(pLibro.getRegistroLibros());
        leerLibros.execute();
    }

    public ControladorLogin getControladorLogin() {
        return cLog;
    }

    public ControladorLibro getControladorLibro() {
        return cLib;
    }

    public PersistenciaUsuario getpUsuario() {
        return pUsuario;
    }

    public PersistenciaLibro getpLibro() {
        return pLibro;
    }
    
}
