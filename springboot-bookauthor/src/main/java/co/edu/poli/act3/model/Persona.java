package co.edu.poli.act3.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="Persona")
public class Persona extends Usuario {
	public Persona() {}
		
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDO")
	private String apellido;

	@Column(name="MUNICIPIO")
	private String municipio;
	
	@Column(name="CORREO")
	private String correo;
	
	@Column(name="CEDULA")
	private String cedula;
	

	public Persona(String nombre, String apellido, String municipio, String correo, String cedula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.municipio = municipio;
		this.correo = correo;
		this.cedula = cedula;
	}
	
	

	public Persona(Integer id, String login, String password, boolean active, String roles) {
		super(id, login, password, active, roles);
		// TODO Auto-generated constructor stub
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

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


}
