/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.DaoIniciativa;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.AreaMapper;

import java.util.List;

/**
 *
 * @author hcadavid
 */
public class MyBatisDAOIniciativa implements DaoIniciativa {



    @Inject
    IniciativaMapper iniciativaMapper;
    @Inject
    UsuarioMapper usuarioMapper;
    @Inject
    AreaMapper areaMapper;


    @Override
    public List<Iniciativa> loadIniciativasPorPalabrasClave(String palabra) throws PersistenceException {
        try{
            return iniciativaMapper.getIniciativasPorPalabraClave(palabra);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar las Iniciativas:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Iniciativa> loadIniciativasPorEstado(String estado) throws PersistenceException {
        try{
            return iniciativaMapper.getIniciativasPorEstado(estado);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar las Iniciativas:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Iniciativa> loadAll() throws PersistenceException {
        try{
            return iniciativaMapper.getIniciativas();
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar las Iniciativas:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Usuario load(int idUsuario) throws PersistenceException {
        try{
            return usuarioMapper.getUsuario(idUsuario);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar las Iniciativas:"+e.getLocalizedMessage(), e);
        }
    }
    @Override
    public List<Area> loadAreas() throws PersistenceException {
        try{
            return areaMapper.getArea();
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar las Iniciativas:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Area> loadCantidadAreas() throws PersistenceException {
        try{
            return areaMapper.getCantidadAreas();
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar las Iniciativas:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void saveIniciativas(String iniciativa, String palabraClave, String area) throws PersistenceException {
        try{
            iniciativaMapper.insertIniciativas(iniciativa, palabraClave, area);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar las Iniciativas:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void updateIniciativaService(int id, String iniciativa, String estado) throws PersistenceException {
        try{
            iniciativaMapper.updateIniciativasService(id, iniciativa, estado);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar las iniciativas:"+e.getLocalizedMessage(), e);
        }
    }



    @Override
    public void save(Iniciativa e) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Iniciativa e) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario loadConsultaUsuario(int id, String pass) throws PersistenceException {
        try{
            return usuarioMapper.consultarUsuarioPorCredentials(id, pass);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar las iniciativas:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Iniciativa>  loadConsultaUsuarioNombre(String nombre) throws PersistenceException {
        try{
            return iniciativaMapper.consultarIniciativasPorUsuario(nombre);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar las iniciativas:"+e.getLocalizedMessage(), e);
        }
    }

}
