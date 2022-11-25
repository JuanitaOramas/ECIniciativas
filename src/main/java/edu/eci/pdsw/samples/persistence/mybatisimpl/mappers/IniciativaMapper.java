/*
 * Copyright (C) 2015 hcadavid
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
package edu.eci.pdsw.samples.persistence.mybatisimpl.mappers;

import java.util.List;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.entities.estado;
import org.apache.ibatis.annotations.Param;


public interface IniciativaMapper {

    List<Iniciativa> getIniciativas();

    List<Iniciativa> getIniciativasPorPalabraClave(@Param("Palabra")  String Palabra);

    List<Iniciativa> getIniciativasPorEstado(@Param("estado")  String estado);

    void insertIniciativas(@Param("iniciativa") String iniciativa,@Param("palabraClave") String palabraClave,@Param("area") String area);

    void updateIniciativasService(@Param("id") int id,@Param("iniciativa") String iniciativa,@Param("estado") String estado);

    //miralo

    //Iniciativa getPaciente(@Param("id") int id, @Param("tipoId") estado estado);

    //List<Iniciativa> getPacientesEnfermosMenores();

}
