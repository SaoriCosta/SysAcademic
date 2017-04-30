package br.com.sysacademic.persistence;

import java.util.HashMap;

import javax.swing.JOptionPane;

import br.com.sysacademic.entidades.Aluno;
import br.com.sysacademic.entidades.Aluno;

public class AlunoManager {
	
	private static HashMap<String,Aluno> alunos = new HashMap<>(4);
	private static int idcount = 0;
	
	public static HashMap<String, Aluno> getAlunos() {
		return alunos;
	}

	public static void setAlunos(HashMap<String, Aluno> alunos) {
		AlunoManager.alunos = alunos;
	}

	public static void addAluno(Aluno aluno){
		
		if(alunos.containsKey(aluno.getCpf())){
			aluno.setId(( alunos.get(aluno.getCpf())).getId());
			alunos.put(aluno.getCpf(), aluno);
		}else{
			idcount += 1;
			aluno.setId(idcount);
			alunos.put(aluno.getCpf(), aluno);
		}
		
	}
	
}
