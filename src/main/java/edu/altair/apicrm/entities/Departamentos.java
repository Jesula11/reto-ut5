package edu.altair.apicrm.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamentos", schema = "crm")

public class Departamentos {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamentos")
    private Long idDepartamentos;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @OneToMany(mappedBy = "departamento")
    private List<Profesores> profesores;
    
    //Constructores
    public Departamentos() {
		super();
	}

	public Departamentos(Long idDepartamentos, String nombre) {
		super();
		this.idDepartamentos = idDepartamentos;
		this.nombre = nombre;
	}

	//Getters y Setters
	public Long getIdDepartamentos() {
		return idDepartamentos;
	}

	public void setIdDepartamentos(Long idDepartamentos) {
		this.idDepartamentos = idDepartamentos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    

}
