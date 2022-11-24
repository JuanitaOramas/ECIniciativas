package edu.eci.pdsw.samples.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean(name = "statistics")
@SessionScoped

public class Statistics implements Serializable {

    private static final long serialVersionUID = 6401166601481931346L;

    private HorizontalBarChartModel viviendas;

    public HorizontalBarChartModel getViviendas() {
        return viviendas;
    }

    @PostConstruct
    public void init(){
        viviendas = new HorizontalBarChartModel();

        final ChartSeries venta  = new ChartSeries("Venta");
        venta.set("2008", 800);
        venta.set("2009", 1300);
        venta.set("2010", 700);
        venta.set("2011", 500);

        final ChartSeries alquiler  = new ChartSeries("Alquiler");
        alquiler.set("2008", 1200);
        alquiler.set("2009", 1100);
        alquiler.set("2010", 1700);
        alquiler.set("2011", 1900);

        viviendas.addSeries(venta);
        viviendas.addSeries(alquiler);

    }
}
