
package edu.eci.pdsw.samples.managedbeans;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Usuario;
//import edu.eci.pdsw.samples.entities.estado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosIniciativas;
import edu.eci.pdsw.samples.services.ServiciosIniciativasFactory;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "modificarIniciativa")

@SessionScoped
public class modificarIniciativaBean extends BasePageBean {

    @Inject
    private ServiciosIniciativas serviciosIniciativas;


    public void updateIniciativa(int id,String iniciativa, String estado) throws Exception {
        try {
            serviciosIniciativas.updateIniciativaService(id,iniciativa,estado);
        } catch (Exception ex) {
            throw ex;
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
