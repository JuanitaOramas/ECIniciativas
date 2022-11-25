/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.entities.estado;
import edu.eci.pdsw.samples.persistence.DaoIniciativa;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;

import java.util.List;


public class ServiciosIniciativas implements edu.eci.pdsw.samples.services.ServiciosIniciativas {

    @Inject
    private DaoIniciativa daoPaciente;

    @Override
    public List<Iniciativa> consultarIniciativas() throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }


    @Override
    public List<Iniciativa> consultarIniciativasPorPalabraClave(String palabraClave) throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.loadIniciativasPorPalabrasClave(palabraClave);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Iniciativa> consultarIniciativasPorEstado(String palabraClave) throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.loadIniciativasPorEstado(palabraClave);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:" + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public Usuario getUsuarioById(int id) throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Area> consultarAreas() throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.loadAreas();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Area> consultarCantidadAreas() throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.loadCantidadAreas();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }


    @Override
    public void insertIniciativas(String iniciativa, String palabraClave, String area ) throws ExcepcionServiciosSuscripciones {
        try {
            daoPaciente.saveIniciativas(iniciativa,palabraClave,area);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public void updateIniciativaService(int id, String iniciativa, String estado) throws ExcepcionServiciosSuscripciones {
        try {
            daoPaciente.updateIniciativaService(id,iniciativa,estado);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }


    @Override
    public Usuario consultarUsuarioPorCredentials(int id, String pass) throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.loadConsultaUsuario(id, pass);
        } catch (Exception ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }


}
