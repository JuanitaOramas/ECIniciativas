package edu.eci.pdsw.samples.tests.services.serviciosIniciativasTest;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosIniciativasFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class consultarIniciativasPorEstado {
    public consultarIniciativasPorEstado(){
    }
    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://testanonimous.mysql.database.azure.com:3306/iniciativas_test?useSSL=false", "anonimous", "Sebastian1234");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from iniciativas");
        stmt.execute("delete from usuarios");
        stmt.execute("delete from areas");
        conn.close();
    }

    /**
     * //     * Obtiene una conexion a la base de datos de prueba
     * //     * @return
     * //     * @throws SQLException
     * //
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://testanonimous.mysql.database.azure.com:3306/iniciativas_test?useSSL=false", "anonimous", "Sebastian1234");
    }

    @Test
    public void dadaUnEstadoSeDebePoderObtenerLasIniciativasQueEstanEnEseEstadoEnProceso() throws SQLException, ExcepcionServiciosSuscripciones {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente

        clearDB();
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        stmt.execute("INSERT INTO `areas` VALUES (1,'prueba')");
        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (1,'fulanito','islazy','veganito2000@mail.com','veganito')");
        stmt.execute("INSERT INTO `iniciativas` (`estado`,`descripcion`,`fecha`,`usuarios_idUsuario`,`areas_idArea`) VALUES ('en proceso','su solicitud esta siendo revisada','2008-7-04',1,1)");
        conn.close();

        //Realizar la operacion de la logica y la prueba
        List<Iniciativa> initiative = ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarIniciativasPorEstado("en proceso");
        //assert ...
        Assert.assertEquals(initiative.get(0).getDescripcion(), "su solicitud esta siendo revisada");
    }
    @Test
    public void dadaUnEstadoSeDebePoderObtenerLasIniciativasQueEstanEnEseEstadoRechazado() throws SQLException, ExcepcionServiciosSuscripciones {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente

        clearDB();
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        stmt.execute("INSERT INTO `areas` VALUES (1,'prueba')");
        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (1,'fulanito','islazy','veganito2000@mail.com','veganito')");
        stmt.execute("INSERT INTO `iniciativas` (`estado`,`descripcion`,`fecha`,`usuarios_idUsuario`,`areas_idArea`) VALUES ('rechazada','su solicitud fue rechazada','2008-7-04',1,1)");
        conn.close();

        //Realizar la operacion de la logica y la prueba
        List<Iniciativa> initiative = ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarIniciativasPorEstado("rechazada");
        //assert ...
        Assert.assertEquals(initiative.get(0).getDescripcion(), "su solicitud fue rechazada");
    }

    @Test
    public void dadaUnEstadoSeDebePoderObtenerLasIniciativasQueEstanEnEseEstadoAprobado() throws SQLException, ExcepcionServiciosSuscripciones {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente

        clearDB();
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        stmt.execute("INSERT INTO `areas` VALUES (1,'prueba')");
        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (1,'fulanito','islazy','veganito2000@mail.com','veganito')");
        stmt.execute("INSERT INTO `iniciativas` (`estado`,`descripcion`,`fecha`,`usuarios_idUsuario`,`areas_idArea`) VALUES ('aprobada','su solicitud fue aprobada','2008-7-04',1,1)");
        conn.close();

        //Realizar la operacion de la logica y la prueba
        List<Iniciativa> initiative = ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarIniciativasPorEstado("aprobada");
        //assert ...
        Assert.assertEquals(initiative.get(0).getDescripcion(), "su solicitud fue aprobada");
    }

}
