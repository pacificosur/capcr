/*
 * Autores: Castro Cisneros Hiralda
 * E-mail: hiraldac.cisneros@gmail.com
 * Fecha Creación: 08/06/2019
 * Fecha Modificación: 08/06/2019
 * Descripción: Procedimientos almacenados y funciones
 */

------------------------------------------------------------
-- Practica
------------------------------------------------------------

-- Obtener practicas
CREATE FUNCTION fnobtenerpracticas(
	OUT _codigo text,
	OUT _nombre text,
	OUT _codigocarrera text,
	OUT _codigosemestre text)
RETURNS SETOF RECORD AS
$BODY$
DECLARE
    tabla RECORD;
BEGIN
    FOR tabla IN SELECT * FROM Practica where fechaeliminacion is null LOOP
	_codigo:= tabla.codigo;
	_nombre := tabla.nombre;
	_codigocarrera:= tabla.codigocarrera;
	_codigosemestre := tabla.codigosemestre;
       RETURN NEXT;
    END LOOP;
    RETURN;
END
$BODY$ LANGUAGE 'plpgsql';
--select * from fnobtenerpractica()

-- Obtener practica
CREATE FUNCTION fnobtenerpractica(
	INOUT _codigo text,
	OUT _nombre text,
	OUT _codigocarrera text,
	OUT _codigosemestre text)
RETURNS SETOF RECORD AS
$BODY$
DECLARE
    tabla RECORD;
BEGIN
     SELECT * INTO tabla FROM Practica where codigo=_codigo;
	_codigo:= tabla.codigo;
	_nombre := tabla.nombre;
	_codigocarrera:= tabla.codigocarrera;
	_codigosemestre := tabla.codigosemestre;
       RETURN NEXT;
    RETURN;
END
$BODY$ LANGUAGE 'plpgsql';
--select * from fnobtenerpracticas('_codigo')

-- Crear practica
CREATE OR REPLACE PROCEDURE spcrearpractica(
	_codigo text,
	_nombre text,
	_codigosemestre text,
	_codigocarrera text)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
INSERT INTO Practica VALUES(_codigo,_nombre,_codigosemestre,_codigocarrera,now(),null,null);
    COMMIT;
END;
$BODY$;
--call spcrearpractica(?,?,?,?)

-- Eliminar practica
CREATE OR REPLACE PROCEDURE speliminarpractica(
	_codigo text)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
UPDATE Practica set fechaEliminacion=now() where codigo=_codigo;
    COMMIT;
END;
$BODY$;
--call speliminarpractica(?)

-- Actualizar practica
CREATE OR REPLACE PROCEDURE spactualizarpractica(
	_codigo text,
	_nombre text,
	_codigosemestre text,
	_codigocarrera text)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
UPDATE Practica set nombre=_nombre, codigoSemestre=_codigosemestre, codigoCarrera=_codigocarrera, fechaActualizacion=now() where codigo=_codigo;
    COMMIT;
END;
$BODY$;
--call spactualizarpractica(?,?,?,?)

------------------------------------------------------------
-- Reservación
------------------------------------------------------------

