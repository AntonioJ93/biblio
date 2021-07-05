/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pryetsa.bibliotecav2.controlador;

import com.pryetsa.bibliotecav2.beans.DatosLogin;
import com.pryetsa.bibliotecav2.beans.Sesion;
import com.pryetsa.bibliotecav2.beans.Usuario;
import com.pryetsa.bibliotecav2.datosFichero.CommandFile;
import com.pryetsa.bibliotecav2.excepciones.LimiteDeIntentosSuperadoException;
import com.pryetsa.bibliotecav2.excepciones.NickIncorrectoException;
import com.pryetsa.bibliotecav2.excepciones.PassIncorrectoException;
import com.pryetsa.bibliotecav2.logica.Logica;
import com.pryetsa.bibliotecav2.servicios.ServiciosSesion;
import com.pryetsa.bibliotecav2.vista.Vista;

/**
 *
 * @author pryet
 */
public class ControladorLogin {

    private final Logica log;
    private final ServiciosSesion sSesion;
    private final Vista vista;
    private Sesion sesion;
    private final int MAX_INTENTOS = 3;
    private int contador = MAX_INTENTOS - 1;
    private CommandFile leer;
    private CommandFile escribir;

    public ControladorLogin(Logica log, ServiciosSesion sSesion, Vista vista) {
        this.log = log;
        this.sSesion = sSesion;
        this.vista = vista;

    }

    public void login(){
        try {
            if (contador >= 0) {
                DatosLogin datosLogin = vista.pideDatosLogin();
                try {
                    Usuario usuario = log.validarUsuario(datosLogin);

                    sesion = sSesion.login(usuario);
                    System.out.println("Login corecto");
                    //return sesion;
                    //redirigir al menu de alquileres
                    return;
                } catch (NickIncorrectoException e) {
                    vista.nickIncorrecto(contador);

                } catch (PassIncorrectoException e) {
                    vista.passIncorrecto(contador);
                }
                contador--;

                //redirigir al menu principal
            } else {
                throw new LimiteDeIntentosSuperadoException("Limite de intentos superado");
            }
        } catch (LimiteDeIntentosSuperadoException e) {
            //vista.numero de intentos();
            System.out.println("Número maximo de intentos superado");
            System.exit(0);
        }
//        if (contador < 0) {
//            throw new LimiteDeIntentosSuperadoException("Limite de intentos superado");
//        }
        login();
        //return login();
        //return null;
    }

    public void logOut() {
        sesion = sSesion.logOut(sesion);
        System.out.println("Deslogueado");
        //guardar en archivo
        //redirigir al menu principal
    }

    public Sesion getSesion() {
        return sesion;
    }

    public Logica getLog() {
        return log;
    }

    public ServiciosSesion getsSesion() {
        return sSesion;
    }

    public Vista getVista() {
        return vista;
    }

}
