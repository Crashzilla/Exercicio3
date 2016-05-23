package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Paciente
 *
 */
@Entity

public class Paciente implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CPF", unique=true, nullable=false, length=11)
	private String cfp;
	
	@Column(name="NOME", nullable=false, length=45)
	private String nome;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="DATANASC", nullable=false)
	private Date nascimento;
	
	@Column(name="TELEFONE", nullable=false, length=20)
	private String telefone;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<Agenda> agenda = new HashSet<>();

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<Procedimento> procedimento = new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<Matmed> matmed = new HashSet<>();

	public String getCfp() {
		return cfp;
	}

	public void setCfp(String cfp) {
		this.cfp = cfp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(Set<Agenda> agenda) {
		this.agenda = agenda;
	}

	public Set<Procedimento> getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Set<Procedimento> procedimento) {
		this.procedimento = procedimento;
	}

	public Set<Matmed> getMatmed() {
		return matmed;
	}

	public void setMatmed(Set<Matmed> matmed) {
		this.matmed = matmed;
	}
}
