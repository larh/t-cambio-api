DROP TABLE IF EXISTS rol;
DROP TABLE IF EXISTS usuario;

DROP SEQUENCE IF EXISTS usuario_seq;
DROP SEQUENCE IF EXISTS rol_seq;

CREATE sequence usuario_seq START WITH 3 INCREMENT BY 1;
CREATE sequence rol_seq START WITH 3 INCREMENT BY 1;

CREATE TABLE usuario (
  id bigint default usuario_seq.nextval PRIMARY KEY,
  username VARCHAR(6) NOT NULL,
  password VARCHAR(100) NOT NULL
);
  
CREATE TABLE rol (
  id bigint default rol_seq.nextval PRIMARY KEY,
  nombre VARCHAR(20) NOT NULL
);

CREATE TABLE usuario_rol (
  id_usuario bigint,
  id_rol NUMBER
);

INSERT INTO usuario (id, username, password) VALUES
  (1, 'admin', '$2a$10$EH3cKIjYQc/MsiF/pLA0A.Fqldp3qmg9mHSAO0ATYH/xCBQeI6mJy'),
  (2, 'larh', '$2a$10$EH3cKIjYQc/MsiF/pLA0A.Fqldp3qmg9mHSAO0ATYH/xCBQeI6mJy');
  
INSERT INTO rol (id, nombre) VALUES
  (1, 'ADMIN'),
  (2, 'INVITADO');
  
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES
  (1, 1),
  (2, 2);