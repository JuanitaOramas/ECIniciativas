package edu.eci.pdsw.samples.services;


import java.util.List;

import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Iniciativa;

/**
 *
 * @author
 */
public interface ServiciosIniciativas {

    public List<Iniciativa> consultarIniciativas() throws ExcepcionServiciosSuscripciones;
        
    public List<Iniciativa>  consultarIniciativasPorPalabraClave(String palabraClave) throws ExcepcionServiciosSuscripciones;


    public List<Iniciativa>  consultarIniciativasPorEstado(String palabraClave) throws ExcepcionServiciosSuscripciones;

     public List<Area> consultarAreas( ) throws ExcepcionServiciosSuscripciones;

     public List<Area> consultarCantidadAreas( ) throws ExcepcionServiciosSuscripciones;

     public void insertIniciativas(String iniciativa, String palabraClave, String area ) throws ExcepcionServiciosSuscripciones;

     public void updateIniciativaService(int id, String iniciativa, String estado ) throws ExcepcionServiciosSuscripciones;

    public List<Iniciativa> consultarIniciativasPorNombreUsuario(String nombre) throws ExcepcionServiciosSuscripciones;


}
