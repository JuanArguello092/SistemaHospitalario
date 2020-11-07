-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.1
-- PostgreSQL version: 9.4
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: gestion_sanitaria | type: DATABASE --
-- -- DROP DATABASE IF EXISTS gestion_sanitaria;
-- CREATE DATABASE gestion_sanitaria
-- 	ENCODING = 'UTF8'
-- 	LC_COLLATE = 'Spanish_Spain.UTF8'
-- 	LC_CTYPE = 'Spanish_Spain.UTF8'
-- 	TABLESPACE = pg_default
-- 	OWNER = postgres
-- ;
-- -- ddl-end --
-- 

-- object: public.hospital | type: TABLE --
-- DROP TABLE IF EXISTS public.hospital CASCADE;
CREATE TABLE public.hospital(
	codhospital integer NOT NULL,
	nombre character(30) NOT NULL,
	ciudad character(20) NOT NULL,
	telefono character(15) NOT NULL,
	nombre_director character(20),
	CONSTRAINT hospitalpk PRIMARY KEY (codhospital)

);
-- ddl-end --
ALTER TABLE public.hospital OWNER TO postgres;
-- ddl-end --

-- object: public.servicio | type: TABLE --
-- DROP TABLE IF EXISTS public.servicio CASCADE;
CREATE TABLE public.servicio(
	idservicio integer NOT NULL,
	acronimo_servicio character(5) NOT NULL,
	nombre_servicio character(20) NOT NULL,
	descripcion character(60),
	CONSTRAINT serviciopk PRIMARY KEY (idservicio)

);
-- ddl-end --
ALTER TABLE public.servicio OWNER TO postgres;
-- ddl-end --

-- object: public.medico | type: TABLE --
-- DROP TABLE IF EXISTS public.medico CASCADE;
CREATE TABLE public.medico(
	dni integer NOT NULL,
	nombre character(20) NOT NULL,
	apellido character(20) NOT NULL,
	fecha_nacimiento date NOT NULL,
	cod_hospital integer,
	id_servicio integer,
	ocupa_direccion boolean,
	CONSTRAINT medicopk PRIMARY KEY (dni)

);
-- ddl-end --
ALTER TABLE public.medico OWNER TO postgres;
-- ddl-end --

-- object: public.hospital_servicio | type: TABLE --
-- DROP TABLE IF EXISTS public.hospital_servicio CASCADE;
CREATE TABLE public.hospital_servicio(
	codhospital integer NOT NULL,
	idservicio integer NOT NULL,
	nro_cama integer,
	CONSTRAINT hospital_servicio_pk PRIMARY KEY (codhospital,idservicio)

);
-- ddl-end --
ALTER TABLE public.hospital_servicio OWNER TO postgres;
-- ddl-end --

-- object: public.paciente | type: TABLE --
-- DROP TABLE IF EXISTS public.paciente CASCADE;
CREATE TABLE public.paciente(
	codigo integer NOT NULL,
	cedula integer NOT NULL,
	nombre character(20) NOT NULL,
	apellido character(20) NOT NULL,
	sexo character NOT NULL,
	fecha_nacimiento date NOT NULL,
	direccion character(45) NOT NULL,
	telefono character(15) NOT NULL,
	CONSTRAINT pacientepk PRIMARY KEY (codigo)

);
-- ddl-end --
ALTER TABLE public.paciente OWNER TO postgres;
-- ddl-end --

-- object: public.historial_clinico | type: TABLE --
-- DROP TABLE IF EXISTS public.historial_clinico CASCADE;
CREATE TABLE public.historial_clinico(
	codhistorial integer NOT NULL,
	codigo_paciente integer,
	id_consulta integer,
	CONSTRAINT historial_clinico_pk PRIMARY KEY (codhistorial)

);
-- ddl-end --
ALTER TABLE public.historial_clinico OWNER TO postgres;
-- ddl-end --

