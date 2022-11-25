package edu.eci.pdsw.samples.persistence.mybatisimpl.mappers;

import java.util.List;

import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.entities.estado;
import org.apache.ibatis.annotations.Param;

public interface AreaMapper {
    List<Area> getArea();
    List<Area> getCantidadAreas();
}
