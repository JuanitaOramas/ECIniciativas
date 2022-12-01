
package edu.eci.pdsw.samples.managedbeans;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosIniciativas;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "registraIniciativa")

@SessionScoped
public class registraIniciativaBean extends BasePageBean {

    @Inject
    private ServiciosIniciativas serviciosIniciativas;



    public List<Area> getArea() throws ExcepcionServiciosSuscripciones {
        try {
            return serviciosIniciativas.consultarAreas();
        } catch (ExcepcionServiciosSuscripciones ex) {
            throw new ExcepcionServiciosSuscripciones(ex);
        }

    }

    public void insertIniciativa(String iniciativa, String palabraClave, String area) throws ExcepcionServiciosSuscripciones {
        try {
            serviciosIniciativas.insertIniciativas(iniciativa,palabraClave,area);
        } catch (Exception ex) {
            throw new ExcepcionServiciosSuscripciones(ex);
        }

    }

    private int id=0;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }


}
