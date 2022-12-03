package edu.eci.pdsw.samples.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Null;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Area;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosIniciativasFactory;
import edu.eci.pdsw.samples.services.ServiciosIniciativas;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean(name = "statistics")
@SessionScoped

public class Statistics extends BasePageBean  {


    private HorizontalBarChartModel viviendas;

    private HorizontalBarChartModel estados;

    public HorizontalBarChartModel getViviendas() {
        return viviendas;
    }
    public HorizontalBarChartModel getEstados() {
        return estados;
    }

    @PostConstruct
    public void init(){

        estados = new HorizontalBarChartModel();
        final ChartSeries estadosCantidad = countEstados();

        viviendas = new HorizontalBarChartModel();
        final ChartSeries venta = countAreas();


        viviendas.addSeries(venta);
        estados.addSeries(estadosCantidad);

    }

    public ChartSeries countAreas() {
        final ChartSeries venta  = new ChartSeries("Areas");

        try {
            List<Area> cantidadAreasList =ServiciosIniciativasFactory.getInstance().getForumsServices().consultarCantidadAreas();
            for(Area a : cantidadAreasList) {
//                System.out.println(a.getNombreArea() + " " + a.getCantidad());
                venta.set(a.getNombreArea(), a.getCantidad());
            }
            return venta;

        } catch (Exception ex) {
            System.out.println("Error al realizar la consulta: "+ex.getLocalizedMessage());
        }
        return venta;
    }

    public ChartSeries countEstados() {
        final ChartSeries estados  = new ChartSeries("Estados");
        int aprobado = 0;
        int esperaRevision = 0;
        int rechazada = 0;
        int revision = 0;

        try {
            List<Iniciativa> iniciativaList = ServiciosIniciativasFactory.getInstance().getForumsServices().consultarIniciativas();
            for(Iniciativa i : iniciativaList) {
                if(i.getEstado().equals("Aprobado")) aprobado+=1;
                else if (i.getEstado().equals("En espera de revisión")) esperaRevision+=1;
                else if (i.getEstado().equals("Rechazado")) rechazada+=1;
                else if (i.getEstado().equals("Revision")) revision+=1;

            }
            estados.set("Aprobado", aprobado);
            estados.set("En espera de revisión", esperaRevision);
            estados.set("Rechazado", rechazada);
            estados.set("Revision", revision);
            return estados;

        } catch (Exception ex) {
            System.out.println("Error al realizar la consulta: "+ex.getLocalizedMessage());
        }
        return estados;
    }



}
