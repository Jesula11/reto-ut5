package edu.altair.apicrm.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula", schema = "crm")

public class Matriculas {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matriculas")
    private Long idMatriculas;

    @Column(name = "fecha", nullable = false, length = 100)
    private LocalDate fecha;
    
    @Column(name = "nota", nullable = false, length = 100)
    private int nota;
    
    @ManyToOne
    @JoinColumn(name = "fk_asignatura",
                referencedColumnName = "id_asignaturas",
                nullable = false)
    private Asignaturas asignatura;

    @ManyToOne
    @JoinColumn(name = "fk_estudiantes",
                referencedColumnName = "id_estudiantes",
                nullable = false)
    private Estudiantes estudiante;
    
    //Constructores
    public Matriculas() {
		super();
	}

	public Matriculas(Long idMatriculas, LocalDate fecha, int nota) {
		super();
		this.idMatriculas = idMatriculas;
		this.fecha = fecha;
		this.nota = nota;
	}
    
    // Getters y Setters
	public Long getIdMatriculas() {
		return idMatriculas;
	}

	public void setIdMatriculas(Long idMatriculas) {
		this.idMatriculas = idMatriculas;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
}
