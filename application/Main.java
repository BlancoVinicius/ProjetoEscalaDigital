package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.Agente;
import model.Alteracao;
import model.Escala;
import model.EscalaIndividual;
import model.RegimeTrablho;
import service.escalaService;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void main(String[] args) {
		
		Escala escala = new Escala();
		
		try {
			System.out.print("Digite o mês da escala de serviço? ");
			int mes = sc.nextInt();
			sc.nextLine();
			escala.setMes(mes);
			
			do {
				int resposta = menu();
				if (resposta == 0) {
					break;
				}else {
					menuAction(resposta, escala);					
				}
				
			} while (true);
			
			System.out.println();
			if(escala.countEscalacao() > 0) {
				escala.listEscalados();
			} else {
				System.out.println("Não houve escalados.");
			}
			
			if(escala.countAlteracoes() > 0) {
				System.out.println();
				escala.listAlteracoes();
			} else {
				System.out.println("Não houve Alterações.");
			}
			System.out.println();
			escalaService.gerarEslaca(escala);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			sc.close();
			System.out.println("Procedimento finalizado!");
		}
	}
	
	public static int menu() {
		
		do {
			System.out.println();
			System.out.print("Menu de opções:"
					+ "\n[0] Para finalizar."
					+ "\n[1] Escalar agente."
					+ "\n[2] Excluir agente."
					+ "\n[3] Adicionar alteração."
					+ "\n[4] Excluir alteração."
					+ "\n[5] Listar agentes escalados."
					+ "\n[6] Listar alterações."
					+ "\n Selecione a opção desejada: "
					);
			int n = sc.nextInt();
			if(n < 7) {
				return n; 
			}
			System.out.println("Opção invalida, tente novamente!");
		} while (true);
	}

	public static void menuAction(int opcao, Escala escala) {
	
		switch (opcao) {
		case 1: {
			System.out.print("Quantos agentes serão escalados: ");
			int n = sc.nextInt();
			sc.nextLine();
		
			for (int i =0; i < n; i++) {
				System.out.print("Digite o nome do agente: ");
				String nome = sc.nextLine();
				
				System.out.print("Digite o nome RE do agente: ");
				int re = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Trabalha dias impares (1) ou pares (2)? ");
				int imparPar = sc.nextInt();
				sc.nextLine();
				
				escala.escalarAgente(new EscalaIndividual(new Agente(nome, re, RegimeTrablho.REGIME_DOZE_36), imparPar));
				
				//System.out.println("Qual regime de trabalho?");
			}
			break;
		}
		case 2: {
			System.out.print("Digite o RE do agente para escluir? ");
			int re = sc.nextInt();
			sc.nextLine();
			escala.removeAgente(re);
			break;
		}
		case 3: {
			
			if(escala.countEscalacao() == 0) {
				System.out.println("Não esxite agentes escalados para alterar!");
				break;
			}
			
			System.out.println("Quantas alteracoes deseja lançar: ");
			int n =  sc.nextInt();
			sc.nextLine();
			
			for(int i=0; i < n; i++) {
				System.out.print("Qual agente sera alterado? ");
				int re = sc.nextInt();
				sc.nextLine();
				
				if(!escala.agenteExiste(re)) {
					System.out.println("Agente não escalado ou RE não existe!");
					break;
				}
				
				System.out.print("Data da alteração dd/MM/yyy: ");				
				String data = sc.nextLine();
				System.out.print("Descrição: ");
				String descricao = sc.nextLine();
				
				System.out.print("Data de reposição(dd/MM/yyy) ou (n) para anular: ");
				String dataReposicao = sc.nextLine();
				if (dataReposicao.contains("n")) {
					escala.addAlteracao(new Alteracao(escala.countAlteracoes() + 1, descricao, LocalDate.parse(data, frm), re));					
				}else {
					escala.addAlteracao(new Alteracao(escala.countAlteracoes() + 1, descricao, LocalDate.parse(data, frm), LocalDate.parse(dataReposicao, frm), re));		
				}
			}
			break;
		}
		case 4: {
			System.out.print("Digite o ID da elteração que deseja excluir? ");
			int res = sc.nextInt();
			sc.nextLine();
			escala.removeAlteracao(res);
			break;
		}
		case 5: {
			escala.listEscalados();
			break;
		}
		case 6: {
			escala.listAlteracoes();
			break;
		}
		default:
			throw new IllegalArgumentException("Opção invalida " + opcao + ", tente novamente!");
		}
	}
}
