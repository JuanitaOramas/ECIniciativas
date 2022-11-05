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

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosPacientesFactory;

import java.sql.*;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

/**
 *
 * @author hcadavid
 */
public class ServicesJUnitTest {

    public ServicesJUnitTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "anonymous");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from CONSULTAS");
        stmt.execute("delete from PACIENTES");
        conn.commit();
        conn.close();
    }

    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "anonymous");
    }

    @Test
    public void dadoRegistrosEnBD_CuandoSeConsultaPorID_EntoncesRetornaRegistro() throws SQLException, ExcepcionServiciosSuscripciones {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase de equivalencia correspondiente (Arrange)
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        stmt.execute("INSERT INTO `PACIENTES` (`id`, `tipo_id`, `nombre`, `fecha_nacimiento`) VALUES (9876,'TI','Carmenzo','1995-07-10')");
        stmt.execute("INSERT INTO `CONSULTAS` (`idCONSULTAS`, `fecha_y_hora`, `resumen`, `PACIENTES_id`, `PACIENTES_tipo_id`) VALUES (1262218,'2001-01-01 00:00:00','Gracias',9876,'TI')");
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba (Act)
        Paciente pacienteTest = ServiciosPacientesFactory.getInstance().getTestingForumServices().consultarPacientesPorId(9876,TipoIdentificacion.TI);

        // Assert
        Assert.assertEquals(pacienteTest.getId(),9876);
        Assert.assertEquals(pacienteTest.getTipo_id(),TipoIdentificacion.TI);
        Assert.assertEquals(pacienteTest.getNombre(),"Carmenzo");
    }

    @Test
    public void dadoRegistrosEnBD_CuandoSeConsultaMenoresEnfermos_EntoncesRetornaRegistro() throws SQLException, ExcepcionServiciosSuscripciones {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase de equivalencia correspondiente (Arrange)
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        stmt.execute("INSERT INTO `PACIENTES` (`id`, `tipo_id`, `nombre`, `fecha_nacimiento`) VALUES (9877,'TI','Carmenza','2009-07-10')");
        stmt.execute("INSERT INTO `CONSULTAS` (`idCONSULTAS`, `fecha_y_hora`, `resumen`, `PACIENTES_id`, `PACIENTES_tipo_id`) VALUES (1262220,'2001-01-01 00:00:00','hepatitis',9877,'TI')");
        conn.commit();
        conn.close();

        // Act
        List<Paciente> pacientes = ServiciosPacientesFactory.getInstance().getTestingForumServices().consultarMenoresConEnfermedadContagiosa();

        // Assert
        Assert.assertEquals(pacientes.get(0).getId(),9877);
        Assert.assertEquals(pacientes.get(0).getTipo_id(),TipoIdentificacion.TI);
        Assert.assertEquals(pacientes.get(0).getNombre(),"Carmenza");
    }
    

}