-- object: public.consulta_medica | type: TABLE --
-- DROP TABLE IF EXISTS public.consulta_medica CASCADE;
CREATE TABLE public.consulta_medica(
	id integer NOT NULL,
	fecha date NOT NULL,
	hora_ingreso time NOT NULL,
	hora_salida time NOT NULL,
	cod_hospital integer,
	id_servicio integer,
	dni_medico integer,
	diagnostico character(60),
	tratamiento character(60),
	nro_habitacion integer,
	CONSTRAINT consulta_medica_pk PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.consulta_medica OWNER TO postgres;
-- ddl-end --

-- object: medico_hospital_servicio_fk | type: CONSTRAINT --
-- ALTER TABLE public.medico DROP CONSTRAINT IF EXISTS medico_hospital_servicio_fk CASCADE;
ALTER TABLE public.medico ADD CONSTRAINT medico_hospital_servicio_fk FOREIGN KEY (id_servicio)
REFERENCES public.servicio (idservicio) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: hospital_medico_fk | type: CONSTRAINT --
-- ALTER TABLE public.medico DROP CONSTRAINT IF EXISTS hospital_medico_fk CASCADE;
ALTER TABLE public.medico ADD CONSTRAINT hospital_medico_fk FOREIGN KEY (cod_hospital)
REFERENCES public.hospital (codhospital) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: hospital_servicio_fk | type: CONSTRAINT --
-- ALTER TABLE public.hospital_servicio DROP CONSTRAINT IF EXISTS hospital_servicio_fk CASCADE;
ALTER TABLE public.hospital_servicio ADD CONSTRAINT hospital_servicio_fk FOREIGN KEY (codhospital)
REFERENCES public.hospital (codhospital) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: servicio_hospital_fk | type: CONSTRAINT --
-- ALTER TABLE public.hospital_servicio DROP CONSTRAINT IF EXISTS servicio_hospital_fk CASCADE;
ALTER TABLE public.hospital_servicio ADD CONSTRAINT servicio_hospital_fk FOREIGN KEY (idservicio)
REFERENCES public.servicio (idservicio) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: historial_paciente_fk | type: CONSTRAINT --
-- ALTER TABLE public.historial_clinico DROP CONSTRAINT IF EXISTS historial_paciente_fk CASCADE;
ALTER TABLE public.historial_clinico ADD CONSTRAINT historial_paciente_fk FOREIGN KEY (codigo_paciente)
REFERENCES public.paciente (codigo) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: historial_consulta_fk | type: CONSTRAINT --
-- ALTER TABLE public.historial_clinico DROP CONSTRAINT IF EXISTS historial_consulta_fk CASCADE;
ALTER TABLE public.historial_clinico ADD CONSTRAINT historial_consulta_fk FOREIGN KEY (id_consulta)
REFERENCES public.consulta_medica (id) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: consulta_medica_hosp_fk | type: CONSTRAINT --
-- ALTER TABLE public.consulta_medica DROP CONSTRAINT IF EXISTS consulta_medica_hosp_fk CASCADE;
ALTER TABLE public.consulta_medica ADD CONSTRAINT consulta_medica_hosp_fk FOREIGN KEY (cod_hospital)
REFERENCES public.hospital (codhospital) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: consulta_medica_serv_fk | type: CONSTRAINT --
-- ALTER TABLE public.consulta_medica DROP CONSTRAINT IF EXISTS consulta_medica_serv_fk CASCADE;
ALTER TABLE public.consulta_medica ADD CONSTRAINT consulta_medica_serv_fk FOREIGN KEY (id_servicio)
REFERENCES public.servicio (idservicio) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: consulta_medica_medico_fk | type: CONSTRAINT --
-- ALTER TABLE public.consulta_medica DROP CONSTRAINT IF EXISTS consulta_medica_medico_fk CASCADE;
ALTER TABLE public.consulta_medica ADD CONSTRAINT consulta_medica_medico_fk FOREIGN KEY (dni_medico)
REFERENCES public.medico (dni) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --


