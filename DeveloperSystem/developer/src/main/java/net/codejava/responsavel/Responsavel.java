package net.codejava.responsavel;

import jakarta.persistence.*;
import net.codejava.atividade.Atividade;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Responsavel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String nome;

	@ManyToMany
	@JoinColumn(name = "atividade_id")
	private List<Atividade> atividades = new ArrayList<>();

	public Responsavel() {
	}

	public Responsavel(Integer id) {
		this.id = id;
	}

	public Responsavel(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	@Override
	public String toString() {
		return nome;
	}

}
