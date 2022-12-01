package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Usuario;

public interface ServiciosUsuario {


    public Usuario getUsuarioById(int id ) throws ExcepcionServiciosSuscripciones;

    public Usuario consultarUsuarioPorCredentials(int id, String pass) throws ExcepcionServiciosSuscripciones;


}
