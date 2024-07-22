package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import frgp.utn.edu.ar.dao.IdaoTurno;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.negocio.IturnoNegocio;

public class TurnoNegocio implements IturnoNegocio{
	
	private IdaoTurno dao;
	
	
	public TurnoNegocio()
	{
		
	}

	@Override
	public boolean Add(Turno turno) {
		// TODO Auto-generated method stub
		return dao.Add(turno);
	}

	@Override
	public Turno ReadOne(int id) {
		// TODO Auto-generated method stub
		return dao.ReadOne(id);
	}

	@Override
	public List<Turno> ReadAll() {
		// TODO Auto-generated method stub
		return dao.ReadAll();
	}

	@Override
	public boolean Exist(String aux) {
		// TODO Auto-generated method stub
		return dao.Exist(aux);
	}

	@Override
	public boolean Update(Turno turno) {
		// TODO Auto-generated method stub
		return dao.Update(turno);
	}

	@Override
	public boolean Delete(Turno turno) {
		turno.setEstado("cancelado");
		return dao.Delete(turno);
	}

	public IdaoTurno getDao() {
		return dao;
	}

	public void setDao(IdaoTurno dao) {
		this.dao = dao;
	}

	@Override
	public List<Turno> readAllFrom(Medico m) {
		// TODO Auto-generated method stub
		return dao.readAllFrom(m);
	}

}
