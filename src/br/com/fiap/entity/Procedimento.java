package br.com.fiap.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Procedimento
 *
 */
@Entity
@Table(name="PROCEDIMENTO", catalog="clinica")
public class Procedimento implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="DESCRICAO", nullable=false, length=45)
	private String descricao;
	
	@Column(name="PRECO", nullable=false)
	private Double preco;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CPFPAC")
	private Paciente paciente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
