
package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.entities.estado;

import java.util.List;


public interface DaoUsuario {

    public Usuario load(int id) throws PersistenceException;

    //    public void addConsulta(int id, estado tipoId, Consulta c) throws PersistenceException;
    public Usuario loadConsultaUsuario(int id, String pass) throws PersistenceException;
}
