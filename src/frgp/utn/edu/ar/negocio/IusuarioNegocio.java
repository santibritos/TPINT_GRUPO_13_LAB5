package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;

public interface IusuarioNegocio {
	public boolean Add(Usuario user);
	public Usuario ReadOne(String legajo);
	public List<Usuario> ReadAll();
	public boolean Exist(String u);
	public boolean Update(Usuario u);
	public boolean Delete(Usuario u);

}
