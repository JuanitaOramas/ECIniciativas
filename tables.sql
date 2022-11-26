/*
-- BASE DE DATOS
CREATE DATABASE IF NOT EXISTS bancoInciativasBD;
    DEFAULT CHARACTER SET utf8;
    DEFAULT COLLATE utf8_general_ci;


-- CREAR TABLAS
CREATE TABLE usuarios(
  idUsuario int NOT NULL PRIMARY KEY,
  perfil VARCHAR(50),
  informacion VARCHAR(100),
  correo VARCHAR(250) NOT NULL UNIQUE,
  contrasena VARCHAR(45)
);

CREATE TABLE areas(
  idArea int NOT NULL PRIMARY KEY,
  nombreArea VARCHAR(200)
);

CREATE TABLE iniciativas(
  idIniciativa int NOT NULL PRIMARY KEY,
  estado VARCHAR(20),
  descripcion VARCHAR(200),
  fecha DATE,
  usuarios_idUsuario int,
  areas_idArea int,
  FOREIGN KEY (usuarios_idUsuario) REFERENCES usuarios(idUsuario) ON DELETE CASCADE,
  FOREIGN KEY (areas_idArea) REFERENCES areas(idArea) ON DELETE CASCADE
);

CREATE TABLE comentarios(
  idComentario int NOT NULL PRIMARY KEY,
  fecha DATE,
  comentario VARCHAR(200),
  usuarios_idUsuario int,
  FOREIGN KEY (usuarios_idUsuario) REFERENCES usuarios(idUsuario) ON DELETE CASCADE
);

CREATE TABLE votos(
  idVoto int NOT NULL PRIMARY KEY,
  usuarios_idUsuario int,
  iniciativas_idIniciativa int,
  FOREIGN KEY (usuarios_idUsuario) REFERENCES usuarios(idUsuario) ON DELETE CASCADE,
  FOREIGN KEY (iniciativas_idIniciativa) REFERENCES iniciativas(idIniciativa) ON DELETE CASCADE
);

CREATE TABLE palabrasClave(
  palabra VARCHAR(200) NOT NULL PRIMARY KEY,
  iniciativas_idIniciativa int,
  FOREIGN KEY (iniciativas_idIniciativa) REFERENCES iniciativas(idIniciativa) ON DELETE CASCADE
);


--USUARIOS
INSERT INTO usuarios VALUES (1,"fulanito","fulanito","fulanito@mail.com","fulanito");
INSERT INTO usuarios VALUES (2,"sam","sam","sam@mail.com","sam");
INSERT INTO usuarios VALUES (3,"pipe","pipe","pipe@mail.com","pipe");
INSERT INTO usuarios VALUES (4,"daniela","daniela","daniela@mail.com","daniela");
INSERT INTO usuarios VALUES (5,"juliana","juliana","juliana@mail.com","juliana");

--AREAS
INSERT INTO areas VALUES (1,"Estudiantes");
INSERT INTO areas VALUES (2,"Profesores");
INSERT INTO areas VALUES (3,"Graduados"); 
INSERT INTO areas VALUES (4,"Acudientes");
INSERT INTO areas VALUES (5,"Donantes");

-- INICIATIVAS
INSERT INTO iniciativas VALUES (1,"en proceso","su solicitud esta siedo revisada","2008-7-04",1,1);
INSERT INTO iniciativas VALUES (2,"aprobada","su solicitud fue aprobada","2010-9-06",2,2);
INSERT INTO iniciativas VALUES (3,"rechazada","su solicitud fue rechazada","2021-10-31",3,3);
INSERT INTO iniciativas VALUES (4,"rechazada","su solicitud fue rechazada","2011-11-04",4,4);
INSERT INTO iniciativas VALUES (5,"en proceso","su solicitud esta siedo revisada","2005-3-24",5,5);

-- COMENTARIOS
INSERT INTO comentarios VALUES (1,'2008-7-04','super duper dice fulanito',1);
INSERT INTO comentarios VALUES (2,'2008-7-04','super duper dice sam',2);
INSERT INTO comentarios VALUES (3,'2008-7-04','super duper dice pipe',3);
INSERT INTO comentarios VALUES (4,'2008-7-04','super duper dice daniela',4);
INSERT INTO comentarios VALUES (5,'2008-7-04','super duper dice juliana',5);

-- VOTOS
INSERT INTO votos VALUES (1,1,1);
INSERT INTO votos VALUES (2,2,2);
INSERT INTO votos VALUES (3,3,3);
INSERT INTO votos VALUES (4,4,4);
INSERT INTO votos VALUES (5,5,5);

-- PALABRAS CLAVE
INSERT INTO palabrasClave VALUES ('creatividad',1);
INSERT INTO palabrasClave VALUES ('ideas',1);
INSERT INTO palabrasClave VALUES ('fortaleza',1);
INSERT INTO palabrasClave VALUES ('avaricia',1);
INSERT INTO palabrasClave VALUES ('nosoyclave',1);

-- XPOBLAR
DELETE FROM palabrasClave;
DELETE FROM votos;
DELETE FROM comentarios;
DELETE FROM iniciativas;
DELETE FROM areas;
DELETE FROM usuarios;


-- XTABLAS
DROP TABLE palabrasClave;
DROP TABLE votos;
DROP TABLE comentarios;
DROP TABLE iniciativas;
DROP TABLE areas;
DROP TABLE usuarios;

-- TRIGGERS
DELIMITER $$
CREATE TRIGGER TR_iniciativas_BI
  BEFORE INSERT ON iniciativas 
  FOR EACH ROW
  BEGIN
   DECLARE value INT;
    SELECT MAX(idIniciativa) INTO value FROM iniciativas;
    IF value IS NULL THEN
      SET new.idIniciativa = 0;
    ELSE
      SET new.idIniciativa =  (value + 1);
    END IF;
  END 
$$ DELIMITER ;

--PRUEBAS
SELECT * FROM usuarios;

INSERT INTO iniciativas(estado,descripcion,fecha,usuarios_idUsuario,areas_idArea) VALUES ("Nueva","prueba","2005-3-24",5,5);
bancoinciativasbd

SELECT
            p.idUsuario AS idUsuario,
            p.contrasena AS contrasena,
            p.perfil AS perfil,
            p.informacion AS informacion,
            c.idIniciativa AS idIniciativa,
            c.descripcion AS descripcion,
            c.fecha AS fecha
        FROM
            USUARIOS AS p JOIN INICIATIVAS as c ON
                p.idUsuario = c.usuarios_idUsuario
        WHERE
            p.idUsuario = 5 AND p.contrasena = 'juliana' */
