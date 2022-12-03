package edu.eci.pdsw.samples.tests.services.serviciosIniciativasTest;

import edu.eci.pdsw.samples.entities.Area;
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

public class insertIniciativas {
    public insertIniciativas(){

    }
    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://eciserver.mysql.database.azure.com:3306/test?useSSL=false", "admineci", "Password!");
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
        return DriverManager.getConnection("jdbc:mysql://eciserver.mysql.database.azure.com:3306/test?useSSL=false", "admineci", "Password!");
    }

    @Test
    public void dadaUnaIniciativaSeDeberiaPoderInsertar() throws SQLException, ExcepcionServiciosSuscripciones {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente

        // ARRANGE
        clearDB();
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        stmt.execute("INSERT INTO `areas` VALUES (3,'prueba')");
        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (3,'fulanito','islazy','veganito2000@mail.com','veganito')");


        conn.close();

        //Realizar la operacion de la logica y la prueba
        ServiciosIniciativasFactory.getInstance().getTestingForumServices().insertIniciativas("Otro Nuevo","defecto", String.valueOf(1));
        //assert ...
        Assert.assertEquals(ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarIniciativasPorEstado("Otro Nuevo").get(0).getDescripcion(), "defecto");
    }
}

