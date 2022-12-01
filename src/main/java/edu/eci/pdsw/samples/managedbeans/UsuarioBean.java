package edu.eci.pdsw.samples.managedbeans;


import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosIniciativas;
import edu.eci.pdsw.samples.services.ServiciosUsuario;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.Singleton;

@ManagedBean(name = "usuarioBean")
@SessionScoped
@Singleton
public class UsuarioBean extends BasePageBean {

    @Inject
    private ServiciosIniciativas serviciosIniciativas;

    @Inject
    private ServiciosUsuario serviciosUsuario;

    Usuario selectedUsuario;

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

//    public void consultarUsuarioCredenciales(int id, String pass) throws ExcepcionServiciosSuscripciones {
//        try {
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>BEANNNN>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//            selectedUsuario = serviciosUsuario.consultarUsuarioPorCredentials(id, pass);
//        } catch (Exception ex) {
//            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
//        }
//    }


    List<Iniciativa> listaIniciativas;



    public List<Iniciativa> consultarIniciativasPorUsuario(String nombre) throws Exception{
        try {
            listaIniciativas = serviciosIniciativas.consultarIniciativasPorNombreUsuario(nombre);
            return listaIniciativas;
        } catch (ExcepcionServiciosSuscripciones ex) {

            throw ex;
        }
    }

    public List<Iniciativa> consultarIniciativasPorUsuarioList(){
        return listaIniciativas;
    }



}
