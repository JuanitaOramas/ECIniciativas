package edu.eci.pdsw.samples.guice;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.pdsw.samples.persistence.DaoIniciativa;
import edu.eci.pdsw.samples.persistence.mybatisimpl.MyBatisDAOIniciativa;
import edu.eci.pdsw.samples.services.ServiciosIniciativas;
import edu.eci.pdsw.samples.services.ServiciosUsuario;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;


public class GuiceContextListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                bind(ServiciosIniciativas.class).to(edu.eci.pdsw.samples.services.impl.ServiciosIniciativas.class);
                bind(ServiciosUsuario.class).to(edu.eci.pdsw.samples.services.impl.ServiciosUsuario.class);
                bind(DaoIniciativa.class).to(MyBatisDAOIniciativa.class);
            }
        });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}