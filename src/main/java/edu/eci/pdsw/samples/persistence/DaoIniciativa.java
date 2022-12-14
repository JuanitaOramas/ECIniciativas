
package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Usuario;

import java.util.List;


public interface DaoIniciativa {


    public List<Iniciativa> loadIniciativasPorPalabrasClave(String palabraClave) throws PersistenceException;

    public List<Iniciativa> loadIniciativasPorEstado(String estado) throws PersistenceException;

    public List<Iniciativa> loadAll() throws PersistenceException;

    public void save(Iniciativa e) throws PersistenceException;
    
    public void update(Iniciativa e) throws PersistenceException;

    public Usuario load(int id) throws PersistenceException;

    public List<Area> loadAreas() throws PersistenceException;

    public List<Area> loadCantidadAreas() throws PersistenceException;

    public void saveIniciativas(String iniciativa, String palabraClave, String area) throws PersistenceException;

    public void updateIniciativaService(int id, String iniciativa, String estado) throws PersistenceException;

    public Usuario loadConsultaUsuario(int id, String pass) throws PersistenceException;

    public List<Iniciativa> loadConsultaUsuarioNombre(String nombre) throws PersistenceException;

}
