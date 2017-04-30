package br.com.sysacademic.persistence;

import java.util.HashMap;

import br.com.sysacademic.entidades.Aluno;
import br.com.sysacademic.entidades.Professor;
import br.com.sysacademic.entidades.Professor;

public class ProfessorManager {
	
	private static HashMap<String,Professor> professores = new HashMap<>(4);
	private static int idcount = 0;
	
	public static HashMap<String, Professor> getProfessor() {
		return professores;
	}
	public static void setProfessor(HashMap<String,Professor> professor) {
		ProfessorManager.professores = professor;
	}
public static void addProfessor(Professor professor){
		
		if(professores.containsKey(professor.getCpf())){
			professor.setId(( professores.get(professor.getCpf())).getId());
			professores.put(professor.getCpf(), professor);
		}else{
			idcount += 1;
			professor.setId(idcount);
			professores.put(professor.getCpf(), professor);
		}
}
}
