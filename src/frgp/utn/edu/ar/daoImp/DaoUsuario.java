package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IdaoUsuario;
import frgp.utn.edu.ar.entidad.Usuario;

@Repository("daoUsuario")
public class DaoUsuario implements IdaoUsuario{
	

	public DaoUsuario() {
		
	}

	@Override
	public boolean Add(Usuario user) {
		boolean estado = true;
		ConfigHibernate ch = new ConfigHibernate();
	    Session session = null;
	    System.out.println("en d da");

	    try {
	        session = ch.abrirConexion();
	        session.beginTransaction();
	        
	        // Guardar el objeto
	        session.save(user);
	        
	        // Forzar la sincronizaci�n de la sesi�n con la base de datos
	        session.flush();
	        
	        // Confirmar la transacci�n
	        session.getTransaction().commit();
	        
	        // Verificar si el objeto se agreg� a la base de datos
	        Usuario savedUser = (Usuario) session.get(Usuario.class, user.getUsuario());
	        
	        if (savedUser == null) {
	            estado = false;
	        }
	        
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	    }
	    
	    return estado;
	}

	@Override
	public Usuario ReadOne(String legajo) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
        Usuario usuario=(Usuario)session.get(Usuario.class,legajo);
        return usuario;
	}

	@Override
	public List<Usuario> ReadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Exist(String u) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
        Usuario usuario=(Usuario)session.get(Usuario.class,u);
        ch.cerrarConexion();
        if(usuario!=null)
        {
        	return true;
        	}
        else 
        	{
        	return false;
        }
        	
        
        
	}

	@Override
	public boolean Update(Usuario u) {
		boolean estado = true;
	    Session session = null;
	    ConfigHibernate ch = new ConfigHibernate();
	    System.out.println("en d d");

	    try {
	    	System.out.println("en d try neg");
			 session = ch.abrirConexion();
	        session.beginTransaction();
	        
	        // Guardar el objeto
	        session.update(u);
	        
	        // Forzar la sincronizaci�n de la sesi�n con la base de datos
	         session.flush();
	        
	        // Confirmar la transacci�n
	        session.getTransaction().commit();
	        
	        // Verificar si el objeto se agreg� a la base de datos
	        Usuario savedUser = (Usuario) session.get(Usuario.class, u.getUsuario());
	        
	        if (savedUser.equals(u) == false) {
	            estado = false;
	        }
	    } catch (Exception e) {
	        if (session != null) {
	        	System.out.println("en ex d");
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	    	ch.cerrarConexion();
	    }
	    
		return estado;
	}

	@Override
	public boolean Delete(Usuario u) {
		boolean estado = true;
		ConfigHibernate ch = new ConfigHibernate();
		Session session = null;

	    try {
	    	
			 session = ch.abrirConexion();
	        session.beginTransaction();
	        
	        // Guardar el objeto
	        session.delete(u);
	        
	        // Forzar la sincronizaci�n de la sesi�n con la base de datos
	        session.flush();
	        
	        // Confirmar la transacci�n
	        session.getTransaction().commit();
	        
	        // Verificar si el objeto se agreg� a la base de datos
	        Usuario savedUser = (Usuario) session.get(Usuario.class, u.getUsuario());
	        
	        if (savedUser != null) {
	            estado = false;
	        }
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	    	ch.cerrarConexion();
	    }
	    
		return estado;
	}
	
	
	

	
	

}
