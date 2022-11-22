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

    public void verDatas(int id, String pass){
        try {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>BEANNNN>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            selectedUsuario = ServiciosIniciativasFactory.getInstance().getForumsServices().consultarUsuarioPorCredentials(id, pass);
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>BEANNNN>>CATH>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            e.printStackTrace();
        }
    }


}
