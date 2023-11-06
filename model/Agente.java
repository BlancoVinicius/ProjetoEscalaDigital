package model;

public class Agente {

	private String name;
	private int re;
	private RegimeTrablho regimeTrabalho;
		
	public Agente(String name, int re, RegimeTrablho regimeTrabalho) {
		this.regimeTrabalho = regimeTrabalho;
		this.name = name;
		this.re = re;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRe() {
		return re;
	}

	public void setRe(int re) {
		this.re = re;
	}

	public RegimeTrablho getRegimeTrabalho() {
		return regimeTrabalho;
	}

	public void setRegimeTrabalho(RegimeTrablho regimeTrabalho) {
		this.regimeTrabalho = regimeTrabalho;
	}

	@Override
	public String toString() {
		return "Agente: " + name
				+ "\nre: " + re
				+ "\nregimeTrabalho: " + regimeTrabalho.toString();
	}
	
	
}
