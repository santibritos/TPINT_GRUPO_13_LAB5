package frgp.utn.edu.ar.negocioImp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IdaoPaciente;
import frgp.utn.edu.ar.daoImp.DaoPaciente;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.negocio.IPacienteNegocio;



public class PacienteNegocio implements IPacienteNegocio {

	private IdaoPaciente daoPaciente;
	
	public PacienteNegocio()
	{
		
	}
	public PacienteNegocio(DaoPaciente daoPaciente)
	{
		this.daoPaciente = daoPaciente;
	}
	
	public IdaoPaciente getDaoPaciente() {
		return daoPaciente;
	}
	
	public void setDaoPaciente(IdaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}
	
	public IdaoPaciente getDao() {
		return daoPaciente;
	}

	public void setDao(IdaoPaciente dao) {
		this.daoPaciente = dao;
	}
	
	
	
	@Override
	public boolean Add(Paciente paciente) {
		return daoPaciente.Add(paciente);
	}
	@Override
	public boolean Exist(String dniPaciente) {
		return daoPaciente.Exist(dniPaciente);
	}

	public Paciente ReadOne(String dniPaciente) {
		return daoPaciente.ReadOne(dniPaciente);
	}

	public List<Paciente> ReadAll() {
		
		/**for(Paciente p : daoPaciente.Readall())
		{
			System.out.println(p.toString());
		}*/
		
		return daoPaciente.Readall();
		
		
	}
	@Override
	public boolean Delete(Paciente paciente) {
		paciente.setEstado(false);
		return daoPaciente.Delete(paciente);
	}
	@Override
	public boolean Update(Paciente paciente) {
		// TODO Auto-generated method stub
		return daoPaciente.Update(paciente);
	}
	
	
	
}
