//package edu.eci.pdsw.samples.tests.services.serviciosIniciativasTest;
//
//import edu.eci.pdsw.samples.entities.Area;
//import edu.eci.pdsw.samples.entities.Iniciativa;
//import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
//import edu.eci.pdsw.samples.services.ServiciosIniciativasFactory;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//
//public class ConsultarIniciativas {
//    public ConsultarIniciativas(){
//
//    }
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void clearDB() throws SQLException {
//        Connection conn = DriverManager.getConnection("jdbc:mysql://testanonimous.mysql.database.azure.com:3306/iniciativas_test?useSSL=false", "anonimous", "Sebastian1234");
//        Statement stmt = conn.createStatement();
//        stmt.execute("delete from iniciativas");
//        stmt.execute("delete from usuarios");
//        stmt.execute("delete from areas");
//        conn.close();
//    }
//
//    /**
//     * //     * Obtiene una conexion a la base de datos de prueba
//     * //     * @return
//     * //     * @throws SQLException
//     * //
//     */
//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection("jdbc:mysql://testanonimous.mysql.database.azure.com:3306/iniciativas_test?useSSL=false", "anonimous", "Sebastian1234");
//    }
//
//    @Test
//    public void dadoUnosDatosEnLaBDSeDebePoderObtenerLasIniciativas() throws SQLException, ExcepcionServiciosSuscripciones {
//        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
//        //de equivalencia correspondiente
//
//        // ARRANGE
//        clearDB();
//        Connection conn = getConnection();
//        Statement stmt = conn.createStatement();
//        stmt.execute("INSERT INTO areas VALUES (1,'Estudiantes PreGrado')");
//        stmt.execute("INSERT INTO areas VALUES (2,'Profesores')");
//        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (1,'fulanito','islazy','veganito2000@mail.com','veganito')");
//        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (2,'pepe','islazy','pepe2004@mail.com','pepe')");
//        stmt.execute("INSERT INTO `iniciativas` (`estado`,`descripcion`,`fecha`,`usuarios_idUsuario`,`areas_idArea`) VALUES ('en proceso','su solicitud esta siendo revisada','2008-7-04',1,1)");
//        stmt.execute("INSERT INTO `iniciativas` (`estado`,`descripcion`,`fecha`,`usuarios_idUsuario`,`areas_idArea`) VALUES ('rechazada','su solicitud ha sido rechazada','2008-7-04',2,2)");
//
//        conn.close();
//
//        //Realizar la operacion de la logica y la prueba
//        List<Iniciativa> iniciativa = ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarIniciativas();
//        System.out.println(iniciativa.get(0));
//        //assert ...
//        Assert.assertEquals(iniciativa.get(0), "{ id:0, estado:en proceso, descripcion: su solicitud esta siendo revisada]");
//
//    }
//}
