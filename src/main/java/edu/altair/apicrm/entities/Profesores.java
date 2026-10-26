package edu.altair.apicrm.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "profesores", schema = "crm", uniqueConstraints = {
        @UniqueConstraint(name = "uk_profesores_dni", columnNames = "dni")
})

public class Profesores {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesores")
    private Long idProfesores;

    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "fk_departamentos",
                referencedColumnName = "id_departamentos",
                nullable = false)
    private Departamentos departamento;

    @OneToMany(mappedBy = "profesor")
    private List<Asignaturas> asignaturas;
    
    //Constructores
    public Profesores() {
		super();
	}

	public Profesores(Long idProfesores, String dni, String nombre) {
		super();
		this.idProfesores = idProfesores;
		this.dni = dni;
		this.nombre = nombre;
	}
	
	// Getters y Setters
	public Long getIdProfesores() {
		return idProfesores;
	}

	public void setIdProfesores(Long idProfesores) {
		this.idProfesores = idProfesores;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
