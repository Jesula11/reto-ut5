package edu.altair.apicrm.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "estudiantes", schema = "crm", uniqueConstraints = {
        @UniqueConstraint(name = "uk_estudiantes_dni", columnNames = "dni")
})
public class Estudiantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiantes")
    private Long idEstudiantes;

    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @OneToMany(mappedBy = "estudiante")
    private List<Matriculas> matriculas;

    // Constructores
    public Estudiantes() {
		super();
	}
 
	public Estudiantes(Long idEstudiantes, String dni, String nombre) {
		super();
		this.idEstudiantes = idEstudiantes;
		this.dni = dni;
		this.nombre = nombre;
	}


	// Getters y Setters
    public Long getIdEstudiantes() {
		return idEstudiantes;
	}

	public void setIdEstudiantes(Long idEstudiantes) {
		this.idEstudiantes = idEstudiantes;
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

