package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AGENDA", catalog="clinica")
public class Agenda implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Integer id;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DATA", nullable=false)
	private Date data;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="HORA", nullable=false)
	private Date hora;
	
	@Column(name="DESCRICAO", nullable=false, length=45)
	private String descricao;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="AGENDA_PACIENTE", catalog="clinica", joinColumns=
	{@JoinColumn(name="AGENDA_ID", nullable=false, updatable=false)},
	inverseJoinColumns = {@JoinColumn(name="PACIENTE_CPF", nullable=false, updatable=false)})
	private Set<Paciente> paciente = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Paciente> getPacientes() {
		return paciente;
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.paciente = pacientes;
	}
}
