package edu.eci.pdsw.samples.services;


import java.util.List;

import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.entities.estado;

/**
 *
 * @author
 */
public interface ServiciosIniciativas {

    /**
     * Consultar todas las iniciativas
     * @return
     * @throws ExcepcionServiciosSuscripciones 
     */

    public List<Iniciativa> consultarIniciativas() throws ExcepcionServiciosSuscripciones;
        
    
    /**
     * Consulta una iniciativa  a partir de su
     * @param palabraClave
     * @return
     * @throws ExcepcionServiciosSuscripciones si NO existe un paciente con dicha
     * identificacion, o si se presenta otro problema en las capas inferiores.
     */
    public List<Iniciativa>  consultarIniciativasPorPalabraClave(String palabraClave) throws ExcepcionServiciosSuscripciones;


    public List<Iniciativa>  consultarIniciativasPorEstado(String palabraClave) throws ExcepcionServiciosSuscripciones;



    /**
     * Consulta los pacientes menores de edad que han tenido enfermedades contagiosas
     * @return el listado de pacientes menores de edad que han tenido enfermedades contagiosas,
     * es decir, que tengan consultas que contengan en su texto palabras 'hepatitis' o
     * 'varicela'
     * @throws ExcepcionServiciosSuscripciones si se presenta otro problema en las capas inferiores.
     */


     public List<Area> consultarAreas( ) throws ExcepcionServiciosSuscripciones;

     public List<Area> consultarCantidadAreas( ) throws ExcepcionServiciosSuscripciones;

     public void insertIniciativas(String iniciativa, String palabraClave, String area ) throws ExcepcionServiciosSuscripciones;

     public void updateIniciativaService(int id, String iniciativa, String estado ) throws ExcepcionServiciosSuscripciones;


}
