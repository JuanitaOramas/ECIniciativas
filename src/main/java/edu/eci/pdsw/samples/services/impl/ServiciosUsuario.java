package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.DaoIniciativa;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;


public class ServiciosUsuario implements edu.eci.pdsw.samples.services.ServiciosUsuario {

    @Inject
    private DaoIniciativa daoPaciente;

    @Override
    public Usuario getUsuarioById(int id) throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta de la iniciativa:"+ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public Usuario consultarUsuarioPorCredentials(int id, String pass) throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.loadConsultaUsuario(id, pass);
        } catch (Exception ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta de la iniciativa:"+ex.getLocalizedMessage(), ex);
        }
    }





}
