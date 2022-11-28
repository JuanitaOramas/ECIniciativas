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
import edu.eci.pdsw.samples.persistence.DaoUsuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.AreaMapper;

import java.util.List;

/**
 *
 * @author hcadavid
 */
public class MyBatisDAOUsuario implements DaoUsuario {


    @Inject
    UsuarioMapper usuarioMapper;

    @Override
    public Usuario load(int idUsuario) throws PersistenceException {
        try{
            return usuarioMapper.getUsuario(idUsuario);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Usuario loadConsultaUsuario(int id, String pass) throws PersistenceException {
        //To change body of generated methods, choose Tools | Templates.
        try{
            return usuarioMapper.consultarUsuarioPorCredentials(id, pass);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

}
