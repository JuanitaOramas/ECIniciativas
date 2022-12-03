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

public class consultarAreas {
    public consultarAreas() {
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
     //     * Obtiene una conexion a la base de datos de prueba
     //     * @return
     //     * @throws SQLException
     //     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://eciserver.mysql.database.azure.com:3306/test?useSSL=false", "admineci", "Password!");
    }

    @Test
    public void dadosUnosDatosEnLaBDSeDebePoderAveriguarQueAreaEs() throws SQLException, ExcepcionServiciosSuscripciones {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente

        // ARRANGE
        clearDB();
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        stmt.execute("INSERT INTO areas VALUES (1,'Estudiantes PreGrado')");
        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (1,'fulanito','islazy','veganito2000@mail.com','veganito')");
        stmt.execute("INSERT INTO `iniciativas` (`estado`,`descripcion`,`fecha`,`usuarios_idUsuario`,`areas_idArea`) VALUES ('en proceso','su solicitud esta siedo revisada','2008-7-04',1,1)");

        conn.close();

        //Realizar la operacion de la logica y la prueba
        List <Area> areas = ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarAreas();
        //assert ...
        Assert.assertEquals(areas.get(0).getNombreArea(),"Estudiantes PreGrado");

    }


}
