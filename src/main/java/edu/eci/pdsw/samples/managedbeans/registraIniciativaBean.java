
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


@ManagedBean(name = "registraIniciativa")

@SessionScoped
public class registraIniciativaBean extends BasePageBean {

    @Inject
    private ServiciosIniciativas serviciosIniciativas;



    public List<Area> getArea() throws Exception {
        try {
//            System.out.println("tu tranqui, si lo print");
            return serviciosIniciativas.consultarAreas();
        } catch (ExcepcionServiciosSuscripciones ex) {
            throw ex;
        }

    }

    public void insertIniciativa(String iniciativa, String palabraClave, String area) {
        try {
            System.out.println(iniciativa + " " + palabraClave + " "  + area );
            serviciosIniciativas.insertIniciativas(iniciativa,palabraClave,area);
        } catch (Exception ex) {
            System.out.println(ex);
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
