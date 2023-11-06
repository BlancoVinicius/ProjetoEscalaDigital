package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alteracao {
	
	private int id;
	private int reAgente;
	private String description;
	private LocalDate dateChange;
	private LocalDate dateReposition;
	
	public Alteracao(int id, String description, LocalDate dateChange, LocalDate dateReposition, int reAgente) {
		this.reAgente = reAgente;
		this.id = id;
		this.description = description;
		this.dateChange = dateChange;
		this.dateReposition = dateReposition;
	}
	
	public Alteracao(int id, String description, LocalDate dateChange, int reAgente) {
		this.reAgente = reAgente;
		this.id = id;
		this.description = description;
		this.dateChange = dateChange;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateChange() {
		return dateChange;
	}

	public void setDateChange(LocalDate dateChange) {
		this.dateChange = dateChange;
	}

	public LocalDate getDateReposition() {
		return dateReposition;
	}

	public void setDateReposition(LocalDate dateReposition) {
		this.dateReposition = dateReposition;
	}

	public int getId() {
		return id;
	}
	
	public int getReAgente() {
		return reAgente;
	}

	public void setReAgente(int reAgente) {
		this.reAgente = reAgente;
	}

	@Override
	public String toString() {
		String data = (dateReposition == null) ? "Sem Registro": dateReposition.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return "Dados: "
				+ "\nID: " + id
				+ "\nRE do Agente: " + reAgente
				+ "\ndescription: " + description
				+ "\ndata Change: " + dateChange.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ "\ndateReposition: "
				+ data;
				//+ dateReposition != null ? dateReposition.toString(): "Sem Registro";
	}	
}
