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
package edu.eci.pdsw.samples.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Iniciativa {

    private int idIniciativa;
    private String estado;
    private String descripcion;
//    private String palabrasClave;
    private Date fecha;



    public Iniciativa(int idIniciativa, String estado, String descripcion, Date fecha) {
        this.idIniciativa = idIniciativa;
        this.estado = estado;
        this.descripcion = descripcion;
//        this.palabrasClave = palabrasClave;
        this.fecha = fecha;
//        consultas=new ArrayList<>();
    }

    public int getIdIniciativa() { return idIniciativa; }
    public void setIdIniciativa(int idIniciativa) {this.idIniciativa = idIniciativa;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

//    public String getPalabrasClave() {return palabrasClave;}
//    public void setPalabrasClave(String palabrasClave) {this.palabrasClave = palabrasClave;}

    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}

        @Override
    public String toString() {
        StringBuffer rep = new StringBuffer("Iniciativa: { id:"+idIniciativa+", estado:"+estado+", descripcion: "+descripcion);
//        for (Consulta c:consultas){
//            rep.append(c+"\n");
//        }
        rep.append("]");
        return rep.toString();
    }
    
    
    
}
//