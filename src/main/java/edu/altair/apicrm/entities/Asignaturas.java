package edu.altair.apicrm.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas", schema = "crm")

public class Asignaturas {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignaturas")
    private Long idAsignaturas;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_profesores",
                referencedColumnName = "id_profesores",
                nullable = false)
    private Profesores profesor;

    @OneToMany(mappedBy = "asignatura")
    private List<Matriculas> matriculas;
    
  //Constructores
    public Asignaturas() {
    	super();
    }
	public Asignaturas(Long idAsignaturas, String nombre) {
		super();
		this.idAsignaturas = idAsignaturas;
		this.nombre = nombre;
}



 // Getters y Setters
    public Long getIdAsignaturas() {
		return idAsignaturas;
	}


	public void setIdAsignaturas(Long idAsignaturas) {
		this.idAsignaturas = idAsignaturas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
