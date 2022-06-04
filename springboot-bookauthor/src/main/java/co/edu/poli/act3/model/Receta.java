package co.edu.poli.act3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Receta")
public class Receta {

	public Receta() {}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="CANTIDAD")
	private Integer cantidad;

	@Column(name="INGREDIENTES")
	private String ingredientes;

	@Column(name="DESCRIPCION")
	private String descripcion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Receta(Integer id, String nombre, Integer cantidad, String ingredientes, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.ingredientes = ingredientes;
		this.descripcion = descripcion;
	}
	
}
