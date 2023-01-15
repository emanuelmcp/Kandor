CREATE TABLE IF NOT EXISTS cuenta(
    uuid VARCHAR(36) PRIMARY KEY,
    nick VARCHAR(50) NOT NULL,
    email VARCHAR(70) UNIQUE,
    password VARCHAR(300) NOT NULL ,
    ultimo_login DATE DEFAULT CURRENT_DATE NOT NULL,
    logueado BOOLEAN DEFAULT FALSE NOT NULL,
    baneado BOOLEAN NOT NULL
);
CREATE TABLE IF NOT EXISTS grupo(
    identificador SERIAL PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE,
    descripcion VARCHAR(100),
    prefijo VARCHAR(5),
    sufijo VARCHAR(5)
);
CREATE TABLE IF NOT EXISTS cuenta_grupo(
    uuid_cuenta VARCHAR(36),
    id_grupo SERIAL,
    CONSTRAINT cuenta_grupo_pk PRIMARY KEY (uuid_cuenta, id_grupo),
    CONSTRAINT cuenta_cuenta_grupo_fk FOREIGN KEY(uuid_cuenta) REFERENCES cuenta(uuid),
    CONSTRAINT grupo_cuenta_grupo_fk FOREIGN KEY(id_grupo) REFERENCES grupo(identificador)
);
CREATE TABLE IF NOT EXISTS permiso(
    identificador SERIAL PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE,
    descripcion VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS grupo_permisos(
    id_grupo SERIAL,
    id_permiso SERIAL,
    CONSTRAINT grupo_permisos_pk PRIMARY KEY (id_grupo, id_permiso),
    CONSTRAINT cuenta_grupo_permisos_fk FOREIGN KEY(id_grupo) REFERENCES grupo(identificador),
    CONSTRAINT permisos_grupo_permisos_fk FOREIGN KEY(id_permiso) REFERENCES permiso(identificador)
);

INSERT INTO cuenta VALUES ('1a18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel1', 'emanuelmcp1@gmail.com', 'contrasenita1', '2023-01-01', true, false);
INSERT INTO cuenta VALUES ('1b18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel2', 'emanuelmcp2@gmail.com', 'contrasenita2', '2023-02-02', true, false);
INSERT INTO cuenta VALUES ('1c18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel3', 'emanuelmcp3@gmail.com', 'contrasenita3', '2023-03-03', true, false);
INSERT INTO cuenta VALUES ('1d18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel4', 'emanuelmcp4@gmail.com', 'contrasenita4', '2023-04-04', true, false);
INSERT INTO cuenta VALUES ('1e18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel5', 'emanuelmcp5@gmail.com', 'contrasenita5', '2023-05-05', true, false);
INSERT INTO cuenta VALUES ('1f18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel6', 'emanuelmcp6@gmail.com', 'contrasenita6', '2023-06-06', true, false);
INSERT INTO cuenta VALUES ('1g18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel7', 'emanuelmcp7@gmail.com', 'contrasenita7', '2023-07-07', true, false);
INSERT INTO cuenta VALUES ('1h18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel8', 'emanuelmcp8@gmail.com', 'contrasenita8', '2023-08-08', true, false);
INSERT INTO cuenta VALUES ('1i18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel9', 'emanuelmcp9@gmail.com', 'contrasenita9', '2023-09-09', true, false);
INSERT INTO cuenta VALUES ('1j18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel10', 'emanuelmc10p@gmail.com', 'contrasenita10', '2023-10-10', true, false);
INSERT INTO cuenta VALUES ('1k18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel11', 'emanuelmcp11@gmail.com', 'contrasenita11', '2023-11-11', true, false);

INSERT INTO grupo(nombre, descripcion, prefijo, sufijo) VALUES ('default1', 'grupo por defecto1', 'def1', 'def1');
INSERT INTO grupo(nombre, descripcion, prefijo, sufijo) VALUES ('default2', 'grupo por defecto2', 'def2', 'def2');
INSERT INTO grupo(nombre, descripcion, prefijo, sufijo) VALUES ('default3', 'grupo por defecto3', 'def3', 'def3');

INSERT INTO cuenta_grupo VALUES ('1e18e9e8-cb2e-412c-a1b7-835e73340d35', 1);

