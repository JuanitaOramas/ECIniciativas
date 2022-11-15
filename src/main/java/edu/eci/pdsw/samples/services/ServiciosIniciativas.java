package edu.eci.pdsw.samples.services;


import java.util.List;

import edu.eci.pdsw.samples.entities.Iniciativa;
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
     * @param id numero de identificacion
     * @param estado
     * @return el paciente con sus consultas ordenadas de la mas
     * reciente a la mas antigua
     * @throws ExcepcionServiciosSuscripciones si NO existe un paciente con dicha
     * identificacion, o si se presenta otro problema en las capas inferiores.
     */
    public Iniciativa consultarPacientesPorId(int id, estado estado) throws ExcepcionServiciosSuscripciones;



    /**
     * Consulta los pacientes menores de edad que han tenido enfermedades contagiosas
     * @return el listado de pacientes menores de edad que han tenido enfermedades contagiosas,
     * es decir, que tengan consultas que contengan en su texto palabras 'hepatitis' o
     * 'varicela'
     * @throws ExcepcionServiciosSuscripciones si se presenta otro problema en las capas inferiores.
     */
    public List<Iniciativa> consultarMenoresConEnfermedadContagiosa() throws ExcepcionServiciosSuscripciones;
    

}
