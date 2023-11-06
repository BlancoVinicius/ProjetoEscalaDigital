package model;

public class EscalaIndividual {

	private Agente agente;
	private int diasDeTrabalho;
	
	public EscalaIndividual(Agente agente, int diasDeTrabalho) {
		this.agente = agente;
		this.diasDeTrabalho = diasDeTrabalho;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public int getDiasDeTrabalho() {
		return diasDeTrabalho;
	}

	public void setDiasDeTrabalho(int diasDeTrabalho) {
		this.diasDeTrabalho = diasDeTrabalho;
	}
}
