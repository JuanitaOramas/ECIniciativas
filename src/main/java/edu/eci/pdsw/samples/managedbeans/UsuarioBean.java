package edu.eci.pdsw.samples.managedbeans;


import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.entities.estado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosIniciativas;
import edu.eci.pdsw.samples.services.ServiciosIniciativasFactory;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "ub")

@SessionScoped
public class UsuarioBean extends BasePageBean {

    @Inject
    private ServiciosIniciativas serviciosIniciativas;

    Usuario selectedUsuario;

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public void verDatas(int id, String pass) throws ExcepcionServiciosSuscripciones {
        try {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>BEANNNN>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            selectedUsuario = serviciosIniciativas.consultarUsuarioPorCredentials(id, pass);
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>BEANNNN>>CATH>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            e.printStackTrace();
        }
    }


}
