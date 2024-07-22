package frgp.utn.edu.ar.controller;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocio.IespecialidadNegocio;
import frgp.utn.edu.ar.negocio.ImedicoNegocio;
import frgp.utn.edu.ar.negocio.IusuarioNegocio;


@Controller

public class UsuarioController {
	
	
	
	@Autowired
	private Usuario usuario;
	@Autowired
	private Usuario aux;
	
	@Autowired
    @Qualifier("servicioUsuario") 
    private IusuarioNegocio neg;
	
	
	
	@RequestMapping("logueo.html")
	public ModelAndView logueo(String username, String password){
		System.out.println("en servicio usuario");
		ModelAndView mav = new ModelAndView();
		
		if(neg.Exist(username)==true)
		{
			System.out.println("existeee");
			usuario.setUsuario(username);
			usuario.setPassword(password);
			
			
			aux = neg.ReadOne(username);
			if(usuario.equals(aux)==true&& aux.getPermiso().equals("admin"))
			{
					mav.addObject("username",username);
					mav.setViewName("vistaAdmin");
					
			}else
			{
				if(usuario.equals(aux)==true)
				{
					mav.addObject("username",username);
					mav.setViewName("vistaUsuario");
				}
				else
				{
					mav.setViewName("Login");
				}
			}
		
		}else
		{
			mav.setViewName("Login");
		}
		
		return mav;
	}
	
	
	

}
