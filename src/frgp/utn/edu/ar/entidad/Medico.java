package frgp.utn.edu.ar.entidad;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="Medico")
public class Medico implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private int legajo;	
	@Column
	private String nombre;	
	@Column
	private String apellido;	
	@Column
	private String sexo;	
	@Column
	private Date fecha_nacimiento;	
	@Column
	private String direccion;
	@Column
	private String localidad;
	@Column
	private String correoElectronico;
	@Column
	private String telefono;
	@Column
	private String horario;
	@Column
	private Boolean estado;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="usuario_m")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="especialidad_id")
	private Especialidad especialidad;
	

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Medico() {
		
	}
	
	public Medico(int legajo, String nombre, String apellido, String sexo, Date fecha_nacimiento,String direccion, String localidad, String correoElectronico, String telefono,Especialidad esp,Usuario us)
	{
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion=direccion;
		this.localidad = localidad;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
		this.setEspecialidad(esp);
		this.setUsuario(us);
	}
	
	public int getLegajo() {
		return legajo;
	}


	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	public Especialidad getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}


	@Override
	public String toString() {
		
		if(this.usuario != null) {
			return "Medico [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
					+ ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + ", localidad=" + localidad
					+ ", correoElectronico=" + correoElectronico + ", telefono=" + telefono + ", usuario=" + usuario.toString();
		}
		// Sin especialidad ni datos de usuario
		return "Medico [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + ", localidad=" + localidad
				+ ", correoElectronico=" + correoElectronico + ", telefono=" + telefono +", horario= "+horario +"]";
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	

}
