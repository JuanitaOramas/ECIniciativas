package edu.eci.pdsw.samples.entities;

public class Area {
    private int idArea;
    private String nombreArea;
    private int cantidad;


    public Area(int idArea, String nombreArea) {
        this.idArea = idArea;
        this.nombreArea = nombreArea;
    }


    public Area(long idArea, String nombreArea, long cantidad) {
        this.idArea = (int) idArea;
        this.nombreArea = nombreArea;
        this.cantidad = (int) cantidad;
    }


    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public int getIdArea() {return idArea;}
    public void setIdArea(int idArea) {this.idArea = idArea;}


    public String getNombreArea() {return nombreArea;}
    public void setNombreArea(String nombreArea) {this.nombreArea = nombreArea;}


    @Override
    public String toString() {
        StringBuilder repArea = new StringBuilder(idArea + "");
        return repArea.toString();
    }

}
