/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pryetsa.bibliotecav2.datosFichero;

import com.pryetsa.bibliotecav2.beans.DatosLogin;
import com.pryetsa.bibliotecav2.beans.Usuario;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pryet
 */
public class PersistenciaUsuario implements Serializable{
    private static final long serialVersionUID = 1L;
    private final Map<DatosLogin,Usuario> registroUsuarios;

    //leemos del archivo y cargamos el mapa
    public PersistenciaUsuario(Map<DatosLogin, Usuario> registroUsuarios) {
        this.registroUsuarios = registroUsuarios;
    }
    
    public PersistenciaUsuario (){
        registroUsuarios=new HashMap<DatosLogin,Usuario>();
    }
    
    //lo recuperamos y hacemos el alta con .add()
    public Map<DatosLogin, Usuario> getRegistroUsuarios() {
        return registroUsuarios;
    }
    
    
}
