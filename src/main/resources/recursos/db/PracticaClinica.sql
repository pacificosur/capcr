-- -------------------------------------------------------------------------------
-- LIMPIEZA DE LA BASE DE DATOS ELIMINAR Y VOLVER A CREAR LA BASE DE DATOS
-- -------------------------------------------------------------------------------
drop database if exists clinica;
create database clinica;
use clinica;
-- -------------------------------------------------------------------------------
-- CREACION DE LAS TABLAS SEMESTRE, CARRERA, PRACTICA, ALUMNO, USUARIO, REGISTRO
-- -------------------------------------------------------------------------------
create table Semestre(
    codigo text not null,
    nombre text not null,
    constraint pk_semestre primary key(codigo)
);

create table Carrera(
    codigo text not null,
    nombre text not null,
    constraint pk_codigoC primary key(codigo)
);

create table Practica(
    codigo text not null,
    nombre text not null unique,
    codigoSemestre text not null,
    codigoCarrera text not null,
    fechaCreacion timestamp(0) not null,
    fechaActualizacion timestamp(0),
    fechaEliminacion timestamp(0),
    constraint fk_Psemestre foreign key(codigoSemestre) references Semestre(codigo)
    on delete cascade
    on update cascade,
    constraint fk_Pcarrera foreign key(codigoCarrera) references Carrera(codigo)
    on delete cascade
    on update cascade,
    constraint pk_practica primary key (codigo)
    );
   
create table Alumno(
    matricula text not null,
    nombre text not null,
    grupo text not null,
    fechaCreacion timestamp(0) not null,
    fechaActualizacion timestamp(0),
    fechaEliminacion timestamp(0),
    codigoSemestre text not null,
    codigoCarrera text not null,
    constraint pk_alumno primary key (matricula),
    constraint fk_Asemestre foreign key(codigoSemestre)	references Semestre(codigo)
    on delete cascade
    on update cascade,
    constraint fk_Acarrrera foreign key(codigoCarrera) references Carrera(codigo)
    on delete cascade
    on update cascade
);

create table Registro(
    matriculaAlumno text not null,
    codigoPractica text not null,
    horaEntrada time(0) ,
    horaSalida time(0) ,
    fecha date,
    sustituye text not null,
    estado text not null,
    comentario text,
    constraint fk_alumno foreign key (matriculaAlumno)	references Alumno(matricula)
    on delete cascade
    on update cascade,
    constraint fk_practica foreign key(codigoPractica)	references Practica(codigo)
    on delete restrict
    on update cascade
);   
    
create table Usuario(
    idusuario bigserial not null,
    nombre text not null,
    apellido text not null,
    nombreUsuario text not null,
    contraseña text not null,
    tipo int not null,
    constraint pk_usuario primary key(idusuario)
);

create table Reservacion(
    idReservacion bigserial not null,
    fechaInicio timestamp(0) not null,
    fechaFin timestamp(0) not null,
    area text not null,
    responsableArea text not null,
    practica text not null,
    responsablePractica text not null,
    constraint pk_reservacion primary key(idReservacion)
);

