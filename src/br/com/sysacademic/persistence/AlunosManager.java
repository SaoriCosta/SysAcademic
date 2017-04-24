package br.com.sysacademic.persistence;

import java.util.HashMap;

import br.com.sysacademic.entidades.Alunos;

public class AlunosManager {
	
	private static HashMap<String,Alunos> alunos = new HashMap<>(4);
	private static int idcount = 0;
	
	public static HashMap<String, Alunos> getAlunos() {
		return alunos;
	}

	public static void setAlunos(HashMap<String, Alunos> alunos) {
		AlunosManager.alunos = alunos;
	}

	public static void addAluno(Alunos aluno){
		idcount += 1;
		aluno.setId(idcount);
		alunos.put(aluno.getCpf(), aluno);
	}
	
}
