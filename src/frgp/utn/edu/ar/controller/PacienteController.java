package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Paciente;

@Controller
public class PacienteController {
	
ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	//@Autowired
	//@Qualifier("servicioPaciente") 
	frgp.utn.edu.ar.negocioImp.PacienteNegocio pacienteNegocio = (frgp.utn.edu.ar.negocioImp.PacienteNegocio) appContext.getBean("beanPacienteNegocio");
	Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
	
	// pacientes
	
	@RequestMapping("pacientes.html")
	public ModelAndView pacientes(@ModelAttribute("username") String username,ModelAndView mav)
	{
		mav.addObject(username);
		System.out.println(username);
		mav.addObject("listaPacientes",pacienteNegocio.ReadAll());
		mav.addObject("clickPacientes",true);
		mav.setViewName("vistaAdmin");
		return mav;
	}
	
	@RequestMapping("altaP.html")
	public ModelAndView agregarPaciente()
	{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("clickAgregarP",true);
		mav.setViewName("vistaAdmin");
		return mav;
	}
	
	@RequestMapping("listarPacientes.html")
	public ModelAndView listarPacientes(ModelAndView mav)
	{
		
		
		System.out.println("en controller listar...");
		mav.addObject("listaPacientes",pacienteNegocio.ReadAll());
		mav.addObject("clickPacientes",true);
		mav.setViewName("vistaAdmin");
		return mav;
	}
	
	
	@RequestMapping(value= "modificarPaciente{dni}.html", method=RequestMethod.GET)
	public ModelAndView funcionLista1(
			@PathVariable String dni)
	{
		
		System.out.println("EN MODIFICAR");
		
		
		
		ModelAndView mav = new ModelAndView();
		
		paciente = pacienteNegocio.ReadOne(dni);
		System.out.println("en controller funcion Lista...");
		mav.addObject("listaPacientes",pacienteNegocio.ReadAll());
		mav.addObject("pacienteAux",paciente);
		mav.addObject("clickModificarP",true);
		mav.setViewName("vistaAdmin");
		return mav;
	}
	@RequestMapping(value= "borrarPaciente{dni}.html", method=RequestMethod.GET)
	public ModelAndView funcionLista2(
			@PathVariable String dni)
	{
		
		System.out.println("BORRAR PACIENTE: "+dni);
		
		paciente = pacienteNegocio.ReadOne(dni);
		pacienteNegocio.Delete(paciente);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("listaPacientes",pacienteNegocio.ReadAll());
		mav.addObject("clickPacientes",true);
		mav.setViewName("vistaAdmin");
		return mav;
	}

	
	
	@RequestMapping("agregarPaciente.html")
	public ModelAndView agregarPaciente(String txtDni,String txtNombre, String txtApellido, 
			String fechaNacimiento, String txtDireccion,String txtLocalidad,String txtProvincia,String txtCorreo,String txtTelefono)
	{
		ModelAndView mav = new ModelAndView();
		
		System.out.println(txtDni);
		paciente.setDni(txtDni);
		paciente.setNombre(txtNombre);
		paciente.setApellido(txtApellido);
		paciente.setDireccion(txtDireccion);
		paciente.setCorreo_electronico(txtCorreo);
		paciente.setTelefono(txtTelefono);
		paciente.setLocalidad(txtLocalidad);
		paciente.setProvincia(txtProvincia);
		paciente.setEstado(true);
		paciente.setFecha_nacimiento(java.sql.Date.valueOf(fechaNacimiento));
		if(pacienteNegocio.Add(paciente)==true)
		{
			mav.addObject("pacienteAgregado",true);
		}
		mav.addObject("listaPacientes",pacienteNegocio.ReadAll());
		mav.addObject("clickPacientes",true);
		
		mav.setViewName("vistaAdmin");
		return mav;
	}
	
	@RequestMapping("modificarPaciente2")
	public ModelAndView modificarPaciente2(String txtDni,String txtNombre, String txtApellido, 
			String fechaNacimiento, String txtDireccion,String txtLocalidad,String txtProvincia,String txtCorreo,String txtTelefono)
	{
		System.out.println("EN MODIF 2");
		ModelAndView mav = new ModelAndView();
		
		System.out.println(txtDni);
		paciente.setDni(txtDni);
		paciente.setNombre(txtNombre);
		paciente.setApellido(txtApellido);
		paciente.setDireccion(txtDireccion);
		paciente.setCorreo_electronico(txtCorreo);
		paciente.setTelefono(txtTelefono);
		paciente.setLocalidad(txtLocalidad);
		paciente.setProvincia(txtProvincia);
		paciente.setEstado(true);
		paciente.setFecha_nacimiento(java.sql.Date.valueOf(fechaNacimiento));
		if(pacienteNegocio.Update(paciente)==true)
		{
			System.out.println("PACIENTE MODIFICADO");
		}
		mav.addObject("listaPacientes",pacienteNegocio.ReadAll());
		mav.addObject("clickPacientes",true);
		
		mav.setViewName("vistaAdmin");
		return mav;
	}
	
	
	@RequestMapping("misPacientes.html")
	public ModelAndView misPacientes(){
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("listaPacientes",pacienteNegocio.ReadAll());
		mav.addObject("clickMisPacientes",true);
		mav.setViewName("vistaUsuario");
		return mav;
		
	}
}
