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
import edu.eci.pdsw.samples.entities.estado;
import edu.eci.pdsw.samples.persistence.DaoIniciativa;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.AreaMapper;
//import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

/**
 *
 * @author hcadavid
 */
public class MyBatisDAOIniciativa implements DaoIniciativa {


    @Inject
    IniciativaMapper iniciativaMapper;
    @Inject
    AreaMapper areaMapper;


    @Override
    public List<Iniciativa> loadIniciativasPorPalabrasClave(String palabra) throws PersistenceException {
        try{
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            List<Iniciativa> ini = iniciativaMapper.getIniciativasPorPalabraClave(palabra);
            for (Iniciativa i: ini) {
                System.out.println("ESTO ES: " + ini);
            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            return iniciativaMapper.getIniciativasPorPalabraClave(palabra);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Iniciativa> loadIniciativasPorEstado(String estado) throws PersistenceException {
        try{
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            List<Iniciativa> ini = iniciativaMapper.getIniciativasPorEstado(estado);
            for (Iniciativa i: ini) {
                System.out.println("ESTO ES: " + ini);
            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            return iniciativaMapper.getIniciativasPorEstado(estado);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Iniciativa> loadAll() throws PersistenceException {
        try{
            return iniciativaMapper.getIniciativas();
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Area> loadAreas() throws PersistenceException {
        try{
            return areaMapper.getArea();
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Area> loadCantidadAreas() throws PersistenceException {
        try{
            return areaMapper.getCantidadAreas();
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void saveIniciativas(String iniciativa, String palabraClave, String area) throws PersistenceException {
        try{
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(iniciativa + " " + palabraClave + " "  + area );
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            iniciativaMapper.insertIniciativas(iniciativa, palabraClave, area);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void updateIniciativaService(int id, String iniciativa, String estado) throws PersistenceException {
        try{
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(id + " " + iniciativa + " "  + estado );
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            iniciativaMapper.updateIniciativasService(id, iniciativa, estado);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
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

}
