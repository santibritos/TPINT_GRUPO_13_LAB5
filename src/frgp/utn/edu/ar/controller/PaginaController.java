package frgp.utn.edu.ar.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.negocio.ImedicoNegocio;

@Controller
public class PaginaController {

	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	//@Autowired
	//@Qualifier("servicioPaciente") 
	frgp.utn.edu.ar.negocioImp.PacienteNegocio pacienteNegocio = (frgp.utn.edu.ar.negocioImp.PacienteNegocio) appContext.getBean("beanPacienteNegocio");
	Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
	
	
	@RequestMapping("login.html")
	public ModelAndView login()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Login");
		return mav;
	}
	
	@RequestMapping("admin.html")
	public ModelAndView admin(ModelAndView mav)
	{
		mav.setViewName("adminView");
		return mav;
	}


	@RequestMapping("adminView.html")
	public ModelAndView adminView(String username, String password, ModelAndView mav)
	{
			String aux ="admin";
		
		
			mav.addObject("click",true);
			mav.addObject("username",username);
			mav.setViewName("vistaAdmin");
			return mav;

		
	}
	@RequestMapping(value= "cerrar.html", method= RequestMethod.GET)
	public ModelAndView cerrar()
	{
		ModelAndView mav = new ModelAndView();
		
			mav.clear();
			mav.setViewName("Login");
			return mav;

		
	}
}
