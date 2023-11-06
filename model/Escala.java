package model;

import java.util.ArrayList;
import java.util.List;

public class Escala {
	
	private List<EscalaIndividual> escalacao = new ArrayList<>();
	private List<Alteracao> alteracoes = new ArrayList<>();
	private int mes;

	public Escala() {
	}
	
	public Escala(int mes) {
		this.mes = mes;
	}

	public int countEscalacao() {
		return escalacao.size();
	}
	
	public boolean agenteExiste(int re) {
		for (EscalaIndividual escalado : escalacao) {
			if(escalado.getAgente().getRe() == re) {
				return true;
			}
		}
		return false;
	}
	
	public void escalarAgente(EscalaIndividual e) {
		escalacao.add(e);
	}
	
	public void removeAgente(int re) {
		if(agenteExiste(re)) {
			this.escalacao.removeIf(x -> (x.getAgente().getRe() == re));
		} else {
			System.out.println("Agente não existe!");
		}
	}
	
	public int countAlteracoes() {
		return alteracoes.size();
	}
	
	public void addAlteracao(Alteracao a) {
		alteracoes.add(a);
	}
	
	public void removeAlteracao(int id) {
		alteracoes.removeIf(x -> x.getId() == id);
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public List<EscalaIndividual> getEscalacao() {
		return escalacao;
	}

	public List<Alteracao> getAlteracoes() {
		return alteracoes;
	}

	public void  listAlteracoes() {
		if(!alteracoes.isEmpty()) {
			System.out.println("Alterações:");
			alteracoes.forEach(x -> System.out.println(x));
		}else {
			System.out.println("Sem Alterações até o momento.");
		}
	}

	public void  listEscalados() {
		if(!escalacao.isEmpty()) {
			System.out.println("Agentes Escalados:\n");
			escalacao.forEach(a -> System.out.println(a.getAgente()));
		}else {
			System.out.println("Sem Agentes escalados até o momento.");
		}
	}
}
