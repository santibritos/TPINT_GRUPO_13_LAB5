package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IdaoEspecialidad;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;

@Repository("dao")
public class DaoEspecialidad implements IdaoEspecialidad{

	@Override
	public boolean Add(Especialidad esp) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
		        
			session.beginTransaction();						
			session.save(esp);			
			session.getTransaction().commit();
			ch.cerrarConexion();
			System.out.println("Se a�adio exitosamente.");
			return true;
			
		}catch(Exception e) {
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();				
			}
			ch.cerrarConexion();
			System.out.println("Error al a�adir.");
			return false;
			
		}
	}

	@Override
	public Especialidad ReadOne(int id) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		try {
			session.beginTransaction();
			Especialidad aux = (Especialidad)session.get(Especialidad.class, id);	
			return aux;
		} catch(Exception e) {
			System.out.println("Error al buscar la especialidad.");
			return null;
		} finally {
			config.cerrarConexion();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidad> ReadAll() {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
	
		List<Especialidad> lista = (List<Especialidad>) session.createQuery("FROM Especialidad").list();
		
		System.out.println("READ ALL ESPECIALIDAD ------");
	    for (Especialidad reg : lista) {
	    	
	    		System.out.println(reg.toString());
	    	
		}
	    config.cerrarConexion();
	    return lista;
	}

	@Override
	public boolean Exist(String aux) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Especialidad reg = (Especialidad)session.get(Especialidad.class, aux);
		if (reg !=null) {
			System.out.println("existe");
			ch.cerrarConexion();
			return true;
		}
		ch.cerrarConexion();
		System.out.println("no existe");
		return false;
	}

}
