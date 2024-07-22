package frgp.utn.edu.ar.controller;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;

@Controller
public class TurnosController {
	
	
ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	//@Autowired
	//@Qualifier("servicioPaciente") 
	frgp.utn.edu.ar.negocioImp.TurnoNegocio neg = (frgp.utn.edu.ar.negocioImp.TurnoNegocio) appContext.getBean("beanTurnoNegocio");
	frgp.utn.edu.ar.negocioImp.EspecialidadNegocio eneg = (frgp.utn.edu.ar.negocioImp.EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
	frgp.utn.edu.ar.negocioImp.MedicoNegocio mneg = (frgp.utn.edu.ar.negocioImp.MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	Turno turno = (Turno) appContext.getBean("turnoDefault");
	Medico medico = (Medico) appContext.getBean("MedicoDefault");
	frgp.utn.edu.ar.negocioImp.PacienteNegocio pneg = (frgp.utn.edu.ar.negocioImp.PacienteNegocio) appContext.getBean("beanPacienteNegocio");
	Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
	
	
	@RequestMapping("turnos.html")
	public ModelAndView turnos(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaTurnos",neg.ReadAll());
		mav.addObject("clickTurnos",true);
		mav.setViewName("vistaAdmin");
		return mav;
		
	}
	
	
	@RequestMapping(value= "bajaTurno{id}.html", method=RequestMethod.GET)
	public ModelAndView bajaTurno(
			@PathVariable Integer id)
	{
		
		System.out.println("BORRAR PACIENTE: "+id);
		
		turno = neg.ReadOne(id);
		turno.setEstado("Ausente");
		neg.Update(turno);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("listaTurnos",neg.ReadAll());
		mav.addObject("clickMisTurnos",true);
		mav.setViewName("vistaUsuario");
		return mav;
	}

	
	@RequestMapping(value= "1modificarTurno{id}.html", method=RequestMethod.GET)
	public ModelAndView modificarTurno1(
			@PathVariable Integer id)
	{
			
		
		ModelAndView mav = new ModelAndView();
		
		paciente = turno.getPaciente();
		turno = neg.ReadOne(id);
	
		System.out.println("en controller funcion Lista...");
		mav.addObject("listaTurnos",neg.readAllFrom(mneg.ReadOne(1235)));
		mav.addObject("turnoAux",turno);
		mav.addObject("pacienteAux",paciente);
		mav.addObject("clickModificarTurno",true);
		mav.setViewName("vistaUsuario");
		return mav;
	}
	
	@RequestMapping(value= "modificarTurno2{id}.html", method=RequestMethod.GET)
	public ModelAndView modificarTurno2(@PathVariable Integer id,String txtObservacion){
		
		turno = neg.ReadOne(id);
		turno.setObservacion(txtObservacion);
		turno.setEstado("presente");
		neg.Update(turno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaTurnos",neg.ReadAll());
		mav.addObject("clickMisTurnos",true);
		mav.setViewName("vistaUsuario");
		return mav;
		
	}
	
	@RequestMapping("altaT.html")
	public ModelAndView altaTurno(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("designation", eneg.ReadAll());
		mav.addObject("listaTurnos",neg.ReadAll());
		mav.addObject("clickAgregarT",true);
		mav.setViewName("vistaAdmin");
		return mav;
		
	}
	
	@RequestMapping("agregarTurno.html")
	public ModelAndView agregarTurno(String dni, String legajo, String hora, String fecha){
		System.out.println("hora: "+hora);
		medico = mneg.ReadOne( Integer. parseInt(legajo));
		paciente = pneg.ReadOne(dni);
		
		turno.setEstado("pendiente");
		turno.setFecha(java.sql.Date.valueOf(fecha));
		turno.setHora(java.sql.Time.valueOf(hora+":00"));
		turno.setMedico(medico);
		turno.setPaciente(paciente);
		turno.setMedico(medico);
		
		neg.Add(turno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaTurnos",neg.ReadAll());
		mav.setViewName("vistaAdmin");
		return mav;
		
	}
	
	@RequestMapping("misTurnos")
	public ModelAndView misTurnos(String legajo)
	{
		System.out.println("en servicio mis turnos");
		ModelAndView mav = new ModelAndView();
		
		medico = mneg.ReadOne(2222);
		mav.addObject("clickMisTurnos",true);
		mav.addObject("listaTurnos",neg.readAllFrom(medico));
		mav.setViewName("vistaUsuario");
		return mav;
	}
	
}
