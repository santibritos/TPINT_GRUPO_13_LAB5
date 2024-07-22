package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidad.Usuario;

public interface IdaoUsuario {
	
	public boolean Add(Usuario user);
	public Usuario ReadOne(String legajo);
	public List<Usuario> ReadAll();
	public boolean Exist(String u);
	public boolean Update(Usuario u);
	public boolean Delete(Usuario u);

}
