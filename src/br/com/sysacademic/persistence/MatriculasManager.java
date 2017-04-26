package br.com.sysacademic.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import br.com.sysacademic.entidades.Matriculas;

public class MatriculasManager {
	
	private static HashMap<String, ArrayList<Matriculas>> matriculas1 = new HashMap<String,ArrayList<Matriculas>>(4);
	public static ArrayList<Matriculas> lista;
	
	public static HashMap<String, ArrayList<Matriculas>> getMatriculas() {
		return matriculas1;
	}

	public static void setMatriculas(HashMap<String, ArrayList<Matriculas>> matriculas) {
		matriculas1 = matriculas;
	}
	public static void addMatricula(Matriculas matricula){
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
