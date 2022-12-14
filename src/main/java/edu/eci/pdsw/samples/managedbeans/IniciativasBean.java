
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


@ManagedBean(name = "mb")

@SessionScoped
public class IniciativasBean extends BasePageBean {

    @Inject
    private ServiciosIniciativas serviciosIniciativas;
    private Iniciativa iniciativa;


    List<Iniciativa> listaIniciativas;
    List<Area> listaAreas;


    public List<Iniciativa> getIniciativas() throws Exception{
        try {
            return serviciosIniciativas.consultarIniciativas();
        } catch (ExcepcionServiciosSuscripciones ex) {

            throw ex;
        }
    }

    public List<Iniciativa> getIniciativasPorPalabraClave(String palabra) throws Exception{
        try {
            listaIniciativas = serviciosIniciativas.consultarIniciativasPorPalabraClave(palabra);
            return serviciosIniciativas.consultarIniciativasPorPalabraClave(palabra);
        } catch (ExcepcionServiciosSuscripciones ex) {

            throw ex;
        }
    }

    public List<Iniciativa> getIniciativasPorPalabraClaveList(){
        return listaIniciativas;
    }

    public List<Iniciativa> getIniciativasPorEstadoList(){
        return listaIniciativas;
    }


    public List<Iniciativa> getIniciativasPorEstado(String estado) throws Exception{
        try {
            listaIniciativas = serviciosIniciativas.consultarIniciativasPorEstado(estado);
            return serviciosIniciativas.consultarIniciativasPorEstado(estado);
        } catch (ExcepcionServiciosSuscripciones ex) {

            throw ex;
        }
    }


    public List<Area> getArea() throws Exception {
        try {
            return serviciosIniciativas.consultarAreas();
        } catch (ExcepcionServiciosSuscripciones ex) {
            throw ex;
        }

    }

    public void insertIniciativa(String iniciativa, String palabraClave, String area) throws Exception {
        try {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>BEANNNN>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(iniciativa + " " + palabraClave + " "  + area );

            serviciosIniciativas.insertIniciativas(iniciativa,palabraClave,area);
        } catch (ExcepcionServiciosSuscripciones ex) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>BEANNNN>>CATH>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            throw ex;
        }

    }

    public void updateIniciativa(int id,String iniciativa, String estado) throws Exception {
        try {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>BEANNNN>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(id + " " + iniciativa + " "  + estado );

            serviciosIniciativas.updateIniciativaService(id,iniciativa,estado);
        } catch (Exception ex) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>BEANNNN>>CATH>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
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
