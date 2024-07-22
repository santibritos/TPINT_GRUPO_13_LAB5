package frgp.utn.edu.ar.controller;

import java.util.List;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;

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


import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocio.IespecialidadNegocio;
import frgp.utn.edu.ar.negocio.ImedicoNegocio;


@Controller
public class MedicoControllers {

	
	
/**********************Gestion Medicos***********************/	
	
	
	@Autowired
	@Qualifier("servicioMedico") 
	private ImedicoNegocio negocioMedico;

	@Autowired
	@Qualifier("servicioEspecialidad") 
	private IespecialidadNegocio negocioEspecialidad;
	
	@Autowired
	private Medico medico;
	
	@RequestMapping(value= {"medicos.html"})
	public ModelAndView medicos()
	{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("listaMedicos",this.negocioMedico.ReadAll());
		mav.addObject("clickMedicos",true);
		mav.setViewName("vistaAdmin");
		return mav;
	}
	
	/*
	 * Form add doctor
	 */
	
	@RequestMapping(value ="redireccionar_agregarMedico.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView eventoRedireccionaragregarMedico()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("designation", this.negocioEspecialidad.ReadAll());
		mav.addObject("clickAgregarM",true);
		mav.setViewName("vistaAdmin");
		return mav;
	}
	

	
	@RequestMapping(value ="regarcarListaMedicos.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView recargarMedicos(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaMedicos",this.negocioMedico.ReadAll());
		MV.setViewName("listMedicos"); 
		return MV;
		
	}
	
	/*
	 * Add an doctor 
	 */
	
	@RequestMapping(value = "nuevoMedico.html", method = {RequestMethod.GET , RequestMethod.POST})
	public ModelAndView saveMedico(Integer legajo, String nombre, String apellido, String sexo, String fecha_nacimiento, String direccion, String localidad, String correoElectronico, String telefono, String horario, String usuario, String especialidadId ) {
		
		Usuario user= new Usuario();
		user.setUsuario(usuario);
		Especialidad especialidad = new Especialidad();
		especialidad.setId(Integer.valueOf(especialidadId));
		
		ModelAndView mv = new ModelAndView();
		
		medico.setLegajo(legajo);
		medico.setNombre(nombre);
		medico.setApellido(apellido);
		medico.setSexo(sexo);
		medico.setFecha_nacimiento(java.sql.Date.valueOf(fecha_nacimiento));
		medico.setDireccion(direccion);
		medico.setLocalidad(localidad);
		medico.setCorreoElectronico(correoElectronico);
		medico.setTelefono(telefono);
		medico.setHorario(horario);
		medico.setEstado(true);
		medico.setUsuario(user);
		medico.setEspecialidad(especialidad);
		
		
		negocioMedico.Add(medico);
		
		System.out.println(medico.getFecha_nacimiento());

		System.out.println(medico.getEstado());
		System.out.println(medico.getUsuario());
		System.out.println(medico.getEspecialidad());

	
		System.out.println("EL MEDICO FUE AGREGADO EXITOSAMENTE");
		mv.addObject("listaMedicos", this.negocioMedico.ReadAll());
		mv.setViewName("abmlMedicos");
		return mv;
	}
	
	
	
	/*
	 * Delete an doctor by it's CODE value.
	 */

	@RequestMapping(value= {"/delete{legajo}.html"} , method= RequestMethod.GET)
	public ModelAndView deleteDoctor(@PathVariable Integer legajo) {
		
		System.out.println("INGREESO A LA FUNCION");
		
		negocioMedico.Delete(negocioMedico.ReadOne(legajo));
		
		ModelAndView MV = new ModelAndView("");
		MV.setViewName("abmlMedicos");
		
		MV.addObject("listaMedicos",this.negocioMedico.ReadAll());
		
		MV.setViewName("vistaAdmin");
		
		return MV;

	}
	
	/**
	 * UPDATE DOCTOR
	 */
	@RequestMapping(value= {"/modificarMedico{legajo}.html"} , method= RequestMethod.GET)
	public ModelAndView updateDoctor(@PathVariable Integer legajo) {			
		System.out.println("INGREESO A LA FUNCION ACTUALIZAR");
		medico = negocioMedico.ReadOne(legajo);
		ModelAndView modelAndView = new ModelAndView("");
		modelAndView.addObject("Medico", medico);
		modelAndView.addObject("clickModifM",true);
		modelAndView.addObject("designation", this.negocioEspecialidad.ReadAll());
		modelAndView.setViewName("vistaAdmin");
		return modelAndView;

	}
	
	@RequestMapping(value="/actualizarMedico/{medico.legajo}.html", method=RequestMethod.POST)
    public ModelAndView edditingMedico(@ModelAttribute Medico medico, @PathVariable Integer id) {
         
        ModelAndView modelAndView = new ModelAndView("");
        
        negocioMedico.Update(medico);

        
        System.out.println("INGREESO A LA FUNCION ACTUALIZAR");
         
        return modelAndView;
    }
	
/*
	
	@RequestMapping(value="/pdf.html")
    public void generarReportePDF(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=reporte.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        document.add(new Paragraph("Reporte de Medicos"));

        PdfPTable table = new PdfPTable(2);
        PdfPCell c1 = new PdfPCell(new Paragraph("Nombre"));
        table.addCell(c1);
        c1 = new PdfPCell(new Paragraph("Precio"));
        table.addCell(c1);

        List<Medico> doctors = negocioMedico.ReadAll();
        for (Medico doctor : doctors) {
            table.addCell(doctor.getNombre());
            table.addCell(String.valueOf(doctor.getLegajo()));
        }

        document.add(table);
        document.close();
    }*/
}
