/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.persistence.DaoUsuario;
import edu.eci.pdsw.samples.persistence.mybatisimpl.MyBatisDAOUsuario;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.pdsw.samples.persistence.DaoIniciativa;
import edu.eci.pdsw.samples.persistence.mybatisimpl.MyBatisDAOIniciativa;

/**
 *
 * @author hcadavid
 */
public class ServiciosIniciativasFactory {

    private static ServiciosIniciativasFactory instance = new ServiciosIniciativasFactory();

    private static Injector injector;
    private static Injector testingInjector;

    private ServiciosIniciativasFactory() {
        injector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServiciosIniciativas.class).to(edu.eci.pdsw.samples.services.impl.ServiciosIniciativas.class);
                bind(DaoIniciativa.class).to(MyBatisDAOIniciativa.class);
                bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);

            }

        }
        );

        testingInjector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis-config-h2.xml");
                bind(ServiciosIniciativas.class).to(edu.eci.pdsw.samples.services.impl.ServiciosIniciativas.class);
                bind(DaoIniciativa.class).to(MyBatisDAOIniciativa.class);
                bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);
            }

        }
        );

    }

    public ServiciosIniciativas getForumsServices() {
        return injector.getInstance(ServiciosIniciativas.class);
    }

    public ServiciosIniciativas getTestingForumServices() {
        return testingInjector.getInstance(ServiciosIniciativas.class);
    }

    public static ServiciosIniciativasFactory getInstance() {
        return instance;
    }

    public static void main(String a[]) throws ExcepcionServiciosSuscripciones {
        System.out.println(ServiciosIniciativasFactory.getInstance().getForumsServices().consultarIniciativas());
    }

}
