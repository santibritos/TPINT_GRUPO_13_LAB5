package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IdaoMedico;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.negocio.ImedicoNegocio;


@Service("servicioMedico")
public class MedicoNegocio implements ImedicoNegocio{

	@Autowired
	private IdaoMedico  daoMedico;

	public MedicoNegocio()
	{
		
	}
	
	@Override
	public boolean Add(Medico user) {
		
		return daoMedico.Add(user);
	}

	@Override
	public Medico ReadOne(int legajo) {
		return daoMedico.ReadOne(legajo);
	}

	@Override
	public List<Medico> ReadAll() {
		return daoMedico.ReadAll();
	}

	@Override
	public boolean Exist(int m) {
		return daoMedico.Exist(m);
	}

	@Override
	public boolean Update(Medico m) {
		return daoMedico.Update(m);
	}

	@Override
	public boolean Delete(Medico m) {
		
		m.setEstado(false);
		return daoMedico.Delete(m);
	}

	public IdaoMedico getDaoMedico() {
		return daoMedico;
	}

	public void setDaoMedico(IdaoMedico daoMedico) {
		this.daoMedico = daoMedico;
	}

}
