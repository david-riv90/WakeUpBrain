package modelo;

import dvx.bd.Entidad;

public class Paciente extends Entidad {
	
	public Paciente()	{
		super();
		this.setPrefijo_funciones("fn");
		this.setTablaNombre("paciente");
		this.setIdNombre("id_paciente");
		this.agregarCampoEtiquetado("id_paciente", "ID");
		this.agregarCampoEtiquetado("nombre", "Nombre");
		this.agregarCampoEtiquetado("apaterno", "Ap Paterno");
		this.agregarCampoEtiquetado("amaterno", "Ap Materno");
		this.agregarCampoEtiquetado("fnacimiento", "Fecha nacimiento");
		this.agregarCampoEtiquetado("grado_primaria", "Grado");
		this.agregarCampoEtiquetado("diagnostico", "Diagnóstico");
		this.agregarCampoEtiquetado("observaciones", "Observaciones");
		this.agregarCampoEtiquetado("id_tutor", "id_tutor");
		this.agregarCampoEtiquetado("id_especialista", "id_especialista");
	}

}
