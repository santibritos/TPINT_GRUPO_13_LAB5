package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IdaoEspecialidad;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.negocio.IespecialidadNegocio;


@Service("servicioEspecialidad")
public class EspecialidadNegocio implements IespecialidadNegocio {
	
	@Autowired
	private IdaoEspecialidad dao;
	
	
	public EspecialidadNegocio()
	{
		
	}

	@Override
	public boolean Add(Especialidad esp) {
		// TODO Auto-generated method stub
		return dao.Add(esp);
	}

	@Override
	public Especialidad ReadOne(int id) {
		// TODO Auto-generated method stub
		return dao.ReadOne(id);
	}

	@Override
	public List<Especialidad> ReadAll() {
		// TODO Auto-generated method stub
		return dao.ReadAll();
	}

	@Override
	public boolean Exist(String aux) {
		// TODO Auto-generated method stub
		return dao.Exist(aux);
	}

	public IdaoEspecialidad getDao() {
		return dao;
	}

	public void setDao(IdaoEspecialidad dao) {
		this.dao = dao;
	}

}
