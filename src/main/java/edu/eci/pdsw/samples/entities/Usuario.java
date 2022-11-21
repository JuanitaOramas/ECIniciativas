package edu.eci.pdsw.samples.entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int idUsuario;
    private String perfil;
    private String informacion;
    private String email;
    private String pass;
    List<Iniciativa> iniciativas;

    public Usuario(int idUsuario, String perfil, String informacion, String email, String pass) {
        this.idUsuario = idUsuario;
        this.perfil = perfil;
        this.informacion = informacion;
        this.email = email;
        this.pass = pass;
        iniciativas=new ArrayList<>();
    }

    public List<Iniciativa> getIniciativas() {
        return iniciativas;
    }

    public void setIniciativas(List<Iniciativa> iniciativas) {
        this.iniciativas = iniciativas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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