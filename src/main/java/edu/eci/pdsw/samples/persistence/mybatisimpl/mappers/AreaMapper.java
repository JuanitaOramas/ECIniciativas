package edu.eci.pdsw.samples.persistence.mybatisimpl.mappers;

import java.util.List;

import edu.eci.pdsw.samples.entities.Area;

public interface AreaMapper {
    List<Area> getArea();
    List<Area> getCantidadAreas();
}
