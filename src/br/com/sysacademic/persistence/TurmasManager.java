package br.com.sysacademic.persistence;

import java.util.HashMap;

import br.com.sysacademic.entidades.Alunos;
import br.com.sysacademic.entidades.Turmas;

public class TurmasManager {

	private static HashMap<String,Turmas> turmas = new HashMap<>(4);

	public static void addTurma(Turmas turma){
		turmas.put(turma.getCodigo(), turma);
		
	}
	
	public static HashMap<String, Turmas> getTurmas() {
		return turmas;
	}

	public static void setTurmas(HashMap<String, Turmas> turmas) {
		TurmasManager.turmas = turmas;
	}
}
