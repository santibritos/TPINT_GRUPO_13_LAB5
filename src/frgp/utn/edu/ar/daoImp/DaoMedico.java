package frgp.utn.edu.ar.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.daoImp.ConfigHibernate;
import frgp.utn.edu.ar.dao.IdaoMedico;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Usuario;


@Repository("daoMedico")
public class DaoMedico implements IdaoMedico{

	@Override
	public boolean Add(Medico m) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
		        
			session.beginTransaction();						
			session.save(m);
			session.flush();
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

	public Medico ReadOne(int legajo) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		try {
			session.beginTransaction();
			Medico aux = (Medico)session.get(Medico.class, legajo);	
			return aux;
		} catch(Exception e) {
			System.out.println("Error al buscar el m�dico.");
			return null;
		} finally {
			config.cerrarConexion();
		}
	}


	@Override
	public List<Medico> ReadAll() {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		List<Medico> listaMedicos = (List<Medico>) session.createQuery("FROM Medico").list();
		
		System.out.println("READ ALL MEDICOS ------");
	    for (Medico medico : listaMedicos) {
	    	if(medico.getEstado()!=null)
	    	{
	    		System.out.println(medico.toString());
	    	}
		}
	    config.cerrarConexion();
	    return listaMedicos;
	}

	@Override
	public boolean Exist(int m) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Medico medico = (Medico)session.get(Medico.class, m);
		if (medico.getEstado()==true) {
			System.out.println("existe");
			ch.cerrarConexion();
			return true;
		}
		ch.cerrarConexion();
		System.out.println("no existe");
		return false;
	}

	@Override
	public boolean Update(Medico m) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		try {	 
			session.beginTransaction();		
			session.update(m);
			session.flush();
			session.getTransaction().commit();	
			System.out.println("Se ha modificado el medico");
			config.cerrarConexion();
			return true;
		} catch(Exception e) {
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();				
			}
			System.out.println("Error al modificar el medico.");
			config.cerrarConexion();
			return false;
		} 
	}

	@Override
	public boolean Delete(Medico m) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		try {	 
			session.beginTransaction();		
			session.update(m);			
			session.getTransaction().commit();	
			System.out.println("medico borrado.");
			return true;
		} catch(Exception e) {
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();				
			}
			System.out.println("Error al borrar el medico.");
			return false;
		} 
	}

}
