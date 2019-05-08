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
    nombre text not null,
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
create table Rol(
    idrol bigserial not null,
    nombre text not null,
    constraint pk_rol primary key(idrol)
);

create table Usuario(
    idusuario bigserial not null,
    nombre text not null,
    apellido text not null,
    nombreUsuario text not null,
    contraseña text not null,
    tipo int not null,
    constraint pk_usuario primary key(idusuario),
    constraint fk_rol foreign key(tipo) references Rol(idrol)
    on delete restrict
    on update cascade
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

-- insertar los datos de la tabla semestre
insert into Semestre values('01','primero');
insert into Semestre values('02','segundo');
insert into Semestre values('03','tercero');
insert into Semestre values('04','cuarto');
insert into Semestre values('05','quinto');
insert into Semestre values('06','sexto');
insert into Semestre values('07','septimo');
insert into Semestre values('08','octavo');
insert into Semestre values('09','noveno');
insert into Semestre values('10','decimo');

-- insertar datos de la tabla carrera
insert into Carrera values('03','enfermería');
insert into Carrera values('13','odontología');
insert into Carrera values('14','medicina');

-- insertar los datos de la tabla practica
insert into Practica values('1001','Practica1 1° semestre enfermeria','01','03',now(),null,null);
insert into Practica values('1002','Practica2 1° semestre enfermeria','01','03',now(),null,null);
insert into Practica values('1003','Practica3 1° semestre enfermeria','01','03',now(),null,null);

insert into Practica values('3001','Practica1 3° semestre enfermeria','03','03',now(),null,null);
insert into Practica values('3002','Practica2 3° semestre enfermeria','03','03',now(),null,null);
insert into Practica values('3003','Practica3 3° semestre enfermeria','03','03',now(),null,null);

insert into Practica values('5001','Practica1 5° semestre enfermeria','05','03',now(),null,null);
insert into Practica values('5002','Practica2 5° semestre enfermeria','05','03',now(),null,null);
insert into Practica values('5003','Practica3 5° semestre enfermeria','05','03',now(),null,null);

insert into Practica values('7001','Practica1 7° semestre enfermeria','05','03',now(),null,null);
insert into Practica values('7002','Practica2 7° semestre enfermeria','05','03',now(),null,null);
insert into Practica values('7003','Practica3 7° semestre enfermeria','05','03',now(),null,null);

insert into Practica values('9001','Practica1 9° semestre enfermeria','09','03',now(),null,null);
insert into Practica values('9002','Practica2 9° semestre enfermeria','09','03',now(),null,null);
insert into Practica values('9003','Practica3 9° semestre enfermeria','09','03',now(),null,null);

-- insertamos datos en la tabla alumno
insert into Alumno values('2014030100','ana maria jimenez bautista','903',now(),null,null,'09','03');
insert into Alumno values('2015030104','blanca bautista nazario','703',now(),null,null,'07','03');
insert into Alumno values('2016030037','carmen garcia olvera','503',now(),null,null,'05','03');
insert into Alumno values('2017030240','irene bustamante jiron','303',now(),null,null,'03','03');
insert into Alumno values('2018030379','maria guadalupe mendoza castro','103',now(),null,null,'01','03');

-- insertamos en la tabla registro
insert into Registro values('2018030379','1001','10:00','11:00','2019-05-02','biblioteca','realizado',null);
insert into Registro values('2018030379','1002','10:00','11:00','2019-05-02','biblioteca','realizado',null);
insert into Registro values('2018030379','1003','10:00','11:00','2019-05-02','biblioteca','realizado',null);

insert into Registro values('2017030240','3001','10:00','11:00','2019-05-02','biblioteca','realizado',null);
insert into Registro values('2017030240','3002','10:00','11:00','2019-05-02','biblioteca','realizado',null);
insert into Registro values('2017030240','3003','10:00','11:00','2019-05-02','biblioteca','realizado',null);

insert into Registro values('2016030037','5001','10:00','11:00','2019-05-02','biblioteca','realizado',null);
insert into Registro values('2016030037','5002','10:00','11:00','2019-05-02','biblioteca','realizado',null);
insert into Registro values('2016030037','5003','10:00','11:00','2019-05-02','biblioteca','realizado',null);

insert into Registro values('2015030104','7001','10:00','11:00','2019-05-02','biblioteca','realizado',null);
insert into Registro values('2015030104','7002','10:00','11:00','2019-05-02','biblioteca','realizado',null);
insert into Registro values('2015030104','7003','10:00','11:00','2019-05-02','biblioteca','realizado',null);

insert into Registro values('2014030100','9001','10:00','11:00','2019-05-02','biblioteca','realizado',null);
insert into Registro values('2014030100','9002','10:00','11:00','2019-05-02','biblioteca','realizado',null);
insert into Registro values('2014030100','9003','10:00','11:00','2019-05-02','biblioteca','realizado',null);

-- insertamos datos en la tabla rol

insert into Rol values(1,'invitado');
insert into Rol values(2,'administrador');
insert into Rol values(3,'encargado');
insert into Rol values(4,'profesor');
insert into Rol values(5,'alumno');

-- insertamos datos en la tabla usuario
insert into Usuario values(1,'arministrador','1','root','root',2);
insert into Usuario values(2,'encargado','1','encargado','secreto',3);
insert into Usuario values(3,'rolando','pedro gabriel','profesor123','user123',4);
insert into Usuario values(4,'alumno','1','alumnuss','students2019',5);

-- insertamos datos en la tabla reservacion
insert into Reservacion values(1,now(),now(),'area1','responsable area 1','practica 1','responsable practica 1');
insert into Reservacion values(2,now(),now(),'area2','responsable area 2','practica 2','responsable practica 2');
insert into Reservacion values(3,now(),now(),'area3','responsable area 3','practica 3','responsable practica 3');
insert into Reservacion values(4,now(),now(),'area4','responsable area 4','practica 4','responsable practica 4');


