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
package edu.eci.pdsw.samples.managedbeans;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.estado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosIniciativas;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name = "mb")

@SessionScoped
public class IniciativasBean extends BasePageBean {

    @Inject
    private ServiciosIniciativas serviciosIniciativas;

    private Consulta consulta;
    private Iniciativa iniciativa;

    estado estado;



    public void setTipoIdentificacion(estado estado) {
        this.estado = estado;
    }

    public estado getTipoIdentificacion() {
        return estado;
    }


    public List<Iniciativa> getIniciativas() throws Exception{
        try {
            return serviciosIniciativas.consultarIniciativas();
        } catch (ExcepcionServiciosSuscripciones ex) {

            throw ex;
        }
    }

//    public Iniciativa getData(int id) throws Exception{
//        try {
//            iniciativa = serviciosIniciativas.consultarPacientesPorId(id, estado.TI );
//            consulta = serviciosIniciativas.consultarPacientesPorId(id, estado.TI ).getIniciativas().get(0);
//            System.out.println(">>>>>>>>>>>>>>>RESULTADO CONSULTA" + consulta);
//            return serviciosIniciativas.consultarPacientesPorId(id, estado.TI );
//        } catch (ExcepcionServiciosSuscripciones ex) {
//
//            throw ex;
//        }
//
//    }

    public Consulta getConsultaBD(){
        return consulta;
    }
    public Iniciativa getPacienteBD(){
        return iniciativa;
    }

    public List<Iniciativa> getPacientesMenores() throws Exception{
        try {
            return serviciosIniciativas.consultarMenoresConEnfermedadContagiosa();
        } catch (ExcepcionServiciosSuscripciones ex) {

            throw ex;
        }

    }

    public estado[] getTiposIdentificacion() {
        return estado.values();
    }
    
}
