package edu.eci.pdsw.samples.services;

import java.util.List;

import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.entities.estado;

public interface ServiciosUsuario {


    public Usuario getUsuarioById(int id ) throws ExcepcionServiciosSuscripciones;

    public Usuario consultarUsuarioPorCredentials(int id, String pass) throws ExcepcionServiciosSuscripciones;


}
