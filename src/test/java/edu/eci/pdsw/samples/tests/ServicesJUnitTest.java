/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.tests;

/**
 *
 * @author hcadavid
 */
public class ServicesJUnitTest {

    public ServicesJUnitTest() {
    }

//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void clearDB() throws SQLException {
//        Connection conn = DriverManager.getConnection("jdbc:mysql://testanonimous.mysql.database.azure.com:3306/iniciativas_test?useSSL=false", "anonimous", "Sebastian1234");
//        Statement stmt = conn.createStatement();
//	stmt.execute("delete from iniciativas");
//        stmt.execute("delete from usuarios");
//	stmt.execute("delete from areas");
//        conn.close();
//    }
//
//    /**
//     * Obtiene una conexion a la base de datos de prueba
//     * @return
//     * @throws SQLException
//     */
//    private Connection getConnection() throws SQLException{
//        return DriverManager.getConnection("jdbc:mysql://testanonimous.mysql.database.azure.com:3306/iniciativas_test?useSSL=false", "anonimous", "Sebastian1234");
//    }
//
//    @Test
//    public void dadoUnEstadoSeDebePoderObtenerSusLasIniciativas() throws SQLException, ExcepcionServiciosSuscripciones {
//        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
//        //de equivalencia correspondiente
//
//        // ARRANGE
//        clearDB();
//        Connection conn=getConnection();
//        Statement stmt=conn.createStatement();
//        stmt.execute("INSERT INTO `areas` VALUES (1,'prueba')");
//        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (1,'fulanito','islazy','veganito2000@mail.com','veganito')");
//        stmt.execute("INSERT INTO `iniciativas` (`estado`,`descripcion`,`fecha`,`usuarios_idUsuario`,`areas_idArea`) VALUES ('en proceso','su solicitud esta siedo revisada','2008-7-04',1,1)");
//
//        conn.close();
//
//        //Realizar la operacion de la logica y la prueba
//        List<Iniciativa> initiative = ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarIniciativasPorEstado("en proceso");
//        //assert ...
//        Assert.assertEquals(initiative.get(0).getDescripcion(), "su solicitud esta siedo revisada");
//    }
//
//    @Test
//    public void dadaUnaPalabraClaveSeDebePoderObtenerSusLasIniciativas() throws SQLException, ExcepcionServiciosSuscripciones {
//        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
//        //de equivalencia correspondiente
//
//        // ARRANGE
//        clearDB();
//        Connection conn=getConnection();
//        Statement stmt=conn.createStatement();
//        stmt.execute("INSERT INTO `areas` VALUES (1,'prueba')");
//        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (1,'fulanito','islazy','veganito2000@mail.com','veganito')");
//        stmt.execute("INSERT INTO `iniciativas` (`estado`,`descripcion`,`fecha`,`usuarios_idUsuario`,`areas_idArea`) VALUES ('en proceso','su solicitud esta siedo revisada','2008-7-04',1,1)");
//        stmt.execute("INSERT INTO `palabrasclave` VALUES ('nosoyclave',0)");
//
//        conn.close();
//
//        //Realizar la operacion de la logica y la prueba
//        List<Iniciativa> initiative = ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarIniciativasPorPalabraClave("nosoyclave");
//        //assert ...
//        Assert.assertEquals(initiative.get(0).getDescripcion(), "su solicitud esta siedo revisada");
//    }
//
//    @Test
//    public void dadaUnaIniciativaSeDeberiaPoderInsertar() throws SQLException, ExcepcionServiciosSuscripciones {
//        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
//        //de equivalencia correspondiente
//
//        // ARRANGE
//        clearDB();
//        Connection conn=getConnection();
//        Statement stmt=conn.createStatement();
//        stmt.execute("INSERT INTO `areas` VALUES (3,'prueba')");
//        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (3,'fulanito','islazy','veganito2000@mail.com','veganito')");
//
//
//        conn.close();
//
//        //Realizar la operacion de la logica y la prueba
//        ServiciosIniciativasFactory.getInstance().getTestingForumServices().insertIniciativas("Otro Nuevo","defecto", String.valueOf(1));
//        //assert ...
//        Assert.assertEquals(ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarIniciativasPorEstado("Otro Nuevo").get(0).getDescripcion(), "defecto");
//    }
//
//    @Test
//    public void dadaUnaIniciativaSeDeberiaPoderActualizar() throws SQLException, ExcepcionServiciosSuscripciones {
//        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
//        //de equivalencia correspondiente
//
//        // ARRANGE
//        clearDB();
//        Connection conn=getConnection();
//        Statement stmt=conn.createStatement();
//        stmt.execute("INSERT INTO `areas` VALUES (1,'prueba')");
//        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (1,'fulanito','islazy','veganito2000@mail.com','veganito')");
//        stmt.execute("INSERT INTO `iniciativas` (`estado`,`descripcion`,`fecha`,`usuarios_idUsuario`,`areas_idArea`) VALUES ('en proceso','su solicitud esta siedo revisada','2008-7-04',1,1)");
//
//        conn.close();
//
//        //Realizar la operacion de la logica y la prueba
//        ServiciosIniciativasFactory.getInstance().getTestingForumServices().updateIniciativaService(0,"nueva descripcion","nuevo estado");
//        //assert ...
//        Assert.assertEquals(ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarIniciativasPorEstado("nuevo estado").get(0).getDescripcion(), "nueva descripcion");
//    }
    /*
    @Test
    public void dadasLasCredencialesDeUnUsuarioSeDebePoderObtenerSuInformacion() throws SQLException, ExcepcionServiciosSuscripciones {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente

        // ARRANGE
        clearDB();
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        stmt.execute("INSERT INTO `areas` VALUES (1,'prueba')");
        stmt.execute("INSERT INTO `usuarios` (`idUsuario`,`perfil`,`informacion`,`correo`,`contrasena`) VALUES (1,'fulanito','islazy','veganito2000@mail.com','veganito')");

        conn.close();

        //Realizar la operacion de la logica y la prueba
        Usuario user = ServiciosIniciativasFactory.getInstance().getTestingForumServices().consultarUsuarioPorCredentials(1,"veganito");
        //assert ...
        Assert.assertEquals(user.getEmail(), "veganito2000@mail.com");
    }*/
}