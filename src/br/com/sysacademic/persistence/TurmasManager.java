package br.com.sysacademic.persistence;

import java.util.HashMap;

import br.com.sysacademic.entidades.Aluno;
import br.com.sysacademic.entidades.Turma;

public class TurmasManager {

	private static HashMap<String,Turma> turmas = new HashMap<>(4);

	public static void addTurma(Turma turma){
		turmas.put(turma.getCodigo(), turma);
		
	}
	
	public static HashMap<String, Turma> getTurmas() {
		return turmas;
	}

	public static void setTurmas(HashMap<String, Turma> turmas) {
		TurmasManager.turmas = turmas;
	}
}
