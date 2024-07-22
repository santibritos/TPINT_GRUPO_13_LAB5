package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Paciente;


public interface IPacienteNegocio {

	public boolean Add(Paciente paciente);
	public boolean Exist(String dniPaciente);
	public Paciente ReadOne(String dniPaciente);
	public List<Paciente> ReadAll();
	public boolean Delete(Paciente paciente);
	public boolean Update(Paciente paciente);
}
