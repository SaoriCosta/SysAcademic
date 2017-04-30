package br.com.sysacademic.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import br.com.sysacademic.entidades.Matricula;

public class MatriculaManager {
	
	private static HashMap<String, ArrayList<Matricula>> matriculas1 = new HashMap<String,ArrayList<Matricula>>(4);
	public static ArrayList<Matricula> lista;
	
	public static HashMap<String, ArrayList<Matricula>> getMatriculas() {
		return matriculas1;
	}

	public static void setMatriculas(HashMap<String, ArrayList<Matricula>> matriculas) {
		matriculas1 = matriculas;
	}
	public static void addMatricula(Matricula matricula){
		if(matriculas1.containsKey(matricula.getTurma().getCodigo())){
			lista = matriculas1.get(matricula.getTurma().getCodigo());
			lista.add(matricula);
			matriculas1.put(matricula.getTurma().getCodigo(),lista);
		}
		else{
			lista = new ArrayList<>();
			lista.add(matricula);
			matriculas1.put(matricula.getTurma().getCodigo(), lista);
		}
	
	}
}
