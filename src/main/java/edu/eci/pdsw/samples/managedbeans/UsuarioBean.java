package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ServiciosIniciativas;
import edu.eci.pdsw.samples.services.ServiciosIniciativasFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "ub")

@SessionScoped
public class UsuarioBean extends BasePageBean {
    Usuario selectedUsuario;

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public void getData(int id, String pass){
        try {
            selectedUsuario = ServiciosIniciativasFactory.getInstance().getForumsServices().consultarUsuarioPorCredentials(id, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
