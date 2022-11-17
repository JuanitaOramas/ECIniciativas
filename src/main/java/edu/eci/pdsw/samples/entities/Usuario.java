package edu.eci.pdsw.samples.entities;

public class Usuario {
    private int idUsuario;
    private String perfil;
    private String informacion;
    public Usuario(int idUsuario, String perfil, String informacion) {
        this.idUsuario = idUsuario;
        this.perfil = perfil;
        this.informacion=informacion;

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}