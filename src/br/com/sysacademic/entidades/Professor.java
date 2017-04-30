package br.com.sysacademic.entidades;

import java.util.List;

public class Professor implements Usuario{
	
	private String nome;
	private int id;
	private String cpf;
	private List<Turma> turma;
	private String senha;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Turma> getTurma() {
		return turma;
	}
	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
	@Override
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String getSenha() {
		return this.senha;
	}
}
