
package edu.eci.pdsw.samples.managedbeans;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosIniciativas;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "iniciativaPalabraClave")

@SessionScoped
public class consultaIniciativaPalabraClaveBean extends BasePageBean {

    @Inject
    private ServiciosIniciativas serviciosIniciativas;


    List<Iniciativa> listaIniciativas;



    public List<Iniciativa> getIniciativasPorPalabraClave(String palabra) throws ExcepcionServiciosSuscripciones{
        try {
            listaIniciativas = serviciosIniciativas.consultarIniciativasPorPalabraClave(palabra);
            return serviciosIniciativas.consultarIniciativasPorPalabraClave(palabra);
        } catch (ExcepcionServiciosSuscripciones ex) {

            throw new ExcepcionServiciosSuscripciones(ex);
        }
    }

    public List<Iniciativa> getIniciativasPorPalabraClaveList(){
        return listaIniciativas;
    }


}
