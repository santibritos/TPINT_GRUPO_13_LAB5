package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IdaoUsuario;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocio.IusuarioNegocio;

@Service("servicioUsuario")
public class UsuarioNegocio implements IusuarioNegocio{
	
	
	@Autowired
	private IdaoUsuario dao;

	public UsuarioNegocio()
	{
		
	}
	
	public UsuarioNegocio(IdaoUsuario dao)
	{
		this.dao = dao;
	}
	@Override
	public boolean Add(Usuario user) {
		// TODO Auto-generated method stub
		return dao.Add(user);
	}

	@Override
	public Usuario ReadOne(String legajo) {
		// TODO Auto-generated method stub
		return dao.ReadOne(legajo);
	}

	@Override
	public List<Usuario> ReadAll() {
		// TODO Auto-generated method stub
		return dao.ReadAll();
	}

	@Override
	public boolean Exist(String u) {
		// TODO Auto-generated method stub
		return dao.Exist(u);
	}

	@Override
	public boolean Update(Usuario u) {
		// TODO Auto-generated method stub
		return dao.Update(u);
	}

	@Override
	public boolean Delete(Usuario u) {
		// TODO Auto-generated method stub
		return dao.Delete(u);
	}

	public IdaoUsuario getDao() {
		return dao;
	}

	public void setDao(IdaoUsuario dao) {
		this.dao = dao;
	}


	

}
