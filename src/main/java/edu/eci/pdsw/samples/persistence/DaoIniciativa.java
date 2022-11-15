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
package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.estado;

import java.util.List;

/**
 *
 * @author hcadavid
 */
public interface DaoIniciativa {
 
    public Iniciativa load(int id, estado estado) throws PersistenceException;
    
    public List<Iniciativa> loadAll() throws PersistenceException;

    public List<Iniciativa> loadMenoresConEnfermedad() throws PersistenceException;

    public void save(Iniciativa e) throws PersistenceException;
    
    public void update(Iniciativa e) throws PersistenceException;
    
    public void addConsulta(int id, estado tipoId, Consulta c) throws PersistenceException;
    
}
